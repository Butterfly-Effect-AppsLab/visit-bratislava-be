package com.visitbratislavabe.repositories;

import com.visitbratislavabe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User getById(long userId);

}
