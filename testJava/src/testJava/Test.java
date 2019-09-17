package testJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	
	public static void main (String[]args) {
		
		
//		int [] a= new int[5];
//		
//		List<String> list = new ArrayList<String>();
//		
//		Map<String, Object> map= new HashMap<String, Object>();
//		
//		map.put("우아ㅏ앙", "ㅁㅇㄴㄹ");
//		System.out.println(map.get("우아ㅏ앙"));
//		
//		for(int i=0;i<a.length;i++) {
//			
//			a[i]=i;
//			System.out.println( a[i]);
//		}
		
			A obj = new B();
	        A obj2 = new B2();
	        
	        System.out.println(obj.x());
	        
	        System.out.println(obj2.x());
	        System.out.println(obj.y());
	}
}
class A{
    public String x(){return "A.x";}

	public String y() {
		// TODO Auto-generated method stub
		return null;
	}
}
class B extends A{
    public String x(){return "B.x";}
    public String y(){return "y";}
}
class B2 extends A{
    public String x(){return "B2.x";}
}
