package com.mulmul.todo.presentation;

import com.mulmul.todo.common.dto.ResponseDto;
import com.mulmul.todo.common.dto.ResponseMessage;
import com.mulmul.todo.dto.bundle.PostCreateBundle;
import com.mulmul.todo.dto.request.PostCreateRequest;
import com.mulmul.todo.dto.response.PostCreateResponse;
import com.mulmul.todo.infrastructure.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Api(tags = "POST DOMAIN")
@RestController
@RequestMapping(value = "/api/v1/posts", produces = MediaTypes.HAL_JSON_VALUE)
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    private WebMvcLinkBuilder getLinkToAddress() {
        return linkTo(PostController.class);
    }

    @ApiOperation("TODO-LIST 생성하기")
    @PostMapping(consumes = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<ResponseDto<PostCreateResponse>> add(@Valid @RequestBody PostCreateRequest request) {
        PostCreateBundle bundle = new PostCreateBundle(
                request.getTitle(),
                request.getContent()
        );

        PostCreateResponse response = postService.create(bundle);

        EntityModel<PostCreateResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_CREATE_SUCCESS,
                        entityModel
                )
        );
    }
}
