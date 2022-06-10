package edu.miu.comment.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date commentedDate;
}
