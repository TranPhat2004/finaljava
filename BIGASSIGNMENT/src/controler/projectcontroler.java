package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ProjectModel;

public class projectcontroler {
	private DBconnect DBconnect = new DBconnect();
	public List<ProjectModel> findAll() {
		List<ProjectModel> listduan = new ArrayList<>();
		String query = "select * from du_an";
		try {
			Statement stmt = this.DBconnect.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProjectModel nv = new ProjectModel(rs.getInt("Ma_Da"), rs.getString("Ten"), rs.getString("Ngay_BD"));
				listduan.add(nv);
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return listduan;
	}

	public void insert(ProjectModel nv) {
		String query = "insert into du_an (Ma_DA,Ten,Ngay_BD) values (?,?,?)";
		try {
			PreparedStatement pstmt = DBconnect.connection.prepareStatement(query);
			pstmt.setInt(1, nv.getMa_DA());
			pstmt.setString(2, nv.getTen());
			pstmt.setString(3, nv.getNgay_BD());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(ProjectModel nv ) {
		String query = "delete from du_an where Ma_DA = '" + nv.getMa_DA() + "' ";
		try {
			PreparedStatement pstmt = this.DBconnect.getConnection().prepareStatement(query);
			pstmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(ProjectModel nv) {
		String query = "update du_an set Ma_DA=?,Ten=?,Ngay_BD=? where Ma_DA='" + nv.getMa_DA() + "'";
		try {
			
			PreparedStatement pstmt = this.DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, nv.getMa_DA());
			pstmt.setString(2, nv.getTen());
			pstmt.setString(3, nv.getNgay_BD());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
