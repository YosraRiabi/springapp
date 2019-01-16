package com.riabi.springapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity/*
Generates constructors that take no arguments
*/
@NoArgsConstructor/*
Generates constructors that take no arguments
*/
@Data /*
All together now: A shortcut for @ToString,
@EqualsAndHashCode, @Getter on all fields,
and @Setter on all non-final fields, and @RequiredArgsConstructor!
*/
public class vote {

    @Id
    @GeneratedValue
    private Long id;
    private int vote;

    //User
    //Link



}
