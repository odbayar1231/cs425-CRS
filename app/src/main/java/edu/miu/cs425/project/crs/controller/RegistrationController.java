package edu.miu.cs425.project.crs.controller;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.model.User;
import edu.miu.cs425.project.crs.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class RegistrationController {

    private BlockService blockService;

    @Autowired
    public RegistrationController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping(value = "/classes")
    public String displayAvailableClasses(Model model){
        List<Block> blocks = blockService.getAllActiveBlocks();
        Class c = (Class) blocks.get(0).getClasses().toArray()[0];
        boolean isAvailable = c.isAvailableToRegister();
        model.addAttribute("blocks", blocks);
        return "/registration/index";
    }

}
