import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {
    public static void main(String[] args) {
        PreparedStatement ps = null;
        Connection connect = null;
        try {
            connect = JdbcUtility.getConnection();
            String query = "INSERT INTO studentinfo (id,sname,sage,scity) VALUES(?,?,?,?)";
            ps = connect.prepareStatement(query);

            System.out.println("Enter values to insert into DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id");
            Integer id = scan.nextInt();
            System.out.println("Enter name");
            String name = scan.next();
            System.out.println("Enter age");
            Integer age = scan.nextInt();
            System.out.println("Enter city");
            String city = scan.next();


            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setString(4,city);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==0){
            System.out.println("Unable to insert data");
            }else {
            System.out.println("Data inserted successfully");
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JdbcUtility.closeConnection(connect,ps);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
