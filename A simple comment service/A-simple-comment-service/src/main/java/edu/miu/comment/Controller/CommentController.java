package edu.miu.comment.Controller;

import edu.miu.comment.DTO.ResponseTemplate;
import edu.miu.comment.Domain.Comment;
import edu.miu.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping
    public ResponseTemplate saveComment(@Valid @RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @GetMapping("/post/{id}")
    public List<Comment> getAllCommentsByPost(@PathVariable Long id){
        return commentService.getAll(id);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentService.get(id);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @Valid @RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }


}
