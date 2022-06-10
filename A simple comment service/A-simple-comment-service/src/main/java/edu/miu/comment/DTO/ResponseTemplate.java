package edu.miu.comment.DTO;

import edu.miu.comment.Domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private Post post;
    private List<Comment> comments;

}
