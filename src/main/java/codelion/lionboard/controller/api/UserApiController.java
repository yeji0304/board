package codelion.lionboard.controller.api;

import codelion.lionboard.dto.user.UserRequestDto;
import codelion.lionboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    //회원 등록
    @PostMapping("/users/new")
    public Long save(@RequestBody UserRequestDto requestDto) {
        return userService.save(requestDto);
    }

}
