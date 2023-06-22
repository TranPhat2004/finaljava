package model;
import java.util.*;
public class ProjectModel {
	private int Ma_DA ;
	private String Ten;
	private String Ngay_BD;
	public ProjectModel(int Ma_DA, String Ten, String Ngay_BD) {
		this.Ma_DA = Ma_DA ;
		this.Ten = Ten;
		this.Ngay_BD = Ngay_BD;
	}

	public ProjectModel() {
	super();
	}
	
	/**
	 * @return the da_ID
	 */
	public int getMa_DA() {
		return Ma_DA;
	}
	/**
	 * @param da_ID the da_ID to set
	 */
	public void setMa_DA(int Ma_DA) {
		this.Ma_DA=Ma_DA;
	}
	/**
	 * @return the da_Name
	 */
	public String getTen() {
		return Ten;
	}
	/**
	 * @param da_Name the da_Name to set
	 */
	public void setTen(String Ten) {
		this.Ten=Ten;
	}
	/**
	 * @return the da_DOS
	 */
	public String getNgay_BD() {
		return Ngay_BD;
	}
	/**
	 * @param da_DOS the da_DOS to set
	 */
	public void setNgay_BD(String Ngay_BD) {
		this.Ngay_BD = Ngay_BD ;
	}
}
