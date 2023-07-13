/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Ban;
import POJO.ChiTietHoaDon;
import POJO.HoaDonBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ChiTietHoaDonDAO {
    public static ArrayList<ChiTietHoaDon> layCTHD(){
        ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
        
        try {
            String sql = "SELECT * FROM CHITIETHOADON";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                ChiTietHoaDon b = new ChiTietHoaDon();
                b.setMahd(rs.getInt(1));
                b.setMamon(rs.getInt(2));
                b.setSl(rs.getInt(3));
                b.setGia(rs.getInt(4));
                b.setThanhtien(rs.getInt(5));    
                ds.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return ds;
    }
    public static ArrayList<ChiTietHoaDon> layCTHDtheoHD(int mahd){
        ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
        
        try {
            String sql = "SELECT * FROM CHITIETHOADON WHERE MAHD = " + mahd +"";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                ChiTietHoaDon b = new ChiTietHoaDon();
                b.setMahd(rs.getInt(1));
                b.setMamon(rs.getInt(2));
                b.setSl(rs.getInt(3));
                b.setGia(rs.getInt(4));
                b.setThanhtien(rs.getInt(5));    
                ds.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return ds;
    }
    public static String layTENMONAN(int mamon)
    {
        String ten = "";
        try {
            String sql = "SELECT TENMON FROM MONAN WHERE MAMON = " + mamon +"";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                ten = rs.getString(1);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return ten;
    }
    public static boolean themCTHD(ChiTietHoaDon pb)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO CHITIETHOADON VALUES(%d,%d,%d,%d,%d)",pb.getMahd(),pb.getMamon(),pb.getSl(),pb.getGia(),pb.getThanhtien());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static int TONGTIEN(int ma)
    {
        int sum = 0;
        try {
            String sql = "SELECT SUM(THANHTIEN) FROM CHITIETHOADON WHERE MAHD = " + ma + "";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                sum = rs.getInt(1);
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return sum;
    }
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
//    public static boolean capnhatban(Ban ban)
//    {
//        boolean kq = false;
//        String sql = String.format("UPDATE Ban SET GHICHU = N'%s' WHERE MABAN = %d", ban.getGhichu(),ban.getMaban());
//        SQLDataProvider pro = new SQLDataProvider();
//        pro.open();
//        int n= pro.excuteUPDATE(sql);
//        if(n==1)
//            kq = true;
//        pro.close();
//        return kq;
//    }
}
