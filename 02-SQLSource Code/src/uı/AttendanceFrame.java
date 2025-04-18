package uı;

import models.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Attendance;
import java.sql.Date;
import java.util.List;


public class AttendanceFrame extends javax.swing.JFrame {

    /**
     * Creates new form AttendanceFrame
     */
    public AttendanceFrame() {
        initComponents();
        refreshAttendancesTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAttDate = new javax.swing.JTextField();
        txtCourseId = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        btnAddAttendance = new javax.swing.JButton();
        btnEditAttendance = new javax.swing.JButton();
        btnDeleteAttendance = new javax.swing.JButton();
        btnListAllAttendances = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAttendances = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Attendance Management");

        jLabel3.setText("Student ID:");

        jLabel4.setText("Course ID:");

        jLabel5.setText("Attendance Date:");

        btnAddAttendance.setText("Add");
        btnAddAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAttendanceActionPerformed(evt);
            }
        });

        btnEditAttendance.setText("Edit");
        btnEditAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAttendanceActionPerformed(evt);
            }
        });

        btnDeleteAttendance.setText("Delete");
        btnDeleteAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAttendanceActionPerformed(evt);
            }
        });

        btnListAllAttendances.setText("List");
        btnListAllAttendances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAllAttendancesActionPerformed(evt);
            }
        });

        btnBackToMenu.setText("Main Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });

        tblAttendances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Attendance ID:", "Student ID:", "Course ID:", "Attendance Date"
            }
        ));
        jScrollPane1.setViewportView(tblAttendances);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAttDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListAllAttendances)
                            .addComponent(btnDeleteAttendance)
                            .addComponent(btnAddAttendance)
                            .addComponent(btnEditAttendance)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBackToMenu)
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnBackToMenu))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAttendance)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditAttendance)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAttendance))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAttDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnListAllAttendances)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
private void refreshAttendancesTable() {
    DefaultTableModel model = (DefaultTableModel) tblAttendances.getModel();
    model.setRowCount(0); // Tablodaki mevcut satırları temizle

    try {
        List<Attendance> attendances = Attendance.getAllAttendances(); // Veritabanından verileri getir
        for (Attendance attendance : attendances) {
            model.addRow(new Object[]{
                attendance.getAttId(),       // Attendance ID
                attendance.getStdId(),       // Student ID
                attendance.getCrsId(),       // Course ID
                attendance.getAttDate()      // Attendance Date
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error fetching attendance data: " + e.getMessage());
    }
}



    private void btnAddAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAttendanceActionPerformed
    try {
        int stdId = Integer.parseInt(txtStudentId.getText()); // Student ID
        int crsId = Integer.parseInt(txtCourseId.getText());  // Course ID
        Date attDate = Date.valueOf(txtAttDate.getText());    // YYYY-MM-DD formatında tarih

        // Attendance ekle (ID kullanıcıdan alınmaz)
        Attendance.addAttendance(stdId, crsId, attDate);

        // Başarı mesajı ve tabloyu yenileme
        JOptionPane.showMessageDialog(this, "Attendance added successfully!");
        refreshAttendancesTable();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding attendance: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAddAttendanceActionPerformed

    private void btnEditAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAttendanceActionPerformed
    try {
        // Kullanıcıdan yalnızca güncellenecek alanları alıyoruz
        int stdId = Integer.parseInt(txtStudentId.getText());
        int crsId = Integer.parseInt(txtCourseId.getText());
        Date attDate = Date.valueOf(txtAttDate.getText()); // YYYY-MM-DD formatında tarih

        // Seçili satırdan Attendance ID'yi al
        int selectedRow = tblAttendances.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to edit!");
            return;
        }
        int attId = (int) tblAttendances.getValueAt(selectedRow, 0); // Tablo üzerinden ID alınıyor

        // Veritabanında güncelleme işlemi
        String query = "UPDATE attendance SET std_id = ?, crs_id = ?, att_date = ? WHERE att_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, stdId);
            statement.setInt(2, crsId);
            statement.setDate(3, attDate);
            statement.setInt(4, attId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Attendance updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Attendance ID not found.");
            }
        }
        refreshAttendancesTable();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error updating attendance: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEditAttendanceActionPerformed

    private void btnDeleteAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAttendanceActionPerformed
        int selectedRow = tblAttendances.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an attendance record to delete!");
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) tblAttendances.getModel();
            int attId = (int) model.getValueAt(selectedRow, 0);

            Attendance.deleteAttendance(attId);
            JOptionPane.showMessageDialog(this, "Attendance deleted successfully!");
            refreshAttendancesTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting attendance: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteAttendanceActionPerformed

    private void btnListAllAttendancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAllAttendancesActionPerformed
    refreshAttendancesTable();
    }//GEN-LAST:event_btnListAllAttendancesActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
    btnBackToMenu.addActionListener(e -> {
    MainMenu mainMenu = new MainMenu();
    mainMenu.setVisible(true);
    dispose();
});
    }//GEN-LAST:event_btnBackToMenuActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAttendance;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnDeleteAttendance;
    private javax.swing.JButton btnEditAttendance;
    private javax.swing.JButton btnListAllAttendances;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAttendances;
    private javax.swing.JTextField txtAttDate;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
