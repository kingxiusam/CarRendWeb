package bean;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaExcel.ReadingExcel;
import entity.Car;
import entity.Curstom;
import entity.Driver;
import entity.User;

public class SqlControule {
	private static Statement cmd;//sql命令执行对象
	private PreparedStatement pre_cmd;
	private static Connection con;
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/carrenddb";
    private static SqlControule mSqlControule;
    
	public SqlControule() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		con= DriverManager.getConnection(url, "root","926802zhd");
	   
	}
	
	public static SqlControule getSqlObj() throws ClassNotFoundException, SQLException{
		if(mSqlControule==null){
			mSqlControule=new SqlControule();
		}
		return mSqlControule;
	}
	
	
	/*
	 * 
	 * 下面方法用于数据库中各表的增删改查
	 */
	
	/*
	 增加记录
	 */
	  //增加一辆汽车记录
     public  void addOneCar(Car car) throws SQLException{
    	 
	  String sql="insert into carInfo values('"+car.getType()+"','"+car.getCarname()+"','"+
			  car.getCarstate()+"',"+car.getRendprice()+",'"+car.getCarid()+"','"+car.getCdrivername()+"')";
	  cmd=con.createStatement();
	  cmd.executeUpdate(sql);
   }
     //增加一条顾客记录
     public  void addOneCurstom(Curstom curstom) throws SQLException{//static
    	 
   	  String sql="insert into curstom values('"+curstom.getDentifyId()+"','"+curstom.getCurstomName()+"','"+curstom.getCurstomage()+"','"+
   			  curstom.getCurstomAdress()+"','"+curstom.getCurstomphone()+"')";
   	  cmd=con.createStatement();
   	  cmd.executeUpdate(sql);
   	  
      }
     
     //增加一条司机记录
     
     public  void addOneDriver(Driver driver) throws SQLException{
    	 String sql="insert into driverinfo values('"+driver.getDentifyId()+"','"+driver.getDriverName()+"',"+driver.getAge()+",'"+
      			 driver.getDriveradress()+"','"+driver.getDriverphone()+"')";
      	  cmd=con.createStatement();
      	  cmd.executeUpdate(sql);
      	 
     }
     
     
     /*
      删除记录
      */
     
     //删除一条（汽车，司机，顾客）记录
   public static void deleteOne(String tablename,String Colname,String Colvalue) throws SQLException{//rowname
	   /*String sql="delete from"+tablename+"where"+rowname+"=?";
	   PreparedStatement cmd=con.prepareStatement(sql);
	   cmd.setString(1,rowvalue);
	   cmd.executeUpdate();
	   con.close();*/
	   String sql="delete from "+tablename+" where "+Colname+"='"+Colvalue+"'";//书写SQL语句的时候注意不要遗漏空格符号
	   cmd=con.createStatement();
	   cmd.executeUpdate(sql);
	  
   }
   
   
   
   
   /*
    查询记录
    */
   
   
   
    //查询汽车的信息
  public ArrayList<Car> queryAllCar(String rowname,String rowvalue) throws SQLException{
	  ArrayList<Car> list=new ArrayList<Car>();
	  String sql="select * from carinfo";
	 // String sql="select * from carinfo where "+rowname+"='"+rowvalue+"'";
	  cmd=con.createStatement();
	   ResultSet cars=cmd.executeQuery(sql);
	   while(cars.next()){
		   Car carObj=new Car();
		   carObj.setType(cars.getString(1));
		   carObj.setCarname(cars.getString(2));
		   carObj.setCarstate(cars.getString(3));
		   carObj.setRendprice(cars.getInt(4));
		   carObj.setCarid(cars.getString(5));
		   carObj.setCdrivername(cars.getString(6));
		   list.add(carObj);
	   }
	   
	   return list;
   }
  
  
  
  //查询汽车的信息
  public static Car queryCar(String rowname,String rowvalue) throws SQLException{
	  ArrayList<Car> list=new ArrayList<Car>();
	  String sql="select * from carinfo where "+rowname+"='"+rowvalue+"'";
	  cmd=con.createStatement();
	   ResultSet cars=cmd.executeQuery(sql);
	   while(cars.next()){
		   Car carObj=new Car();
		   carObj.setType(cars.getString(1));
		   carObj.setCarname(cars.getString(2));
		   carObj.setCarstate(cars.getString(3));
		   carObj.setRendprice(cars.getInt(4));
		   carObj.setCarid(cars.getString(5));
		   carObj.setCdrivername(cars.getString(6));
		   list.add(carObj);
	   }
	   
	   return list.get(0);
   }
  
  
//查询满足条件的顾客的信息
  public ArrayList<Curstom> queryCurstom(String rowname,String rowvalue) throws SQLException{
	  ArrayList<Curstom> list=new ArrayList<Curstom>();
	  String sql="select * from curstom where"+rowname+"='"+rowvalue+"'";
	  cmd=con.createStatement();
	   ResultSet curstomers=cmd.executeQuery(sql);
	   while(curstomers.next()){
		   Curstom curstomObj=new Curstom();
		   curstomObj.setDentifyId(curstomers.getString(1));
		   curstomObj.setCurstomName(curstomers.getString(2));
		   curstomObj.setCurstomage(curstomers.getString(3));
		   curstomObj.setCurstomAdress(curstomers.getString(4));
		   curstomObj.setCurstomphone(curstomers.getString(5));
		   list.add(curstomObj);
	   }
	   return list;
   }
  
  
  
  public ArrayList<Curstom> queryAllCurstom() throws SQLException{
	  ArrayList<Curstom> list=new ArrayList<Curstom>();
	  String sql="select * from curstom";
	  cmd=con.createStatement();
	   ResultSet curstomers=cmd.executeQuery(sql);
	   while(curstomers.next()){
		   Curstom curstomObj=new Curstom();
		   curstomObj.setDentifyId(curstomers.getString(1));
		   curstomObj.setCurstomName(curstomers.getString(2));
		   curstomObj.setCurstomage(curstomers.getString(3));
		   curstomObj.setCurstomAdress(curstomers.getString(4));
		   curstomObj.setCurstomphone(curstomers.getString(5));
		   list.add(curstomObj);
	   }
	   return list;
   }
  
  
  
//查询司机的信息
  public ArrayList<Driver> queryAllDriver(String rowname,String rowvalue) throws SQLException{
	  ArrayList<Driver> list=new ArrayList<Driver>();
	  //String sql="select * from driverinfo where "+rowname+"='"+rowvalue+"'";
	  String sql="select * from driverinfo";
	  cmd=con.createStatement();
	   ResultSet drivers=cmd.executeQuery(sql);
	   while(drivers.next()){
		   Driver driverObj=new Driver();
		   driverObj.setDentifyId(drivers.getString(1));
		   driverObj.setDriverName(drivers.getString(2));
		   driverObj.setAge(drivers.getInt(3));
		   driverObj.setDriveradress(drivers.getString(4));
           driverObj.setDriverphone(drivers.getString(5));
		   driverObj.setDriverId(drivers.getString(6));
		   list.add(driverObj);
	   }
	   return list;
   }
  
  
  
  
  
  //查询满足查询条件的 用户信息
  public User queryUser(String username) throws SQLException{
	  ArrayList<User> list=new ArrayList<User>();
	  String sql="select * from user where username='"+username+"'";
	  cmd=con.createStatement();
	   ResultSet users=cmd.executeQuery(sql);
	   while(users.next()){
	   User userObj=new User();
	   userObj.setId(users.getInt(1));
	   userObj.setUsername(users.getString(2));
	   userObj.setPassword(users.getString(3));
	   list.add(userObj);
	   }
	   
	    return list.get(0);
	   
  }
  
  
  
  //更改车辆信息
  public static void updateCar(String rowname,String rowvalue,String updaterowname,String updatevalue) throws SQLException{

	  String sql="update carinfo set "+updaterowname+"='"+updatevalue+"' where "+rowname+"='"+rowvalue+"'";
	   cmd=con.createStatement();
	   cmd.executeUpdate(sql);
	
   }
  
  
  //Excel数据批量导入数据库
  public void dataimport_curstom(List<String[]> list) throws SQLException{
	  String sql="insert into curstom values(?,?,?,?,?)";
	  for(int i=0;i<list.size();i++){//记录条数
		  pre_cmd=con.prepareStatement(sql);
		  pre_cmd.setString(1, list.get(i)[0]);
		  pre_cmd.setString(2, list.get(i)[1]);
		  pre_cmd.setString(3, list.get(i)[2]);
		  pre_cmd.setString(4, list.get(i)[3]);
		  pre_cmd.setString(5, list.get(i)[4]);
		  pre_cmd.executeUpdate();
	  }
	  
}

  public void dataimport_car(List<String[]> list) throws SQLException{
	  String sql="insert into car values(?,?,?,?,?,?)";
	  for(int i=0;i<list.size();i++){//记录条数
		  pre_cmd=con.prepareStatement(sql);
		  pre_cmd.setString(1, list.get(i)[0]);
		  pre_cmd.setString(2, list.get(i)[1]);
		  pre_cmd.setString(3, list.get(i)[2]);
		  pre_cmd.setInt(4, Integer.parseInt(list.get(i)[3]));
		  pre_cmd.setString(5, list.get(i)[4]);
		  pre_cmd.setString(6, list.get(i)[5]);
		  pre_cmd.executeUpdate();
	  }
	  
}
  
  
  
  public void dataimport_driver(List<String[]> list) throws SQLException{
	  String sql="insert into car values(?,?,?,?,?,?)";
	  for(int i=0;i<list.size();i++){//记录条数
		  pre_cmd=con.prepareStatement(sql);
		  pre_cmd.setString(1, list.get(i)[0]);
		  pre_cmd.setString(2, list.get(i)[1]);
		  pre_cmd.setInt(3, Integer.parseInt(list.get(i)[2]));
		  pre_cmd.setString(4, list.get(i)[3]);
		  pre_cmd.setString(5, list.get(i)[4]);
		  pre_cmd.executeUpdate();
	  }
	  
}
  
  
}


