import java.sql.*;

public class JdbcUtility {
    static {
        try {
            //Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Establish the connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "drakshapally";
        return DriverManager.getConnection(url,user,password);
    }
    //Closing the resources
    public static void closeConnection(Connection connect, Statement statement, ResultSet resultSet) throws SQLException{
        connect.close();
        statement.close();
        resultSet.close();
    }
}
