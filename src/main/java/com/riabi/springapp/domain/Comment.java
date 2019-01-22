package com.riabi.springapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Comment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String body;

    @ManyToOne
    @NonNull
    private Link link;

    public Comment( String body, Link link) {
        this.body = body;
        this.link = link;
    }
}
