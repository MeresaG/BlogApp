package edu.miu.comment.Service.Impl;

import edu.miu.comment.DTO.Post;
import edu.miu.comment.DTO.ResponseTemplate;
import edu.miu.comment.Domain.Comment;
import edu.miu.comment.Repository.CommentRepo;
import edu.miu.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseTemplate save(Comment comment) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        //System.out.println("http://POST-MICRO-SERVICE/posts/"+comment.getPostId());
        Post post = restTemplate.getForObject("http://POST-MICRO-SERVICE/posts/"+comment.getPostId(),
                Post.class);
        Comment c =  commentRepo.save(comment);
        responseTemplate.setComments(Arrays.asList(c));
        responseTemplate.setPost(post);
        return responseTemplate;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment get(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }
}
