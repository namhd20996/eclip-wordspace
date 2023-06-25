
package model;


public class SinhVien {
    private String MASV;
    private String Hoten;
    private String Email;
    private String SoDT;
    private boolean Gioitinh;
    private String Diachi;
    private byte[] Hinh;

    public SinhVien() {
    }

    public SinhVien(String MASV, String Hoten, String Email, String SoDT, boolean Gioitinh, String Diachi, byte[] Hinh) {
        this.MASV = MASV;
        this.Hoten = Hoten;
        this.Email = Email;
        this.SoDT = SoDT;
        this.Gioitinh = Gioitinh;
        this.Diachi = Diachi;
        this.Hinh = Hinh;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "MASV=" + MASV + ", Hoten=" + Hoten + ", Email=" + Email + ", SoDT=" + SoDT + ", Gioitinh=" + Gioitinh + ", Diachi=" + Diachi + ", Hinh=" + Hinh + '}';
    }

   
    
}
