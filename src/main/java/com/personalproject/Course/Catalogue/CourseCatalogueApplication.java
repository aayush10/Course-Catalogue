package com.personalproject.Course.Catalogue;

import com.personalproject.Course.Catalogue.models.Visitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
//@ComponentScan({"com.personalproject.Course.Catalogue.resultsetextractors"})
public class CourseCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseCatalogueApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("beans.xml loaded...");





//		Visitor v = context.getBean("visitor",Visitor.class);
//		v.signUp("Mayank","Sharma","mayank@gmail.com","manu","hello");
	}

}
