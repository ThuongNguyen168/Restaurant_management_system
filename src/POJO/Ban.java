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
public class Ban {
    private int maban;
    private int soghe;
    private String ghichu;

    public Ban(int maban, int soghe, String ghichu) {
        this.maban = maban;
        this.soghe = soghe;
        this.ghichu = ghichu;
    }

    public Ban() {
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
