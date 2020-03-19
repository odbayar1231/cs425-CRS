package edu.miu.cs425.project.crs.service.impl;

import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.repository.ClassRepository;
import edu.miu.cs425.project.crs.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;

    @Override
    public Class findClassById(long id) {
        return classRepository.findById(id).orElse(null);
    }
}
