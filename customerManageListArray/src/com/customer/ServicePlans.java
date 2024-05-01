package com.customer;

public enum ServicePlans {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private double plans;
	ServicePlans(double plans){
		this.plans=plans;
	}
	
	public String toString() {
		return name()+" : "+plans;
	}
	public double getPlans() {
		return this.plans;
	}
}
