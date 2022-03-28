package entity;

import java.util.Date;

public class Employee {
	private int id;
	private int iddep;
	private String fullname;
	private String address;
	private Date birthday;
	private boolean gender;
	private double salary;
	private boolean status;
	private String imglink;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, int iddep, String fullname, String address, Date birthday, boolean gender, double salary,
			boolean status, String imglink) {
		super();
		this.id = id;
		this.iddep = iddep;
		this.fullname = fullname;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.salary = salary;
		this.status = status;
		this.imglink = imglink;
	}

	public Employee(int iddep, String fullname, String address, Date birthday, boolean gender, double salary,
			boolean status, String imglink) {
		super();
		this.iddep = iddep;
		this.fullname = fullname;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.salary = salary;
		this.status = status;
		this.imglink = imglink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIddep() {
		return iddep;
	}

	public void setIddep(int iddep) {
		this.iddep = iddep;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImglink() {
		return imglink;
	}

	public void setImglink(String imglink) {
		this.imglink = imglink;
	}

}
