package com.kaidash.datingapp.service;

import com.kaidash.datingapp.entity.Match;
import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.repository.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final UserService userService;

    public MatchService(MatchRepository matchRepository, UserService userService) {
        this.matchRepository = matchRepository;
        this.userService = userService;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<User> getAllMatchByUserId (long id){
        List<Match> matches = matchRepository.findAllByUser1_Id(id);
        List<User> users = new ArrayList<>();

        for (Match match:matches){
            users.add(match.getUser2());
        }

        return users;
    }

    public Match getMatchById(Long matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
    }

//    public Match createMatch(Match match) {
//        return matchRepository.save(match);
//    }

    public Match createMatch(Long user1Id, Long user2Id) {
        User user1 = userService.findById(user1Id);
        User user2 = userService.findById(user2Id);

        Match match = new Match();
        match.setUser1(user1);
        match.setUser2(user2);

        List<Match> match_list = new ArrayList<>();
        match_list.add(match);

        user1.setMatches(match_list);
        userService.save(user1);

        return matchRepository.save(match);
    }

    public void deleteMatchById(Long matchId) {
        matchRepository.deleteById(matchId);
    }

}

