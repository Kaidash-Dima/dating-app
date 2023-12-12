package com.kaidash.datingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id_1")
    @JsonIgnore
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_id_2")
    @JsonIgnore
    private User user2;
}
