package edu.miu.post.Controller;

import edu.miu.post.Domain.Post;
import edu.miu.post.Domain.Roles;
import edu.miu.post.Domain.User;
import edu.miu.post.Service.PostService;
import edu.miu.post.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Post savePost(@Valid @RequestBody Post post) {
        //post.setAuthor(userService.get(pos));
        return postService.save(post);
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {

        return postService.get(id);
    }

    @KafkaListener(topics = "NewComment", groupId = "group_id")
    public void consumer(String message) {
        System.out.println(message);
        //return message;
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @Valid @RequestBody Post post) {
        post.setId(id);
        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable Long id) {
        Post post = postService.get(id);
        postService.delete(id);
        return post;
    }
    

}
