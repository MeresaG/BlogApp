package edu.miu.comment.Service.Impl;

import edu.miu.comment.DTO.Post;
import edu.miu.comment.DTO.ResponseTemplate;
import edu.miu.comment.Domain.Comment;
import edu.miu.comment.Repository.CommentRepo;
import edu.miu.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, Comment> kafkaTemplate;
    private String TOPIC = "NewComment";
    @Override
    public ResponseTemplate save(Comment comment) {

        ResponseTemplate responseTemplate = new ResponseTemplate();
        //System.out.println("http://POST-MICRO-SERVICE/posts/"+comment.getPostId());
        Post post = restTemplate.getForObject("http://POST-MICRO-SERVICE/posts/"+comment.getPostId(),
                 Post.class);

        Comment c =  commentRepo.save(comment);
        responseTemplate.setComments(Arrays.asList(c));
        responseTemplate.setPost(post);
        //kafkaTemplate.send(TOPIC , comment);
        return responseTemplate;
    }

    @Override
    public List<Comment> getAll(Long id) {
        return commentRepo.findByPostId(id);
    }

    @Override
    public Comment get(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public Comment update(Comment comment) {
        //System.out.println("http://POST-MICRO-SERVICE/posts/"+comment.getPostId());
        Post post = restTemplate.getForObject("http://POST-MICRO-SERVICE/posts/"+comment.getPostId(),
                Post.class);
        Comment c = commentRepo.findById(comment.getId()).get();
        c.setComment(comment.getComment());
        c.setPostId(comment.getPostId());
        c.setUserId(comment.getUserId());
        return commentRepo.save(c);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }
}
