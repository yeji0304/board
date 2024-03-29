package codelion.lionboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    /** 회원가입 **/
    @GetMapping("/join")
    public String join() {
        return "user/joinForm";
    }



}
