package by.teachmeskills.module;

public class UserSqlQueries {

    public static final String INSERT_USER = "INSERT  INTO users (name,surname,email,password) VALUES(?,?,?,?);";
    public static final String GET_ALL_USERS = "SELECT * FROM users";


}
