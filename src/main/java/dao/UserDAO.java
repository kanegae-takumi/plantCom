package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO {
    public void insertUser(UserDTO user) throws SQLException {
        String sql = "INSERT INTO users (account_name, name, email, password) VALUES (?, ?, ?, ?)";
        try (
            Connection conn = DBManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
        	ps.setString(1, user.getAccount_Name());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        }
    }
}

