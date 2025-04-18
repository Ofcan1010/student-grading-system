package uı;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Grades;

public class GradesFrame extends javax.swing.JFrame {

    /**
     * Creates new form GradesFrame
     */
    public GradesFrame() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGradeId = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        txtCourseId = new javax.swing.JTextField();
        txtMidterm = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        txtHomework = new javax.swing.JTextField();
        txtLetterGrade = new javax.swing.JTextField();
        btnAddGrade = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        btnEditGrade = new javax.swing.JButton();
        btnDeleteGrade = new javax.swing.JButton();
        btnListAllGrades = new javax.swing.JButton();
        btnBackupGrades = new javax.swing.JButton();
        btnRestoreGrades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Grades Management");

        jLabel2.setText("Grade ID:");

        jLabel3.setText("Student ID:");

        jLabel4.setText("Course ID:");

        jLabel5.setText("Midterm:");

        jLabel6.setText("Homework:");

        jLabel7.setText("Final:");

        jLabel8.setText("Letter Grade:");

        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });

        btnAddGrade.setText("Add Grade");
        btnAddGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGradeActionPerformed(evt);
            }
        });

        btnBackToMenu.setText("Main Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });

        btnEditGrade.setText("Edit Grade");
        btnEditGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGradeActionPerformed(evt);
            }
        });

        btnDeleteGrade.setText("Delete Grade");
        btnDeleteGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGradeActionPerformed(evt);
            }
        });

        btnListAllGrades.setText("List All Grades");
        btnListAllGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAllGradesActionPerformed(evt);
            }
        });

        btnBackupGrades.setText("Backup Grades");
        btnBackupGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupGradesActionPerformed(evt);
            }
        });

        btnRestoreGrades.setText("Restore Grades");
        btnRestoreGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreGradesActionPerformed(evt);
            }
        });

        tblGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade ID", "Student ID", "Course ID", "Midterm ID", "Homework", "Final", "Letter Grade"
            }
        ));
        jScrollPane1.setViewportView(tblGrades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnBackToMenu)
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGradeId, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtStudentId)
                            .addComponent(txtCourseId)
                            .addComponent(txtMidterm)
                            .addComponent(txtHomework)
                            .addComponent(txtFinal)
                            .addComponent(txtLetterGrade))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddGrade)
                            .addComponent(btnEditGrade)
                            .addComponent(btnDeleteGrade)
                            .addComponent(btnListAllGrades)
                            .addComponent(btnBackupGrades)
                            .addComponent(btnRestoreGrades)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnBackToMenu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGradeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddGrade)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditGrade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteGrade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMidterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListAllGrades))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHomework, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackupGrades))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestoreGrades))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLetterGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void refreshGradesTable() {
    DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
    model.setRowCount(0); // Eski verileri temizle

    // Grades listesindeki tüm notları tabloya ekleyin
    for (Grades grade : Grades.grades) {
        model.addRow(new Object[]{
            grade.getGrdId(),
            grade.getStdId(),
            grade.getCrsId(),
            grade.getGrdMt(),
            grade.getGrdHw(),
            grade.getGrdFinal(),
            grade.getGrdLgrade()
        });
    }
}
    
    private void btnAddGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGradeActionPerformed
    int grdId = Integer.parseInt(txtGradeId.getText());
    int stdId = Integer.parseInt(txtStudentId.getText());
    int crsId = Integer.parseInt(txtCourseId.getText());
    float grdMt = Float.parseFloat(txtMidterm.getText());
    float grdHw = Float.parseFloat(txtHomework.getText());
    float grdFinal = Float.parseFloat(txtFinal.getText());
    String grdLgrade = txtLetterGrade.getText();

    Grades.addGrade(grdId, stdId, crsId, grdMt, grdHw, grdFinal, grdLgrade);

    JOptionPane.showMessageDialog(this, "Grade added successfully!");
    refreshGradesTable();// TODO add your handling code here:
    }//GEN-LAST:event_btnAddGradeActionPerformed

    private void btnEditGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGradeActionPerformed
    int grdId = Integer.parseInt(txtGradeId.getText());
    int stdId = Integer.parseInt(txtStudentId.getText());
    int crsId = Integer.parseInt(txtCourseId.getText());
    float grdMt = Float.parseFloat(txtMidterm.getText());
    float grdHw = Float.parseFloat(txtHomework.getText());
    float grdFinal = Float.parseFloat(txtFinal.getText());
    String grdLgrade = txtLetterGrade.getText();

    Grades.editGrade(grdId, stdId, crsId, grdMt, grdHw, grdFinal, grdLgrade);

    JOptionPane.showMessageDialog(this, "Grade updated successfully!");
    refreshGradesTable();// TODO add your handling code here:
    }//GEN-LAST:event_btnEditGradeActionPerformed

    private void btnDeleteGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGradeActionPerformed
    DefaultTableModel model = (DefaultTableModel) tblGrades.getModel(); // Tablonun modelini al
    model.setRowCount(0); // Eski verileri temizle

    // Grades listesindeki tüm notları tabloya ekleyin
    for (Grades grade : Grades.grades) {
        model.addRow(new Object[]{
            grade.getGrdId(),
            grade.getStdId(),
            grade.getCrsId(),
            grade.getGrdMt(),
            grade.getGrdHw(),
            grade.getGrdFinal(),
            grade.getGrdLgrade()
        });
    }
    }//GEN-LAST:event_btnDeleteGradeActionPerformed

    private void btnListAllGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAllGradesActionPerformed
           DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
    model.setRowCount(0); // Eski verileri temizle

    // Grades listesindeki tüm notları tabloya ekleyin
    for (Grades grade : Grades.grades) {
        model.addRow(new Object[]{
            grade.getGrdId(),
            grade.getStdId(),
            grade.getCrsId(),
            grade.getGrdMt(),
            grade.getGrdHw(),
            grade.getGrdFinal(),
            grade.getGrdLgrade()
        });
    }
    }//GEN-LAST:event_btnListAllGradesActionPerformed

    private void btnBackupGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupGradesActionPerformed
         Grades.backupGrades();
    JOptionPane.showMessageDialog(this, "Backup completed successfully!");
    }//GEN-LAST:event_btnBackupGradesActionPerformed

    private void btnRestoreGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreGradesActionPerformed
    // Verileri dosyadan geri yükle
    Grades.restoreGrades(); 

    // Tablodaki verileri güncelle
    DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
    model.setRowCount(0); // Mevcut tabloyu temizle

    // Öğrencilerin notlarını tabloya ekle
    for (Grades grade : Grades.grades) {
        model.addRow(new Object[]{
            grade.getGrdId(),
            grade.getStdId(),
            grade.getCrsId(),
            grade.getGrdMt(),
            grade.getGrdHw(),
            grade.getGrdFinal(),
            grade.getGrdLgrade()
        });
    }

    JOptionPane.showMessageDialog(this, "Restore completed successfully!");
    }//GEN-LAST:event_btnRestoreGradesActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        // TODO add your handling code here:
    btnBackToMenu.addActionListener(e -> {
    MainMenu mainMenu = new MainMenu();
    mainMenu.setVisible(true);
    dispose(); // StudentFrame'i kapat
});        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(GradesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGrade;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnBackupGrades;
    private javax.swing.JButton btnDeleteGrade;
    private javax.swing.JButton btnEditGrade;
    private javax.swing.JButton btnListAllGrades;
    private javax.swing.JButton btnRestoreGrades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGrades;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtGradeId;
    private javax.swing.JTextField txtHomework;
    private javax.swing.JTextField txtLetterGrade;
    private javax.swing.JTextField txtMidterm;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
