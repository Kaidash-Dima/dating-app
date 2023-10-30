/*
package com.kaidash.datingapp.security.jwt;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {

    @Getter
    private final Long id;
    private final String username;
    private final String password;
    @Getter
    private final String email;
    @Getter
    private final Date birthdate;
    @Getter
    private final String gender;
    @Getter
    private final String orientation;
    @Getter
    private final String profilePictureURL;
    @Getter
    private final String bio;

    public JwtUser(
            Long id,
            String username,
            String password,
            String email,
            Date birthdate,
            String gender,
            String orientation,
            String profilePictureURL,
            String bio) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.orientation = orientation;
        this.profilePictureURL = profilePictureURL;
        this.bio = bio;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
*/
