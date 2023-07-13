/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author HP
 */
public class NhaCC {
    
    int idNCC;
    String TenNCC;
    String DiaChi;
    public  NhaCC()
    {
        
    }

    public int getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(int idNCC) {
        this.idNCC = idNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public NhaCC(int idNCC, String TenNCC, String DiaChi) {
        this.idNCC = idNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
    }
    
}
