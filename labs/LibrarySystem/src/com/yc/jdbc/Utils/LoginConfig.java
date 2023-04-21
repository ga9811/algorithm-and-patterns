package com.yc.jdbc.Utils;

import com.yc.jdbc.domain.User;

import java.io.*;

public class LoginConfig {

    public static void save(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("login_info.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User load() {
        User user = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("login_info.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
