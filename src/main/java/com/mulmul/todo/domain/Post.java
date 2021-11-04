package com.mulmul.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mulmul.todo.common.domain.DateEntity;
import com.mulmul.todo.domain.vo.Status;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Post extends DateEntity {
    @JsonIgnore
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Lob
    @Column(name = "post_content")
    private String content;

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    protected Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.status = Status.PROCEEDING;
    }

    public Post(Long id, String title, String content, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        return Objects.equals(id, post.id)
                && Objects.equals(title, post.title)
                && Objects.equals(content, post.content)
                && status == post.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, status);
    }
}
