package com.example.backend.api.response.board;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardResponse {

    private String title;

    private String content;

}
