import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDelete {
    public static void main(String[] args) {
        PreparedStatement ps = null;
        Connection connect = null;
        try {
            connect = JdbcUtility.getConnection();
            String query = "DELETE FROM studentinfo WHERE id=?";
            ps = connect.prepareStatement(query);

            System.out.println("Enter values tobe deleted in DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id");
            Integer id = scan.nextInt();

            ps.setInt(1,id);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==0){
                System.out.println("Unable to delete data");
            }else {
                System.out.println("Data deleted successfully");
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
