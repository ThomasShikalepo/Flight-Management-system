
import DB.Myconnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Thomas
 */
public class TicketBookingConnectino {

    Connection conn;
    PreparedStatement pst;

    public TicketBookingConnectino() {
        conn = Myconnection.getConnection(); // Cast conn to java.sql.Connection in the getConnection method
    }

    // Inserting data into the database
    public void bookingTicket(String passportNumber, String FirstName, String Lastname,
            String FlightNumber, String DepartureAirPort,
            String ArrivalAirPort, String DepartureDate, String AvrivalDate, int priceTicketText,
            String seat) {
        // Define a stored procedure call to add a new flight

        String storedProcedureCall = "{call SP_BookingTable(?, ?, ?, ?, ?, ?, ?,?, ?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(storedProcedureCall)) {
            // Set parameters for the stored procedure
            cstmt.setString(1, passportNumber);
            cstmt.setString(2, FirstName);
            cstmt.setString(3, Lastname);
            cstmt.setString(4, FlightNumber);
            cstmt.setString(5, DepartureAirPort);
            cstmt.setString(6, ArrivalAirPort);
            cstmt.setString(7, DepartureDate);
            cstmt.setString(8, AvrivalDate);
            cstmt.setInt(9, priceTicketText);
            cstmt.setString(10, seat);

            // Execute the stored procedure
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "You have successfully booked your ticket!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

  public void getBookingInfo(JTable table, String searchValue) {
    String sql = "SELECT * FROM BookingTable WHERE CONCAT(PassportNumber, FirstName, Lastname, "
            + "FlightNumber, DepartureAirPort, ArrivalAirPort, "
            + "DepartureDate, AvrivalDate, Price, Seat) LIKE ?";
    try {
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + searchValue + "%");
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row;

        while (rs.next()) {
            row = new Object[10]; // Adjust the array size based on the number of columns you are retrieving

            row[0] = rs.getString("PassportNumber");
            row[1] = rs.getString("FirstName");
            row[2] = rs.getString("Lastname");
            row[3] = rs.getString("FlightNumber");
            row[4] = rs.getString("DepartureAirPort");
            row[5] = rs.getString("ArrivalAirPort");
            row[6] = rs.getString("DepartureDate");
            row[7] = rs.getString("ArrivalDate");
            row[8] = rs.getInt("Price");
            row[9] = rs.getString("Seat");

            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving booking data: " + ex.getMessage());
    }
}

    
    }

