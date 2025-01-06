package com.green.team.bootmvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.team.bootmvn.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}

