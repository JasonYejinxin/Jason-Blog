package jason.springframework.jasonblog.configure;

import jason.springframework.jasonblog.interceptor.BackInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyWebConfigureAdapter extends WebMvcConfigurerAdapter {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    public void configureMessageConverts(List<HttpMessageConverter<?>> converters){
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    public void configureNegotiation(ContentNegotiationConfigurer configurer){
        configurer.favorPathExtension(false);
    }
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new BackInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/toLogin");
        super.addInterceptors(registry);
    }

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/admin/login").setViewName("login.html");
        super.addViewControllers(registry);
    }
}
