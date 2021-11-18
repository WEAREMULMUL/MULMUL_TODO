package com.mulmul.todo.post.application;

import com.mulmul.todo.post.domain.Post;
import com.mulmul.todo.post.dto.bundle.*;
import com.mulmul.todo.post.dto.response.PostCreateResponse;
import com.mulmul.todo.post.dto.response.PostDeleteResponse;
import com.mulmul.todo.post.dto.response.PostDetailResponse;
import com.mulmul.todo.error.exception.NotExitsPostException;
import com.mulmul.todo.post.infrastructure.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public PostCreateResponse create(PostCreateBundle bundle) {
        Post instance = new Post(bundle.getContent());

        Post post = postRepository.save(instance);

        return new PostCreateResponse(
                post.getId(),
                post.getContent(),
                post.getStatus()
        );
    }

    @Transactional(readOnly = true)
    public PostDetailResponse find(PostFindBundle bundle) {
        Post post = postRepository.findById(bundle.getId())
                .orElseThrow(NotExitsPostException::new);

        return new PostDetailResponse(
                post.getId(),
                post.getContent(),
                post.getStatus()
        );
    }

    @Transactional(readOnly = true)
    public Page<PostDetailResponse> findAll(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(post ->
                        new PostDetailResponse(
                                post.getId(),
                                post.getContent(),
                                post.getStatus()
                        )
                );
    }

    @Transactional
    public PostDetailResponse update(PostUpdateBundle bundle) {
        Post post = postRepository.findById(bundle.getId())
                .orElseThrow(NotExitsPostException::new);

        post.update(bundle.getContent());

        return new PostDetailResponse(
                post.getId(),
                post.getContent(),
                post.getStatus()
        );
    }

    @Transactional
    public PostDeleteResponse delete(PostDeleteBundle bundle) {
        Post post = postRepository.findById(bundle.getId())
                .orElseThrow(NotExitsPostException::new);

        postRepository.delete(post);

        return new PostDeleteResponse(post.getId());
    }

    @Transactional
    public PostDetailResponse changeStatus(PostStatusChangeBundle bundle) {
        Post post = postRepository.findById(bundle.getId())
                .orElseThrow(NotExitsPostException::new);

        post.changeStatus(bundle.getStatus());

        return new PostDetailResponse(
                post.getId(),
                post.getContent(),
                post.getStatus()
        );
    }
}