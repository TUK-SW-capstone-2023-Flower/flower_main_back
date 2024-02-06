package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, Long> {
    UserDAO findByUserId(String userId);
}
