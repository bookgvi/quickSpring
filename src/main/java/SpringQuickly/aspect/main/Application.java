package SpringQuickly.aspect.main;

import SpringQuickly.aspect.config.ProjectConfig;
import SpringQuickly.aspect.model.Comment;
import SpringQuickly.aspect.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = ctx.getBean(CommentService.class);
        Comment comment = new Comment("comment", "Author");
        String res = commentService.publishCommentOld(comment);
        System.out.println(res);
        boolean isSuccess = commentService.deletComment(comment);
        System.out.println(isSuccess);
    }
}
