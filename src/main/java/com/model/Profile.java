package com.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="profile")
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="first_name", nullable = false)
    private String firstname;

    @Column(name="last_name", nullable = false)
    private String lastname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="join_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date joinDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    @JsonManagedReference
    private Set<Contact> contacts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    @JsonManagedReference
    private Set<Post> posts;

    public Profile(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        contacts = new HashSet<Contact>();
        posts = new HashSet<Post>();
    }
}
