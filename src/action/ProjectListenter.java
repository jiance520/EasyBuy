package action;

import java.util.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// ���� ������ 
public class ProjectListenter implements ServletContextListener{

	private MyTask mt ;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(" ---- ���̽��� ");//�����������ȹ��������硣
		if(mt != null){
		  mt.close();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(" ---- �������� ");
		Timer  t1 = new Timer();
		mt = new MyTask(t1);
		
		mt.start(new Date(), 1000);
	}

}
