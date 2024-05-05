package com.app.patient;

public enum ServicePlan {
HIGH(10000),MEDIUM(5000),LOW(2500);
private double minAmtReg;

private ServicePlan(double minAmtReg) {
	this.minAmtReg = minAmtReg;
}

public double getMinAmtReg() {
	return minAmtReg;
}

public void setMinAmtReg(double minAmtReg) {
	this.minAmtReg = minAmtReg;
}




	
}
