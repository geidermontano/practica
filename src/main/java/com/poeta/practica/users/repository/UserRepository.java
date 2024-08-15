package com.poeta.practica.users.repository;

import com.poeta.practica.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}