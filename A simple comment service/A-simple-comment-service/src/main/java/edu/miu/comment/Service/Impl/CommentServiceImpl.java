package edu.miu.comment.Service.Impl;

import edu.miu.comment.Domain.Comment;
import edu.miu.comment.Repository.CommentRepo;
import edu.miu.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
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
