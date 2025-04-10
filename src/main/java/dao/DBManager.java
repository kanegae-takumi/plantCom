package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベースの接続を行う
 *
 * @since : 2025/02/20
 * @author : K.Imazawa
 */
public class DBManager {

    private static final String NAME_DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/plantcom?characterEncoding=UTF-8&serverTimeZone=JST";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * コネクションを確立します
     *
     * @since : 2025/02/20 K.Imazawa
     * @return Connection コネクション
     * @throws SQLException DBのオープンに失敗した場合
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // ドライバのロード
            Class.forName(NAME_DRIVER_MYSQL);
            
            // データベース接続
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (conn == null) {
                throw new SQLException("データベース接続に失敗しました。コネクションがnullです。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBCドライバのロードに失敗しました: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("データベース接続に失敗しました: " + e.getMessage());
        }
        return conn;
    }
}
