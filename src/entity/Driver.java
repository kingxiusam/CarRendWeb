package entity;

public class Driver {

	private String dentifyId;
	private String driverName;
	private Integer age;
	private String driveradress;
	private String driverphone;
	private String driverId;

	public Driver(){
		
	}
	
	public Driver(String dentifyId,String driverName,Integer age,String driveradress,String driverphone, String driverid){
		this.dentifyId = dentifyId;
		this.driverName = driverName;
		this.age = age;
		this.driveradress =driveradress;
        this.driverphone=driverphone;
        this.driverId=driverid;
	
	}
	
	
	public String getDentifyId() {
		return dentifyId;
	}
	public void setDentifyId(String dentifyId) {
		this.dentifyId = dentifyId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDriveradress() {
		return driveradress;
	}

	public void setDriveradress(String driveradress) {
		this.driveradress = driveradress;
	}

	public String getDriverphone() {
		return driverphone;
	}

	public void setDriverphone(String driverphone) {
		this.driverphone = driverphone;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	
	
	
}
