package edu.miu.cs425.project.crs.service;

import edu.miu.cs425.project.crs.UserRepository;
import edu.miu.cs425.project.crs.model.MyUserDetails;
import edu.miu.cs425.project.crs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmailAddress(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));

        return new MyUserDetails(user.get());
    }
}
