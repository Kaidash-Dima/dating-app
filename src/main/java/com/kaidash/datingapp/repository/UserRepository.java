package com.kaidash.datingapp.repository;

import com.kaidash.datingapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<Users, Long> {
}
