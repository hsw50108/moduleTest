package com.example.backend.service;

import com.example.backend.api.request.comment.CommentRequest;
import com.example.backend.api.response.comment.BoardResponseWithComment;
import com.example.backend.api.response.comment.CommentResponse;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.exception.board.BoardNotFoundException;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardResponseWithComment findBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new BoardNotFoundException("게시글이 없습니다."));

//        List<BoardResponse> boardResponses = commentRepository.findByBoardId(board.getId());

        List<Comment> comments = commentRepository.findCommentByBoardId(
                board.getId());

        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment : comments) {
            CommentResponse commentResponse = CommentResponse.builder()
                    .comment(comment.getContent())
                    .build();
            commentResponses.add(commentResponse);
        }

        return BoardResponseWithComment.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .comments(commentResponses)
                .build();
    }

    public BoardResponseWithComment saveComment(Long boardId, CommentRequest commentRequest) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new BoardNotFoundException("게시글이 없습니다."));

        Comment comment = Comment.builder()
                .board(board)
                .content(commentRequest.getContent())
                .build();

        commentRepository.save(comment);

        return BoardResponseWithComment.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
