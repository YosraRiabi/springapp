package com.riabi.springapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity

@Getter @Setter
@NoArgsConstructor /*
All together now: A shortcut for @ToString,
@EqualsAndHashCode, @Getter on all fields,
and @Setter on all non-final fields, and @RequiredArgsConstructor!
*/
public class Link extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    //Comment

    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
