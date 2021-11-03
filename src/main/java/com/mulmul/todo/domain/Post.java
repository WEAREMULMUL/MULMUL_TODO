package com.mulmul.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mulmul.todo.common.DateEntity;
import com.mulmul.todo.domain.vo.Status;

import javax.persistence.*;

@Entity
public class Post extends DateEntity {
    @JsonIgnore
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    protected Post() {
    }
}
