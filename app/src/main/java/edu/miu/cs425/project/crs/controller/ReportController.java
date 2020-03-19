package edu.miu.cs425.project.crs.controller;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.report.PieChart;
import edu.miu.cs425.project.crs.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    BlockService blockService;

    @GetMapping(value = "/{blockId}")
    public PieChart displayReport(@PathVariable("blockId") long blockId){
        Block block = blockService.findBlockById(blockId);
        return new PieChart(block);
    }
}
