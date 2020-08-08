package cn.itcast.DAO;

import cn.itcast.User.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users=new ArrayList<>();

    static {
        users.add(new User("aaa","123"));
        users.add(new User("bbb","123"));
        users.add(new User("ccc","123"));

    }
    public static List<User> getUsers(){
        return users;
    }
    public static void setUsers(List<User> users){
        UserDB.users=users;
    }
}
