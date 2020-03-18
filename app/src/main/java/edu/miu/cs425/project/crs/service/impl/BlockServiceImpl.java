package edu.miu.cs425.project.crs.service.impl;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.repository.BlockRepository;
import edu.miu.cs425.project.crs.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    private BlockRepository blockRepository;

    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public List<Block> getAllActiveBlocks() {
        return blockRepository.findAllActiveBlocks();
    }
}
