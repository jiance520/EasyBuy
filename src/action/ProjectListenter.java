package action;

import java.util.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 工程 监听器 
public class ProjectListenter implements ServletContextListener{

	private MyTask mt ;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(" ---- 工程结束 ");//最先启动，比过滤器还早。
		if(mt != null){
		  mt.close();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(" ---- 工程启动 ");
		Timer  t1 = new Timer();
		mt = new MyTask(t1);
		
		mt.start(new Date(), 1000);
	}

}
