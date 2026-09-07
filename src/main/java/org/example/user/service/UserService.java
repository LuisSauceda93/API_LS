package org.example.user.service;

import org.example.user.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}
