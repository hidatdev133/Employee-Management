package UI.ThietBi;

import BLL.thietbiBLL;
import DAL.HibernateUtils;
import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import UI.ThietBi.themThietBiForm;
import java.io.File;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.io.IOException;
import java.text.ParseException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class thietbiPanel extends javax.swing.JPanel {

    private thietbiBLL tbBLL = new thietbiBLL();
    DefaultTableModel model;
    themThietBiForm themtb = new themThietBiForm();

    public thietbiPanel() {
        initComponents();
        loadThietbi();
    }

    public void loadThietbi() {
        // Get the list of thietbi objects from the BLL
        List<thietbi> thietbiList = tbBLL.loadThietbi();

        // Create a DefaultTableModel for the table jtQLTB
        model = (DefaultTableModel) jtQLTB.getModel();

        // Clear existing rows from the table
        model.setRowCount(0);

        // Iterate through the thietbiList and add each thietbi object to the table
        for (thietbi tb : thietbiList) {
            Object[] row = {tb.getMaTB(), tb.getTenTB(), tb.getMo_tatb()};
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMatb = new javax.swing.JTextField();
        txtID = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtTentb = new javax.swing.JTextField();
        txtDes = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtQLTB = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbThem = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cbbTimKiem = new javax.swing.JComboBox<>();
        cbbXoa = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(950, 513));

        txtID.setText("Mã thiết bị:");

        txtName.setText("Tên thiết bị:");

        txtDes.setText("Mô tả thiết bị:");

        jtQLTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Mô tả thiết bị"
            }
        ));
        jtQLTB.setRowHeight(30);
        jtQLTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtQLTBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtQLTB);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("QUẢN LÝ THIẾT BỊ");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cbThem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thêm", "Nhập thông tin 1 thiết bị", "Nhập theo file excel" }));
        cbThem.setFocusCycleRoot(true);
        cbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThemActionPerformed(evt);
            }
        });

        txtSearch.setToolTipText("");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã thiết bị", "Tên thiết bị", "Mô tả thiết bị" }));

        cbbXoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xóa", "Xóa 1 thiết bị", "Xóa theo mã quy định" }));
        cbbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbXoa, 0, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID)
                                .addGap(57, 57, 57)
                                .addComponent(txtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addComponent(txtDes))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTentb, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtMota)))
                            .addComponent(cbThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnTimKiem)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName)
                            .addComponent(txtTentb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDes)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(cbThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(cbbXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnSua))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtQLTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtQLTBMouseClicked
        int i = jtQLTB.getSelectedRow();
        if (i >= 0) {
            txtMatb.setText(model.getValueAt(i, 0).toString());
            txtTentb.setText(model.getValueAt(i, 1).toString());
            txtMota.setText(model.getValueAt(i, 2).toString());
        }
    }//GEN-LAST:event_jtQLTBMouseClicked

    private void cbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThemActionPerformed
        // Lấy lựa chọn từ combo box
        int luaChon = cbThem.getSelectedIndex();
        switch (luaChon) {
            case 0: // Trường hợp chưa chọn tùy chọn
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một tùy chọn để thêm thiết bị mới.");
                break;
            case 1: // Trường hợp nhập thông tin 1 thiết bị
                themtb.setVisible(true);
                themtb.setLocationRelativeTo(this);
                break;
            case 2: // Trường hợp nhập theo file excel
                importExcel();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cbThemActionPerformed

    private void importExcel() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xls", "xlsx"));
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                List<thietbi> importedData = readDataFromExcel(file);
                if (importedData != null) {
                    for (thietbi tb : importedData) {
                        tbBLL.addThietbi(tb); // Thêm từng thiết bị vào cơ sở dữ liệu
                    }
                    JOptionPane.showMessageDialog(this, "Đã nhập dữ liệu từ Excel thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    // Sau khi thêm dữ liệu xong, cập nhật lại bảng hiển thị
                    loadThietbi();
                }
            } catch (IOException | InvalidFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi nhập dữ liệu từ Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private List<thietbi> readDataFromExcel(File file) throws IOException, InvalidFormatException, ParseException {
        List<thietbi> importedData = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        // Duyệt qua từng dòng và cột để đọc dữ liệu, bắt đầu từ dòng thứ hai
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue; // Bỏ qua nếu dòng là null
            }

            Cell cellMaTB = row.getCell(0);
            Cell cellTenTB = row.getCell(1);
            Cell cellMoTaTB = row.getCell(2);

            // Kiểm tra xem ô có phải là số không trước khi lấy giá trị
            int maTB;
            try {
                maTB = (int) cellMaTB.getNumericCellValue();
            } catch (IllegalStateException | NumberFormatException e) {
                // Nếu không thể chuyển đổi giá trị sang số, bỏ qua dòng này và hiển thị cảnh báo
                System.err.println("Dòng " + (i + 1) + ": Mã thiết bị không hợp lệ, bỏ qua dữ liệu từ dòng này.");
                continue;
            }

            String tenTB = cellTenTB.getStringCellValue();
            String moTaTB = cellMoTaTB.getStringCellValue();

            thietbi tb = new thietbi(maTB, tenTB, moTaTB);
            importedData.add(tb);
        }
        workbook.close();
        return importedData;
    }

    public static void main(String[] args) {
        thietbiPanel tbPanel = new thietbiPanel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tbPanel.setVisible(true);
            }
        });
    }


    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = jtQLTB.getSelectedRow();
        if (selectedRow != -1) {
            int maTB = Integer.parseInt(txtMatb.getText());
            String tenTB = txtTentb.getText().trim();
            String moTaTB = txtMota.getText().trim();

            if (tenTB.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thiết bị", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            thietbi tb = new thietbi(maTB, tenTB, moTaTB);

            try {
                tbBLL.updateThietbi(tb);
                if (tbBLL.isMaTbExisted(maTB)) {
                    JOptionPane.showMessageDialog(this, "Đã sửa thông tin thiết bị thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    // Reload data after updating
                    loadThietbi();
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy thiết bị có mã: " + maTB, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên cho mã thiết bị", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thực hiện cập nhật: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một thiết bị để sửa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText().trim();
        String selectedOption = cbbTimKiem.getSelectedItem().toString();

        if (!search.isEmpty()) {
            List<thietbi> searchResult = null;

            switch (selectedOption) {
                case "Mã thiết bị":
                    try {
                    int matb = Integer.parseInt(search);
                    searchResult = tbBLL.searchThietBiByIDBLL(matb);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid grade format");
                }

                break;
                case "Tên thiết bị":
                    searchResult = tbBLL.searchThietBiByNameBLL(search);
                    break;
                case "Mô tả thiết bị":
                    searchResult = tbBLL.searchThietBiByDescriptionBLL(search);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid search option");
                    break;
            }
            if (searchResult != null) {
                // Xóa dữ liệu cũ trong bảng
                model.setRowCount(0);
                // Hiển thị kết quả tìm kiếm trên bảng
                for (thietbi tb : searchResult) {
                    Object[] row = {tb.getMaTB(), tb.getTenTB(), tb.getMo_tatb()};
                    model.addRow(row);
                }
            }
        } else {
            // Nếu trường tìm kiếm trống, hiển thị tất cả 
            loadThietbi();
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbXoaActionPerformed
        // TODO add your handling code here:
        String selectedOption = cbbXoa.getSelectedItem().toString();

        if (selectedOption == "Xóa 1 thiết bị" || selectedOption == "Xóa theo mã quy định") {
            txtMatb.setText("");
            txtTentb.setText("");
            txtMota.setText("");
            txtSearch.setText("");

            txtMatb.setEnabled(false);
            txtTentb.setEnabled(false);
            txtMota.setEnabled(false);
            loadThietbi();
        } else {
            txtMatb.setEnabled(true);
            txtTentb.setEnabled(true);
            txtMota.setEnabled(true);
        }
    }//GEN-LAST:event_cbbXoaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        String searchQuery = txtSearch.getText().trim();
        String selectedOption = cbbXoa.getSelectedItem().toString();

        int selectedRow = jtQLTB.getSelectedRow();

        switch (selectedOption) {
            case "Xóa 1 thiết bị":
                if (selectedRow != -1) {
                    int maTB = Integer.parseInt(txtMatb.getText());
                    String tenTB = txtTentb.getText();
                    String moTaTB = txtMota.getText();

                    if (tbBLL.deleteThietBiByIDBLL(maTB)) {
                        loadThietbi();
                        System.out.println("ma: " + tbBLL.isMaTbExisted(maTB));
                        System.out.println("ma: " + tbBLL.deleteThietBiByIDBLL(maTB));
                        JOptionPane.showMessageDialog(this, "Đã xóa thiết bị thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadThietbi();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thiết bị không thành công", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn một thiết bị để xóa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Xóa theo mã quy định":
                String search = txtSearch.getText().trim();
                if (search.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nhập mã quy định vào ô tìm kiếm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int maquydinh = Integer.parseInt(search);
                        System.out.println("maquydinh: " + search);
                        if (tbBLL.deleteThietBiByMaQuyDinhBLL(maquydinh)) {
                            JOptionPane.showMessageDialog(this, "Đã xóa những thiết bị theo mã quy định thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            loadThietbi();
                        } else {
                            JOptionPane.showMessageDialog(this, "Xóa thiết bị không thành công", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Mã quy định không đúng");
                    }

                }

                break;
            default:
                System.out.println("hello");
                throw new AssertionError();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbThem;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JComboBox<String> cbbXoa;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtQLTB;
    private javax.swing.JLabel txtDes;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtMatb;
    private javax.swing.JTextField txtMota;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTentb;
    // End of variables declaration//GEN-END:variables

}
