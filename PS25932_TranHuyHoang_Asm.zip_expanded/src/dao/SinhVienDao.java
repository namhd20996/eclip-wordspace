/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

import java.util.ArrayList;
import model.SinhVien;

/**
 *
 * @author Tran Hoang
 */
public class SinhVienDao implements DAOInterface<SinhVien> {

    @Override
    public int insert(SinhVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(SinhVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(SinhVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SinhVien selectById(SinhVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<SinhVien> selectAll() {
        ArrayList<SinhVien> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from STUDENTS";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MASV = rs.getString("MASV");
                String Hoten = rs.getString("Ho ten");
                String Email = rs.getString("email");
                String SoDT = rs.getString("SDT");
                boolean Gioitinh = rs.getBoolean("Gioitinh");
                String Diachi = rs.getString("Diachi");
                byte[] Hinh = null;
                SinhVien sv = new SinhVien(MASV, Hoten, Email, SoDT, Gioitinh, Diachi, Hinh);
                list.add(sv);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
