package UI.Menu;

import UI.ThietBi.thietbiPanel;
import UI.XuLy.xulyPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class menuForm extends javax.swing.JFrame {

    thietbiPanel tb = new thietbiPanel();
    xulyPanel xl = new xulyPanel();

    public menuForm() {
        initComponents();

        jPanel4.setLayout(new BorderLayout());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHomePage = new javax.swing.JButton();
        btnThietbi = new javax.swing.JButton();
        btnThongtin = new javax.swing.JButton();
        btnXuPhat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThanhvien = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelthanhvien = new javax.swing.JLabel();
        jLabelthietbi = new javax.swing.JLabel();
        JLabelxuphat = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnHomePage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/home.png"))); // NOI18N
        btnHomePage.setText("Trang tổng quan");
        btnHomePage.setBorder(null);
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });

        btnThietbi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThietbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/device.png"))); // NOI18N
        btnThietbi.setText("Thiết bị                 ");
        btnThietbi.setBorder(null);
        btnThietbi.setMaximumSize(new java.awt.Dimension(119, 38));
        btnThietbi.setMinimumSize(new java.awt.Dimension(119, 38));
        btnThietbi.setPreferredSize(new java.awt.Dimension(119, 38));
        btnThietbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietbiActionPerformed(evt);
            }
        });

        btnThongtin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongtin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/info.png"))); // NOI18N
        btnThongtin.setText("Thông tin sử dụng");
        btnThongtin.setBorder(null);
        btnThongtin.setMaximumSize(new java.awt.Dimension(119, 38));
        btnThongtin.setMinimumSize(new java.awt.Dimension(119, 38));
        btnThongtin.setPreferredSize(new java.awt.Dimension(119, 38));
        btnThongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongtinActionPerformed(evt);
            }
        });

        btnXuPhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuPhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/condemn.png"))); // NOI18N
        btnXuPhat.setText("Xử phạt                ");
        btnXuPhat.setBorder(null);
        btnXuPhat.setMaximumSize(new java.awt.Dimension(119, 38));
        btnXuPhat.setMinimumSize(new java.awt.Dimension(119, 38));
        btnXuPhat.setPreferredSize(new java.awt.Dimension(119, 38));
        btnXuPhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuPhatActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/admin.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADMIN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        btnThanhvien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/user.png"))); // NOI18N
        btnThanhvien.setText("Thành viên         ");
        btnThanhvien.setBorder(null);
        btnThanhvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhvienActionPerformed(evt);
            }
        });

        jPanel4.setPreferredSize(new java.awt.Dimension(950, 513));

        jLabelthanhvien.setText("THÀNH VIÊN");

        jLabelthietbi.setText("THIẾT BỊ");

        JLabelxuphat.setText("XỬ PHẠT");

        jPanel6.setBackground(new java.awt.Color(225, 219, 219));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 165));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(225, 219, 219));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 165));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(225, 219, 219));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 165));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelthanhvien)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelthietbi))
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelxuphat, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(184, 184, 184))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelthanhvien)
                    .addComponent(jLabelthietbi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabelxuphat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThanhvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(btnThietbi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongtin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuPhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThanhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThietbi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnXuPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhvienActionPerformed

    private void btnXuPhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuPhatActionPerformed
// xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(xl);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display
        btnXuPhat.setBackground(new Color(225, 219, 219));
        btnHomePage.setBackground(new Color(255, 255, 255));
        btnThanhvien.setBackground(new Color(255, 255, 255));
        btnThongtin.setBackground(new Color(255, 255, 255));
        btnThietbi.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnXuPhatActionPerformed

    private void btnThongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongtinActionPerformed

    }//GEN-LAST:event_btnThongtinActionPerformed

    private void btnThietbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietbiActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(tb);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display
        btnThietbi.setBackground(new Color(225, 219, 219));
        btnHomePage.setBackground(new Color(255, 255, 255));
        btnThanhvien.setBackground(new Color(255, 255, 255));
        btnThongtin.setBackground(new Color(255, 255, 255));
        btnXuPhat.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnThietbiActionPerformed

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        // Thiết lập vị trí và kích thước cho các JLabel và JPanel
        jLabelthanhvien.setBounds(50, 50, 100, 20); // X, Y, width, height
        jLabelthietbi.setBounds(300, 50, 100, 20);
        JLabelxuphat.setBounds(500, 50, 100, 20);
//        jPanel6.setBounds(50, 200, 200, 150);
//        jPanel2.setBounds(300, 200, 200, 150);
//        jPanel3.setBounds(550, 200, 200, 150);

        // Thêm các JLabel và JPanel vào jPanel4
        jPanel4.add(jLabelthanhvien);
        jPanel4.add(jLabelthietbi);
        jPanel4.add(JLabelxuphat);
//        jPanel4.add(jPanel6);
//        jPanel4.add(jPanel2);
//        jPanel4.add(jPanel3);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnHomePage.setBackground(new Color(225, 219, 219));
        btnThanhvien.setBackground(new Color(255, 255, 255));
        btnThietbi.setBackground(new Color(255, 255, 255));
        btnThongtin.setBackground(new Color(255, 255, 255));
        btnXuPhat.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnHomePageActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                menuForm menu = new menuForm();
                menu.setLocationRelativeTo(menu);
                menu.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelxuphat;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnThanhvien;
    private javax.swing.JButton btnThietbi;
    private javax.swing.JButton btnThongtin;
    private javax.swing.JButton btnXuPhat;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelthanhvien;
    private javax.swing.JLabel jLabelthietbi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables

}
