import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdate {
    public static void main(String[] args) {
        PreparedStatement ps = null;
        Connection connect = null;
        try {
            connect = JdbcUtility.getConnection();
            String query = "UPDATE studentinfo SET sage=? WHERE id=?";
            ps = connect.prepareStatement(query);

            ps.setInt(1,30);
            ps.setInt(2,1);
            ps.addBatch();

            ps.setInt(1,31);
            ps.setInt(2,2);
            ps.addBatch();

            ps.setInt(1,32);
            ps.setInt(2,3);
            ps.addBatch();

            ps.setInt(1,33);
            ps.setInt(2,4);
            ps.addBatch();

            int[] rowsAffected = ps.executeBatch();

            if(rowsAffected.length==0){
                System.out.println("Unable to update data");
            }else {
                System.out.println("Data updated successfully on" + rowsAffected);
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
