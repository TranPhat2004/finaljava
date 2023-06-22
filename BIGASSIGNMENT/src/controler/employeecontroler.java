package controler;
import java.sql.*;
import controler.DBconnect;
import model.EmployeeModel;

import java.util.*;
public class employeecontroler {
	private DBconnect DBconnect = new DBconnect();
	public List<EmployeeModel> findAll() {
		List<EmployeeModel> listnhanvien = new ArrayList<>();
		String query = "select * from nhan_vien";
		try {
			
			Statement stmt = this.DBconnect.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				EmployeeModel nv = new EmployeeModel(rs.getInt("Ma_Nv"), rs.getString("Ten"), rs.getString("NgaySinh"),
						rs.getString("DiaChi"));
				listnhanvien.add(nv);
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return listnhanvien;
	}

	public void insert(EmployeeModel nv) {
		String query = "insert into nhan_vien (Ma_Nv, Ten, NgaySinh, DiaChi) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = DBconnect.connection.prepareStatement(query);
			pstmt.setInt(1, nv.getMa_NV());
			pstmt.setString(2, nv.getTen());
			pstmt.setString(3, nv.getNgaySinh());
			pstmt.setString(4, nv.getDiaChi());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(EmployeeModel nv ) {
		String query = "delete from nhan_vien where Ma_NV = '" + nv.getMa_NV() + "'";
		try {
			PreparedStatement pstmt = this.DBconnect.getConnection().prepareStatement(query);
			pstmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(EmployeeModel nv) {
		String query = "update nhan_vien set Ma_NV=?,Ten=?,NgaySinh=?,DiaChi=? where Ma_NV='" + nv.getMa_NV() + "'";
		try {
			
			PreparedStatement pstmt = this.DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, nv.getMa_NV());
			pstmt.setString(2, nv.getTen());
			pstmt.setString(3, nv.getNgaySinh());
			pstmt.setString(4, nv.getDiaChi());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
