package entity;

public class Car {
    
	private String carid;
	private String type;
	private String carname;
	private String carstate;
	private Integer rendprice;
	private String cdrivername;
	
	public Car(){
		
	}
	
	public Car(String type,String carname,String carstate,Integer rendprice,String carid,String cdrivername){
		this.type = type;
		this.carname = carname;
		this.carstate = carstate;
		this.rendprice = rendprice;
		this.carid=carid;
		this.cdrivername=cdrivername;
	}
	
	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	
	public String getCarstate() {
		return carstate;
	}
	public void setCarstate(String carstate) {
		this.carstate = carstate;
	}
	public Integer getRendprice() {
		return rendprice;
	}
	public void setRendprice(Integer rendprice) {
		this.rendprice = rendprice;
	}
	
	
	

	public String getCdrivername() {
		return cdrivername;
	}

	public void setCdrivername(String cdrivername) {
		this.cdrivername = cdrivername;
	}

	@Override
	public boolean equals(Object obj){
		boolean flage=obj instanceof Car;
		if(flage==false){
			return false;
		}
		Car car=(Car) obj;
		if(this.getCarid().equals(car.carid)&&this.getCarname().equals(car.carname)&&this.getCarstate().equals(car.carstate)&&this.rendprice==car.rendprice&&this.cdrivername.equals(car.cdrivername)){
			return true;
		}else{
			
			return false;
		}
		
	}
	
}
