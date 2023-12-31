package com.aalvarez.hexagonal.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    private Long id;
    private String comment;
    private User user;

}
