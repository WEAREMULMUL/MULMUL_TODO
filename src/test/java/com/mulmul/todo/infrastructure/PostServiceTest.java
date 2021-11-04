package com.mulmul.todo.infrastructure;

import com.mulmul.todo.domain.Post;
import com.mulmul.todo.domain.vo.Status;
import com.mulmul.todo.dto.bundle.PostCreateBundle;
import com.mulmul.todo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    private final Post entity = new Post(POST_ID, POST_TITLE, POST_CONTENT, Status.PROCEEDING);

    @Test
    void TODO_LIST_생성() {
        // given
        PostCreateBundle postCreateBundle = new PostCreateBundle(POST_TITLE, POST_CONTENT);
        Post post = new Post(postCreateBundle.getTitle(), postCreateBundle.getContent());
        given(postRepository.save(post)).willReturn(entity);

        // when
        postService.create(postCreateBundle);

        // then
        verify(postRepository).save(post);
    }
}