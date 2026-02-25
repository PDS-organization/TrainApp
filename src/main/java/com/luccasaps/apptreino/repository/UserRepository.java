package com.luccasaps.apptreino.repository;

import com.luccasaps.apptreino.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
