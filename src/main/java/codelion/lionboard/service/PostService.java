package codelion.lionboard.service;

import codelion.lionboard.domain.Post;
import codelion.lionboard.dto.post.PostListResponseDto;
import codelion.lionboard.dto.post.PostRequestDto;
import codelion.lionboard.dto.post.PostResponseDto;
import codelion.lionboard.dto.post.PostUpdateDto;
import codelion.lionboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /** 게시물 등록 **/
    public Long save(PostRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    /** 게시물 개별 조회 **/
    public PostResponseDto searchById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new PostResponseDto(post);
    }

    /** 게시물 전체 조회 **/
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }


    /** 게시물 수정 **/
    public Long update(Long id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        post.update(postUpdateDto.getTitle(), postUpdateDto.getContent());

        return id;
    }


    /** 게시물 삭제 **/
    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        postRepository.delete(post);
    }


    /** 게시글 검색 **/
    @Transactional
    public Page<Post> search(String keyword, Pageable pageable) {

        Page<Post> postList = postRepository.findByTitle(keyword, pageable);

        return postList;
    }


    /** 조회수 **/
    @Transactional
    public int updateView(Long id) {
        return postRepository.updateView(id);
    }


    /** 페이징 **/
    @Transactional
    public Page<Post> postList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional
    public Boolean postListNextCheck(Pageable pageable) {
        Page<Post> saved = postList(pageable);
        Boolean checkNext = saved.hasNext();

        return checkNext;
    }

    @Transactional
    public Boolean postListPrevCheck(Pageable pageable) {
        Page<Post> saved = postList(pageable);
        Boolean checkPrev = saved.hasPrevious();

        return checkPrev;
    }

}
