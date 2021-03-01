package com.example.demotask2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@SpringBootApplication
@Configuration
public class Demotask2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demotask2Application.class, args);
    }

    @Bean
    public ViewResolver getXSLTViewResolver(){

        XsltViewResolver xsltResolover = new XsltViewResolver();
        xsltResolover.setOrder(1);
        //xsltResolover.setSourceKey("xmlSource");

        xsltResolover.setViewClass(XsltView.class);
        xsltResolover.setViewNames(new String[] {"test.xsl"});
        xsltResolover.setPrefix("classpath:/xsl/");
        xsltResolover.setSuffix(".xsl");
        return xsltResolover;
    }

    @Bean
    public ViewResolver getJSPViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
        resolver.setOrder(2);
        return resolver;
    }

}
