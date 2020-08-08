package cn.itcast.DAO;

import cn.itcast.User.User;

import java.util.List;

public class UserDao {
    public User find(String username,String password){
        List<User> userList=UserDB.getUsers();

        //遍历集合，看有没有对应的username和password
        for(User user:userList){
            if (user.getUsername().equals(username)&&user.getPassward().equals(password)){
                return user;
            }
        }
        return null;
    }
}
