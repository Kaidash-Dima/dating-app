package com.kaidash.datingapp.service;

import com.kaidash.datingapp.dto.RegistrationUserDto;
import com.kaidash.datingapp.entity.User;
import com.kaidash.datingapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public User createNewUser(RegistrationUserDto registrationUserDto, String password) {
        User user = new User();

        user.setUsername(registrationUserDto.getUsername());
        user.setPassword(password);
        user.setEmail(registrationUserDto.getEmail());
        user.setBirthdate(registrationUserDto.getBirthdate());
        user.setGender(registrationUserDto.getGender());
        user.setOrientation(registrationUserDto.getOrientation());
        user.setBio(registrationUserDto.getBio());
        user.setRoles(List.of(roleService.getUserRole()));
        return userRepository.save(user);
    }


//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User findById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//    }


}
