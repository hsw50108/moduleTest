package com.example.backend.api;

import com.example.backend.api.request.board.BoardPostRequest;
import com.example.backend.api.response.board.BoardResponse;
import com.example.backend.api.response.board.BoardResponseWithId;
import com.example.backend.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardApi {

    private final BoardService boardService;

    // 게시글 전체 조회 - TODO paging
    @GetMapping()
    public List<BoardResponse> getAllBoards() {
        return boardService.findAllBoard();
    }

    // 게시글 단건 조회
    @GetMapping("/{boardId}")
    public BoardResponseWithId getBoardById(@PathVariable Long boardId) {
        return boardService.findBoardById(boardId);
    }

    // 게시글 검색(title)
    //TODO requestParam vs query Parameter
//    @GetMapping("/search/{}")
//    public List<>

    // 게시글 검색(content)

    // 게시글 등록
    @PostMapping()
    public BoardResponse postBoard(@RequestBody BoardPostRequest boardPostRequest) {
        return boardService.postBoard(boardPostRequest);
    }

    // 게시글 수정
    @PatchMapping("/{boardId}")
    public void editBoard(@PathVariable Long boardId, @RequestBody BoardPostRequest boardPostRequest) {
        boardService.editBoard(boardPostRequest, boardId);
    }

    // 게시글 삭제


}
