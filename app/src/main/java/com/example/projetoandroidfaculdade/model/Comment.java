package com.example.projetoandroidfaculdade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
