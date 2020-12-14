package by.teachmeskills.module;

public class UserEntityFields {


    private static final String INSERT_USER = "INSERT  INTO users (id,name,surname,email,password) VALUES(?,?,?,?,?);";
    private static final String GET_ALL_USERS = "SELECT * FROM users";

    public static String getGetAllUsers() {
        return GET_ALL_USERS;
    }
    public static String getInsertUser() {
        return INSERT_USER;
    }

}
