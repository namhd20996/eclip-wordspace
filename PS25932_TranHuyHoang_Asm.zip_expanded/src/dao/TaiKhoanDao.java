
package dao;

import java.sql.Connection;

import java.util.ArrayList;
import model.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.StatementEvent;

public class TaiKhoanDao implements DAOInterface<TaiKhoan> {

    @Override
    public int insert(TaiKhoan t) {
        int result = 0;
        try {
            // Bước 1 kết nối
            Connection connection = JDBCUtil.getConnection();
            // Bước 2: Tạo đối tượng stament
            String sql = "insert into TaiKhoan (userName, pass_Word, ro_le) values \n"
                    + "(?, ?, ?)";
            // Bước 3: Thực thi stament
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getUserName());
            pst.setString(2, t.getPassWord());
            pst.setBoolean(3, t.isRole());
            // Bước 4: Xử lý kết quả
            result = pst.executeUpdate();
            System.out.println("Da thuc thi " + result + " dong");
            // NGắt kết nối
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public int update(TaiKhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TaiKhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan";
            PreparedStatement pst = connection.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("pass_Word");
                boolean role = rs.getBoolean("ro_le");
                TaiKhoan tk = new TaiKhoan(userName, passWord, role);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        TaiKhoanDao tkd = new TaiKhoanDao();
       TaiKhoan tkm = new TaiKhoan();
       tkm.setUserName("namboi");
       TaiKhoan tkmm = tkd.selectById(tkm);
        System.out.println(tkmm);
    }

    @Override
    public TaiKhoan selectById(TaiKhoan t) {
        TaiKhoan tkm = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where userName=?";
            PreparedStatement pst = connection.prepareCall(sql);
            pst.setString(1, t.getUserName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("pass_Word");
                boolean role = rs.getBoolean("ro_le");
                tkm = new TaiKhoan(userName, passWord, role);

            }
        } catch (Exception e) {
        }
        return tkm;
    }
  public TaiKhoan checkLogin(TaiKhoan t) {
        TaiKhoan tkm = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where userName=? and pass_Word=?";
            PreparedStatement pst = connection.prepareCall(sql);
            pst.setString(1, t.getUserName());
            pst.setString(2, t.getPassWord());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("pass_Word");
                boolean role = rs.getBoolean("ro_le");
                tkm = new TaiKhoan(userName, passWord, role);

            }
        } catch (Exception e) {
        }
        return tkm;
    }
}
