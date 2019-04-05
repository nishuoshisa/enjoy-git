package net.wanho.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 胡梦娟 on 2018/11/27.
 */
/*@SpringBootConfiguration
public class StaticResourceConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js*//**").addResourceLocations("/js/");
        registry.addResourceHandler("/css*//**").addResourceLocations("/css/");
        super.addResourceHandlers(registry);
    }*/
@SpringBootConfiguration
public class StaticResourceConfigure extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StaticResourceConfigure.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(StaticResourceConfigure.class);
    }

}

