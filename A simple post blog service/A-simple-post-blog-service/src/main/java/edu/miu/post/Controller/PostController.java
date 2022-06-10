package edu.miu.post.Controller;

import edu.miu.post.Domain.Post;
import edu.miu.post.Domain.User;
import edu.miu.post.Service.PostService;
import edu.miu.post.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Post savePost(@RequestBody Post post) {
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

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
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
