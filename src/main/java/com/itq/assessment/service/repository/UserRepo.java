package com.itq.assessment.service.repository;

import com.itq.assessment.service.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    void deleteById(Long id);

    Optional<User> findUserById(Long id);
}
