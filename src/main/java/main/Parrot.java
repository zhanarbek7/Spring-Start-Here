package main;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
