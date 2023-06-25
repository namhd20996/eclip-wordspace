/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author balis
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> {
    
    private final String INSERT_SQL = "insert into ChuyenDe (maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa) values "
			+ "(?, ?, ?, ?, ?, ?)";
	private final String UPDATE_SQL = "update ChuyenDe "
			+ "set tenChuyenDe=?, hocPhi=?, thoiLuong=?, hinhLogo=?, moTa=? " + "where maChuyenDe=?";
	private final String DELETE_SQL = "delete from ChuyenDe where maChuyenDe=?";
	private final String SELECT_BY_ID_SQL = "select * from ChuyenDe where maChuyenDe=?";
	private final String SELECT_ALL_SQL = "select * from ChuyenDe";

    @Override
    public void insert(ChuyenDe entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getMaCD(),
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa(),
                entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<ChuyenDe> selectBySQL(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("maChuyenDe"));
                entity.setTenCD(rs.getString("tenChuyenDe"));
                entity.setHocPhi(rs.getDouble("hocPhi"));
                entity.setThoiLuong(rs.getInt("thoiLuong"));
                entity.setHinh(rs.getString("hinhLogo"));
                entity.setMoTa(rs.getString("moTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
