package edu.miu.comment.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    private Long userId;
    private String comment;
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date commentedDate;
}