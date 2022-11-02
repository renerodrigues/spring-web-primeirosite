package br.com.uni.springweb.Servico.Autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//public class LoginInterceptorAppConfig extends WebMvcConfigurerAdapter {
    public class LoginInterceptorAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) new LoginInterceptor())
                .excludePathPatterns(
                        "/login",
                        "/error",
                        "/logar",
                        "/vendor/**",
                        "/img/**",
                        "/js/**",
                        "/favicon.ico",
                        "/css/**");
    }
}
