package ksmart.ks48team02.user.config;


import ksmart.ks48team02.user.interceptor.CommonInterceptor;
import ksmart.ks48team02.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * Configuration 스프링 프로젝트 내에 설정에 관련된 빈을 선언할 때 사용됨
 * WebMvcConfigurer 클래스 : web에 관련된 모든 설정들이 추상화되어있는 클래스
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    //  Dependency Injection(의존성 주입)
    private final CommonInterceptor commonInterceptor;
    private final LoginInterceptor loginInterceptor;

    public WebConfig(CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
        this.commonInterceptor = commonInterceptor;
        this.loginInterceptor = loginInterceptor;
    }


    /**
     * WebMvcConfigurer의 addInterceptors 메소드를 오버라이드하여 생성한 interceptor를 추가
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 정적 리소스 주소는 배제한 나머지 동적 리소스 주소만 설정
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/build/**")
                .excludePathPatterns("/admin/css/**")
                .excludePathPatterns("/admin/images/**")
                .excludePathPatterns("/admin/js/**")
                .excludePathPatterns("/admin/vendors/**")
                .excludePathPatterns("/common/css/**")
                .excludePathPatterns("/common/images/**")
                .excludePathPatterns("/common/js/**")
                .excludePathPatterns("/user/css/**")
                .excludePathPatterns("/user/fonts/**")
                .excludePathPatterns("/user/images/**")
                .excludePathPatterns("/user/js/**")
                .excludePathPatterns("/success")
                .excludePathPatterns("/fail")
                .excludePathPatterns("/error")
                .excludePathPatterns("/summernoteImage/**")
                .excludePathPatterns("/favicon.ico");

		/*
		// 로그인 검증 interceptor
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/member/addMember")
				.excludePathPatterns("/member/idCheck")
				.excludePathPatterns("/member/login")
				.excludePathPatterns("/member/logout");
		*/

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    //web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:8088/summernoteImage/1234.jpg
    //로 접속하면 C:/summernote_image/1234.jpg 파일을 불러온다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String rootPath = getOsFileRootPath();
        registry.addResourceHandler("/summernoteImage/**")
                .addResourceLocations(rootPath);
    }

    public String getOsFileRootPath(){
        String os = System.getProperty("os.name").toLowerCase();
        String rootPath = "file:////home/springboot/resources/summernote_image/";
        if (os.contains("win")) {
            rootPath = "file:///C:/summernote_image/";
        } else if (os.contains("mac")) {
            rootPath = "file:////Users/Shared/summernote_image/";
        }

        return rootPath;
    }

}








