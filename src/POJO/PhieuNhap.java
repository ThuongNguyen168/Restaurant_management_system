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
public class PhieuNhap {
    int idphieu;
    int idncc;
    int manl;
    int soluong;
    String ngaygiao;
    public  PhieuNhap()
    {
        
    }

    public int getIdphieu() {
        return idphieu;
    }

    public void setIdphieu(int idphieu) {
        this.idphieu = idphieu;
    }

    public int getIdncc() {
        return idncc;
    }

    public void setIdncc(int idncc) {
        this.idncc = idncc;
    }

    public int getManl() {
        return manl;
    }

    public void setManl(int manl) {
        this.manl = manl;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public PhieuNhap(int idphieu, int idncc, int manl, int soluong, String ngaygiao) {
        this.idphieu = idphieu;
        this.idncc = idncc;
        this.manl = manl;
        this.soluong = soluong;
        this.ngaygiao = ngaygiao;
    }
}
