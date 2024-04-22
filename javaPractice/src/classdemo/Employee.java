package classdemo;

public class Employee {
	private int empid;
	private String ename;
	private double salary;



	public Employee(){
		empid=0;
		ename="kohli";
		salary=0.0;
	}
	public Employee (int id,String nm,double sl){
		empid=id;
		ename=nm;
		salary=sl;
	}
	public void displayDetails(){
		System.out.print("empid : "+ empid +" name : "+ ename +" salary :"+ salary);
	}
}
