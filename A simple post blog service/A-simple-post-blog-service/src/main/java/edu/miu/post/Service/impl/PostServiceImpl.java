package edu.miu.post.Service.impl;

import edu.miu.post.Domain.Post;
import edu.miu.post.Domain.User;
import edu.miu.post.Repository.PostRepo;
import edu.miu.post.Repository.UserRepo;
import edu.miu.post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Post save(Post post) {
        User user = userRepo.findByEmail(post.getAuthor().getEmail());
        if(user != null) {
            post.setAuthor(user);
        }
        return postRepo.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public Post get(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public Post update(Post post) {
        User user = userRepo.findByEmail(post.getAuthor().getEmail());
        if(user != null) {
            post.setAuthor(user);
        }
        return postRepo.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }
}
