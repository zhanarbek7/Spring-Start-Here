package service;

import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {

        logger.log(Level.WARNING, "Publishing comment: " + comment.getText());
    }
}
