package com.example.backend.api;

import com.example.backend.api.request.comment.CommentRequest;
import com.example.backend.api.response.comment.BoardResponseWithComment;
import com.example.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards/")
public class CommentApi {

    private final CommentService commentService;

    // 게시글 단건 조회 with comment
    @GetMapping("/{boardId}/comments")
    public BoardResponseWithComment getBoardById(@PathVariable Long boardId) {
        return commentService.findBoard(boardId);
    }

    // comment 등록
    @PostMapping("/{boardId}/comments")
    public BoardResponseWithComment saveComment(@PathVariable Long boardId, CommentRequest commentRequest) {
        return commentService.saveComment(boardId, commentRequest);
    }


    // comment 수정

    // comment 삭제

}
