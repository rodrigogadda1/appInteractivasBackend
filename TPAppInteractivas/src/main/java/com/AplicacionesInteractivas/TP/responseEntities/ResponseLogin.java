package com.AplicacionesInteractivas.TP.responseEntities;

public class ResponseLogin {
	
	private long nroUser;

	public long getNroUser() {
		return nroUser;
	}

	public void setNroUser(long nroUser) {
		this.nroUser = nroUser;
	}

	public ResponseLogin(long loginExitosoId) {
		super();
		this.nroUser = loginExitosoId;
	}

	public ResponseLogin() {
		super();
	}
	
	
}
