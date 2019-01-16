package com.riabi.springapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data /*
All together now: A shortcut for @ToString,
@EqualsAndHashCode, @Getter on all fields,
and @Setter on all non-final fields, and @RequiredArgsConstructor!
*/
public class Link {

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


}
