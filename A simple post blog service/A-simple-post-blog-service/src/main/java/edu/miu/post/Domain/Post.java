package edu.miu.post.Domain;

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
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date postedDate;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User author;

}
