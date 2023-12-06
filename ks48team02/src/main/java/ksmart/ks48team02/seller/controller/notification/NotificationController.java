package ksmart.ks48team02.seller.controller.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerNotificationController")
@RequestMapping("/seller/notification")
public class NotificationController {

    @GetMapping(value = {"","/"})
    public String notificationMainPage(){

        return "seller/notification/main";
    }
}
