package action;

import java.util.*;

public class MyTask extends TimerTask{

	private Timer timer;
	
	public MyTask(Timer timer) {
		this.timer = timer;
	}

    public void start(Date firstTime,long period){
 
    	timer.schedule(this, firstTime, period);
    }

    public void close(){
    	
    	timer.cancel();
    }   
	public void run() {
		
//		System.out.println(" Ê±¼ä £º "+ new Date());
	}
}
