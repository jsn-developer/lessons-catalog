package jp.co.solxyz.lessons.catalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDao {

    private static final String CONNECTION_STRING = "jdbc:mysql://db/catalog?user=user&password=user";

    Connection conn;

    public DataDao() throws ClassNotFoundException {
        Class.forName( "com.mysql.jdbc.Driver" );
    }

    public void select(String query)  throws ClassNotFoundException, SQLException {

        try(Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {

            var st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            // 取り出し
            while(result.next()) {

            }

        } catch(SQLException e) {
            conn.rollback();
            throw e;
        } 
    }

}
