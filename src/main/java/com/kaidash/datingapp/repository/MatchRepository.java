package com.kaidash.datingapp.repository;

import com.kaidash.datingapp.entity.Match;
import com.kaidash.datingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByUser1_Id (long id);

}
