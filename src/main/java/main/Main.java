package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot1 = new Parrot();
        parrot1.setName("Kiki");


        Supplier<Parrot> parrotSupplier1 = () -> parrot1;

        context.registerBean("parrot",Parrot.class, parrotSupplier1,
                bc -> bc.setPrimary(true));

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

    }
}
