package com.riabi.springapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor/*
Generates constructors that take no arguments
*/
@Data /*
All together now: A shortcut for @ToString,
@EqualsAndHashCode, @Getter on all fields,
and @Setter on all non-final fields, and @RequiredArgsConstructor!
*/
public class Comment extends Auditable{


    @Id
    @GeneratedValue
    private Long id;
    private String body;

    //Link

    @ManyToOne
    private Link link;



}
