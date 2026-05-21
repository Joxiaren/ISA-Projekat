package xyz.jovanstoiljkovic.isa.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/songs/**")
                .addResourceLocations("file:/" + System.getProperty("user.dir") + "/src/main/resources/songs/")
                .setCachePeriod(0)
                .resourceChain(false);
    }
}
