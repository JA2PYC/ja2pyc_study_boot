package com.green.team.bootmvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.team.bootmvn.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
