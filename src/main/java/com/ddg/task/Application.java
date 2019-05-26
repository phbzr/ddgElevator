package com.ddg.task;

import com.ddg.task.domain.ElevatorDestination;

import com.ddg.task.service.ElevatorControlPanel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        context.getBean(ElevatorControlPanel.class).addDestination(ElevatorDestination.getWaiters());

    }

    @Bean
    public ElevatorControlPanel elevatorControlPanel() {
        return new ElevatorControlPanel();
    }

}
