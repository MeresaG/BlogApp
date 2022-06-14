package edu.miu.comment.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Post Id is Mandatory")
    private Long postId;
    @NotNull(message = "userId is Mandatory ")
    private Long userId;
    @NotBlank(message = "comment is Mandatory")
    @Size(min = 2, max = 255, message = "comment length should be between 2 and 255 chars long")
    @Lob
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date commentedDate;
}
