import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {
    public static void main(String[] args) {
        PreparedStatement ps = null;
        Connection connect = null;
        ResultSet rs = null;
        try {
            connect = JdbcUtility.getConnection();
            String query = "SELECT id,sname,sage,scity FROM studentinfo WHERE id=?";
            ps = connect.prepareStatement(query);

            System.out.println("Enter value tobe fetched from DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id");
            Integer id = scan.nextInt();

            ps.setInt(1,id);

             rs = ps.executeQuery();

            if(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getInt("sage")+" "+rs.getString("scity"));
            }else {
                System.out.println("There is no record with"+ id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JdbcUtility.closeConnection(connect,ps);
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
