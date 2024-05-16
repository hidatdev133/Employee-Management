/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ThongKe;
import BLL.ThongKeBLL;
import DAL.XuLy.xuly;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author hp_pc
 */
public class viphamPanel extends javax.swing.JPanel {

    /**
     * Creates new form viphamPanel
     */
    ThongKeBLL tkBLL;
    ArrayList<xuly>daxlList;
    ArrayList<xuly>chuaxlList;
    ArrayList<xuly>xulyList;
    DefaultTableModel model;
    public viphamPanel() {
          initComponents();
        tkBLL=new ThongKeBLL();
        createPieChart();

     loadata();
    
       
        
    }
      public  void createPieChart(){
        JPanelChart.removeAll();
        JPanelChart.revalidate();
        JPanelChart.repaint();
         DefaultPieDataset dataset=new DefaultPieDataset();
        int amountDaXL=tkBLL.getTotalDaXL().size();
        int amountChuaXL=tkBLL.getTotalChuaXL().size();
        int total=amountChuaXL+amountDaXL;
        dataset.setValue("Đã Xử Lý", (amountDaXL*100)/total);
        dataset.setValue("Chưa Xử Lý", (amountChuaXL*100)/total);
        JFreeChart chart=ChartFactory.createPieChart("THỐNG KÊ XỬ LÝ", dataset, true, true, true);
        ChartPanel chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(getPreferredSize());
        JPanelChart.setLayout(new BorderLayout());
        JPanelChart.add(chartPanel,BorderLayout.CENTER);
        JPanelChart.validate();

       
    }
        public void createBarChart(){
            JPanelChart.removeAll();
            JPanelChart.revalidate();
        JPanelChart.repaint();
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
           List<xuly>list=new ArrayList<>(); 
          list=tkBLL.getHinhThuc();
        for(xuly xl:list){
            dataset.addValue(tkBLL.getAmountXL(xl.getHinhThucXL().trim().toString()),
                    "Số Thành Viên", xl.getHinhThucXL());
    }
       JFreeChart chart = ChartFactory.createBarChart(
                 "THỐNG KÊ THÀNH VIÊN THEO TỪNG VI PHẠM ĐÃ XỬ LÝ",
               "Vi Phạm" ,
                "Số Thành Viên", 
                dataset, PlotOrientation.VERTICAL,
                true,true, true
        );
       dataset.addValue((long)tkBLL.getAmountXL(list.get(0).getHinhThucXL()),
               "Số Thành Viên", list.get(0).getHinhThucXL());
        ChartPanel chartPanel=new ChartPanel(chart);
         JPanelChart.setLayout(new BorderLayout());
        JPanelChart.add(chartPanel,BorderLayout.CENTER);
        chartPanel.setPreferredSize(getPreferredSize());
        JPanelChart.validate();
    }
          public void createBarChartCXL(){
               JPanelChart.removeAll();
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
            List<xuly>list=new ArrayList<>(); 
          list=tkBLL.getHinhThuc();
        for(int i=0;i<list.size();i++){
            dataset.addValue((long)tkBLL.getAmountCXL(list.get(i).getHinhThucXL())
                    ,"Số Thành Viên", list.get(i).getHinhThucXL());
    }
 dataset.addValue((long)tkBLL.getAmountCXL(list.get(0).getHinhThucXL()),
         "Số Thành Viên", list.get(0).getHinhThucXL());
       JFreeChart chart = ChartFactory.createBarChart(
                 "THỐNG KÊ THÀNH VIÊN THEO TỪNG VI PHẠM CHƯA XỬ LÝ",
               "Vi Phạm" ,
                "Số Thành Viên", 
                dataset, PlotOrientation.VERTICAL,
                true,true, true
        );
        ChartPanel chartPanel=new ChartPanel(chart);
         JPanelChart.setLayout(new BorderLayout());
        JPanelChart.add(chartPanel,BorderLayout.CENTER);
        chartPanel.setPreferredSize(getPreferredSize());
        JPanelChart.validate();
    }
@Override
public Dimension getPreferredSize() {
    // given some values of w & h
    return new Dimension(400, 300);
}
public void loadViPhamDaXuLy(){
    daxlList=(ArrayList<xuly>) tkBLL.getTotalDaXL();
   
    model=(DefaultTableModel)jTable1.getModel();
     model.setRowCount(0);
    for(xuly xl:daxlList){
       String tt=xl.getTrangThaiXL()==0?"Đang Xử Lý":"Đã Xử Lý";
        model.addRow(new Object[]{xl.getMaTV(),tkBLL.getTV(xl.getMaTV()).getHo_ten()
                ,xl.getHinhThucXL(),xl.getSoTien(),xl.getNgayXL(),tt});
    }
    sl.setText(daxlList.size()+"");
    tongtien.setVisible(true);
    boithuong.setVisible(true);
    boithuong.setText(tkBLL.getTongTien()+" đ");
   
}
public void loadViPhamChuaXuLy(){
    chuaxlList=(ArrayList<xuly>)tkBLL.getTotalChuaXL();
   
     model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
    for(xuly xl:chuaxlList){
         String tt=xl.getTrangThaiXL()==0?"Đang Xử Lý":"Đã Xử Lý";
        model.addRow(new Object[]{xl.getMaTV(),tkBLL.getTV(xl.getMaTV()).getHo_ten()
                ,xl.getHinhThucXL(),xl.getSoTien(),xl.getNgayXL(),tt});
    }
     sl.setText(chuaxlList.size()+"");
    tongtien.setVisible(false);
    boithuong.setVisible(false);
   
    
}
public void loadTatCaViPham(){
    xulyList=(ArrayList<xuly>)tkBLL.getXL();
   
     model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
    for(xuly xl:xulyList){
         String tt=xl.getTrangThaiXL()==0?"Đang Xử Lý":"Đã Xử Lý";
        model.addRow(new Object[]{xl.getMaTV(),tkBLL.getTV(xl.getMaTV()).getHo_ten(),
            xl.getHinhThucXL(),xl.getSoTien(),xl.getNgayXL(),tt});
    }
     sl.setText(xulyList.size()+"");
    tongtien.setVisible(false);
    boithuong.setVisible(false);
       
}
public void loadata(){
    if(cbbFilter.getSelectedItem().equals("Tất Cả Vi Phạm")){
        loadTatCaViPham();
         createPieChart();
    
       
    }
   else if(cbbFilter.getSelectedItem().equals("Đã Được Xử Lý")){
        loadViPhamDaXuLy();
         createBarChart();
        
         
    }
   else if(cbbFilter.getSelectedItem().equals("Đang Xử Lý")){
        loadViPhamChuaXuLy();
           createBarChartCXL();
      
        
}
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelChart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbbFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        sl = new javax.swing.JLabel();
        tongtien = new javax.swing.JLabel();
        boithuong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JPanelChartLayout = new javax.swing.GroupLayout(JPanelChart);
        JPanelChart.setLayout(JPanelChartLayout);
        JPanelChartLayout.setHorizontalGroup(
            JPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        JPanelChartLayout.setVerticalGroup(
            JPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thành Viên", "Tên ", "Hình Thức Xử Lý", "Số Tiền", "Ngày Xử Lý", "Trạng Thái"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        cbbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Vi Phạm", "Đã Được Xử Lý", "Đang Xử Lý", " " }));
        cbbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("SL:");

        sl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tongtien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tongtien.setText("TT Bồi Thường:");

        boithuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boithuong, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boithuong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cbbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterActionPerformed
        loadata();
    }//GEN-LAST:event_cbbFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelChart;
    private javax.swing.JLabel boithuong;
    private javax.swing.JComboBox<String> cbbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sl;
    private javax.swing.JLabel tongtien;
    // End of variables declaration//GEN-END:variables
}
