/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author admin
 */
public class ChiTietHoaDon {
    private int Mahd;
    private int Mamon;
    private int sl;
    private int gia;
    private int thanhtien;
    private String tenmon;

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }
    public int getMahd() {
        return Mahd;
    }

    public void setMahd(int Mahd) {
        this.Mahd = Mahd;
    }

    public int getMamon() {
        return Mamon;
    }

    public void setMamon(int Mamon) {
        this.Mamon = Mamon;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public ChiTietHoaDon() {
    }
}
