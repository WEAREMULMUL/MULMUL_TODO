package com.mulmul.todo.infrastructure;

import com.mulmul.todo.domain.Post;
import com.mulmul.todo.dto.bundle.PostCreateBundle;
import com.mulmul.todo.dto.response.PostCreateResponse;
import com.mulmul.todo.repository.PostRepository;
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
        Post instance = new Post(bundle.getTitle(), bundle.getContent());

        Post post = postRepository.save(instance);

        return new PostCreateResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getStatus()
        );
    }
}
