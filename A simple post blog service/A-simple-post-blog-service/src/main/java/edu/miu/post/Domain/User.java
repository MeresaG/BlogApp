package edu.miu.post.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "FirstName may not be empty")
    @Size(min = 2, max = 10, message = "firstName must be between 2 and 10 characters long")
    private String firstName;

    @NotEmpty(message = "lastName may not be empty")
    @Size(min = 2, max = 10, message = "lastName must be between 2 and 10 characters long")
    private String lastName;

    @NotEmpty(message = "userName may not be empty")
    @Size(min = 2, max = 10, message = "userName must be between 2 and 10 characters long")
    private String userName;

    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "password may not be empty")
    //@Size(min = 4, max = 8, message = "password length should be between 4 and 8")
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

}
