package ksmart.ks48team02.user.controller.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userNotificationController")
@RequestMapping("/user/notification")
public class NotificationController {

    @GetMapping(value = {"","/"})
    public String userNotifiMainPage(){

        return "user/notification/main";
    }
}
