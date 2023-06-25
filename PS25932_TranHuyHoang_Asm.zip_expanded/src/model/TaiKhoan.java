package model;

public class TaiKhoan {

    private String userName;
    private String passWord;
    private boolean role;

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String passWord, boolean role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "userName=" + userName + ", passWord=" + passWord + ", role=" + role + '}';
    }

}
