/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import POJO.NguyenLieu;
import POJO.NhaCC;
import POJO.PhieuNhap;

/**
 *
 * @author HP
 */
public class TruyVanSQL {
        public static ArrayList<NguyenLieu> layDanhSachNguyenLieus() {
        ArrayList<NguyenLieu> dsTK = new ArrayList<NguyenLieu>();
        dsTK.clear();
        try {
            String sql = "select*from NguyenLieu";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                NguyenLieu tk = new NguyenLieu();
                tk.setManl(Integer.valueOf(rs.getString("manguyenlieu")));
                tk.setTennl(rs.getString("TENGNUYENLIEU"));
                tk.setDongia(Float.valueOf(rs.getString("dongianhap")));
                tk.setIdncc(Integer.valueOf(rs.getString("idncc")));
                tk.setSoluong(Integer.valueOf(rs.getString("soluong")));
                dsTK.add(tk);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
        
   public static ArrayList<String> layDanhSachTenNCC() {
        ArrayList<String> dsTK = new ArrayList<String>();
        dsTK.clear();
        try {
            String sql = "select*from NguyenLieu";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                String tenncc=rs.getString("tenncc");
                dsTK.add(tenncc);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
   
    public static ArrayList<String> layDanhSachIdNCC() {
            ArrayList<String> dsTK = new ArrayList<String>();
        dsTK.clear();
        try {
            String sql = "select*from nhacungcap";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                String id=rs.getString("idncc");
                  dsTK.add(id);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
   
      public static ArrayList<NhaCC> layDanhSachNCC() {
        ArrayList<NhaCC> dsTK = new ArrayList<NhaCC>();
        dsTK.clear();
        try {
            String sql =String.format("select*from NhaCungCap");
         
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                NhaCC ncc=new NhaCC();
                ncc.setIdNCC(rs.getInt("IDNCC"));
                ncc.setTenNCC(rs.getString("Tenncc"));
                ncc.setDiaChi(rs.getString("diachi"));
                dsTK.add(ncc);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
   
   
   
   public  static ArrayList<PhieuNhap> layDanhSachPhieuNhaps()
   {
       ArrayList<PhieuNhap> dstk=new ArrayList<>();
       dstk.clear();
       try {
                       String sql = "select*from NguyenLieu";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                PhieuNhap pn=new  PhieuNhap();
                pn.setIdphieu(Integer.valueOf(rs.getString("idphieu")));
                pn.setIdncc(Integer.valueOf(rs.getString("idncc")));
                pn.setManl(Integer.valueOf(rs.getString("manl")));
                pn.setSoluong(Integer.valueOf(rs.getString("soluong")));
                pn.setNgaygiao(rs.getString("ngaynhao"));
               dstk.add(pn);
            }
       } catch (Exception e) {
       }
       return dstk;
   }
   
   /////Them nha cung cap
       public static boolean themNCC(String ten,String dc) {
        boolean kq = false;
        String sql = String.format("INSERT INTO NhaCungCap values('" + ten + "','" + dc + "')");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
         

        }
        provider.close();

        return kq;
    }
    public static boolean capNhatNhaCC(int id, String tenString,String dc) {
        boolean kq = false;
        String sql = String.format("UPDATE NhaCungCap SET tenncc = '" + tenString + "', diachi='"+dc+"' WHERE idncc ='" + id + "'");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
           layDanhSachNCC();
        }
        provider.close();
        return kq;
    }
    
    
    // NguyenLieu
    
        public static boolean themNL(String tennl,float dg,int idncc,int sl) {
        boolean kq = false;
        String sql = String.format("INSERT INTO Nguyenlieu values('" + tennl + "'," + dg + ","+idncc+","+sl+")");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();

        return kq;
    }
        
         public static boolean capNhatNL(int id, String tenString,float dg,int sl) {
        boolean kq = false;
        String sql = String.format("UPDATE NguyenLieu SET TENGNUYENLIEU = '" + tenString + "', dongianhap="+dg+", soluong="+sl+" WHERE manguyenlieu='" + id + "'");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
           layDanhSachNCC();
        }
        provider.close();
        return kq;
    }
         
         
         ///Phieu Nhap
         
         
       public static ArrayList<PhieuNhap> layDanhSachPN() {
        ArrayList<PhieuNhap> dsTK = new ArrayList<PhieuNhap>();
        dsTK.clear();
        try {
            String sql = "select*from phieunhap";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                PhieuNhap tk = new PhieuNhap();
                tk.setIdphieu(Integer.valueOf(rs.getString("idphieu")));
                tk.setIdncc(Integer.valueOf(rs.getString("idncc")));
                tk.setManl(Integer.valueOf(rs.getString("manguyenlieu")));
                tk.setSoluong(Integer.valueOf(rs.getString("soluong")));
                tk.setNgaygiao(String.valueOf(rs.getString("ngaynhao")));
                dsTK.add(tk);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
       
           public static ArrayList<String> layDanhSachIdMaLoai() {
            ArrayList<String> dsTK = new ArrayList<String>();
        dsTK.clear();
        try {
            String sql = "select*from nguyenlieu";
            SQLDataProvider provider = new SQLDataProvider();
            provider.open();
            ResultSet rs = provider.excuteSQL(sql);
            while (rs.next()) {
                String id=rs.getString("manguyenlieu");
                  dsTK.add(id);
            }
        } catch (Exception e) {
        }
        return dsTK;
    }
           
       public static boolean themPhieu(int idncc,int manl,int soluong,String ngaynhan) {
        boolean kq = false;
        String sql = String.format("INSERT INTO PhieuNhap values(" + idncc + "," + manl + ","+soluong+",'"+ngaynhan+"')");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();

        return kq;
    }
       
        public static boolean SuaPN(int idpn,int idncc,int manl,int soluong,String ngaynhan) {
        boolean kq = false;
        String sql = String.format("UPDATE PhieuNhap SET IDncc = " + idncc + ", manguyenlieu="+manl+", soluong="+soluong+", ngaynhao='"+ngaynhan+"' WHERE idphieu='" + idpn + "'");
        SQLDataProvider provider = new SQLDataProvider();
        provider.open();
        int n = provider.excuteUPDATE(sql);
        if (n == 1) {
            kq = true;
           layDanhSachNCC();
        }
        provider.close();
        return kq;
    }
    //public static updateSLNL(int )
       
       
}
