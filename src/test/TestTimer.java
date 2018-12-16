package test;

import action.*;
import java.util.*;

public class TestTimer {

	public static void main(String[] args) {
		Timer  t1 = new Timer();
		
		MyTask mt = new MyTask(t1);
		       mt.start(new Date(), 1000);
		
        try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        mt.close();
	}

}
