package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginUserDTO;

public class LoginUserDAO {

    public LoginUserDTO login(String email, String password) throws SQLException {
        String sql = "SELECT id, account_name, name, email FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password); // ※本番ではハッシュ化すべきです

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new LoginUserDTO(
                        rs.getInt("id"),
                        rs.getString("account_name"),
                        rs.getString("name"),
                        rs.getString("email")
                    );
                }
            }
        }

        return null; // 該当ユーザーなし
    }
}

