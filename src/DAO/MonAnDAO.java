/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Ban;
import POJO.MonAn;
import Pojo.LoaiMonAn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MonAnDAO {
    public static ArrayList<MonAn> layMA(){
        ArrayList<MonAn> dsMA = new ArrayList<MonAn>();
        
        try {
            String sql = "SELECT * FROM MONAN";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                MonAn b = new MonAn();
                b.setMamon(rs.getInt(1));
                b.setTenmon(rs.getString(2));
                b.setGia(rs.getInt(3));
                b.setMaloai(rs.getInt(4));
                b.setManuyenlieu(rs.getInt(5));
                dsMA.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return dsMA;
    }
    public static int layGIA(int ma)
    {
        int gia = 0;
        try {
            String sql = "SELECT DONGIA FROM MONAN WHERE MAMON = " + ma +"";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                gia = rs.getInt(1);
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return gia;
    }
    public static int layMANL(int ma)
    {
        int manl = 0;
        try {
            String sql = "SELECT MANGUYENLIEU FROM MONAN WHERE MAMON = " + ma +"";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                manl = rs.getInt(1);
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return manl;
    }
    public static boolean checkSL(int sl,int mamon)
    {
        try {
            String sql = "SELECT SOLUONG FROM NGUYENLIEU WHERE MANGUYENLIEU = " + layMANL(mamon) +"";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                if(sl > rs.getInt(1))
                {
                    return false;
                }
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return true;
    }
//    public static boolean themphongban(PhongBan pb)
//    {
//        boolean kq = false;
//        String sql = String.format("INSERT [dbo].[PhongBan] ([TenPHG]) VALUES (N'%s')", pb.getTenpb());
//        SQLDataProvider pro = new SQLDataProvider();
//        pro.open();
//        int n= pro.excuteUPDATE(sql);
//        if(n==1)
//            kq = true;
//        pro.close();
//        return kq;
//    }
//    public static boolean xoaphongban(int ma)
//    {
//        boolean kq = false;
//        String sql = String.format("DELETE FROM PhongBan WHERE MaPHG = %d", ma);
//        SQLDataProvider pro = new SQLDataProvider();
//        pro.open();
//        int n= pro.excuteUPDATE(sql);
//        if(n==1)
//            kq = true;
//        pro.close();
//        return kq;
//    }
    public static boolean capnhatSL(int sl,int mamon)
    {
        boolean kq = false;
        String sql = String.format("UPDATE NGUYENLIEU SET SOLUONG = SOLUONG - %d WHERE MANGUYENLIEU = %d", sl,layMANL(mamon));
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean themMonAn(MonAn monAn)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        String query = "Insert into MONAN (TENMON, DONGIA, MALOAIMON, MANGUYENLIEU) values (N'"+monAn.getTenmon()+"', "+monAn.getGia()+", "+monAn.getMaloai()+", "+monAn.getManuyenlieu()+")";
        int i  =  dataProvider.excuteUPDATE(query);
        if(i > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
     public static boolean ktrMonAn(String monAn)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        String query = "Select * from monAn where TenMon = N'"+monAn+"'";
        ResultSet rs = dataProvider.excuteSQL(query);
        try {
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static ArrayList<LoaiMonAn> dsLoai(){
        ArrayList<LoaiMonAn> dsloai = new ArrayList<LoaiMonAn>();
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        
        String query = "select * from LoaiMonAn";
        ResultSet rs =  dataProvider.excuteSQL(query);
        try {
            while(rs.next())
            {
                LoaiMonAn loaiMon = new LoaiMonAn();
                loaiMon.setMaLoai(rs.getInt("MaLoaiMon"));
                loaiMon.setTenLoai(rs.getString("TenLoaiMon"));
                dsloai.add(loaiMon);
                
            }
            return dsloai;
            
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsloai;
    }
    
    public static ArrayList<MonAn> dsNguyenLieu(){
        ArrayList<MonAn> dsNguyenLieu = new ArrayList<MonAn>();
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        
        String query = "select * from NguyenLieu";
        ResultSet rs =  dataProvider.excuteSQL(query);
        try {
            while(rs.next())
            {
                
                MonAn ma = new MonAn();
                ma.setTennguyenlieu(rs.getString("TENGNUYENLIEU"));
                dsNguyenLieu.add(ma);
                
            }
            return dsNguyenLieu;
            
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNguyenLieu;
    }
    
    public static ArrayList<MonAn> DsMonAn(){
        
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        String query = "Select MAMON, TENMON, DONGIA, NGUYENLIEU.TENGNUYENLIEU, LOAIMONAN.TENLOAIMON from MONAN, NGUYENLIEU, LOAIMONAN where MONAN.MANGUYENLIEU = NGUYENLIEU.MANGUYENLIEU AND MONAN.MALOAIMON = LOAIMONAN.MALOAIMON";
        
        ResultSet rs =  dataProvider.excuteSQL(query);
        
        try {
            while(rs.next())
            {
                MonAn monAN = new MonAn();
                monAN.setMamon(rs.getInt("MAMON"));
                monAN.setTenmon(rs.getString("TENMON"));
                monAN.setGia(rs.getInt("DONGIA"));
                monAN.setTennguyenlieu(rs.getString("TENGNUYENLIEU"));
                monAN.setTenLoai(rs.getString("TENLOAIMON"));
                dsMonAn.add(monAN);
                
            }
            return dsMonAn;
            
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return dsMonAn;    
        
        
    }
    
    
    
    public static int layMaNguyenLieuTheoTen(String ten)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
       ResultSet rs =  dataProvider.excuteSQL("select *  from NGUYENLIEU where TENGNUYENLIEU = N'"+ten+"'");
        try {
            while(rs.next())
            {
                return rs.getInt("MaNguyenLieu");
                
            }} catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    public static int layMaLoaiTheoTen(String ten)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
       ResultSet rs =  dataProvider.excuteSQL("select *  from LOAIMONAN where TENLOAIMON =  N'"+ten+"'");
        try {
            while(rs.next())
            {
                return rs.getInt("MaLoaiMon");
                
            }} catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
    public static boolean SuaMonAn(MonAn monAn)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        int i = dataProvider.excuteUPDATE("Update MonAn set TenMon = N'"+monAn.getTenmon()+"', DonGia = "+monAn.getGia()+", MaLoaiMon =  "+monAn.getMaloai()+", MaNguyenLieu = "+monAn.getManuyenlieu()+" where MaMon = "+monAn.getMamon()+"");
        if(i > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
    
    public static boolean  XoaMon(int maMon)
    {
        SQLDataProvider dataProvider = new SQLDataProvider();
        dataProvider.open();
        int i = dataProvider.excuteUPDATE("Delete from MonAn where maMon = "+maMon+"");
        if(i > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
