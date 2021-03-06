package com.codegym.controller;

import com.codegym.IOFile.ReadFile;
import com.codegym.IOFile.WriteFile;
import com.codegym.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagement implements WriteFile, ReadFile {
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RESET = "\u001B[0m";
    private static List<User> users = new ArrayList<>();
    private static final String PATH_USER = "user.txt";
    private static final String REGEX_ID = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";//Tối thiểu tám ký tự, ít nhất một chữ cái và một số
    private static final String REGEX_PASS = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";//Tối thiểu tám ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường và một số

    public UserManagement() {
        File file = new File(PATH_USER);
        if (file.exists()) {
            try {
                readFile(PATH_USER);
            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }

    public void register(User user) {
        users.add(user);
        try {
            writeFile(PATH_USER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public boolean validateUserName(String regex) {
        Pattern pattern = Pattern.compile(REGEX_ID);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePassWord(String regex) {
        Pattern pattern = Pattern.compile(REGEX_PASS);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

   public boolean checkExistId(String string) {
        for (User user : users) {
            if (user.getUserName().equals(string)) {
                System.out.println(TEXT_RED+"Tài khoản đã tồn tại!!!"+TEXT_RESET);
                return true;
            }
        }
        return false;
    }

    public boolean checkLogin(String userName, String password, String role){
        boolean isLogin = false;
        for (int i = 0; i < users.size(); i++) {
            if (userName.equals(users.get(i).getUserName()) && password.equals(users.get(i).getPassword()) && role.equals(users.get(i).getRole()) ){
                isLogin = true;
                break;
            }
        }
        return  isLogin;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        users = (List<User>) ois.readObject();
        is.close();
        ois.close();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(users);
        os.close();
        oos.close();
    }
}
