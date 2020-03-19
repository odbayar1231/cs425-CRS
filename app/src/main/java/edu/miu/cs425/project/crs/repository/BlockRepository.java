package edu.miu.cs425.project.crs.repository;

import edu.miu.cs425.project.crs.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
    @Query("SELECT b FROM Block b WHERE b.startDate > CURRENT_DATE ORDER BY b.startDate")
    List<Block> findAllActiveBlocks();
}
