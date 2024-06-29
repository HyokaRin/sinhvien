/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sinhvien;

/**
 *
 * @author Admin
 */
public class Student {

    public Student(String ID, String IDClass, String Name, String dantoc, String Khoa, String KhoaHoc, int Namsinh) {
        this.ID = ID;
        this.IDClass = IDClass;
        this.Name = Name;
        this.dantoc = dantoc;
        this.Khoa = Khoa;
        this.KhoaHoc = KhoaHoc;
        this.Namsinh = Namsinh;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDClass() {
        return IDClass;
    }

    public void setIDClass(String IDClass) {
        this.IDClass = IDClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDantoc() {
        return dantoc;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }

    public int getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(int Namsinh) {
        this.Namsinh = Namsinh;
    }
    private String ID;
    private String IDClass;
    private String Name;
    private String dantoc;
    private String Khoa;
    private String KhoaHoc;
    private int Namsinh;
    
    
}
