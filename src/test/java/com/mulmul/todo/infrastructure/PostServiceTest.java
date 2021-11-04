package com.mulmul.todo.infrastructure;

import com.mulmul.todo.domain.Post;
import com.mulmul.todo.domain.vo.Status;
import com.mulmul.todo.dto.bundle.PostCreateBundle;
import com.mulmul.todo.dto.bundle.PostFindBundle;
import com.mulmul.todo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    private final Long POST_ID = 1L;
    private final String POST_TITLE = "코딩";
    private final String POST_CONTENT = "코딩하자!!";

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Mock
    private Pageable pageable;

    private final Post entity = new Post(POST_ID, POST_TITLE, POST_CONTENT, Status.PROCEEDING);

    @Mock
    private Page<Post> posts;

    @Test
    void TODO_LIST_생성() {
        // given
        PostCreateBundle bundle = new PostCreateBundle(POST_TITLE, POST_CONTENT);
        Post post = new Post(bundle.getTitle(), bundle.getContent());
        given(postRepository.save(post)).willReturn(entity);

        // when
        postService.create(bundle);

        // then
        verify(postRepository).save(post);
    }

    @Test
    void TODO_LIST_단건_조회() {
        // given
        PostFindBundle bundle = new PostFindBundle(POST_ID);
        when(postRepository.findById(POST_ID)).thenReturn(Optional.of(entity));

        // when
        postService.find(bundle);

        // then
        verify(postRepository).findById(POST_ID);
    }

    @Test
    void TODO_LIST_전체_조회() {
        // given
        when(postRepository.findAll(pageable)).thenReturn(posts);

        // when
        postService.findAll(pageable);

        // then
        verify(postRepository).findAll(pageable);
    }
}