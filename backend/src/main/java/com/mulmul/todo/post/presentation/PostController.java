package com.mulmul.todo.post.presentation;

import com.mulmul.todo.common.domain.LinkType;
import com.mulmul.todo.common.dto.ResponseDto;
import com.mulmul.todo.common.dto.ResponseMessage;
import com.mulmul.todo.post.dto.bundle.*;
import com.mulmul.todo.post.dto.request.PostCreateRequest;
import com.mulmul.todo.post.dto.request.PostStatusChangeRequest;
import com.mulmul.todo.post.dto.request.PostUpdateRequest;
import com.mulmul.todo.post.dto.response.PostCreateResponse;
import com.mulmul.todo.post.dto.response.PostDeleteResponse;
import com.mulmul.todo.post.dto.response.PostDetailResponse;
import com.mulmul.todo.post.application.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Api(tags = "POST DOMAIN")
@RestController
@RequestMapping(value = "/api/v1/posts", consumes = MediaTypes.HAL_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    private WebMvcLinkBuilder getLinkToAddress() {
        return linkTo(PostController.class);
    }

    @ApiOperation("TODO-LIST 생성하기")
    @PostMapping()
    public ResponseEntity<ResponseDto<PostCreateResponse>> add(@Valid @RequestBody PostCreateRequest request) {
        PostCreateBundle bundle = new PostCreateBundle(
                request.getContent()
        );

        PostCreateResponse response = postService.create(bundle);

        EntityModel<PostCreateResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.READ_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withRel(LinkType.READ_ALL_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.UPDATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PUT.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.DELETE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.STATUS_CHANGING_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PATCH.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_CREATE_SUCCESS,
                        entityModel
                )
        );
    }

    @ApiOperation("TODO-LIST 단건 조회")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<PostDetailResponse>> find(@PathVariable Long id) {
        PostFindBundle bundle = new PostFindBundle(id);

        PostDetailResponse response = postService.find(bundle);

        EntityModel<PostDetailResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withRel(LinkType.CREATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withRel(LinkType.READ_ALL_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.UPDATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PUT.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.DELETE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.STATUS_CHANGING_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PATCH.name())

        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_READ_SUCCESS,
                        entityModel
                )
        );
    }

    @ApiOperation("TODO-LIST 전체 조회")
    @GetMapping()
    public ResponseEntity<ResponseDto<Page<PostDetailResponse>>> findAll(Pageable pageable) {
        Page<PostDetailResponse> response = postService.findAll(pageable);

        EntityModel<Page<PostDetailResponse>> entityModel = EntityModel.of(response,
                getLinkToAddress().withRel(LinkType.CREATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().slash("{id}").withRel(LinkType.READ_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().slash("{id}").withRel(LinkType.UPDATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PUT.name()),
                getLinkToAddress().slash("{id}").withRel(LinkType.DELETE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name()),
                getLinkToAddress().slash("{id}").withRel(LinkType.STATUS_CHANGING_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PATCH.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_READ_ALL_SUCCESS,
                        entityModel
                )
        );
    }

    @ApiOperation("TODO-LIST 수정")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<PostDetailResponse>> update(@PathVariable Long id, @Valid @RequestBody PostUpdateRequest request) {
        PostUpdateBundle bundle = new PostUpdateBundle(id, request.getContent());

        PostDetailResponse response = postService.update(bundle);

        EntityModel<PostDetailResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withRel(LinkType.CREATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.READ_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withRel(LinkType.READ_ALL_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PUT.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.DELETE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.STATUS_CHANGING_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PATCH.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_UPDATE_SUCCESS,
                        entityModel
                )
        );
    }

    @ApiOperation("TODO-LIST 삭제")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<PostDeleteResponse>> update(@PathVariable Long id) {
        PostDeleteBundle bundle = new PostDeleteBundle(id);

        PostDeleteResponse response = postService.delete(bundle);

        EntityModel<PostDeleteResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withRel(LinkType.CREATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().withRel(LinkType.READ_ALL_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_DELETE_SUCCESS,
                        entityModel
                )
        );
    }

    @ApiOperation("TODO-LIST 상태 변화")
    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<PostDetailResponse>> changeStatus(@PathVariable Long id, @RequestBody PostStatusChangeRequest request) {
        PostStatusChangeBundle bundle = new PostStatusChangeBundle(id, request.getStatus());

        PostDetailResponse response = postService.changeStatus(bundle);

        EntityModel<PostDetailResponse> entityModel = EntityModel.of(response,
                getLinkToAddress().withRel(LinkType.CREATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.POST.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.READ_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().withRel(LinkType.READ_ALL_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.GET.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.UPDATE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PUT.name()),
                getLinkToAddress().slash(response.getId()).withRel(LinkType.DELETE_METHOD).withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.DELETE.name()),
                getLinkToAddress().withSelfRel().withMedia(MediaTypes.HAL_JSON_VALUE).withType(HttpMethod.PATCH.name())
        );

        return ResponseEntity.ok(
                ResponseDto.of(
                        ResponseMessage.POST_STATUS_CHANGE_SUCCESS,
                        entityModel
                )
        );
    }
}