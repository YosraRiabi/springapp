package com.riabi.springapp.domain;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote extends Auditable{

    @Id
    @GeneratedValue
    private Long id;


   @NonNull
    private short direction;

   @NonNull
   @ManyToOne
    private Link link;


    //User
    //Link


    public Vote() {
    }

   public Vote( short direction, Link link){
        this.direction = direction;
        this.link = link;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "vote{" +
                "id=" + id +
                ", direction=" + direction +
                ", link=" + link +
                '}';
    }
}
