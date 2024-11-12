package main;

import config.ProjectConfig;
import beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
//        System.out.println();

        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot());

        context.close();

    }
}
