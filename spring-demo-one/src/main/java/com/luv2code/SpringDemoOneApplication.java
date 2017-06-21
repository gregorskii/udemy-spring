package com.luv2code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDemoOneApplication {

	public static void main(String[] args) {
		// Define Context
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("context.xml");
		SpringApplication.run(SpringDemoOneApplication.class, args);

		// Retrieve Bean
		Coach coach = context.getBean("cricketCoach", Coach.class);

		// Use Class
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// Close Context
		context.close();
	}
}
