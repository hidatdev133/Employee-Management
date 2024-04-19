package UI.Menu;

import DAL.ThanhVien.ThanhVienDAL;
import DAL.ThietBi.thietbiDAL;
import DAL.XuLy.XuLyDAL;
import UI.ThanhVien.thanhvienPanel;
import UI.ThietBi.thietbiPanel;
import UI.ThongKe.ThongKePanel;
import UI.XuLy.xulyPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class menuForm extends javax.swing.JFrame {

    private thietbiPanel tb = new thietbiPanel();
    private xulyPanel xl = new xulyPanel();
    private thanhvienPanel tv = new thanhvienPanel();
    private ThanhVienDAL tvDAL;
    private thietbiDAL tbDAL;
    private XuLyDAL xlDAL;
    private ThongKePanel thongKe  = new ThongKePanel();
    public menuForm() {
        initComponents();
        jPanel4.setLayout(new BorderLayout());
        updateCounts();
    }

    private void updateCounts() {
        tvDAL = new ThanhVienDAL();
        tbDAL = new thietbiDAL();
        xlDAL = new XuLyDAL();
        int thanhVienCount = tvDAL.getTotalCount();
        int thietBiCount = tbDAL.getTotalCount();
        int xulyCount = xlDAL.getTotalCount();

        // Update JLabels with counts
        thanhvien.setText(Integer.toString(thanhVienCount));
        thietbi.setText(Integer.toString(thietBiCount));
        xuphat.setText(Integer.toString(xulyCount));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHomePage = new javax.swing.JButton();
        btnThietbi = new javax.swing.JButton();
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
        thanhvien = new javax.swing.JLabel();
        jPanelthietbi = new javax.swing.JPanel();
        thietbi = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        xuphat = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnHomePage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/home.png"))); // NOI18N
        btnHomePage.setText("Trang tổng quan ");
        btnHomePage.setBorder(null);
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });

        btnThietbi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThietbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/device.png"))); // NOI18N
        btnThietbi.setText("  Thiết bị                 ");
        btnThietbi.setBorder(null);
        btnThietbi.setMaximumSize(new java.awt.Dimension(119, 38));
        btnThietbi.setMinimumSize(new java.awt.Dimension(119, 38));
        btnThietbi.setPreferredSize(new java.awt.Dimension(119, 38));
        btnThietbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietbiActionPerformed(evt);
            }
        });

        btnXuPhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuPhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/condemn.png"))); // NOI18N
        btnXuPhat.setText("  Xử phạt                ");
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
        btnThanhvien.setText("Thành viên           ");
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

        thanhvien.setText("countthanhvien");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(thanhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(thanhvien)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanelthietbi.setBackground(new java.awt.Color(225, 219, 219));
        jPanelthietbi.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        jPanelthietbi.setPreferredSize(new java.awt.Dimension(200, 165));

        thietbi.setText("countthietbi");

        javax.swing.GroupLayout jPanelthietbiLayout = new javax.swing.GroupLayout(jPanelthietbi);
        jPanelthietbi.setLayout(jPanelthietbiLayout);
        jPanelthietbiLayout.setHorizontalGroup(
            jPanelthietbiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelthietbiLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(thietbi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanelthietbiLayout.setVerticalGroup(
            jPanelthietbiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelthietbiLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(thietbi)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(225, 219, 219));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 165));

        xuphat.setText("countxuphat");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(xuphat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(xuphat)
                .addContainerGap(73, Short.MAX_VALUE))
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
                    .addComponent(jPanelthietbi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanelthietbi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/statistic.png"))); // NOI18N
        btnThongKe.setText("Thống kê                 ");
        btnThongKe.setBorder(null);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

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
                            .addComponent(btnThanhvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThietbi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuPhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThanhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThietbi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnXuPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhvienActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(tv);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display
        btnThietbi.setBackground(new Color(255, 255, 255));
        btnHomePage.setBackground(new Color(255, 255, 255));
        btnThanhvien.setBackground(new Color(225, 219, 219));
        
        btnXuPhat.setBackground(new Color(255, 255, 255));
       
        btnThongKe.setBackground(new Color(255, 255, 255));
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
        btnThietbi.setBackground(new Color(255, 255, 255));
        btnThongKe.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnXuPhatActionPerformed

    private void btnThietbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietbiActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(tb);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display
        btnThietbi.setBackground(new Color(225, 219, 219));
        btnHomePage.setBackground(new Color(255, 255, 255));
        btnThanhvien.setBackground(new Color(255, 255, 255));
     
        btnXuPhat.setBackground(new Color(255, 255, 255));
        btnThongKe.setBackground(new Color(255, 255, 255));
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
        btnXuPhat.setBackground(new Color(255, 255, 255));
        btnThongKe.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
         jPanel4.removeAll();

        jPanel4.add(thongKe);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display
        btnXuPhat.setBackground(new Color(255,255,255 ));
        btnHomePage.setBackground(new Color(255, 255, 255));
        btnThanhvien.setBackground(new Color(255, 255, 255));
        btnThongKe.setBackground(new Color(225, 219, 219));
        btnThietbi.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_btnThongKeActionPerformed

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
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuPhat;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelthanhvien;
    private javax.swing.JLabel jLabelthietbi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelthietbi;
    private javax.swing.JLabel thanhvien;
    private javax.swing.JLabel thietbi;
    private javax.swing.JLabel xuphat;
    // End of variables declaration//GEN-END:variables

}
