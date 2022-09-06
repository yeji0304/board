package codelion.lionboard.dto.post;

import codelion.lionboard.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostListResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime updateDate;
    private int count;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.updateDate = entity.getUpdateDate();
        this.count = entity.getCount();
    }
}
