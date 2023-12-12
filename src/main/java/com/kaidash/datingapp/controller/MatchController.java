package com.kaidash.datingapp.controller;
import com.kaidash.datingapp.entity.Match;
import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

//    @GetMapping
//    public ResponseEntity<List<Match>> getAllMatches() {
//        List<Match> matches = matchService.getAllMatches();
//        return new ResponseEntity<>(matches, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
//        Match match = matchService.getMatchById(id);
//        return new ResponseEntity<>(match, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getAllMatchByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(matchService.getAllMatchByUserId(id), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
//        Match createdMatch = matchService.createMatch(match);
//        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
//    }

    @PostMapping("/{user1_id}/{user2_id}")
    public ResponseEntity<Match> createMatch(@PathVariable Long user1_id, @PathVariable Long user2_id) {
        return new ResponseEntity<>(matchService.createMatch(user1_id, user2_id), HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMatchById(@PathVariable Long id) {
//        matchService.deleteMatchById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}

