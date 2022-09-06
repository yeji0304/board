package codelion.lionboard.dto.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostUpdateDto {

    private String title;
    private String content;


    public PostUpdateDto( String title, String content) {
        this.title = title;
        this.content = content;
    }

}
