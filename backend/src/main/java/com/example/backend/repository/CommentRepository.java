package com.example.backend.repository;

import com.example.backend.api.response.comment.CommentResponse;
import com.example.backend.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByBoardId(Long boardId);



}
