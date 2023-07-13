/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Ban;
import POJO.HoaDonBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class HoaDonBanDAO {
    public static ArrayList<HoaDonBan> layHDB(){
        ArrayList<HoaDonBan> ds = new ArrayList<HoaDonBan>();
        
        try {
            String sql = "SELECT * FROM HOADONBAN";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                HoaDonBan b = new HoaDonBan();
                b.setMahd(rs.getInt(1));
                b.setManv(rs.getInt(2));
                b.setThanhtien(rs.getInt(3));
                b.setMaban(rs.getInt(4));
                b.setNgay(rs.getString(5));
                ds.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return ds;
    }
    public static ArrayList<HoaDonBan> layHDBtheoNGAY(String ngay){
        ArrayList<HoaDonBan> ds = new ArrayList<HoaDonBan>();
        
        try {
            String sql = "SELECT * FROM HOADONBAN WHERE NGAY = '"+ngay+"'";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                HoaDonBan b = new HoaDonBan();
                b.setMahd(rs.getInt(1));
                b.setManv(rs.getInt(2));
                b.setThanhtien(rs.getInt(3));
                b.setMaban(rs.getInt(4));
                b.setNgay(rs.getString(5));
                ds.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return ds;
    }
    public static HoaDonBan layHDtheoBAN(int soban){
        HoaDonBan b = new HoaDonBan();
        try {
            String sql = "SELECT * FROM HOADONBAN WHERE MABAN = " + soban + "";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                b.setMahd(rs.getInt(1));
                b.setManv(rs.getInt(2));
                b.setThanhtien(rs.getInt(3));
                b.setMaban(rs.getInt(4));
                b.setNgay(rs.getString(5));
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return b;
    }
    public static boolean themHD(HoaDonBan hd)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO HOADONBAN VALUES(1,0,%d,'%s')",hd.getMaban(), hd.getNgay());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static int TinhTongTienTheoNgay(String ngay)
    {
        int sum = 0;
        
        try {
            String sql = String.format("SELECT SUM(THANHTIEN) FROM HOADONBAN WHERE NGAY = '%s'",ngay);
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
    public static int TONGTIEN()
    {
        int sum = 0;
        
        try {
            String sql = String.format("SELECT SUM(THANHTIEN) FROM HOADONBAN");
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
    public static boolean capnhatHD(int hd,int tt)
    {
        boolean kq = false;
        String sql = String.format("UPDATE HOADONBAN SET THANHTIEN = %d WHERE MAHD = %d", tt,hd);
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
}
