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
public class NguyenLieu {
    String tennl;
    float dongia;
    int idncc;
    int soluong;
    int manl;
    
    public  NguyenLieu()
    {
        
    }

    public String getTennl() {
        return tennl;
    }

    public void setTennl(String tennl) {
        this.tennl = tennl;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getIdncc() {
        return idncc;
    }

    public void setIdncc(int idncc) {
        this.idncc = idncc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getManl() {
        return manl;
    }

    public void setManl(int manl) {
        this.manl = manl;
    }

    public NguyenLieu(String tennl, float dongia, int idncc, int soluong, int manl) {
        this.tennl = tennl;
        this.dongia = dongia;
        this.idncc = idncc;
        this.soluong = soluong;
        this.manl = manl;
    }

    public void getIdncc(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}