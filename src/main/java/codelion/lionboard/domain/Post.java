package codelion.lionboard.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User users;

    private String title;
    private String content;


    @Column(columnDefinition = "integer default 0", nullable = false)
    private int count;  //조회 수


   @Builder
    public Post(Long id, String title, String content, int count) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.count = count;
    }


    //==비즈니스 로직==//
    /** 게시글 수정 **/
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
