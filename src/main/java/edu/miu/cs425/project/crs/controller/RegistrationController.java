package edu.miu.cs425.project.crs.controller;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.service.BlockService;
import edu.miu.cs425.project.crs.service.ClassService;
import edu.miu.cs425.project.crs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistrationController {

    private BlockService blockService;
    private UserService userService;
    private ClassService classService;

    @Autowired
    public RegistrationController(BlockService blockService, UserService userService,ClassService classService) {
        this.blockService = blockService;
        this.userService = userService;
        this.classService = classService;
    }

    @GetMapping(value = "/classes")
    public String displayAvailableClasses(Model model){
        List<Block> blocks = blockService.getAllActiveBlocks();
        model.addAttribute("blocks", blocks);
        return "registration/index";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam("id") long id){
        Class c = classService.findClassById(id);
        userService.removeClassesBelongTo(c.getBlock());
        userService.registerTo(c);
        return "redirect:/classes";
    }

}
