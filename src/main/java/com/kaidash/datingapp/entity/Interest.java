package com.kaidash.datingapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_interest_id")
    private Interest parentInterest;

    @OneToMany(mappedBy = "parentInterest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Interest> subInterests;

    @ManyToMany(mappedBy = "interests")
    private List<User> users;

}
