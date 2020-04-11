package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
    User getById(long userId);

}
