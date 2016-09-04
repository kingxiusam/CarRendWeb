package entity;

public class Curstom {
	
	private String dentifyId;
	private String curstomName;
	private String curstomage;
	private String curstomAdress;
	private String curstomphone;
	
	
	public Curstom(){
		
	}
	
	
	public  Curstom(String dentifyId,String curstomName,String curstomage,String curstomAdress,String curstomphone){
		this.dentifyId = dentifyId;
		this.curstomName = curstomName;
		this.curstomage = curstomage;
		this.curstomAdress = curstomAdress;
	    this.curstomphone=curstomphone;
	}
	
	
	
	public String getDentifyId() {
		return dentifyId;
	}
	public void setDentifyId(String dentifyId) {
		this.dentifyId = dentifyId;
	}
	public String getCurstomName() {
		return curstomName;
	}
	public void setCurstomName(String curstomName) {
		this.curstomName = curstomName;
	}
	public String getCurstomage() {
		return curstomage;
	}
	public void setCurstomage(String curstomage) {
		this.curstomage = curstomage;
	}
	public String getCurstomAdress() {
		return curstomAdress;
	}
	public void setCurstomAdress(String curstomAdress) {
		this.curstomAdress = curstomAdress;
	}

	public String getCurstomphone() {
		return curstomphone;
	}
	public void setCurstomphone(String curstomphone) {
		this.curstomphone = curstomphone;
	}
	   
	
	
	
	
	
	

}
