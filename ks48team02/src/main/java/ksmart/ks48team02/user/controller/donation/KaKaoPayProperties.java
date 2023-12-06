package ksmart.ks48team02.user.controller.donation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KaKaoPayProperties {

    @Value("${kakao.pay.admin-key}")
    private String adminKey;

    public String getAdminKey() {
        return adminKey;
    }
}
