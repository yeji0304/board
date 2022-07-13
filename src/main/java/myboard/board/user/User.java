package myboard.board.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myboard.board.post.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    private String userId;
    private String password;

    private String userName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private List<Post> post = new ArrayList<>();

    @Builder
    public User(String userId, String password, String userName, String email, Role role) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }
}
