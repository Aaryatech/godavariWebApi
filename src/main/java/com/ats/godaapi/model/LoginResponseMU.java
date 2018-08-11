package com.ats.godaapi.model;

public class LoginResponseMU {

	private boolean error;
	private String msg;
	private MahasnaghUser mahasnaghUser;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MahasnaghUser getMahasnaghUser() {
		return mahasnaghUser;
	}

	public void setMahasnaghUser(MahasnaghUser mahasnaghUser) {
		this.mahasnaghUser = mahasnaghUser;
	}

	@Override
	public String toString() {
		return "LoginResponseMU [error=" + error + ", msg=" + msg + ", mahasnaghUser=" + mahasnaghUser + "]";
	}

}
