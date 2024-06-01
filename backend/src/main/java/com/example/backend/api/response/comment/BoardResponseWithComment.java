package com.example.backend.api.response.comment;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponseWithComment {

    private String title;
    private String content;
    private List<CommentResponse> comments;


}
