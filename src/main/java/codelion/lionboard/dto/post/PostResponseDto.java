package codelion.lionboard.dto.post;

import codelion.lionboard.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private int count;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.count = entity.getCount();
    }

}
