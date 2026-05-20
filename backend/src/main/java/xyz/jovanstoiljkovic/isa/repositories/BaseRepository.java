package xyz.jovanstoiljkovic.isa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, TPK> extends JpaRepository<T, TPK> {
	
}
