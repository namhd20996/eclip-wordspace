/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.KhoaHoc;
import com.edusys.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author balis
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer> {
    
    private final String INSERT_SQL = "insert into KhoaHoc (maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV, ngayTao) values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_SQL = "update KhoaHoc "
			+ "set maChuyenDe=?, hocPhi=?, thoiLuong=?, ngayKhaiGiang=?, ghiChu=?, maNV=?, ngayTao=? "
			+ "where maKhoaHoc=?";
	private final String DELETE_SQL = "delete from KhoaHoc where maKhoaHoc=?";
	private final String SELECT_BY_ID_SQL = "select * from KhoaHoc where maKhoaHoc=?";
	private final String SELECT_ALL_SQL = "select * from KhoaHoc";

    @Override
    public void insert(KhoaHoc entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV());
    }

    @Override
    public void update(KhoaHoc entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV(),
                entity.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public KhoaHoc selectById(Integer id) {
        List<KhoaHoc> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhoaHoc> selectBySQL(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("maKhoaHoc"));
                entity.setMaCD(rs.getString("maChuyenDe"));
                entity.setHocPhi(rs.getDouble("hocPhi"));
                entity.setThoiLuong(rs.getInt("thoiLuong"));
                entity.setNgayKG(rs.getDate("ngayKhaiGiang"));
                entity.setGhiChu(rs.getString("ghiChu"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setNgayTao(rs.getDate("ngayTao"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhoaHoc> selectByChuyenDe(String macd) {
        String SQL = "SELECT * FROM KhoaHoc WHERE maChuyenDe = ?";
        return this.selectBySQL(SQL, macd);
    }

    public List<Integer> selectYears() {
        String SQL = "SELECT DISTINCT year(ngayKhaiGiang) Year FROM KhoaHoc ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SQL);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
