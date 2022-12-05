package kr.eddi.demo.repository.test;

import kr.eddi.demo.entity.test.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c join c.testBoard tb where tb.id = :boardId")
    List<Comment> findAllCommentsByBoardId(Long boardId);

    // Jpa를 써야하는 궁극적인 이유 : 데이터를 객체로 다룰수 있다.
    // -> class 개념으로?
}
