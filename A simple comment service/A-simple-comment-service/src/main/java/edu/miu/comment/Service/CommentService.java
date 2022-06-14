package edu.miu.comment.Service;

import edu.miu.comment.DTO.ResponseTemplate;
import edu.miu.comment.Domain.Comment;

import java.util.List;

public interface CommentService {
    public ResponseTemplate save(Comment comment);

    public List<Comment> getAll(Long id);

    public Comment get(Long id);

    public Comment update(Comment comment);

    public void delete(Long id);
}
