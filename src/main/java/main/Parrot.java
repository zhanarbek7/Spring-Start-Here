package main;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Parrot {

    public Parrot() {
        System.out.println("Parrot created");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }

}
