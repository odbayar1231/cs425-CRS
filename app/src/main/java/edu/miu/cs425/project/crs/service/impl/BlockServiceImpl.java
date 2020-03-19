package edu.miu.cs425.project.crs.service.impl;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.model.Course;
import edu.miu.cs425.project.crs.model.MyUserDetails;
import edu.miu.cs425.project.crs.model.User;
import edu.miu.cs425.project.crs.repository.BlockRepository;
import edu.miu.cs425.project.crs.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    private BlockRepository blockRepository;

    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public List<Block> getAllActiveBlocks() {
        List<Block> blocks = blockRepository.findAllActiveBlocks();

        // temporary
        for (Block b: blocks) {
            for (Class c : b.getClasses()){
                processAvailability(c);
            }
        }

        return blockRepository.findAllActiveBlocks();
    }

    @Override
    public Block findBlockById(long id) {
        Block b = blockRepository.findById(id).orElse(null);

        for (Class c : b.getClasses()){
            processAvailability(c);
        }
        return b;
    }

    private void processAvailability(Class c){
        //get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((MyUserDetails) authentication.getPrincipal()).getUser();

        if (!user.getRole().getName().equals("ROLE_STUDENT"))
            return;

        List<Course> prerequisites = c.getCourse().getPrerequisites();


        // check prerequisites has been taken or not
        List<Course> registeredCourses = user.getRegisteredClasses().stream().map(cl -> cl.getCourse()).collect(Collectors.toList());
        c.setIsRegistered(registeredCourses.contains(c.getCourse()));

        if (c.getIsRegistered() && !user.getRegisteredClasses().contains(c)){
            c.setIsAvailableToRegister(false);
            c.setStatusUnavailableClass("You have taken this course in one of previous blocks");
        }


        int availableSeats = c.getSeatCapacity() - c.getStudents().size();

        if (!registeredCourses.containsAll(prerequisites)){
            c.setStatusUnavailableClass("You don't fulfill the prerequisite(s) of this course. " +
                    "\nPrerequisite(s): " + prerequisites.stream().map(Course::getName).collect(Collectors.joining(", ")));
            c.setIsAvailableToRegister(false);
        }else if (!c.getIsRegistered() && availableSeats <= 0){
            c.setStatusUnavailableClass("There is no available seats in this class.");
            c.setIsAvailableToRegister(false);
        }


        c.setAvailableSeats(Math.max(0,availableSeats));
    }
}
