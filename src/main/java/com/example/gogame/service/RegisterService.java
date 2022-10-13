package com.example.gogame.service;

import com.example.gogame.dao.RegisterDAO;
import com.example.gogame.entity.db.User;
import com.example.gogame.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {
    @Autowired
    private RegisterDAO registerDAO;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDAO.register(user);
    }
}
