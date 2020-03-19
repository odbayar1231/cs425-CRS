package edu.miu.cs425.project.crs.service.impl;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.model.MyUserDetails;
import edu.miu.cs425.project.crs.model.User;
import edu.miu.cs425.project.crs.repository.UserRepository;
import edu.miu.cs425.project.crs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerTo(Class c) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((MyUserDetails) authentication.getPrincipal()).getUser();

        user.addClass(c);
        return userRepository.save(user);
    }

    @Override
    public User removeClassesBelongTo(Block b) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((MyUserDetails) authentication.getPrincipal()).getUser();
        user.removeClasses(b.getClasses());

        return userRepository.save(user);
    }
}
