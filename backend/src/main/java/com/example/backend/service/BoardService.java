package com.example.backend.service;

import com.example.backend.api.request.board.BoardPostRequest;
import com.example.backend.api.response.board.BoardResponse;
import com.example.backend.api.response.board.BoardResponseWithId;
import com.example.backend.entity.Board;
import com.example.backend.exception.board.BoardNotFoundException;
import com.example.backend.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    public static final String NOT_FOUND_BOARD_MESSAGE = "찾는 게시글이 없습니다.";
    private final BoardRepository boardRepository;

    public List<BoardResponse> findAllBoard() {
        List<BoardResponse> boardResponses = new ArrayList<>();
        List<Board> boards = boardRepository.findAll();

        for (Board board : boards) {
            BoardResponse boardResponse = BoardResponse.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();

            boardResponses.add(boardResponse);
        }
        return boardResponses;
    }

    @Transactional
    public BoardResponseWithId findBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(NOT_FOUND_BOARD_MESSAGE));

        return BoardResponseWithId.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }


    public BoardResponse postBoard(BoardPostRequest boardPostRequest) {

        Board board = Board.builder()
                .title(boardPostRequest.getTitle())
                .content(boardPostRequest.getContent())
                .build();

        Board saveBoard = boardRepository.save(board);

        return BoardResponse.builder()
                .title(saveBoard.getTitle())
                .content(saveBoard.getContent())
                .build();
    }

    @Transactional
    public void editBoard(BoardPostRequest boardPostRequest, Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new BoardNotFoundException(NOT_FOUND_BOARD_MESSAGE));

        board.editBoard(boardPostRequest);
    }


    public void deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(NOT_FOUND_BOARD_MESSAGE));

        boardRepository.delete(board);
    }
}
