package com.kaidash.datingapp.service;

import com.kaidash.datingapp.entity.Interest;
import com.kaidash.datingapp.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class InterestService {

    private InterestRepository interestRepository;
    private final UserService userRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository, UserService userRepository) {
        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
    }

    public List<Interest> getAllInterests() {
        return interestRepository.findAll();
    }

    public Interest getInterestById(Long id) {
        return interestRepository.findById(id).orElse(null);
    }

    public List<Interest> getSubinterestsByParentInterest(Interest parentInterest) {
        return interestRepository.findByParentInterest(parentInterest);
    }

    public Interest saveInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }

}
