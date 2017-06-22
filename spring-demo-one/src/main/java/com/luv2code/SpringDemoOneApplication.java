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
        // Coach coach = context.getBean("CricketCoach", Coach.class);

        // Use Class
        // System.out.println(coach.getDailyWorkout());
        // System.out.println(coach.getDailyFortune());
        // System.out.println(coach.getInfo());

        // Demo Spring Scopes
        Coach coach = context.getBean("coach", Coach.class);
        // Coach alphaCoach = context.getBean("coach", Coach.class);

        // boolean result = (coach == alphaCoach);
        //
        // System.out.println("Pointing to the same object: " + result);
        // System.out.println("Memory location for coach" + coach);
        // System.out.println("Memory location for alphaCoach" + alphaCoach);

        System.out.println(coach.getDailyWorkout());

        // Close Context
        context.close();
    }
}
