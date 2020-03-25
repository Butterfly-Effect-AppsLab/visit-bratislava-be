package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

	@Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
	UserDto getById(long userId);

}
