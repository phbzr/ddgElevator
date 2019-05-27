package com.ddg.task;

import com.ddg.task.service.ElevatorDestination;
import com.ddg.task.service.Elevator;
import com.ddg.task.service.ElevatorControlPanel;
import com.ddg.task.service.ElevatorMoving;
import com.ddg.task.domain.ElevatorStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ElevatorDestination elD = context.getBean(ElevatorDestination.class);
        context.getBean(ElevatorControlPanel.class).addDestination(elD.getWaiters());

    }

    @Bean
    public ElevatorControlPanel elevatorControlPanel() {
        return new ElevatorControlPanel();
    }

    @Bean
    public ElevatorMoving elevatorMoving(){
        return new ElevatorMoving();
    }

    @Bean
    public ElevatorDestination elevatorDestination(){
        return new ElevatorDestination();
    }

    @Bean
    public ElevatorStatus elevatorStatus(){
        return new ElevatorStatus();
    }

    @Bean
    public Elevator elevator(){
        return new Elevator();
    }

}
