package edu.miu.cs425.project.crs.service.impl;

import edu.miu.cs425.project.crs.service.BlockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockServiceImplTest {

    @Autowired
    BlockService blockService;

    @Test
    void getAllActiveBlocks() {
        int count = blockService.getAllActiveBlocks().size();
        assertEquals(5, count);
    }
}