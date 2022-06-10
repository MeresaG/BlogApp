package edu.miu.post.Service.impl;

import edu.miu.post.Domain.Post;
import edu.miu.post.Repository.PostRepo;
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

    @Override
    public Post save(Post post) {
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
        return postRepo.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }
}
