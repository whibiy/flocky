package ksmart.ks48team02.user.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userBoardController")
@RequestMapping("/user/board")
public class BoardController {

    // 공지사항 /user/board/board
    @GetMapping("/board")
    public String userBoardPage(){

        return "user/board/board";
    }

    // 공지사항 전체
    @GetMapping(value = {"","/"})
    public String userMainPage (){

        return "user/board/main";
    }

    // 서비스 메인 오픈 상세 페이지
    @GetMapping("/1")
    public String userDetail1Page(){

        return "user/board/1";
    }

    @GetMapping("/2")
    public String userDetail2Page() {

        return "user/board/2";
    }

    @GetMapping("/3")
    public String userDetail3Page() {

        return "user/board/3";
    }

    // 이벤트 /user/board/event
    @GetMapping("/event")
    public String userEventMainPage(){

        return "user/board/event";
    }

    @GetMapping("/event_1")
    public String userEventPage(){

    return "user/board/event_1";
    }
}