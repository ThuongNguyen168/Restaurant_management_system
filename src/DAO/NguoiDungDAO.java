/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NguoiDungDAO {
    public static ArrayList<NguoiDung> layDSND(){
        ArrayList<NguoiDung> dsND = new ArrayList<NguoiDung>();
        
        try {
            String sql = "SELECT * FROM NGUOIDUNG";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setTendangnhap(rs.getString(1));
                nd.setMatkhau(rs.getString(2));
                dsND.add(nd);
                
            }
            pro.close();
        } catch (SQLException sQLException) {
        }
        return dsND;
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
//    public static boolean capnhatphongban(PhongBan pb)
//    {
//        boolean kq = false;
//        String sql = String.format("UPDATE PhongBan SET TENPHG = N'%s' WHERE MaPHG = %d", pb.getTenpb(),pb.getMapb());
//        SQLDataProvider pro = new SQLDataProvider();
//        pro.open();
//        int n= pro.excuteUPDATE(sql);
//        if(n==1)
//            kq = true;
//        pro.close();
//        return kq;
//    }
}
