package test;

import java.util.*;

import entity.*;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		// json 特殊格式的字符串  {key:value,key:value}
        Users u2 = new Users();
              u2.setUserId("ds1");
              u2.setUserName("peter");
              
        String js = JSON.toJSONString(u2)   ;   
        // json = {"status":0,"userId":"ds1","userName":"peter"}
		System.out.println(" json = "+js);
		
		List<Users> list = new ArrayList<Users>();
		            list.add(u2);
		
		            Users u3 = new Users();
		              u3.setUserId("ds2");
		              u3.setUserName("peter2");            
		            list.add(u3);
		            
		String js2 = JSON.toJSONString(list)   ;  
		//[{"status":0,"userId":"ds1","userName":"peter"},{"status":0,"userId":"ds2","userName":"peter2"}]
		System.out.println(" json2 = "+js2);
	}

}
