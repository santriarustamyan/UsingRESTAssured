import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectURL {
    public static void main(String[] args) {
        // Create a variable for the connection string.
       // String dbURL = "jdbc:sqlserver://localhost\\sqlexpress"
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost/SQLEXPRESS;databaseName=Project; integratedSecurity=true;");
             Statement stmt = con.createStatement();)
        {
            String SQL = "SELECT TOP 10 1 FROM User";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
