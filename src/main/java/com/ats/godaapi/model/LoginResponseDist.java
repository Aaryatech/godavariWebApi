package com.ats.godaapi.model;

public class LoginResponseDist {

	private boolean error;
	private String msg;
	private Distributor distributor;

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

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	@Override
	public String toString() {
		return "LoginResponseDist [error=" + error + ", msg=" + msg + ", distributor=" + distributor + "]";
	}

}
