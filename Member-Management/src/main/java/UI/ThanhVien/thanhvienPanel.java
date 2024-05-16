/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ThanhVien;

import BLL.ThanhVienBLL;
import DAL.ThanhVien.ThanhVienDAL;
import DAL.ThanhVien.thanhvien;
import UI.KhuVucHocTap.nhapMaTVForm;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class thanhvienPanel extends javax.swing.JPanel {

    /**
     * Creates new form thanhvienPanel
     */
    private DefaultTableModel model;
    private ThanhVienBLL thanhVienBLL;
    private ThanhVienDAL thanhVienDAL;
    nhapMaTVForm nhapForm = new nhapMaTVForm();

    public thanhvienPanel() {
        initComponents();

        model = (DefaultTableModel) tbThanhVien.getModel();
        thanhVienBLL = new ThanhVienBLL();
        thanhVienDAL = new ThanhVienDAL();
        fillTableThanhVien();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThanhVien = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnImportExcel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtKhoa = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtNganh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaTV = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ THÀNH VIÊN");

        tbThanhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thành viên", "Họ Tên", "Khoa", "Ngành", "SĐT", "Password", "Email"
            }
        ));
        tbThanhVien.setRowHeight(40);
        tbThanhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThanhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbThanhVien);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnImportExcel.setText("Import Excel");
        btnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportExcelActionPerformed(evt);
            }
        });

        jLabel7.setText("Password:");

        jLabel2.setText("Mã thành viên:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Khoa:");

        jLabel5.setText("Ngành:");

        jLabel6.setText("Số điện thoại:");

        jLabel8.setText("Email:");

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã thành viên", "Họ tên", "Khoa", "Ngành", "SĐT", "Email" }));

        jButton1.setText("Vào khu vực học tập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(364, 364, 364))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(22, 22, 22)
                        .addComponent(btnEdit)
                        .addGap(30, 30, 30)
                        .addComponent(btnDelete)
                        .addGap(31, 31, 31)
                        .addComponent(btnImportExcel)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(132, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void fillTableThanhVien() {
        model.setRowCount(0);
        List<thanhvien> tvList = thanhVienBLL.getAllThanhVien();

        for (thanhvien tv : tvList) {
            model.addRow(new Object[]{tv.getMaTV(), tv.getHo_ten(), tv.getKhoa(), tv.getNganh(), tv.getSDT(), tv.getPass_word(), tv.getEmail()});
        }

    }

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearch.getText().trim();
        String selectedCb = cbSearch.getSelectedItem().toString();

        if (!keyword.isEmpty()) {
            List<thanhvien> result = null;

            switch (selectedCb) {
                case "Mã thành viên":
                    try {
                    int matv = Integer.parseInt(keyword);
                    result = thanhVienBLL.searchThanhVien(keyword, 1);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Mã thành viên không hợp lệ");
                }

                break;
                case "Họ tên":
                    result = thanhVienBLL.searchThanhVien(keyword, 2);
                    break;
                case "Khoa":
                    result = thanhVienBLL.searchThanhVien(keyword, 3);
                    break;
                case "Ngành":
                    result = thanhVienBLL.searchThanhVien(keyword, 4);
                    break;
                case "SDT":
                    try {
                    int sdt = Integer.parseInt(keyword);
                    result = thanhVienBLL.searchThanhVien(keyword, 5);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                }
                case "Email":
                    result = thanhVienBLL.searchThanhVien(keyword, 6);
                    break;  
                default:
                    break;
            }
            if (result != null) {
                model.setRowCount(0);
                for (thanhvien tv : result) {
                    model.addRow(new Object[]{tv.getMaTV(), tv.getHo_ten(), tv.getKhoa(), tv.getNganh(),
                        tv.getSDT(), tv.getPass_word(), tv.getEmail()});
                }
            }
        } else {
            fillTableThanhVien();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String maTV = txtMaTV.getText();
        String hoten = txtHoTen.getText().trim();
        String khoa = txtKhoa.getText().trim();
        String nganh = txtNganh.getText().trim();
        String sdt = txtSDT.getText().trim();
        String password = txtPass.getText().trim();
        String email = txtEmail.getText().trim();

        if (maTV.isEmpty() || hoten.isEmpty() || khoa.isEmpty() || nganh.isEmpty() || sdt.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ dữ liệu");
            return;
        }
        int matv;

        try {
            matv = Integer.parseInt(maTV);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số cho trường mã thành viên");
            return;
        }

        boolean isMaTVExisted = thanhVienDAL.isMaTVExisted(matv);
        if (!isMaTVExisted) {
            JOptionPane.showMessageDialog(this, "Chưa có mã thành viên này");
            return;
        }

        if (!isEmailValid(email)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email hợp lệ");
            return;
        }

        thanhvien tv = new thanhvien(matv, hoten, khoa, nganh, Integer.parseInt(sdt), password, email);
        boolean success = thanhVienBLL.updateThanhVien(tv);

        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa thông tin của thành viên này không?", "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (success && check == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Đã sửa dữ liệu thành công!");
            fillTableThanhVien();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tbThanhVien.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt(tbThanhVien.getValueAt(selectedRow, 0).toString());
            thanhvien tv = thanhVienBLL.getThanhVien(id);
            boolean success = thanhVienBLL.deleteThanhVien(tv);

            if (success) {
                JOptionPane.showMessageDialog(this, "Đã xóa dữ liệu thành công!");
                fillTableThanhVien();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maTV = txtMaTV.getText();
        String hoten = txtHoTen.getText().trim();
        String khoa = txtKhoa.getText().trim();
        String nganh = txtNganh.getText().trim();
        String sdt = txtSDT.getText().trim();
        String password = txtPass.getText().trim();
        String email = txtEmail.getText().trim();

        if (maTV.isEmpty() || hoten.isEmpty() || khoa.isEmpty() || nganh.isEmpty() || sdt.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ dữ liệu");
            return;
        }
        int matv;
        int sDT;
        try {
            matv = Integer.parseInt(maTV);
            sDT = Integer.parseInt(sdt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số cho trường mã thành viên và số điện thoại");
            return;
        }

        boolean isMaTVExisted = thanhVienDAL.isMaTVExisted(matv);
        if (isMaTVExisted) {
            JOptionPane.showMessageDialog(this, "Mã thành viên này đã tồn tại vui lòng nhập lại mã khác");
            return;
        }

        if (!isEmailValid(email)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email hợp lệ");
            return;
        }

        thanhvien tv = new thanhvien(matv, hoten, khoa, nganh, sDT, password, email);
        boolean success = thanhVienBLL.addThanhVien(tv);

        if (success) {
            JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu thành công!");
            fillTableThanhVien();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thất bại!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbThanhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThanhVienMouseClicked
        int row = tbThanhVien.getSelectedRow();
        if (row >= 0) {
            txtMaTV.setText(model.getValueAt(row, 0).toString());
            txtHoTen.setText(model.getValueAt(row, 1).toString());
            txtKhoa.setText(model.getValueAt(row, 2).toString());
            txtNganh.setText(model.getValueAt(row, 3).toString());
            txtSDT.setText(model.getValueAt(row, 4).toString());
            txtPass.setText(model.getValueAt(row, 5).toString());
            txtEmail.setText(model.getValueAt(row, 6).toString());
        }
    }//GEN-LAST:event_tbThanhVienMouseClicked

    public List<thanhvien> readDataFromExcel(BufferedInputStream bis) throws IOException {
        List<thanhvien> tvList = new ArrayList<>();
        XSSFWorkbook wb = new XSSFWorkbook(bis);
        Sheet sheet = wb.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            Cell matvCell = row.getCell(0);
            Cell hotenCell = row.getCell(1);
            Cell khoaCell = row.getCell(2);
            Cell nganhCell = row.getCell(3);
            Cell sdtCell = row.getCell(4);
            Cell passwordCell = row.getCell(5);
            Cell emailCell = row.getCell(6);

            String matv = formatter.formatCellValue(matvCell);
            String sdt = formatter.formatCellValue(sdtCell);

            int maTV, sDT;
            try {
                maTV = Integer.parseInt(matv);
                sDT = Integer.parseInt(sdt);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số cho cột mã thành viên và số điện thoại");
                continue;
            }

            String email = emailCell.getStringCellValue();
            if (!isEmailValid(email)) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập email hợp lệ cho cột email");
                continue;
            }

            String hoten = hotenCell.getStringCellValue();
            String khoa = khoaCell.getStringCellValue();
            String nganh = nganhCell.getStringCellValue();
            String password = formatter.formatCellValue(passwordCell);

            thanhvien tv = new thanhvien(maTV, hoten, khoa, nganh, sDT, password, email);
            tvList.add(tv);
        }
        wb.close();
        return tvList;
    }

    private void btnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportExcelActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xls", "xlsx");
        chooser.addChoosableFileFilter(filter);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileInputStream excelFIS = new FileInputStream(file);
                BufferedInputStream excelBIS = new BufferedInputStream(excelFIS);
                List<thanhvien> tvList = readDataFromExcel(excelBIS);
                if (!tvList.isEmpty()) {
                    for (thanhvien tv : tvList) {
                        if (thanhVienDAL.isMaTVExisted(tv.getMaTV())) {
                            JOptionPane.showMessageDialog(this, tv.getMaTV() + " mã này đã tồn tại");
                            continue;
                        }
                        thanhVienBLL.addThanhVien(tv);
                    }
                    JOptionPane.showMessageDialog(this, "Đã nhập dữ liệu từ file excel thành công!");
                    fillTableThanhVien();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(thanhvienPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(thanhvienPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnImportExcelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nhapForm.setVisible(true);
        nhapForm.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnImportExcel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbThanhVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaTV;
    private javax.swing.JTextField txtNganh;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
