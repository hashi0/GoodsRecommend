package top.cyanide.GRMS.config;

import com.briup.bigdata.pre.grms.web.common.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Bean
    public HandlerInterceptor authInterceptor(){
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(this.authInterceptor()).addPathPatterns("/grms/**").excludePathPatterns("/grms/user/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
