package main;

import config.ProjectConfig;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Retrieved a bean from the Spring context
        CommentService service = context.getBean(CommentService.class);
        // Creating a comment instance
        Comment comment = new Comment();
        comment.setText("Demo content");
        comment.setAuthor("Natasha");

        String value = service.publishComment(comment);
        logger.info(value);
    }


}
