package UI.ThietBi;

import BLL.thietbiBLL;
import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import javax.swing.JOptionPane;

public class themThietBiForm extends javax.swing.JFrame {

    private thietbiBLL tbBLL = new thietbiBLL();
    private thietbiDAL tbDAL = new thietbiDAL();
    private thietbiPanel tbPanel;


    public themThietBiForm() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        txtTentb = new javax.swing.JTextField();
        txtDes = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        txtMatb = new javax.swing.JTextField();
        txtID = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtName.setText("Tên thiết bị:");

        txtDes.setText("Mô tả thiết bị:");

        txtID.setText("Mã thiết bị:");

        btnReset.setText("Reset");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID)
                                .addGap(57, 57, 57)
                                .addComponent(txtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addComponent(txtDes))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTentb)
                                    .addComponent(txtMota)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnReset)
                        .addGap(94, 94, 94)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnback)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(txtTentb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDes)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnThem)
                    .addComponent(btnback))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        tbPanel = new thietbiPanel();
        // Lấy thông tin từ các trường nhập liệu
        String strMaTB = txtMatb.getText().trim();
        String tenTB = txtTentb.getText();
        String moTaTB = txtMota.getText();

        // Kiểm tra xem các trường dữ liệu có rỗng không
        if (strMaTB.isEmpty() || tenTB.isEmpty()) {
            // Hiển thị hộp thoại cảnh báo yêu cầu nhập đầy đủ thông tin
            JOptionPane.showMessageDialog(this, "Mã thiết bị hoặc tên thiết bị trống, vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return; // Không thực hiện thêm thiết bị nếu có trường dữ liệu rỗng
        }

        // Kiểm tra xem MaTB có phải là số nguyên hay không
        try {
            int maTB = Integer.parseInt(strMaTB);
            // Kiểm tra xem mã thiết bị đã tồn tại hay chưa
            if (tbDAL.isMaTbExisted(maTB)) {
                // Hiển thị hộp thoại cảnh báo nếu mã thiết bị đã tồn tại
                JOptionPane.showMessageDialog(this, "Mã thiết bị đã tồn tại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return; // Không thực hiện thêm thiết bị nếu mã thiết bị đã tồn tại
            }
            // Tạo một đối tượng thietbi mới
            thietbi tbMoi = new thietbi(maTB, tenTB, moTaTB);
            tbBLL.addThietbi(tbMoi); // Thêm thiết bị mới vào cơ sở dữ liệu
            if (tbBLL.isSuccess()) {
                JOptionPane.showMessageDialog(this, "Đã thêm thiết bị thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                tbPanel.loadThietbi();
            }
        } catch (NumberFormatException e) {
            // Hiển thị hộp thoại cảnh báo nếu MaTB không phải là số
            JOptionPane.showMessageDialog(this, "Mã thiết bị phải là số nguyên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        tbPanel = new thietbiPanel();
        setVisible(false);
        tbPanel.setVisible(true);
        tbPanel.loadThietbi();

    }//GEN-LAST:event_btnbackActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themThietBiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel txtDes;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtMatb;
    private javax.swing.JTextField txtMota;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtTentb;
    // End of variables declaration//GEN-END:variables
}
