package xyz.jovanstoiljkovic.isa.repoositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, TPK> extends CrudRepository<T, TPK> {
	
}
