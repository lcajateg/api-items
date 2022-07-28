package com.devskiller.dao;

import com.devskiller.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findById(Long id);
}
