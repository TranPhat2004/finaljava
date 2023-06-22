package model;
import java.util.*;
import java.sql.*;
public class EmployeeModel {
		private int Ma_NV;
		private String Ten;
		private String NgaySinh;
		private String DiaChi;
		public EmployeeModel() {}
		public EmployeeModel(int Ma_NV, String Ten, String NgaySinh, String DiaChi) {
			this.Ma_NV = Ma_NV;
			this.Ten = Ten;
			this.NgaySinh = NgaySinh;
			this.DiaChi = DiaChi;
		}

		

		public String getTen() {
			return Ten;
		}

		public void setTen(String Ten) {
			this.Ten = Ten;
		}

		public String getNgaySinh() {
			return NgaySinh;
		}

		public void setNgaySinh(String NgaySinh) {
			this.NgaySinh = NgaySinh;
		}

		public int getMa_NV() {
			return Ma_NV;
		}

		public void setMa_NV(int Ma_NV) {
			this.Ma_NV = Ma_NV;
		}

		public String getDiaChi() {
			return DiaChi;
		}

		public void setDiaChi(String DiaChi) {
			this.DiaChi = DiaChi;
		}

	}


