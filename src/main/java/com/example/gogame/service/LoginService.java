package com.example.gogame.service;

import com.example.gogame.dao.LoginDAO;
import com.example.gogame.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public String verifyLogin(String userId, String password) throws IOException {
        password = Util.encryptPassword(userId, password);
        return loginDAO.verifyLogin(userId, password);
    }
}
