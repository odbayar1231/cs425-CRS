package edu.miu.cs425.project.crs.repository;

import edu.miu.cs425.project.crs.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
