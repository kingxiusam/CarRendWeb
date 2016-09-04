package config;

import java.io.File;
import java.sql.SQLException;

import javaExcel.ReadingExcel;
import bean.SqlControule;

public class ThreadTest implements Runnable{
	private File file;
	
	public ThreadTest(File file){
		super();
		this.file=file;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			SqlControule.getSqlObj().dataimport(ReadingExcel.xls2String(file));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
