package model;

public class ParticipationModel {
	private int Ma_DA;
	private int Ma_NV;
	private int Tien_Luong;

	public ParticipationModel(int Ma_DA, int Ma_NV, int Tien_Luong) {
		this.Ma_DA = Ma_DA;
		this.Ma_NV = Ma_NV;
		this.Tien_Luong = Tien_Luong;
	}

	public ParticipationModel() {
	}

	public int getMa_DA() {
		return Ma_DA;
	}

	public void setMa_DA(int Ma_DA) {
		this.Ma_DA = Ma_DA;
	}

	public int getMa_NV() {
		return Ma_NV;
	}

	public void setMa_NV(int Ma_NV) {
		this.Ma_NV = Ma_NV;
	}

	public int getTien_Luong() {
		return Tien_Luong;
	}

	public void setTien_Luong(int Tien_Luong) {
		this.Tien_Luong = Tien_Luong;
	}
}
