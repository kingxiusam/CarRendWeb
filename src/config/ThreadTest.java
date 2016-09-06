package config;

import java.io.File;
import java.sql.SQLException;

import javaExcel.ReadingExcel;
import bean.SqlControule;

public class ThreadTest implements Runnable{
	private File file;
	private String table;
	public ThreadTest(File file,String table){
		super();
		this.file=file;
		this.table=table;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			
			switch(table){
			case "curstom":
				SqlControule.getSqlObj().dataimport_curstom(ReadingExcel.xls2String(file));
				break;
				
			case "car":
				SqlControule.getSqlObj().dataimport_car(ReadingExcel.xls2String(file));
				break;
				
			case "driver":
				SqlControule.getSqlObj().dataimport_driver(ReadingExcel.xls2String(file));
				break;
				
			default:
					break;
			}
			
			
			
			
			
			
			
			
		//	SqlControule.getSqlObj().dataimport(ReadingExcel.xls2String(file));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
