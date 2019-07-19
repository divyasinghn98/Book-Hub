package minip;
import java.text.*;
import java.util.*;

class Cal1
{ int c,q;
  static int tot=0;
  static String u,ei;
  String b;
  Database db;
  
  Date date = Calendar.getInstance().getTime();  
  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
  String d= dateFormat.format(date);
  
  Cal1(String una,String emi)
  { u=una;
    ei=emi;
    System.out.println(u+"\t"+ei);
  }
  
  Cal1(String b,int c,int q)
  { db=new Database();
	this.b=b;
    this.c=c;
    this.q=q;
    
    System.out.println("1");
    db.order(this.u,this.ei,b,c,q,d);
  } 
  
} 
  
public class Cal 
{ public static ArrayList<Cal1> a=new ArrayList<Cal1>();
  

  void calc(String b,String c1,int q)
  { int c=(Integer.parseInt(c1));
	Cal1 b1=new Cal1(b,c,q);
	a.add(b1);
  }
  
}
