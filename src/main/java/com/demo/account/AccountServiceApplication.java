package com.demo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableAutoConfiguration
public class AccountServiceApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation("com.demo.account.config");


        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(applicationContext)
        );

        dispatcher.setLoadOnStartup(1);

    }
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

}
