/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import DB.adminConnection;
import java.awt.Color;
import java.lang.System.Logger;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JFrame;

public class Admin extends javax.swing.JFrame {

    
    
    public boolean isEmptyFlight() {

        if (flightNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Flight Number is missing");
            return false;
        }
        if (departureAirPort.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Departure Airport is missing");
            return false;
        }
        if (departureDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Departure date is missing");
            return false;
        }

        // Check if the departure date is in the past
        if (departureDate.getDate().compareTo(new Date()) < 0) {
            JOptionPane.showMessageDialog(this, "You cannot book in the past (Departure date)");
            return false;
        }

        if (arrivalAirPort.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Arrival Airport is missing");
            return false;
        }
        if (arrivalDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Arrival date is missing");
            return false;
        }

        // Check if the arrival date is in the past
        if (arrivalDate.getDate().compareTo(new Date()) < 0) {
            JOptionPane.showMessageDialog(this, "You cannot book in the past (Arrival date)");
            return false;
        }

        if (priceAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is missing");
            return false;
        }
        if (departureTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Departure time is missing");
            return false;
        }
        if (departureTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Departure time is missing");
            return false;
        }
        
        if (arrivalTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Arrival time is missing");
            return false;
        }

        return true;
        
    }
   

    Connection connect = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    private JFrame admin;
    String urllink = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Airline;encrypt=true;trustServerCertificate=true;";
    String pass = "35987521456";
    String username = "admin";

    public Admin() {
        initComponents();
       tableViewFlight();
    }

     

    public void init() {

    }
    

    private void tableViewFlight() {

        adminConnection adminConn = new adminConnection();
        adminConn.getFlightValues(infoTable, "");
        DefaultTableModel model = (DefaultTableModel) infoTable.getModel();

        infoTable.setRowHeight(30);
        infoTable.setShowGrid(true);
        infoTable.setGridColor(Color.black); // Use Color.black instead of black
        infoTable.setBackground(Color.white); // Use Color.white instead of white

    }
    

    public void empty() {
        flightNumber.setText(null);
        departureAirPort.setText(null);
        arrivalAirPort.setText(null);
        departureDate.setDate(null);
        departureTime.setText(null);
        arrivalDate.setDate(null);
        arrivalTime.setText(null);
        priceAmount.setText(null);
    }

    public void displayData() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(urllink, username, pass);
            st = connect.createStatement();
            rs = st.executeQuery("select* from flight");

            DefaultTableModel dbTable = (DefaultTableModel) infoTable.getModel();
            dbTable.setRowCount(0);
            while (rs.next()) {
                dbTable.addRow(new String[]{rs.getString(0),
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    
                });
            }
        } catch (Exception ex) {
            System.out.println("Failed to connect to the database");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        arrivalAirPort = new javax.swing.JTextField();
        flightNumber = new javax.swing.JTextField();
        departureAirPort = new javax.swing.JTextField();
        departureTime = new javax.swing.JTextField();
        arrivalTime = new javax.swing.JTextField();
        priceAmount = new javax.swing.JTextField();
        resetbtn = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        removebtn = new javax.swing.JButton();
        bviewbtn = new javax.swing.JButton();
        extitbtn = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        departureDate = new com.toedter.calendar.JDateChooser();
        arrivalDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(60767, 60767));
        jPanel1.setPreferredSize(new java.awt.Dimension(20000, 20718));

        jPanel2.setBackground(new java.awt.Color(3, 27, 27));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("CodeAirlines Flight Management");
        jLabel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel2.setText("Flight Number:");

        jLabel3.setText("Departure Airport:");

        jLabel4.setText("Arrival Airport:");

        jLabel5.setText("Departure Date:");

        jLabel6.setText("Departure Time:");

        jLabel7.setText("Arrival Date:");

        jLabel8.setText("Arrival Time:");

        jLabel9.setText("Amount:");

        infoTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight Number", "Departure Airport", "Arrival Airport", "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", "Amount"
            }
        ));
        infoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infoTable);
        if (infoTable.getColumnModel().getColumnCount() > 0) {
            infoTable.getColumnModel().getColumn(0).setResizable(false);
            infoTable.getColumnModel().getColumn(1).setResizable(false);
            infoTable.getColumnModel().getColumn(2).setResizable(false);
            infoTable.getColumnModel().getColumn(3).setResizable(false);
            infoTable.getColumnModel().getColumn(4).setResizable(false);
            infoTable.getColumnModel().getColumn(5).setResizable(false);
            infoTable.getColumnModel().getColumn(6).setResizable(false);
            infoTable.getColumnModel().getColumn(7).setResizable(false);
        }

        arrivalAirPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        arrivalAirPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalAirPortActionPerformed(evt);
            }
        });

        flightNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        departureAirPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        departureTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        arrivalTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        arrivalTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalTimeActionPerformed(evt);
            }
        });

        priceAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        resetbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        insert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        removebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removebtn.setText("Remove flight");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        bviewbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bviewbtn.setText("View Bookings");
        bviewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewbtnActionPerformed(evt);
            }
        });

        extitbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        extitbtn.setText("EXIT");
        extitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extitbtnActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setText("UPDATE");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        departureDate.setDateFormatString("yyyy-MM-dd");
        departureDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        arrivalDate.setDateFormatString("yyyy-MM-dd");
        arrivalDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(flightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(resetbtn)
                                .addGap(51, 51, 51)
                                .addComponent(insert)
                                .addGap(44, 44, 44)
                                .addComponent(editButton)
                                .addGap(34, 34, 34)
                                .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bviewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(extitbtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departureAirPort, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(arrivalAirPort, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(62, 62, 62)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel5)
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(arrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(arrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(priceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departureAirPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrivalAirPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(flightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(removebtn)
                    .addComponent(bviewbtn)
                    .addComponent(extitbtn)
                    .addComponent(resetbtn)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1385, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void extitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extitbtnActionPerformed

        if (JOptionPane.showConfirmDialog(admin, "You are logged in as the admin are you sure you want to exit", "Confirm",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_extitbtnActionPerformed

    private void bviewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewbtnActionPerformed
        dispose();
        Bookings booked = new Bookings();
        booked.setVisible(true);
    }//GEN-LAST:event_bviewbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
          if (isEmptyFlight()) {
        // Fetch input values from UI components
        String priceticketText = priceAmount.getText();
        String flightnumber = flightNumber.getText();
        String departureAir = departureAirPort.getText();
        String arrivalAir = arrivalAirPort.getText();
        String Departuretime = departureTime.getText();
        String Arrivaltime = arrivalTime.getText();

        // Validate inputs
       

        // Format date objects to string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Departuredate = dateFormat.format(departureDate.getDate());
        String Arrivaldate = dateFormat.format(arrivalDate.getDate());

        // Parse price text to integer
        int ticketPrice = Integer.parseInt(priceticketText);
            try {
               
                int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to permananetly delete the flight", "Warning", JOptionPane.YES_NO_OPTION);
                if (deleteItem == JOptionPane.YES_OPTION) {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    connect = DriverManager.getConnection(urllink, username, pass);
                    pst = connect.prepareStatement("delete from flight where flightNumber=?");
                    pst.setString(1, flightnumber);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Row deleted succeffuly");
                }
             

            } catch (Exception ex) {
                System.out.print("Deletion is unsuccessful" + ex.getMessage());
             ex.printStackTrace(); 
            }
            
        }
    }                                         

    private void viewDatabtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        displayData();
    
        
    }//GEN-LAST:event_removebtnActionPerformed
//inbtn used to insert data from the jtextfield into the database
    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
       if (isEmptyFlight()) {
    try {
        // Fetch input values from UI components
        String priceticketText = priceAmount.getText();
        String flightnumber = flightNumber.getText();
        String departureAir = departureAirPort.getText();
        String arrivalAir = arrivalAirPort.getText();
        String Departuretime = departureTime.getText();
        String Arrivaltime = arrivalTime.getText();

        // Validate inputs
       

        // Format date objects to string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Departuredate = dateFormat.format(departureDate.getDate());
        String Arrivaldate = dateFormat.format(arrivalDate.getDate());

        // Parse price text to integer
        int ticketPrice = Integer.parseInt(priceticketText);

        // Create adminConnection instance for database operations
        adminConnection adminConn = new adminConnection();

        // Insert flight into the database
        adminConn.flightIntoDatabase(flightnumber, departureAir, arrivalAir, Departuredate, Departuretime, Arrivaldate, Arrivaltime, ticketPrice );

        // Update existing table model and display updated flight values
      
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid price.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_insertActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        empty();
    }//GEN-LAST:event_resetbtnActionPerformed

    private void infoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTableMouseClicked
           DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
        int rowIndex = infoTable.getSelectedRow();
        if (rowIndex != -1) { // Check if a row is selected
            flightNumber.setText(model.getValueAt(rowIndex, 0).toString());
            departureAirPort.setText(model.getValueAt(rowIndex, 1).toString());
            arrivalAirPort.setText(model.getValueAt(rowIndex, 2).toString());
            arrivalTime.setText(model.getValueAt(rowIndex, 6).toString());
             departureTime.setText(model.getValueAt(rowIndex, 4).toString());
            String PriceText = priceAmount.getText(); // Assuming Price is a JTextField or similar component where the user enters the price
          
             priceAmount.setText(model.getValueAt(rowIndex, 7).toString());
            try {
                // Parse departure date (assuming it's in column 4 and in format "yyyy-MM-dd")
                Date DepartureDate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 5).toString());
                departureDate.setDate(DepartureDate);

                // Parse arrival date (assuming it's in column 5 and in format "yyyy-MM-dd")
                Date ArrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 3).toString());
               arrivalDate.setDate(ArrivalDate);

       
            

            } catch (NumberFormatException ex) {
                // Handle parsing exceptions
                  java.util.logging.Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 

    }//GEN-LAST:event_infoTableMouseClicked

    private void arrivalTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalTimeActionPerformed
     
    }//GEN-LAST:event_arrivalTimeActionPerformed

    private void arrivalAirPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalAirPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrivalAirPortActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
         if (isEmptyFlight()) {
        // Fetch input values from UI components
        String priceticketText = priceAmount.getText();
        String flightnumber = flightNumber.getText();
        String departureAir = departureAirPort.getText();
        String arrivalAir = arrivalAirPort.getText();
        String Departuretime = departureTime.getText();
        String Arrivaltime = arrivalTime.getText();

        // Validate inputs
       

        // Format date objects to string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Departuredate = dateFormat.format(departureDate.getDate());
        String Arrivaldate = dateFormat.format(arrivalDate.getDate());

        // Parse price text to integer
        int ticketPrice = Integer.parseInt(priceticketText);

       

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connect = DriverManager.getConnection(urllink, username, pass);
        PreparedStatement preparedStatement = connect.prepareStatement(
            "UPDATE flight SET flightNumber=?, DepartureAirport=?, ArrivalAirport=?, " +
            "DepartureDate=?, DepartureTime=?, ArrivalDate=?, ArrivalTime=?, TicketPrice=? " +
            "WHERE flightNumber=?"
        );
        preparedStatement.setString(1, flightnumber);
        preparedStatement.setString(2, departureAir);
        preparedStatement.setString(3, arrivalAir);
        preparedStatement.setString(4, Departuredate);
        preparedStatement.setString(5, Departuretime);
        preparedStatement.setString(6, Arrivaldate);
        preparedStatement.setString(7, Arrivaltime);
        preparedStatement.setInt(8, ticketPrice);
        preparedStatement.setString(9, flightnumber); // For WHERE clause
        preparedStatement.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data updated successfully!");
        
       
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Failed to update data: " + ex.getMessage());
        ex.printStackTrace(); 
    }
        

    }//GEN-LAST:event_editButtonActionPerformed
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arrivalAirPort;
    private com.toedter.calendar.JDateChooser arrivalDate;
    private javax.swing.JTextField arrivalTime;
    private javax.swing.JButton bviewbtn;
    private javax.swing.JTextField departureAirPort;
    private com.toedter.calendar.JDateChooser departureDate;
    private javax.swing.JTextField departureTime;
    private javax.swing.JButton editButton;
    private javax.swing.JButton extitbtn;
    private javax.swing.JTextField flightNumber;
    private javax.swing.JTable infoTable;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priceAmount;
    private javax.swing.JButton removebtn;
    private javax.swing.JButton resetbtn;
    // End of variables declaration//GEN-END:variables
}
