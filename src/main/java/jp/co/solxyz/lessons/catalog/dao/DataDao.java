package jp.co.solxyz.lessons.catalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.solxyz.lessons.catalog.entity.GoodsEntity;
import jp.co.solxyz.lessons.catalog.entity.InquiryEntity;

public class DataDao {

    private static final String CONNECTION_STRING = "jdbc:mysql://db/catalog?user=user&password=user";

    private static final String INSERT_GOODS_TABLE = "insert into goods (name, description, price, photodata, photomime), values(?, ?, ?, ?)";

    private static final String INSERT_INQUIRY_TABLE = "insert into inquiry (name, company, phone, mail) values (?, ?, ?, ?)";

    Connection conn;

    public DataDao() throws ClassNotFoundException {
        Class.forName( "com.mysql.cj.jdbc.Driver" );
    }

    /**
     * SELECTの発行
     * @param query 発行するSQLクエリ
     * @return 実行結果
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<GoodsEntity> select(String query)  throws ClassNotFoundException, SQLException {

        List<GoodsEntity> retSet = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {

            var st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            // 取り出し
            while(result.next()) {
                var goods = new GoodsEntity();

                goods.setId(result.getInt("id"));
                goods.setName(result.getString("name"));
                goods.setDescription(result.getString("description"));
                goods.setPrice(result.getLong("price"));

                // ImageData
                goods.setPhoto(result.getBytes("photodata"));
                goods.setMime(result.getString("photomime"));

                retSet.add(goods);
            }

        } catch(SQLException e) {
            conn.rollback();
            throw e;
        } 

        return retSet;
    }

    /**
     * 問い合わせ情報のインサート処理
     * @param entity
     * @return
     * @throws Exception
     */
    public int insert(InquiryEntity entity) throws Exception{

        try(Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(INSERT_INQUIRY_TABLE)) {

                ps.setString(1, entity.getName());
                ps.setString(2, entity.getCompany());
                ps.setString(3, entity.getPhone());
                ps.setString(4, entity.getMail());
                
                int ret = ps.executeUpdate();
                conn.commit();

                return ret;

            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        } catch(Exception e) {
           
            throw e;
        }
    }

}
