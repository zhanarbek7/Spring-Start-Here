package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;
import repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private ApplicationContext context;

    public void sendComment(Comment c){
        CommentProcessor p = context.getBean(CommentProcessor.class);
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        c = p.getComment();
    }

    public ApplicationContext getContext() {
        return context;
    }
}
