package timetask;

import javax.servlet.http.HttpServlet;



public abstract class Get_sum_money {
	private static int basemonth_Money=500,eachMonth=1000;
	private static int baseday_Money=50,eachday=100;
	private static int sum_Money=0;
	
	public static void getTimeState(String rendtype, long rendtime) {
		// TODO Auto-generated method stub
		 if(rendtype.equals("日租")){
			 sum_Money+=rendtime*eachday+baseday_Money;//按天数更新
          }else{
        	  sum_Money+=rendtime*eachMonth+basemonth_Money;//按月数更新
          }
	}
	public static int getMoney(){
		return sum_Money;
		
	}
}
