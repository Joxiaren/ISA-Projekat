package xyz.jovanstoiljkovic.isa.services.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    @Autowired
    private ISAUserDetailsService userDetailsService;

    final private String secretKey;
    public JWTService() {
        KeyGenerator keyGen;
        try{
            keyGen = KeyGenerator.getInstance("HmacSHA256");
        } catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }

        SecretKey sk = keyGen.generateKey();
        secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    }

    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        claims.put("auths", userDetails.getAuthorities());
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)))
                .and()
                .signWith(getKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return extractSubject(token);
    }
    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractSubject(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    private String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        Claims claims = Jwts.claims().build();

        try{
            claims = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }
        catch(SignatureException se){
            System.out.println("Invalid token sent");
        }

        return claims;
    }

    private boolean isTokenExpired (String token) {
        return extractExpiration(token).before(new Date());
    }

}
