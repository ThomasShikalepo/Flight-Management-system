


import DB.Myconnection;
import java.sql.PreparedStatement;



import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class signUPcon {

    Connection conn;
    PreparedStatement pst;

    public signUPcon() {
        // Initialize the connection in the constructor
        conn = Myconnection.getConnection();
    }

    // Method to insert student data into the passager table
    public void insertPassager(int passportNumber, String firstName, String lastName, String email,
            int phoneNumber, String nationality, String password, String confirmPassword) {
        // Define a stored procedure call to add a new passager
        String storedProcedureCall = "{call SP_PassagerRegistration(?, ?, ?, ?, ?, ?, ?, ?)}"; // corrected the syntax

        try (CallableStatement cstmt = conn.prepareCall(storedProcedureCall)) {
            // Set parameters for the stored procedure
            cstmt.setInt(1, passportNumber);
            cstmt.setString(2, firstName);
            cstmt.setString(3, lastName);
            cstmt.setString(4, email);
            cstmt.setInt(5, phoneNumber);
            cstmt.setString(6, nationality);
            cstmt.setString(7, password);
            cstmt.setString(8, confirmPassword);

            // Execute the stored procedure
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "You have successfully created an account");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void forgotPassword(int passportnumber, int phonenumber, String email, String password, String confirmPassword) {
        // Define a stored procedure call to add a new passager
        String storedProcedureCall = "{call SP_forgotPassword(?, ?, ?, ?, ?)}"; // corrected the syntax

        try (CallableStatement cstmt = conn.prepareCall(storedProcedureCall)) {
            // Set parameters for the stored procedure
            cstmt.setInt(1, passportnumber);
            cstmt.setInt(2, phonenumber);
            cstmt.setString(3, email);
            cstmt.setString(4, password);
            cstmt.setString(5, confirmPassword);

            System.out.println("Executing SQL: " + storedProcedureCall); // Debugging output
            System.out.println("Parameters: passport=" + passportnumber + ", phonenumber=" + phonenumber + ", Email=" + email
                    + ", password=" + password + ", confirmPassword=" + confirmPassword); // Debugging output

            cstmt.execute();
            JOptionPane.showMessageDialog(null, "You have successfully updated your password");

        } catch (SQLException ex) {
            ex.printStackTrace();  // Log the exception details for debugging
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }

}
