package DB;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.CallableStatement;
import java.sql.Connection; // Import java.sql.Connection instead of com.sun.jdi.connect.spi.Connection
import java.sql.Date; // Import java.sql.Date for SQL date types
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class adminConnection {
    Connection conn;
    PreparedStatement pst;

    public adminConnection() {
        conn = Myconnection.getConnection(); // Cast conn to java.sql.Connection in the getConnection method
    }

    // Inserting data into the database
    public void flightIntoDatabase(String flightNumber, String departureAirport, String arrivalAirport, String departureDate,String departuretime, String arrivalDate,String arrivaltime, int price) {
        // Define a stored procedure call to add a new flight
        
        String storedProcedureCall = "{call sp_AddFlight(?, ?, ?, ?, ?, ?, ?,?)}";

        try (CallableStatement cstmt = conn.prepareCall(storedProcedureCall)) {
            // Set parameters for the stored procedure
            cstmt.setString(1, flightNumber);
            cstmt.setString(2, departureAirport);
            cstmt.setString(3, arrivalAirport);
            cstmt.setDate(4, java.sql.Date.valueOf(departureDate));
            cstmt.setString(5,departuretime);
            cstmt.setDate(6, java.sql.Date.valueOf(arrivalDate));
            cstmt.setString(7, arrivaltime);
            cstmt.setInt(8, price);

            // Execute the stored procedure
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "A new flight was successfully added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
     public void getFlightValues(JTable table, String searchValue) {
    String sql = "SELECT * FROM Flight WHERE CONCAT(flightNumber, departureAirport, arrivalAirport, "
            + "departureDate, departureTime, arrivalDate, "
            + "arrivalTime, ticketprice) LIKE ?";
    try {
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + searchValue + "%");
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row;

        while (rs.next()) {
            row = new Object[8]; // Adjust the array size based on the number of columns you are retrieving

            row[0] = rs.getString("flightNumber");
            row[1] = rs.getString("departureAirport");
            row[2] = rs.getString("arrivalAirport");
            row[3] = rs.getDate("departureDate");
            row[4] = rs.getString("departureTime");
            row[5] = rs.getDate("arrivalDate");
            row[6] = rs.getString("arrivalTime");
              row[7] = rs.getString("ticketprice");
          
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(table, "Error retrieving flight data: " + ex.getMessage());
    }
}
public void deleteFlight(String flightNumber) {
    String sql = "DELETE FROM Flight WHERE flightNumber = ?";
    try {
        pst = conn.prepareStatement(sql);
        pst.setString(1, flightNumber);
        
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Flight deleted successfully.");
        } else {
            System.out.println("Flight with the specified flight number not found.");
        }
    } catch (SQLException ex) {
        System.out.println("Error deleting flight: " + ex.getMessage());
    }
}


public void updateFlightValues(JTable table, String searchValue) {
 String sql = "UPDATE Flight SET CONCAT(flightNumber, departureAirport, arrivalAirport, "
            + "departureDate, departureTime, arrivalDate, "
            + "arrivalTime, ticketprice) WHERE flightNumber ?";   
 try {
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + searchValue + "%");
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row;

        while (rs.next()) {
            row = new Object[8]; // Adjust the array size based on the number of columns you are retrieving

            row[0] = rs.getString("flightNumber");
            row[1] = rs.getString("departureAirport");
            row[2] = rs.getString("arrivalAirport");
            row[3] = rs.getDate("departureDate");
            row[4] = rs.getString("departureTime");
            row[5] = rs.getDate("arrivalDate");
            row[6] = rs.getString("arrivalTime");
              row[7] = rs.getString("ticketprice");
          
            model.addRow(row);
             JOptionPane.showMessageDialog(null, "Successfully updated!");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(table, "Error retrieving flight data: " + ex.getMessage());
    }
}


    

}
