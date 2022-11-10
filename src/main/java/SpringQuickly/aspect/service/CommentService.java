package SpringQuickly.aspect.service;

import SpringQuickly.aspect.customAnnotation.ToLog;
import SpringQuickly.aspect.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishCommentOld(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public boolean deletComment(Comment comment) {
        logger.info("Deleting comment:" + comment.getText());
        return true;
    }
}
