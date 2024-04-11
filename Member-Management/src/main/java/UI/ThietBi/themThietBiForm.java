package UI.ThietBi;

import BLL.thietbiBLL;
import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import javax.swing.JOptionPane;

public class themThietBiForm extends javax.swing.JFrame {

    private thietbiBLL tbBLL = new thietbiBLL();
    private thietbiDAL tbDAL = new thietbiDAL();


    public themThietBiForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        jtTentb = new javax.swing.JTextField();
        txtDes = new javax.swing.JLabel();
        jtMota = new javax.swing.JTextField();
        jtMatb = new javax.swing.JTextField();
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
                                .addComponent(jtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addComponent(txtDes))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtTentb)
                                    .addComponent(jtMota)))))
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
                    .addComponent(jtMatb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(jtTentb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDes)
                    .addComponent(jtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        thietbiPanel tbPanel = new thietbiPanel();
        // Lấy thông tin từ các trường nhập liệu
        int maTB = Integer.parseInt(jtMatb.getText());
        String tenTB = jtTentb.getText();
        String moTaTB = jtMota.getText();

        // Kiểm tra xem các trường dữ liệu có rỗng không
        if (jtMatb.getText().trim().isEmpty() || tenTB.isEmpty() || moTaTB.isEmpty()) {
            // Hiển thị hộp thoại cảnh báo yêu cầu nhập đầy đủ thông tin
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return; // Không thực hiện thêm thiết bị nếu có trường dữ liệu rỗng
        } else {
            // Lấy giá trị của trường MaTB
            try {
                maTB = Integer.parseInt(jtMatb.getText().trim());
            } catch (NumberFormatException e) {
                // Hiển thị hộp thoại cảnh báo nếu trường MaTB không phải là số
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số vào trường Mã thiết bị", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return; // Không thực hiện thêm thiết bị nếu MaTB không phải là số
            }

            // Kiểm tra xem mã thiết bị đã tồn tại hay chưa
            if (tbDAL.isMaTbExisted(maTB)) {
                // Hiển thị hộp thoại cảnh báo nếu mã thiết bị đã tồn tại
                JOptionPane.showMessageDialog(this, "Mã thiết bị đã tồn tại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return; // Không thực hiện thêm thiết bị nếu mã thiết bị đã tồn tại
            }
            // Tạo một đối tượng thietbi mới
            thietbi tbMoi = new thietbi(maTB, tenTB, moTaTB);

            // Thêm thiết bị mới vào cơ sở dữ liệu
            tbBLL.addThietbi(tbMoi);
            JOptionPane.showMessageDialog(this, "Đã thêm thiết bị thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            // Set visibility of current frame to false
            setVisible(false);
            tbPanel.setVisible(true);
            tbPanel.loadThietbi();

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // Set visibility of current frame to false
        setVisible(false);

        // Show thietbiPanel
        thietbiPanel tbPanel = new thietbiPanel();
        tbPanel.setVisible(true);

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
    private javax.swing.JTextField jtMatb;
    private javax.swing.JTextField jtMota;
    private javax.swing.JTextField jtTentb;
    private javax.swing.JLabel txtDes;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
