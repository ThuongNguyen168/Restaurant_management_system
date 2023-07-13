/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Ban;
import POJO.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class BanDAO {
    public static ArrayList<Ban> layBAN(){
        ArrayList<Ban> dsBAN = new ArrayList<Ban>();
        
        try {
            String sql = "SELECT * FROM BAN";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                Ban b = new Ban();
                b.setMaban(rs.getInt(1));
                b.setSoghe(rs.getInt(2));
                b.setGhichu(rs.getString(3));
                dsBAN.add(b);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return dsBAN;
    }
    public static boolean themban(Ban pb)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO BAN VALUES(%d,NULL)", pb.getSoghe());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean xoaban(int ma)
    {
        boolean kq = false;
        String sql = String.format("DELETE FROM BAN WHERE MABAN = %d", ma);
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean capnhatban(Ban ban)
    {
        boolean kq = false;
        String sql = String.format("UPDATE Ban SET GHICHU = N'%s' WHERE MABAN = %d", ban.getGhichu(),ban.getMaban());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean capnhatbanTT(int soban)
    {
        boolean kq = false;
        String sql = String.format("UPDATE Ban SET GHICHU = null WHERE MABAN = %d", soban);
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
}
