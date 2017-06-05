package net.sdygt.jsp.login.model;

import java.sql.*;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private Connection conn;

    private void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_test", "root", "");
    }

    public Boolean query() throws SQLException, ClassNotFoundException {
        this.connect();
        String sql = "SELECT `username`,`password` FROM `users` WHERE `username` = ? LIMIT 1;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, this.username);

        ResultSet rs = pstmt.executeQuery();
        return rs.next() && Objects.equals(rs.getString("password"), this.password);
    }

    public Boolean save() throws SQLException, ClassNotFoundException {
        this.connect();
        conn.setAutoCommit(false);

        String sql = "SELECT `username`,`password` FROM `users` WHERE `username` = ? LIMIT 1;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, this.username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) { // username exists
            conn.rollback();
            return false;
        }

        sql = "INSERT INTO `users` (`username`, `password`) VALUES (?, ?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, this.username);
        pstmt.setString(2, this.password);
        pstmt.executeUpdate();
        conn.commit();
        return true;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return username + " (toString)";
    }
}
