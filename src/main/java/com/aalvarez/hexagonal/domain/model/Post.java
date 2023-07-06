package com.aalvarez.hexagonal.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    private String comment;
    private User user;

}
