package codelion.lionboard.repository;

import codelion.lionboard.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    List<Post> findAllDesc();

    @Modifying
    @Query("UPDATE Post p SET p.count = p.count + 1 WHERE p.id = :id")
    int updateView(@Param("id") Long id);

    Page<Post> findByTitle(String keyword, Pageable pageable);

}
