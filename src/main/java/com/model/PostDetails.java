package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post_details")
@Getter
@Setter
@NoArgsConstructor
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="post_description")
    private String postDescription;

    @Column(name="author", nullable = false)
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="posted_on", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date postedOn;

    @OneToOne
    @JoinColumn(name="post_id", nullable = false)
    @JsonBackReference
    private Post post;

    public PostDetails(String author, Post post, String postDescription) {
        this.author = author;
        this.post = post;
        this.postDescription = postDescription;
    }
}
