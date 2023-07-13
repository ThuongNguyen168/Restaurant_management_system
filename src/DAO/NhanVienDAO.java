/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhanVIen;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NhanVienDAO {
    public static ArrayList<NhanVIen> layDSNV(){
        ArrayList<NhanVIen> dsPB = new ArrayList<NhanVIen>();
        
        try {
            String sql = "SELECT * FROM NHANVIEN";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while(rs.next())
            {
                NhanVIen pb = new NhanVIen();
                pb.setManv(rs.getInt(1));
                pb.setTen(rs.getString(2));
                pb.setSdt(rs.getString(3));
                pb.setNs(rs.getString(4));
                dsPB.add(pb);
                
            }
            pro.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }
    public static ArrayList<NhanVIen> timNV(String name){
        ArrayList<NhanVIen> dsPB = new ArrayList<NhanVIen>();
        
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE HOTENNV LIKE '%"+name+"%'";
            SQLDataProvider pro = new SQLDataProvider();
            pro.open();
            ResultSet rs = pro.excuteSQL(sql);
            while(rs.next())
            {
                NhanVIen pb = new NhanVIen();
                pb.setManv(rs.getInt(1));
                pb.setTen(rs.getString(2));
                pb.setSdt(rs.getString(3));
                pb.setNs(rs.getString(4));
                dsPB.add(pb);
                
            }
            pro.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }
    public static boolean themNV(NhanVIen pb)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO NHANVIEN VALUES(N'%s','%s','%s')", pb.getTen(),pb.getSdt(),pb.getNs());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean XoaNV(int ma)
    {
        boolean kq = false;
        String sql = String.format("DELETE FROM NHANVIEN WHERE MANV = %d", ma);
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
    public static boolean CapNhatNV(NhanVIen pb)
    {
        boolean kq = false;
        String sql = String.format("UPDATE NHANVIEN SET HOTENNV = N'%s' AND DIENTHOAINV = '%s' AND NGAYSINH = '%s' WHERE MANV = %d", pb.getTen(),pb.getSdt(),pb.getNs(),pb.getManv());
        SQLDataProvider pro = new SQLDataProvider();
        pro.open();
        int n= pro.excuteUPDATE(sql);
        if(n==1)
            kq = true;
        pro.close();
        return kq;
    }
}
