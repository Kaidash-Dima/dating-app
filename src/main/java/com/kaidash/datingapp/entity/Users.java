package com.kaidash.datingapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;
    private Date birthdate;
    private String gender;
    private String orientation;
    private String profilePictureURL;
    private String bio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(userName, users.userName) && Objects.equals(password, users.password) && Objects.equals(email, users.email) && Objects.equals(birthdate, users.birthdate) && Objects.equals(gender, users.gender) && Objects.equals(orientation, users.orientation) && Objects.equals(profilePictureURL, users.profilePictureURL) && Objects.equals(bio, users.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, birthdate, gender, orientation, profilePictureURL, bio);
    }
}
