package com.ats.godaapi.model;

public class LoginResponseSup {

	private boolean error;
	private String msg;
	private RouteSup routeSup;

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

	public RouteSup getRouteSup() {
		return routeSup;
	}

	public void setRouteSup(RouteSup routeSup) {
		this.routeSup = routeSup;
	}

	@Override
	public String toString() {
		return "LoginResponseSup [error=" + error + ", msg=" + msg + ", routeSup=" + routeSup + "]";
	}

}
