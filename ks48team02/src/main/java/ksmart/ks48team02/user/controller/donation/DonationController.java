package ksmart.ks48team02.user.controller.donation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.OrderTableList;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.scheduler.UserCommonScheduler;
import ksmart.ks48team02.user.service.donation.DonationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("userDonationController")
@RequestMapping("/user/donation")
@Slf4j
public class DonationController {
    private final DonationService donationService;
    private final KaKaoPayProperties kaKaoPayProperties;

    DonationController(DonationService donationService,
                       KaKaoPayProperties kaKaoPayProperties){
        this.donationService = donationService;
        this.kaKaoPayProperties = kaKaoPayProperties;
    }


    @GetMapping(value = {"", "/"})
    public String mainPage(Model model){
        List<AllDonationInfo> allDonationInfo = donationService.getAllDonationInfo();
        model.addAttribute("allDonationInfo", allDonationInfo);
        
        return "user/donation/main";
    }

    @GetMapping("/detail")
    public String detailMainPage(@RequestParam(name = "donationCode") String donationCode,
                                 Model model,
                                 HttpSession session){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }
        int NumberOfParticipants = donationService.getNumberOfParticipants(donationCode);
        model.addAttribute("NumberOfParticipants", NumberOfParticipants);

        int searchCount = donationInfo.getSearchCount() + 1;
        donationService.searchCountUpdate(donationCode, Integer.toString(searchCount));
      
        return "user/donation/detail/main";
    }

    @GetMapping("/detail/condition")
    public String detailConditionPage(Model model, HttpSession session,
                                      @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        String conditionContents = donationService.getCondition(donationCode);
        model.addAttribute("conditionContents", conditionContents);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }
        int NumberOfParticipants = donationService.getNumberOfParticipants(donationCode);
        model.addAttribute("NumberOfParticipants", NumberOfParticipants);

        return "user/donation/detail/condition";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(HttpSession session, Model model,
                                    @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        // getcomment 만들어서 댓글 가져오기.
        List<DonationCommentList> donationCommentList = donationService.getCommentList(donationCode);
        model.addAttribute("donationCommentList", donationCommentList);
        // 리뷰 개수 계산
        int viewCount = 0;
        for (int i = 0; i < donationCommentList.size(); i++) {
            if(donationCommentList.get(i).getCommentClass().equals("comment")){
                viewCount++;
            }
        }
        model.addAttribute("viewCount", viewCount);
        int NumberOfParticipants = donationService.getNumberOfParticipants(donationCode);
        model.addAttribute("NumberOfParticipants", NumberOfParticipants);

        return "user/donation/detail/comment";
    }

    @PostMapping("/detail/comment")
    public String commentAdd(HttpSession session, Model model,
                             @RequestParam(name = "donationCode") String donationCode,
                             @RequestParam(name = "commentContent") String commentContent){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = donationService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        donationService.CommentAdd(memberId, donationCode, commentMember.getMemberName(), commentContent);

        return "redirect:/user/donation/detail/comment?donationCode=" + donationCode;
    }

    @PostMapping("/detail/reply")
    public String replyAdd(HttpSession session, Model model,
                             @RequestParam(name = "reply") String reply,
                           @RequestParam(name = "donationCode") String donationCode,
                             @RequestParam(name = "parentCommentCode") String parentCommentCode){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = donationService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        donationService.replyAdd(reply, donationCode, parentCommentCode, memberId, commentMember.getMemberName());


        return "redirect:/user/donation/detail/comment?donationCode=" + donationCode;
    }

    @GetMapping("/order")
    public String orderMainPage(@RequestParam(name = "donationCode") String donationCode,
            HttpSession session, Model model){
        String SID = (String)session.getAttribute("SID");
        model.addAttribute("SID", SID);
        int myFlover = donationService.getFlover(SID);
        model.addAttribute("myFlover", myFlover);
        model.addAttribute("donationCode", donationCode);

        return "user/donation/order/main";
    }

    @PostMapping("/payment")
    public String paymentMainPage(@RequestParam(name = "floverCount") int floverCount,
                                  @RequestParam(name = "donationCode") String donationCode,
                                  HttpSession session,
                                  Model model){
        String SID = (String)session.getAttribute("SID");
        int dbflover = donationService.getFlover(SID);
        int resultFlover = dbflover - floverCount;
        if (resultFlover < 0){

        }else{
            Map<String, Object> deductData = new HashMap<String,Object>();
            deductData.put("SID", SID);
            deductData.put("resultFlover", resultFlover);
            donationService.deductFlover(deductData);
            model.addAttribute("floverCount", floverCount);
            List<AllDonationInfo> donationInfoList = donationService.getAllDonationInfo();
            for (int i = 0; i < donationInfoList.size(); i++) {
                if(donationInfoList.get(i).getDonationCode().equals(donationCode)){
                    model.addAttribute("donationSubject" , donationInfoList.get(i).getDonationSubject());
                    model.addAttribute("storeName", donationInfoList.get(i).getStoreName());
                }
            }

            int floverToMoney = floverCount * 100;
            donationService.addOrderTable(SID, donationCode, Integer.toString(floverToMoney));
            donationService.addDonationPayment(donationCode, Integer.toString(floverCount), Integer.toString(floverToMoney));
            DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
            float acvMoney = donationInfo.getDonationAchievementMoney() + floverToMoney;
            float goalMoney = donationInfo.getDonationGoalMoney();
            float acvPercent = (acvMoney / goalMoney) * 100;
            donationService.updateMoney(donationCode, Float.toString(acvMoney), Float.toString(acvPercent));
        }


        return "user/donation/payment/confirm";
    }

    @GetMapping("/payment/charge/main")
    public String paymentPage(@RequestParam(name = "memberId")String memberId,
                              Model model){
        model.addAttribute("memberId", memberId);
        return "user/donation/payment/main";
    }

    @RequestMapping("/payment/charge")
    @ResponseBody
    public String paymentChargePage(@RequestParam(name = "orderAmount")String orderAmount,
                                    @RequestParam(name = "floverCount")String floverCount,
                                    @RequestParam(name = "memberId")String memberId,
                                    HttpServletRequest request,
                                    HttpSession session){
        try {
            String serverName = request.getServerName();
            String osName = System.getProperty("os.name").toLowerCase();
            String localPort = ":"+request.getLocalPort();
            if(osName.contains("linux")) localPort = "";
            URL addr = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection serverConnect = (HttpURLConnection) addr.openConnection();// 서버 연결하는 클래스
            serverConnect.setRequestMethod("POST");
            serverConnect.setRequestProperty("Authorization", "KakaoAK "+kaKaoPayProperties.getAdminKey());
            serverConnect.setRequestProperty("Content-type" , "application/x-www-form-urlencoded;charset=utf-8");
            serverConnect.setDoOutput(true);
            // String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=Flover&quantity=1&total_amount=2200&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8088/user/donation/payment/success&fail_url=http://localhost:8088/user/donation/payment/fail&cancel_url=http://localhost:8088/user/donation/payment/cancel";
            String parameter = "cid=" + URLEncoder.encode("TC0ONETIME", "UTF-8")
                    + "&partner_order_id=" + URLEncoder.encode("partner_order_id", "UTF-8")
                    + "&partner_user_id=" + URLEncoder.encode(memberId, "UTF-8")
                    + "&item_name=" + URLEncoder.encode("플로버", "UTF-8")
                    + "&quantity=" + URLEncoder.encode(floverCount, "UTF-8")
                    + "&total_amount=" + URLEncoder.encode(orderAmount, "UTF-8")
                    + "&tax_free_amount=" + URLEncoder.encode("0", "UTF-8")
                    + "&approval_url=" + URLEncoder.encode("http://"+serverName+localPort+"/user/donation/payment/success?memberId="+memberId, "UTF-8")
                    + "&fail_url=" + URLEncoder.encode("http://"+serverName+localPort+"/user/donation/payment/fail", "UTF-8")
                    + "&cancel_url=" + URLEncoder.encode("http://"+serverName+localPort+"/user/donation/payment/cancel", "UTF-8");
            OutputStream outputStream = serverConnect.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(parameter);
            dataOutputStream.close(); // close 시  자동으로 flush 실행 후 close 됨

            int result = serverConnect.getResponseCode();
            InputStream inputStream;
            /*if (result == 200){
                inputStream = serverConnect.getInputStream();
            }else{
                inputStream = serverConnect.getErrorStream();
            }*/
            if (result == 200){
                inputStream = serverConnect.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                String response = sb.toString();

                // Gson 라이브러리를 사용하여 응답을 파싱하고 tid와 next_redirect_pc_url를 추출합니다.
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(response);
                String tid = element.getAsJsonObject().get("tid").getAsString();
                String nextRedirectPcUrl = element.getAsJsonObject().get("next_redirect_pc_url").getAsString();

                log.info("responseElement:{}", element);
                // 세션에 tid를 저장합니다.
                session.setAttribute("tid", tid);

                // tid와 next_redirect_pc_url을 포함하는 JSON을 생성합니다.
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("tid", tid);
                jsonObject.addProperty("next_redirect_pc_url", nextRedirectPcUrl);
                return jsonObject.toString();
            } else {
                inputStream = serverConnect.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "(\"result\":\"NO\")";
    }

    @RequestMapping("/payment/success")
    public String paymentSuccess(@RequestParam(name = "pg_token")String pgToken, HttpSession session,
                                 @RequestParam(name = "memberId")String memberId,
                                 Model model){
        String tid = (String)session.getAttribute("tid");
        try {
            URL url = new URL("https://kapi.kakao.com/v1/payment/approve");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "KakaoAK " + kaKaoPayProperties.getAdminKey());
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setDoOutput(true);

            String parameters = "cid=" + URLEncoder.encode("TC0ONETIME", "UTF-8")
                    + "&tid=" + URLEncoder.encode(tid, "UTF-8")
                    + "&partner_order_id=" + URLEncoder.encode("partner_order_id", "UTF-8")
                    + "&partner_user_id=" + URLEncoder.encode(memberId, "UTF-8")
                    + "&pg_token=" + URLEncoder.encode(pgToken, "UTF-8");
            OutputStream outputStream = connection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(parameters);
            dataOutputStream.close();

            int responseCode = connection.getResponseCode();
            InputStream inputStream;
            if (responseCode == 200) {
                inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String responseLine;
                StringBuilder responseBody = new StringBuilder();
                while ((responseLine = bufferedReader.readLine()) != null) {
                    responseBody.append(responseLine);
                }
                String response = responseBody.toString();

                // Gson 라이브러리를 사용하여 응답을 파싱합니다.
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(response);

                // 각 필드 값을 추출합니다.
                String aid = null, tid2 = null, cid = null, sid = null, partner_order_id = null, partner_user_id = null, payment_method_type = null;
                JsonObject amount = null;
                int total = 0, tax_free = 0, vat = 0, point = 0;
                String item_name = null, item_code = null;
                int quantity = 0;
                Date created_at = null, approved_at = null;

                if (element.getAsJsonObject().get("aid") != null) aid = element.getAsJsonObject().get("aid").getAsString();
                if (element.getAsJsonObject().get("tid") != null) tid = element.getAsJsonObject().get("tid").getAsString();
                if (element.getAsJsonObject().get("cid") != null) cid = element.getAsJsonObject().get("cid").getAsString();
                if (element.getAsJsonObject().get("sid") != null) sid = element.getAsJsonObject().get("sid").getAsString();
                if (element.getAsJsonObject().get("partner_order_id") != null) partner_order_id = element.getAsJsonObject().get("partner_order_id").getAsString();
                if (element.getAsJsonObject().get("partner_user_id") != null) partner_user_id = element.getAsJsonObject().get("partner_user_id").getAsString();
                if (element.getAsJsonObject().get("payment_method_type") != null) payment_method_type = element.getAsJsonObject().get("payment_method_type").getAsString();

                // amount는 중첩 객체이므로 별도 처리가 필요합니다.
                if (element.getAsJsonObject().get("amount") != null) {
                    amount = element.getAsJsonObject().get("amount").getAsJsonObject();
                    if (amount.get("total") != null) total = amount.get("total").getAsInt();
                    if (amount.get("tax_free") != null) tax_free = amount.get("tax_free").getAsInt();
                    if (amount.get("vat") != null) vat = amount.get("vat").getAsInt();
                    if (amount.get("point") != null) point = amount.get("point").getAsInt();
                }

                if (element.getAsJsonObject().get("item_name") != null) item_name = element.getAsJsonObject().get("item_name").getAsString();
                if (element.getAsJsonObject().get("item_code") != null) item_code = element.getAsJsonObject().get("item_code").getAsString();
                if (element.getAsJsonObject().get("quantity") != null) quantity = element.getAsJsonObject().get("quantity").getAsInt();
                if (element.getAsJsonObject().get("created_at") != null)
                    created_at = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(element.getAsJsonObject().get("created_at").getAsString());
                if (element.getAsJsonObject().get("approved_at") != null)
                    approved_at = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(element.getAsJsonObject().get("approved_at").getAsString());

                System.out.println(quantity + "@@@@@@@@@@@@@qyabtuty");
                System.out.println(partner_user_id + "@@@@@@@@@@@@@@@@@@@partner_user_id");
                // 플로버 충전
                int Flover = donationService.getFlover(partner_user_id) + quantity;
                donationService.chargeFlover(partner_user_id, Integer.toString(Flover));

            } else {
                inputStream = connection.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/donation/payment/success";
    }
    @GetMapping("/payment/fail")
    public String paymentFail(@RequestParam(name = "pg_token")String pgToken){
        return "user/donation/payment/fail";
    }
    @GetMapping("/payment/cancel")
    public String paymentCancel(@RequestParam(name = "pg_token")String pgToken){

        return "user/donation/payment/cancel";
    }

    @GetMapping("/floverPayment/cancel")
    public String floverPaymentCancel(@RequestParam(name = "orderCode")String orderCode){
        OrderTableList getOrderInfo = donationService.getOrderInfo(orderCode);
        int cancelPrice = getOrderInfo.getOrderTotalPrice();
        int MoneyToFlover = cancelPrice / 100;
        String orderMemberId = getOrderInfo.getMemberId();
        Customer customerInfo = donationService.getCustomerInfo(orderMemberId);
        int resultFlover = customerInfo.getCustomerFlover() + MoneyToFlover;

        Map<String, Object> deductData = new HashMap<String,Object>();
        deductData.put("SID", orderMemberId);
        deductData.put("resultFlover", resultFlover);
        donationService.deductFlover(deductData);
        donationService.removeOrderInfo(orderCode);

        return "redirect:/user/mypage";
    }

    @GetMapping("/payment/detailInfo")
    public String paymentDetailInfo(@RequestParam(name = "orderCode")String orderCode, Model model){
        OrderTableList orderInfo = donationService.getOrderInfo(orderCode);
        model.addAttribute("orderInfo", orderInfo);

        return "user/donation/payment/detailInfo";
    }


    @GetMapping("/detail/news")
    public String newsPage(Model model, HttpSession session,
            @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);

        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);

        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        List<NewsList> newsList = donationService.getNewsList(donationCode);
        model.addAttribute("newsList", newsList);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }
        int NumberOfParticipants = donationService.getNumberOfParticipants(donationCode);
        model.addAttribute("NumberOfParticipants", NumberOfParticipants);


        return "user/donation/detail/news/main";
    }

    @GetMapping("/detail/news/newsDetail")
    public String newsDetailPage(@RequestParam(name = "newCode") String newsCode,
                                 @RequestParam(name = "donationCode") String donationCode,
                                 Model model, HttpSession session){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        NewsList newsList = donationService.getDetailNews(newsCode);
        model.addAttribute("newsList", newsList);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }
        int NumberOfParticipants = donationService.getNumberOfParticipants(donationCode);
        model.addAttribute("NumberOfParticipants", NumberOfParticipants);


        return "user/donation/detail/news/news_detail";
    }


}