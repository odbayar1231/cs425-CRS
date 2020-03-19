package edu.miu.cs425.project.crs.service;

import edu.miu.cs425.project.crs.model.Block;
import edu.miu.cs425.project.crs.model.Class;
import edu.miu.cs425.project.crs.model.User;

public interface UserService {
    User registerTo(Class c);
    User removeClassesBelongTo(Block b);

}
