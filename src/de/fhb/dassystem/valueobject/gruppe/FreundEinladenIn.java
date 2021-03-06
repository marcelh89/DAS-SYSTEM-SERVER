package de.fhb.dassystem.valueobject.gruppe;

public class FreundEinladenIn {

	private Integer gruppenid;
	private Integer userid;

	public FreundEinladenIn(int gruppenid, int userid) {
		this.gruppenid = gruppenid;
		this.userid = userid;
	}

	public Integer getGruppenid() {
		return gruppenid;
	}

	public void setGruppenid(Integer gruppenid) {
		this.gruppenid = gruppenid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "FreundEinladenIn [gruppenid=" + gruppenid + ", userid="
				+ userid + "]";
	}

	
}
