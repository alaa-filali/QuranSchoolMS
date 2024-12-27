package HomeJFrame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class HomeJFrame extends javax.swing.JFrame {

    private static final String DB_URL = "jdbc:sqlite:database/my_database.db";

    Connection Conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int i, q;

    public void updateDB() {
        try {
            Conn = DriverManager.getConnection(DB_URL); //, DB_USER, DB_PASSWORD

            String sql = "select * from students";
            pst = Conn.prepareStatement(sql);

            // Execute the query
            rs = pst.executeQuery();

            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("absences"));
                    columnData.add(rs.getString("class"));
                    columnData.add(rs.getString("age"));
                    columnData.add(rs.getString("name"));
                    columnData.add(rs.getString("id"));
//                    columnData.add(rs.getShort("notes"));
                }
                RecordTable.addRow(columnData);
            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public HomeJFrame() {
        initComponents();
        updateDB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBtnُExit = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnُAbs = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextAge = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextClass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("برنامج تسيير المدرسة القرآنية");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 940, 70));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnُExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnُExit.setText("الخروج");
        jBtnُExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnُExitActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnُExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, 70));

        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnAdd.setText("اضافة");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 70));

        jBtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnEdit.setText("تعديل");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 200, 70));

        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnDelete.setText("حذف");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 200, 70));

        jBtnُAbs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnُAbs.setText("غائب");
        jBtnُAbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnُAbsActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnُAbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 70));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 460));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("الاسم");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        jTextName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameActionPerformed(evt);
            }
        });
        jPanel5.add(jTextName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 394, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "عدد الغيابات", "القسم ", "العمر", "الاسم", "id"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 650, 240));

        jTextAge.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextAge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel5.add(jTextAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 394, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("العمر");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jTextClass.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextClass.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel5.add(jTextClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 394, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("القسم");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "كل الاقسام", "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 670, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        try {
            Conn = DriverManager.getConnection(DB_URL);

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            int selectedRows = jTable1.getSelectedRow();

            String sql = "update students set name = ?, age = ?, class = ? where id = ?";
            pst = Conn.prepareStatement(sql);
            pst.setString(1, jTextName.getText());
            pst.setString(2, jTextAge.getText());
            pst.setString(3, jTextClass.getText());
            pst.setString(4, RecordTable.getValueAt(selectedRows, 4).toString());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم تعديل معلومات الطالب");
            updateDB();

            jTextName.setText("");
            jTextAge.setText("");
            jTextClass.setText("");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private JFrame frame;
    private void jBtnُExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnُExitActionPerformed
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "هل تريد حقا الخروج؟", "المدرسة القرأنية", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtnُExitActionPerformed

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        if (jTextName.getText().isEmpty() || jTextAge.getText().isEmpty() || jTextClass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "من فضلك ادخل كل المعلومات");
            return;
        }
        try {
            Conn = DatabaseManager.getConnection();
            String query = "INSERT INTO students (name, age, class) VALUES (?, ?, ?)";
            pst = Conn.prepareStatement(query);
            pst.setString(1, jTextName.getText());
            pst.setString(2, jTextAge.getText());
            pst.setString(3, jTextClass.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم اضافة الطالب");
            updateDB();

            jTextName.setText("");
            jTextAge.setText("");
            jTextClass.setText("");

            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int selectedRows = jTable1.getSelectedRow();

        jTextName.setText(RecordTable.getValueAt(selectedRows, 3).toString());
        jTextAge.setText(RecordTable.getValueAt(selectedRows, 2).toString());
        jTextClass.setText(RecordTable.getValueAt(selectedRows, 1).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        try {
            Conn = DriverManager.getConnection(DB_URL);

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            int selectedRows = jTable1.getSelectedRow();

            String sql = "delete from students where id = ?";
            pst = Conn.prepareStatement(sql);
            pst.setString(1, RecordTable.getValueAt(selectedRows, 4).toString());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم حذف الطالب");
            updateDB();

            jTextName.setText("");
            jTextAge.setText("");
            jTextClass.setText("");

            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedItem = (String) jComboBox1.getSelectedItem();
        if (selectedItem.equals("كل الاقسام")) {
            updateDB();
            return;
        }
        try {
            Conn = DatabaseManager.getConnection();
            String query = "SELECT * FROM students WHERE class = ?";
            pst = Conn.prepareStatement(query);
            pst.setString(1, selectedItem);

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("absences"));
                    columnData.add(rs.getString("class"));
                    columnData.add(rs.getString("age"));
                    columnData.add(rs.getString("name"));
                    columnData.add(rs.getString("id"));
                }
                RecordTable.addRow(columnData);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jBtnُAbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnُAbsActionPerformed
        try {
            Conn = DriverManager.getConnection(DB_URL);

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            int selectedRows = jTable1.getSelectedRow();

            String sql = "update students set absences = ? where id = ?";
            pst = Conn.prepareStatement(sql);
            int numOfAbs = Integer.parseInt(RecordTable.getValueAt(selectedRows, 0).toString());
            numOfAbs++;

            pst.setString(1, String.valueOf(numOfAbs));

            pst.setString(2, RecordTable.getValueAt(selectedRows, 4).toString());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم تسجيل غياب الطالب");
            updateDB();

            jTextName.setText("");
            jTextAge.setText("");
            jTextClass.setText("");

            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jBtnُAbsActionPerformed

    public static void main(String args[]) throws SQLException {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        DatabaseManager.initializeDatabase();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HomeJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnُAbs;
    private javax.swing.JButton jBtnُExit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAge;
    private javax.swing.JTextField jTextClass;
    private javax.swing.JTextField jTextName;
    // End of variables declaration//GEN-END:variables
}
