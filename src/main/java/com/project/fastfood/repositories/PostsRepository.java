package com.project.fastfood.repositories;

import com.project.fastfood.entities.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Integer> {
}
