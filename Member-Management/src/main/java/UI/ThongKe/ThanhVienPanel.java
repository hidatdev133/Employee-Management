/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ThongKe;

import BLL.ThongKeBLL;
import DAL.ThanhVien.thanhvien;
import DAL.ThongKe.ThongKeDAL;
import DAL.ThongTinSuDung.thongtinsd;
import DAL.XuLy.xuly;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author trant
 */
public class ThanhVienPanel extends javax.swing.JPanel {

    public ThongKeBLL tkBLL = new ThongKeBLL();
    /**
     * Creates new form ThanhVienPanel
     */
    public ThanhVienPanel() {
        initComponents();
        
        moreInits();
        createPieChart();
        loadTableMember();
        
    }
    
    public void moreInits(){
       renderer = new DefaultTableCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
       modelTbMember = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
               return false;
           }
       };
       
       panelSearch.setVisible(false);
       
       
      
    }

    public void loadTableMember(){
         modelCbbMember = (DefaultComboBoxModel) cbbMember.getModel();
         modelCbbDepartment = (DefaultComboBoxModel) cbbDepartment.getModel();
         modelTbMember = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
           }
       };
       
       tbMember.setModel(modelTbMember);
         modelTbMember.setRowCount(0);
         String choice = modelCbbMember.getSelectedItem().toString();
         switch (choice) {
            case "Tất cả thành viên":
                loadListMember();
                break;
            case "Lọc theo thời gian":
                loadTimeMember();
                break;
            case "Lọc theo khoa":
                String depart = modelCbbDepartment.getSelectedItem().toString();
                if(depart != null)
                    loadDepartmentMember(depart);
                break;
            case "Lọc theo ngành":
                String major = modelCbbDepartment.getSelectedItem().toString();
                if(major != null)
                    loadMajorMember(major);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void loadListMember(){
       
       modelTbMember.addColumn("STT");
       modelTbMember.addColumn("Mã thành viên");
       modelTbMember.addColumn("Tên thành viên");
        List list = tkBLL.getAllThanhVien();
        for(int i = 0 ; i< list.size() ; i++ ){
            thanhvien tv = (thanhvien) list.get(i);
            int stt = i + 1;
            int maTV = tv.getMaTV();
            String nameTV = tv.getHo_ten();
            Object[] ob ={stt, maTV, nameTV};
            modelTbMember.addRow(ob);
        }
        
        TableColumnModel columnModel = tbMember.getColumnModel();
       
       columnModel.getColumn(0).setPreferredWidth(1);
       columnModel.getColumn(1).setPreferredWidth(100);
       columnModel.getColumn(2).setPreferredWidth(150);

    }
    
    public void loadTimeMember(){
        modelTbMember.addColumn("STT");
        modelTbMember.addColumn("Mã thành viên");
        modelTbMember.addColumn("Tên thành viên");

        String from = new SimpleDateFormat("yyyy-MM-dd").format( fromDate.getDate());
        String to = new SimpleDateFormat("yyyy-MM-dd").format( toDate.getDate());
       
        List list = tkBLL.getTimeMember(from, to);
        for(int i = 0 ; i< list.size() ; i++ ){
            thongtinsd tt = (thongtinsd) list.get(i);
            int stt = i + 1;
            int maTV = tt.getMaTV();
            thanhvien tv = tkBLL.getThanhVien(maTV);
            String tenTV = tv.getHo_ten();
            Object[] ob ={stt, maTV, tenTV};
            modelTbMember.addRow(ob);
        }
        
        TableColumnModel columnModel = tbMember.getColumnModel();
       
       columnModel.getColumn(0).setPreferredWidth(1);
       columnModel.getColumn(1).setPreferredWidth(50);
       columnModel.getColumn(2).setPreferredWidth(100);
       

    }
    
    
    public void loadDepartmentMember(String depart){
        modelTbMember.addColumn("STT");
        modelTbMember.addColumn("Mã thành viên");
        modelTbMember.addColumn("Tên thành viên");

        List list = tkBLL.getDepartmentMember(depart);
        for(int i = 0 ; i< list.size() ; i++ ){
            thanhvien tv = (thanhvien) list.get(i);
            int stt = i + 1;
            int maTV = tv.getMaTV();
            String tenTV = tv.getHo_ten();
            Object[] ob ={stt, maTV, tenTV};
            modelTbMember.addRow(ob);
        }
        
        TableColumnModel columnModel = tbMember.getColumnModel();
       
       columnModel.getColumn(0).setPreferredWidth(1);
       columnModel.getColumn(1).setPreferredWidth(50);
       columnModel.getColumn(2).setPreferredWidth(100);

    }
    
    // tai bang theo nganh 
    public void loadMajorMember(String major){
        modelTbMember.addColumn("STT");
        modelTbMember.addColumn("Mã thành viên");
        modelTbMember.addColumn("Tên thành viên");

        List list = tkBLL.getMajortMember(major);
        for(int i = 0 ; i< list.size() ; i++ ){
            thanhvien tv = (thanhvien) list.get(i);
            int stt = i + 1;
            int maTV = tv.getMaTV();
            String tenTV = tv.getHo_ten();
            Object[] ob ={stt, maTV, tenTV};
            modelTbMember.addRow(ob);
        }
        
        TableColumnModel columnModel = tbMember.getColumnModel();
       
       columnModel.getColumn(0).setPreferredWidth(1);
       columnModel.getColumn(1).setPreferredWidth(50);
       columnModel.getColumn(2).setPreferredWidth(100);

    }
    
    public void dataCbbKhoa(){
         modelCbbDepartment = (DefaultComboBoxModel) cbbDepartment.getModel();
         modelCbbDepartment.removeAllElements();
         modelCbbDepartment.setSelectedItem(null);
         List<thanhvien> list = tkBLL.getListKhoa();
         for(int i = 0 ; i<list.size() ;  i++){
             thanhvien tv = list.get(i);
             modelCbbDepartment.addElement(tv.getKhoa());
         }
    }
    
    public void dataCbbNganh(){
         modelCbbDepartment = (DefaultComboBoxModel) cbbDepartment.getModel();
         modelCbbDepartment.removeAllElements();
         modelCbbDepartment.setSelectedItem(null);
         List<thanhvien> list = tkBLL.getListNganh();
         for(int i = 0 ; i<list.size() ;  i++){
             modelCbbDepartment.addElement(list.get(i).getNganh());
         }
    }
     public  void createPieChart(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        int viPham = tkBLL.getListPunish().size();
        dataset.setValue("Vi phạm", viPham);
        int all = tkBLL.getAllThanhVien().size();
        dataset.setValue("Còn lại", all - viPham);
        JFreeChart chart=ChartFactory.createPieChart("Thống kê thành viên", dataset, true, true, true);
        ChartPanel pieChart = new ChartPanel(chart);
        panelChart.setLayout(new BorderLayout());
        panelChart.add(pieChart);
        panelChart.validate();
        panelChart.setPreferredSize(new Dimension(400,300));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbMember = new javax.swing.JComboBox<>();
        panelSearch = new javax.swing.JPanel();
        panelKhoa = new javax.swing.JPanel();
        labelSearch = new javax.swing.JLabel();
        cbbDepartment = new javax.swing.JComboBox<>();
        panelTime = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        fromDate = new com.toedter.calendar.JDateChooser();
        btnSeach = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMember = new javax.swing.JTable();
        panelChart = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lựa chọn");

        cbbMember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả thành viên", "Lọc theo thời gian", "Lọc theo khoa", "Lọc theo ngành" }));
        cbbMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMemberActionPerformed(evt);
            }
        });

        labelSearch.setText("Khoa");

        cbbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKhoaLayout = new javax.swing.GroupLayout(panelKhoa);
        panelKhoa.setLayout(panelKhoaLayout);
        panelKhoaLayout.setHorizontalGroup(
            panelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhoaLayout.createSequentialGroup()
                .addComponent(labelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDepartment, 0, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        panelKhoaLayout.setVerticalGroup(
            panelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKhoaLayout.createSequentialGroup()
                        .addComponent(labelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelKhoaLayout.createSequentialGroup()
                        .addComponent(cbbDepartment)
                        .addGap(1, 1, 1))))
        );

        jLabel2.setText("Thời gian");

        btnSeach.setText("Tìm kiếm");
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setText("-");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTimeLayout = new javax.swing.GroupLayout(panelTime);
        panelTime.setLayout(panelTimeLayout);
        panelTimeLayout.setHorizontalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnSeach)
                .addContainerGap())
        );
        panelTimeLayout.setVerticalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeach)
                    .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMember.setRowHeight(30);
        jScrollPane1.setViewportView(tbMember);

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMemberActionPerformed
        // TODO add your handling code here:
      if(modelCbbMember.getSelectedItem() == "Lọc theo thời gian"){
        panelKhoa.setVisible(false);
        panelTime.setVisible(true);
        panelSearch.setVisible(true);
      } else if(modelCbbMember.getSelectedItem() == "Lọc theo khoa") {
          
          labelSearch.setText("Khoa");
        panelKhoa.setVisible(true);
        panelTime.setVisible(false);
        panelSearch.setVisible(true);
        dataCbbKhoa();
      } else if(modelCbbMember.getSelectedItem() == "Lọc theo ngành"){
          labelSearch.setText("Ngành");
        panelKhoa.setVisible(true);
        panelTime.setVisible(false);
        panelSearch.setVisible(true);
        dataCbbNganh();
      } else{
         panelSearch.setVisible(false);
         loadTableMember();
      }
      
    }//GEN-LAST:event_cbbMemberActionPerformed

    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        // TODO add your handling code here:
        loadTableMember();
    }//GEN-LAST:event_btnSeachActionPerformed

    private void cbbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDepartmentActionPerformed
        // TODO add your handling code here:
        if(modelCbbDepartment.getSelectedItem() != null)
            loadTableMember();
    }//GEN-LAST:event_cbbDepartmentActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    private DefaultComboBoxModel modelCbbDepartment ;
    private DefaultComboBoxModel modelCbbMember ;
    private DefaultTableCellRenderer renderer;
    private DefaultTableModel modelTbMember ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeach;
    private javax.swing.JComboBox<String> cbbDepartment;
    private javax.swing.JComboBox<String> cbbMember;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel panelKhoa;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelTime;
    private javax.swing.JTable tbMember;
    private com.toedter.calendar.JDateChooser toDate;
    // End of variables declaration//GEN-END:variables
}
