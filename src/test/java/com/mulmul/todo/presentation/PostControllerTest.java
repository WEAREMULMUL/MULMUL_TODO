package com.mulmul.todo.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mulmul.todo.domain.vo.Status;
import com.mulmul.todo.dto.request.PostCreateRequest;
import com.mulmul.todo.dto.response.PostCreateResponse;
import com.mulmul.todo.dto.response.PostDetailResponse;
import com.mulmul.todo.infrastructure.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    private final Long POST_ID = 1L;
    private final String POST_TITLE = "코딩";
    private final String POST_CONTENT = "코딩하자!!";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @Test
    void TODO_LIST_생성() throws Exception {
        // given
        PostCreateRequest request = new PostCreateRequest(POST_TITLE, POST_CONTENT);
        PostCreateResponse response = new PostCreateResponse(POST_ID, POST_TITLE, Status.PROCEEDING);

        // when
        when(postService.create(any())).thenReturn(response);

        // then
        mockMvc.perform(post("/api/v1/posts")
                        .contentType(MediaTypes.HAL_JSON_VALUE)
                        .accept(MediaTypes.HAL_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void TODO_LIST_단건_조회() throws Exception {
        // given
        PostDetailResponse response = new PostDetailResponse(POST_ID, POST_TITLE, POST_CONTENT, Status.PROCEEDING);

        // when
        when(postService.find(any())).thenReturn(response);

        // then
        mockMvc.perform(get("/api/v1/posts/{id}", POST_ID)
                        .contentType(MediaTypes.HAL_JSON_VALUE)
                        .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }
}