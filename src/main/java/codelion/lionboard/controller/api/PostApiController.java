package codelion.lionboard.controller.api;

import codelion.lionboard.dto.post.PostListResponseDto;
import codelion.lionboard.dto.post.PostRequestDto;
import codelion.lionboard.dto.post.PostResponseDto;
import codelion.lionboard.dto.post.PostUpdateDto;
import codelion.lionboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    //게시글 등록
    @PostMapping("/post/write")
    public Long save(@RequestBody PostRequestDto requestDto) {
        return postService.save(requestDto);
    }

    //게시글 개별 조회
    @GetMapping("/post/{id}")
    public PostResponseDto searchById(@PathVariable Long id) {
        return postService.searchById(id);
    }

    //게시글 전체 조회
    @GetMapping("/post")
    public List<PostListResponseDto> searchAllDesc() {
        return postService.findAllDesc();
    }


    //게시글 수정
    @PutMapping("/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.update(id, postUpdateDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }
}
