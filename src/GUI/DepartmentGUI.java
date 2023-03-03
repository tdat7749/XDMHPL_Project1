/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.DepartmentBLL;
import ENTITY.Department;
import ENTITY.Lecture;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DepartmentGUI extends javax.swing.JPanel {

    /**
     * Creates new form DepartmentGUI
     */
    private int id;
    private ArrayList<Department> listDepart;

    public DepartmentGUI() throws Exception {
        initComponents();
        loadListDepartment();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNameDepart = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        JCalendarStartDate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDepartment = new javax.swing.JTable();

        setBackground(new java.awt.Color(236, 239, 193));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/department (1).png"))); // NOI18N
        jLabel1.setText("   DEPARTMENT");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Department Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Budget");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Date");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search (1).png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add (1).png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit (1).png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete (1).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reset (1).png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        JCalendarStartDate.setDateFormatString("yyyy-dd-MM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBudget, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameDepart, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCalendarStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset)
                            .addComponent(btnEdit))))
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(btnDelete)
                        .addComponent(btnReset))
                    .addComponent(JCalendarStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setRequestFocusEnabled(false);

        tableDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDepartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDepartment);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Add
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtNameDepart.getText().isEmpty() || txtBudget.getText().isEmpty() || JCalendarStartDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin khoa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Timestamp timestamp = new Timestamp(JCalendarStartDate.getDate().getTime());

            Department depart = new Department();
            depart.setName(txtNameDepart.getText());
            depart.setBudget(Double.parseDouble(txtBudget.getText()));
            depart.setStartDate(timestamp);
            try {
                if (DepartmentBLL.addDepartment(depart)) {
                    JOptionPane.showMessageDialog(this, "Thêm khoa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtNameDepart.setText("");
                    txtBudget.setText("");
                    try {
                        loadListDepartment();
                    } catch (Exception ex) {
                        Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Delete
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtNameDepart.getText().isEmpty() && txtBudget.getText().isEmpty()) {
        } else {
            int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa hay không?");
            if (x == JOptionPane.YES_OPTION) {

                try {
                    if (DepartmentBLL.deleteDepartmentByID(id)) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            loadListDepartment();
                            txtNameDepart.setText("");
                            txtBudget.setText("");
                        } catch (Exception ex) {
                            Logger.getLogger(LectureGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    // Update
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtNameDepart.getText().isEmpty() || txtBudget.getText().isEmpty() || JCalendarStartDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin khoa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Timestamp timestamp = new Timestamp(JCalendarStartDate.getDate().getTime());

            Department depart = new Department();
            depart.setName(txtNameDepart.getText());
            depart.setBudget(Double.parseDouble(txtBudget.getText()));
            depart.setStartDate(timestamp);

            try {
                if (DepartmentBLL.updateDepartmentByID(id, depart)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadListDepartment();
                }
            } catch (Exception ex) {
                Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnEditActionPerformed

    // Click 1 dong trong table
    private void tableDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDepartmentMouseClicked
        int row = tableDepartment.getSelectedRow();
        id = Integer.parseInt(tableDepartment.getValueAt(row, 1).toString());
        String nameDepart = tableDepartment.getValueAt(row, 2).toString();
        String budget = tableDepartment.getValueAt(row, 3).toString();
        Date startDate = null;
        try {
            startDate = (Date) new SimpleDateFormat("yyyy-dd-MM").parse(tableDepartment.getValueAt(row, 4).toString());
        } catch (ParseException ex) {
            Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtNameDepart.setText(nameDepart);
        txtBudget.setText(budget);
        JCalendarStartDate.setDate(startDate);
    }//GEN-LAST:event_tableDepartmentMouseClicked

    //Reset
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtNameDepart.setText("");
        txtBudget.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    // Search department
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyWordSearch = txtSearch.getText().toString();
        ArrayList<Department> listDepartSearch = null;
        try {
            listDepartSearch = DepartmentBLL.searchByName(keyWordSearch);
        } catch (Exception ex) {
            Logger.getLogger(DepartmentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadListDepartSearch(listDepartSearch);
    }//GEN-LAST:event_btnSearchActionPerformed

    // load danh sach khoa SEARCH
    private void loadListDepartSearch(ArrayList<Department> listDepart) {
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();

        // Xoá dữ liệu đang có trong table
        model.setRowCount(0);

        Vector<Object> header = new Vector<>();
        header.add("STT");
        header.add("ID");
        header.add("Department Name");
        header.add("Budget");
        header.add("Start Date");

        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }

        int i = 0;
        for (Department depart : listDepart) {
            Vector<Object> vec = new Vector<>();
            vec.add(i);
            vec.add(depart.getDepartmentID());
            vec.add(depart.getName());
            vec.add(depart.getBudget());
            vec.add(depart.getStartDate().toString());
            i++;
            model.addRow(vec);
        }
        tableDepartment.setModel(model);
    }

    // load danh sách khoa
    private void loadListDepartment() throws Exception {
        listDepart = DepartmentBLL.getAllDepartment();
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();

        // Xoá dữ liệu đang có trong table
        model.setRowCount(0);

        Vector<Object> header = new Vector<>();
        header.add("STT");
        header.add("ID");
        header.add("Department Name");
        header.add("Budget");
        header.add("Start Date");

        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }

        int i = 0;
        for (Department depart : listDepart) {
            Vector<Object> vec = new Vector<>();
            vec.add(i);
            vec.add(depart.getDepartmentID());
            vec.add(depart.getName());
            vec.add(depart.getBudget());
            vec.add(depart.getStartDate().toString());
            i++;
            model.addRow(vec);
        }
        tableDepartment.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JCalendarStartDate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDepartment;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextField txtNameDepart;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
