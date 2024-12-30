package com.spring.mvcproject.chap08.config;

import jakarta.servlet.FilterRegistration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 사용자가 업로드한 로컬에 저장된 파일에 접근하는 설정
@Configuration
@RequiredArgsConstructor
public class WebResourceConfig implements WebMvcConfigurer {
    private final FileUploadConfig fileUploadConfig;

    // 리소스 URL 매핑
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:"+ fileUploadConfig.getLocation());
    }
}
