import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdate {
    public static void main(String[] args) {
        PreparedStatement ps = null;
        Connection connect = null;
        try {
            connect = JdbcUtility.getConnection();
            String query = "UPDATE studentinfo SET sage=? WHERE id=?";
            ps = connect.prepareStatement(query);

            System.out.println("Enter values tobe updated in DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id");
            Integer id = scan.nextInt();
            System.out.println("Enter age");
            Integer age = scan.nextInt();

            ps.setInt(1,age);
            ps.setInt(2,id);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==0){
                System.out.println("Unable to update data");
            }else {
                System.out.println("Data updated successfully");
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
