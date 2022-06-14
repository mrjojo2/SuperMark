import com.sun.org.apache.xml.internal.serializer.ToStream;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Usuario us1 = new Usuario("mjojo2", "password");
   
   System.out.println(us1);
   
	System.out.println("*********************");	   
	
	us1.mostrar();
	
	
	}

}
