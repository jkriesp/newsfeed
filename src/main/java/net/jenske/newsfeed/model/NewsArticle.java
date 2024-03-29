package net.jenske.newsfeed.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class NewsArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = true, length = 10000)
    private String content;

    @Column(nullable = true, length = 500)
    private String source;

    @Column(nullable = true)
    private Date publicationDate;
}
