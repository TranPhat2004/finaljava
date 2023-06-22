package controler;
import java.sql.*;
import controler.DBconnect;
import model.ParticipationModel;

import java.util.*;
public class participationcontroler {
	private DBconnect DBconnect = new DBconnect();
	public List<ParticipationModel> findAll() {
		List<ParticipationModel> listthamgia = new ArrayList<>();
		String query = "select * from tham_gia";
		try {
			
			Statement stmt = this.DBconnect.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ParticipationModel money = new ParticipationModel(rs.getInt("Ma_DA"), rs.getInt("Ma_NV"), rs.getInt("Tien_Luong")
						);
				listthamgia.add(money);
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return listthamgia;
	}

	public void insert(ParticipationModel money) {
		String query = "insert into tham_gia (Ma_DA, Ma_NV, Tien_Luong) values (?,?,?)";
		try {
			PreparedStatement pstmt = DBconnect.connection.prepareStatement(query);
			pstmt.setInt(1, money.getMa_DA());
			pstmt.setInt(2, money.getMa_NV());
			pstmt.setInt(3, money.getTien_Luong());
			pstmt.execute();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}

	public void delete(ParticipationModel money ) {
		String query = "delete from tham_gia where Ma_DA= '"+money.getMa_DA()+"' and Ma_NV= '"+money.getMa_NV()+"'";
		try {
			PreparedStatement pstmt = this.DBconnect.connection.prepareStatement(query);
			pstmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(ParticipationModel money) {
		String query = "update tham_gia set Ma_DA=?,Ma_NV=?,Tien_Luong=? where Ma_DA='" + money.getMa_DA() + "' and Ma_NV= '"+money.getMa_NV()+"'";
		try {
			
			PreparedStatement pstmt = this.DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, money.getMa_DA());
			pstmt.setInt(2, money.getMa_NV());
			pstmt.setInt(3, money.getTien_Luong());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}