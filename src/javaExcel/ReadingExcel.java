package javaExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



public class ReadingExcel {
	
	  private static String result;
     
	/**
     * 读取xls文件内容
     * @param file 想要读取的文件对象
	 * @return 
     */
    public static List<String[]> xls2String(File file){

 	     List<String[]> list=new ArrayList<String[]>();
        
        try{
            FileInputStream fis = new FileInputStream(file);   
            StringBuilder sb = new StringBuilder();   
            Workbook rwb = Workbook.getWorkbook(fis);   
            Sheet[] sheet = rwb.getSheets(); 
            
            for (int i = 0; i < sheet.length; i++) {   
                Sheet rs = rwb.getSheet(i);   
                for (int j = 1; j < rs.getRows(); j++) { 
                   Cell[] cells = rs.getRow(j);   //获取每行单元格
                   String[] save=new String[cells.length];
                   for(int k=0;k<cells.length;k++){
                	  save[k]=cells[k].getContents();
                   }
               
                   list.add(save);
                }   
            }   
            fis.close();   
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
         return list;
    }
    
}

