package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="contact")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @ManyToOne
    @JsonBackReference
    private Profile profile;

    public Contact(String email, String phoneNumber, Profile profile) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profile = profile;
    }
}
