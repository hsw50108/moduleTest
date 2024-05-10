package com.example.backend.api.response.board;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponseWithId {

    private Long id;

    private String title;

    private String content;

}
