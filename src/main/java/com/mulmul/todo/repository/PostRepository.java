package com.mulmul.todo.repository;

import com.mulmul.todo.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Post save(Post post);

    @Override
    Optional<Post> findById(Long id);

    @Override
    Page<Post> findAll(Pageable pageable);

    @Override
    void deleteById(Long id);
}
