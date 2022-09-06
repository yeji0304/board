package codelion.lionboard.controller;

import codelion.lionboard.domain.Post;
import codelion.lionboard.dto.post.PostResponseDto;
import codelion.lionboard.login.LoginUser;
import codelion.lionboard.login.SessionUser;
import codelion.lionboard.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Post> list = postService.postList(pageable);

        model.addAttribute("posts", list);
        model.addAttribute("postList", postService.postList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("checkNext", postService.postListNextCheck(pageable));
        model.addAttribute("checkPrev", postService.postListPrevCheck(pageable));

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    /** 게시글 등록 **/
    @GetMapping("/post/new")
    public String postSave() {
        return "post/createPostForm";
    }

    /** 게시글 조회 **/
    @GetMapping("/post/list/{id}")
    public String postList(@PathVariable Long id, Model model) {
        PostResponseDto dto = postService.searchById(id);
        postService.updateView(id);
        model.addAttribute("post", dto);
        return "post/postForm";
    }

    /** 게시글 수정 **/
    @GetMapping("/post/list/{id}/edit")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostResponseDto dto = postService.searchById(id);
        model.addAttribute("post", dto);
        return "post/updatePostForm";
    }

    /** 게시글 검색 **/
    @GetMapping("/post/search")
    public String search(String keyword, Model model,
                         @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Post> searchList = postService.search(keyword, pageable);

        model.addAttribute("searchList", searchList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("checkSearchNext", postService.postListNextCheck(pageable));
        model.addAttribute("checkSearchPrev", postService.postListPrevCheck(pageable));

        return "post/searchForm";
    }


    /** 공지사항 **/
    @GetMapping("/notice")
    public String noticeForm(Model model, @LoginUser SessionUser user,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Post> list = postService.postList(pageable);

        model.addAttribute("posts", list);
        model.addAttribute("postList", postService.postList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("checkNext", postService.postListNextCheck(pageable));
        model.addAttribute("checkPrev", postService.postListPrevCheck(pageable));

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "/post/noticeForm";
    }

}
