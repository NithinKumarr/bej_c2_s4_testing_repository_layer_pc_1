package org.niit.Course13_S3_PC_1.service;

import org.niit.Course13_S3_PC_1.Course13S3Pc1Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServeiceInitializer extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Course13S3Pc1Application.class);
    }
}
