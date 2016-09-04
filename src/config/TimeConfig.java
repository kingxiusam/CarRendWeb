package config;

import java.util.ArrayList;
import java.util.Timer;

import timetask.Task;

public class TimeConfig {
     
	
public static void setTimer(ArrayList cars,String carid,String rendtype,Timer timer,long rendtime){
	
	if(rendtype.equals("日租")){
        timer.schedule(new Task(cars,carid),rendtime*24*3600*1000);//按天数更新
     }else{
     	timer.schedule(new Task(cars,carid),30*rendtime*24*3600*1000);//按月数更新
     }
	
	}
	
}
