package edu.miu.comment.Service;

import edu.miu.comment.Domain.Comment;

import java.util.List;

public interface CommentService {
    public Comment save(Comment comment);

    public List<Comment> getAll();

    public Comment get(Long id);

    public Comment update(Comment comment);

    public void delete(Long id);
}
