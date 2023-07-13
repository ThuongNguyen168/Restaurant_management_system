/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonBanDAO;
import DAO.MonAnDAO;
import POJO.Ban;
import POJO.ChiTietHoaDon;
import POJO.HoaDonBan;
import POJO.MonAn;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class DatBan extends javax.swing.JFrame {

    /**
     * Creates new form DatBan
     */
    DefaultTableModel tableModel = new DefaultTableModel();
    public DatBan() {
        initComponents();
        this.setLocationRelativeTo(null);
        String[] columnNames = { "Mã Hóa Đơn","Mã Món","Số Lượng","Giá","Thành Tiền"};
        tbl_chitiethoadonban.setModel(tableModel);
        tableModel.setColumnIdentifiers(columnNames);
        Ban_init();
        LoadCB();
    }

    public void Print() {
        Object[] rows;
        try {
            ChiTietHoaDonDAO pbd = new ChiTietHoaDonDAO();
            ArrayList<ChiTietHoaDon> pb = new ArrayList<ChiTietHoaDon>();
            pb = pbd.layCTHDtheoHD(Integer.valueOf(txt_mahd.getText()));
            for (ChiTietHoaDon ct : pb) {
                String tenmon = pbd.layTENMONAN(ct.getMamon());
                rows = new Object[]{ct.getMahd(), tenmon, ct.getSl(), ct.getGia(), ct.getThanhtien()};
                tableModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void LoadCB()
    {

        try {
            MonAnDAO pbd = new MonAnDAO();
            ArrayList<MonAn> pb = new ArrayList<MonAn>();
            pb = pbd.layMA();
            for (MonAn ma : pb) {
                String item =ma.getMamon() + " " + ma.getTenmon();
                cb_monan.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public int SO_BAN ;
    public void Ban_init()
    {
        //Get the components in the panel
        Component[] componentList = Panel_Ban.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof JButton){

                //Remove it
                Panel_Ban.remove(c);
            }
        }

        //IMPORTANT
        Panel_Ban.revalidate();
        Panel_Ban.repaint();
        try {
            int x = 0;
            int y = 0;
            BanDAO band = new BanDAO();
            ArrayList<Ban> ban = new ArrayList<Ban>();
            ban = band.layBAN();
            for (Ban b : ban) {
                JButton btn = new JButton();
                System.out.println(b.getMaban());
                btn.setBounds(x, y, 100, 100);
                btn.setText(String.valueOf(b.getMaban()));
                btn.setFont(new Font("Comic Sans",Font.BOLD,20));
                if(b.getGhichu() != null)
                {
                    btn.setBackground(Color.gray);
                }
                else
                    btn.setBackground(Color.blue);
                
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SO_BAN = Integer.valueOf(btn.getText());
                        txt_so_ban.setText(String.valueOf(SO_BAN));
                        txt_trangthai.setText(b.getGhichu());
                        if(txt_trangthai.getText().isEmpty())
                        {
                            txt_mahd.setText("0");
                        }
                        else
                        {
                            try {
                            HoaDonBanDAO pbd = new HoaDonBanDAO();
                            HoaDonBan hd = new HoaDonBan();
                            hd = pbd.layHDtheoBAN(SO_BAN);
                            txt_mahd.setText(String.valueOf(hd.getMahd()));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        tableModel.setRowCount(0);
                        Print();
                        try {
                            ChiTietHoaDonDAO cthdd = new ChiTietHoaDonDAO();
                            int Sumtt = 0;
                            Sumtt = cthdd.TONGTIEN(Integer.valueOf(txt_mahd.getText()));
                            txt_TONGTIEN.setText(String.valueOf(Sumtt));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                Panel_Ban.add(btn);
                x+=120;
                if(x >= Panel_Ban.preferredSize().width)
                {
                    x = 0;
                    y += 110;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        Panel_Ban = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_so_ban = new javax.swing.JTextField();
        txt_trangthai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_datban = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chitiethoadonban = new javax.swing.JTable();
        cb_monan = new javax.swing.JComboBox<>();
        txt_soluong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Calendar_HD = new com.toedter.calendar.JDateChooser();
        txt_gia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_datban1 = new javax.swing.JButton();
        txt_TONGTIEN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_ThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Panel_Ban.setAutoscrolls(true);

        javax.swing.GroupLayout Panel_BanLayout = new javax.swing.GroupLayout(Panel_Ban);
        Panel_Ban.setLayout(Panel_BanLayout);
        Panel_BanLayout.setHorizontalGroup(
            Panel_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        Panel_BanLayout.setVerticalGroup(
            Panel_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Số Bàn :");

        txt_so_ban.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_trangthai.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Trạng thái :");

        btn_datban.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_datban.setForeground(new java.awt.Color(255, 51, 51));
        btn_datban.setText("ĐẶT BÀN");
        btn_datban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datbanActionPerformed(evt);
            }
        });

        tbl_chitiethoadonban.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_chitiethoadonban);

        cb_monan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_monanActionPerformed(evt);
            }
        });

        txt_soluong.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng :");

        Calendar_HD.setDateFormatString("dd-MM-yyyy");

        txt_gia.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Gia :");

        txt_mahd.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã HD:");

        btn_datban1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_datban1.setForeground(new java.awt.Color(255, 51, 51));
        btn_datban1.setText("ĐẶT MÓN");
        btn_datban1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datban1ActionPerformed(evt);
            }
        });

        txt_TONGTIEN.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txt_TONGTIEN.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tổng TIền :");

        btn_ThanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_ThanhToan.setForeground(new java.awt.Color(255, 51, 51));
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_datban, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_so_ban, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_mahd))
                                        .addComponent(cb_monan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Calendar_HD, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_datban1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_TONGTIEN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_so_ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_datban, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_monan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Calendar_HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_datban1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_TONGTIEN, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel_Ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_datbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datbanActionPerformed
        
        
        if(txt_so_ban.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn!!");
        }
        else if(txt_trangthai.getText().isEmpty() != true)
        {
            JOptionPane.showMessageDialog(this, "Bàn đã được đặt!!");
        }
        else
        {
            Ban b = new Ban();
            b.setMaban(SO_BAN);
            b.setGhichu("ĐÃ ĐẶT");
            BanDAO band = new BanDAO();
            boolean check = band.capnhatban(b);
            if(check == true)
            {
                JOptionPane.showMessageDialog(this, "Đặt bàn Thành Công");
                HoaDonBan p = new HoaDonBan();
                p.setMaban(SO_BAN);
                Date vd =  Calendar_HD.getDate();
                DateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy"); 
                if(String.valueOf(formatdate.format(vd)).isEmpty())
                {
                    Date now = new Date();
                    p.setNgay(String.valueOf(formatdate.format(now)));
                }
                else
                {
                    p.setNgay(String.valueOf(formatdate.format(vd)));
                }
                
                HoaDonBanDAO pbd = new HoaDonBanDAO();
                boolean check2 = pbd.themHD(p);
                if(check2 == true)
                {
                    System.out.println("Đã tạo Hóa Đơn");
                }
                else
                    JOptionPane.showMessageDialog(this, "Thêm Không Thành Công");
                Ban_init();
            }
            else
                JOptionPane.showMessageDialog(this, "Đặt bàn Không Thành Công");
        }
    }//GEN-LAST:event_btn_datbanActionPerformed

    private void btn_datban1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datban1ActionPerformed
        ChiTietHoaDon p = new ChiTietHoaDon();
        if(txt_mahd.getText().isEmpty() == true || txt_soluong.getText().isEmpty() == true)
        {
            JOptionPane.showMessageDialog(this, "Dữ liệu bị thiếu");
        }
        else
        {
            String monan = String.valueOf(cb_monan.getSelectedItem());
            int i = monan.indexOf(" ");
            String id = monan.substring(0,i);
            p.setMamon(Integer.valueOf(id));
            try {
                MonAnDAO dao = new MonAnDAO();
                boolean checksl = dao.checkSL(Integer.valueOf(txt_soluong.getText()), Integer.valueOf(id));
                if(checksl == false)
                {
                    JOptionPane.showMessageDialog(this, "Số Lượng Không đủ");
                }
                else
                {
                    p.setMahd(Integer.valueOf(txt_mahd.getText()));
                    p.setSl(Integer.valueOf(txt_soluong.getText()));
                    p.setGia(Integer.valueOf(txt_gia.getText()));
                    int tt = Integer.valueOf(txt_soluong.getText()) + Integer.valueOf(txt_gia.getText());
                    p.setThanhtien(tt);
                    ChiTietHoaDonDAO pbd = new ChiTietHoaDonDAO();
                    boolean check = pbd.themCTHD(p);
                    if(check == true)
                    {
                        boolean updatesl = dao.capnhatSL(Integer.valueOf(txt_soluong.getText()), Integer.valueOf(id));
                        if(updatesl == true)
                            System.out.println("Cập nhật thành công");
                        else
                            System.out.println("Cập nhật thất bại");
                        JOptionPane.showMessageDialog(this, "Đặt món thành công");
                        tableModel.setRowCount(0);
                        Print();
                        try {
                            ChiTietHoaDonDAO cthdd = new ChiTietHoaDonDAO();
                            int Sumtt = 0;
                            Sumtt = cthdd.TONGTIEN(Integer.valueOf(txt_mahd.getText()));
                            txt_TONGTIEN.setText(String.valueOf(Sumtt));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Đặt món Không Thành Công");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
        }
        
    }//GEN-LAST:event_btn_datban1ActionPerformed

    private void cb_monanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_monanActionPerformed
        
        String monan = String.valueOf(cb_monan.getSelectedItem());
        int i = monan.indexOf(" ");
        String id = monan.substring(0,i);
        try {
                MonAnDAO pbd = new MonAnDAO();
                int dongia = 0;
                dongia = pbd.layGIA(Integer.valueOf(id));
                txt_gia.setText(String.valueOf(dongia));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_cb_monanActionPerformed

    public void XuatHD(ArrayList<ChiTietHoaDon> list)
    {
        try(PrintWriter pw = new PrintWriter(new File("HoaDon.txt")))
        {
            pw.println("==================HÓA ĐƠN=========================");
            pw.println("");
            pw.println("***************************************************");
            pw.println("MãHóaĐơn    MãMón    Số Lượng     Giá      Thành Tiền");
            for (ChiTietHoaDon chiTietHoaDon : list) {
                pw.print(chiTietHoaDon.getMahd() + "           ");
                pw.print(chiTietHoaDon.getMamon()+ "        ");
                pw.print(chiTietHoaDon.getSl()+ "          ");
                pw.print(chiTietHoaDon.getGia()+ "     ");
                pw.print(chiTietHoaDon.getThanhtien()+ "     ");
                pw.println();
            }
            pw.println("***************************************************");
            pw.print("                               Tổng Tiền :  " + txt_TONGTIEN.getText());
        }catch(Exception e)
        {
            System.out.println("got an exception");
        }
        
    }
    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        if(txt_mahd.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Chọn bàn cần thanh toán");
        }
        else
        {
            try {
                HoaDonBanDAO hddao = new HoaDonBanDAO();
                boolean c = hddao.capnhatHD(Integer.valueOf(txt_mahd.getText()), Integer.valueOf(txt_TONGTIEN.getText()));
                if(c==true)
                {
                    BanDAO bandao = new BanDAO();
                    boolean checkban = bandao.capnhatbanTT(SO_BAN);
                    if(checkban == true)
                    {
                        Ban_init();
                        System.out.println("đã thanh toán");
                    }
                        
                    else
                        System.out.println("có lỗi");
                    JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
                    ChiTietHoaDonDAO ctdao = new ChiTietHoaDonDAO();
                    ArrayList<ChiTietHoaDon> ct = new ArrayList<ChiTietHoaDon>();
                    ct = ctdao.layCTHDtheoHD(Integer.valueOf(txt_mahd.getText()));
                    XuatHD(ct);
                }
                    
                else
                    JOptionPane.showMessageDialog(this, "Thanh Toán Thất bại");
            } catch (Exception ex) {
            ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, 
            "Bạn muốn thoát?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            new TrangChu().setVisible(true);
        }
        
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendar_HD;
    private javax.swing.JPanel Panel_Ban;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_datban;
    private javax.swing.JButton btn_datban1;
    private javax.swing.JComboBox<String> cb_monan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_chitiethoadonban;
    private javax.swing.JTextField txt_TONGTIEN;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_so_ban;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
