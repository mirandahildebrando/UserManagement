package com.brando_project.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brando_project.UserManagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
