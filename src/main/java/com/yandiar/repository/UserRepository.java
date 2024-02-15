package com.yandiar.repository;

import com.yandiar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YAR
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
