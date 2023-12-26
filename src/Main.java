
import java.sql.*;

public class Main {
    public static void main(String[] args)  {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
        connect = JdbcUtility.getConnection();
        //Creating statement
        statement = connect.createStatement();
        //Execute query
        java.lang.String sqlInsertion = "INSERT INTO studentinfo (id,sname,sage,scity) VALUES(2,'test',28,'Delhi')";
        java.lang.String sqlUpdation = "UPDATE studentinfo SET sage=24 WHERE id=2";
        java.lang.String sqlRetrive = "SELECT * FROM studentinfo";
        java.lang.String sqlDelete = "DELETE FROM studentinfo WHERE id=2";
//        int rowsAffected = statement.executeUpdate(sqlDelete);
        resultSet = statement.executeQuery(sqlRetrive);
//
//        //Process the result
//        if(rowsAffected==0){
//            System.out.println("Unable to insert data");
//        }else {
//            System.out.println("Data inserted successfully");
//        }

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id")+" "+resultSet.getString("sname")+" "+resultSet.getInt("sage")+" "+resultSet.getString("scity"));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JdbcUtility.closeConnection(connect, statement);
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}