


import DB.Myconnection;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public boolean checkDatails(){
      // Check if PassID field is empty
if (passID.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Passport/ID number is required", "Error", JOptionPane.ERROR_MESSAGE);
    return false; // Exit the method
}

// Check if Password field is empty
if (password.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
    return false; // Exit the method
}
return true;
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        password = new javax.swing.JPasswordField();
        passID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Singin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Signup = new javax.swing.JButton();
        Forgot = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 380, 40));
        jPanel2.add(passID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 380, 40));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("Welcome to CodeAirLines");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 610, -1));

        Singin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Singin.setText("Sign in");
        Singin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinginActionPerformed(evt);
            }
        });
        jPanel2.add(Singin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, -1, 40));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        Signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Signup.setText("Sign up");
        Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupActionPerformed(evt);
            }
        });
        jPanel2.add(Signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        Forgot.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Forgot.setText("Forgot password");
        Forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotActionPerformed(evt);
            }
        });
        jPanel2.add(Forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText(" Where Every Byte Flies First Class!");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 319, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plane-png-image-1569.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 740));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SinginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinginActionPerformed
        // TODO add your handling code here:
        
    /*   if (checkDatails()) {
    try {
        // Check if PassID and Password fields are empty
        String passIDText = passID.getText();
        String passwordText = password.getText();

        if (passIDText.isEmpty() || passwordText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Passport/ID number and password are required", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method
        }

        // Parse PassID after ensuring it's not empty
        int passID = Integer.parseInt(passIDText);

        String sqlQuery = "SELECT * FROM passager WHERE PassportNumber = ? AND password = ?";
        // Assuming Myconnection extends or contains the necessary methods for database connection
        Myconnection myConn = new Myconnection();
        Connection conn = myConn.getConnection();
        
        PreparedStatement pst = conn.prepareStatement(sqlQuery);
        pst.setInt(1, passID);  // Set PassportNumber parameter
        pst.setString(2, passwordText);  // Set password parameter
        
        ResultSet rs = pst.executeQuery();
        
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Passport/ID number and password are incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //opens the tiket page 
            TicketBooking ticket = new TicketBooking();
            ticket.setVisible(true);
            
            
        }
        
        rs.close();
        pst.close();
        conn.close();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Passport/ID format", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
      if (checkDatails()) {
    try {
        // Check if PassID and Password fields are empty
        String passIDText = passID.getText();
        String passwordText = password.getText();

        if (passIDText.isEmpty() || passwordText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Passport/ID number and password are required", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method
        }

        // Parse PassID after ensuring it's not empty
        int passID = Integer.parseInt(passIDText);

        String sqlQuery = "SELECT * FROM staff WHERE PassportNumber = ? AND password = ?";
        // Assuming Myconnection extends or contains the necessary methods for database connection
        Myconnection myConn = new Myconnection();
        Connection conn = myConn.getConnection();
        
        PreparedStatement pst = conn.prepareStatement(sqlQuery);
        pst.setInt(1, passID);  // Set PassportNumber parameter
        pst.setString(2, passwordText);  // Set password parameter
        
        ResultSet rs = pst.executeQuery();
        
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Passport/ID number and password are incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //opens the tiket page 
            TicketBooking ticket = new TicketBooking();
            ticket.setVisible(true);
            
            
        }
        
        rs.close();
        pst.close();
        conn.close();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Passport/ID format", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
      }
       }*/


    }//GEN-LAST:event_SinginActionPerformed

    private void SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupActionPerformed
       signUpUpdated signup = new signUpUpdated();
       signup.setVisible(true);
    }//GEN-LAST:event_SignupActionPerformed

    private void ForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotActionPerformed
        // TODO add your handling code here:
        forgotPassword forgot = new forgotPassword();
        forgot.setVisible(true);
    }//GEN-LAST:event_ForgotActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Login login = new Login();
                 login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Forgot;
    private javax.swing.JButton Signup;
    private javax.swing.JButton Singin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField passID;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
