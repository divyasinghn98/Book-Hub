package minip;
import java.sql.*;
public class Database 
{  Connection con;
   PreparedStatement pst,stmt1,stmt2,stmt3,stmt4,stmt5,stmt6,stmt7,stmt8;
   ResultSet rs;
   String u,ei;
   Mailer M;
   Cal1 C;
   
   Database()
   {   try
	   {  con=DriverManager.getConnection("jdbc:Mysql://localhost/30d","root","divya1998");
          pst=con.prepareStatement("select ei from info where un=? and psswd=?");    
          String sql1="insert into info(un,psswd,cont,ei,addr) values (?,?,?,?,?)";
          stmt1=con.prepareStatement(sql1);
          stmt2=con.prepareStatement("select distinct author from book");   
          stmt3=con.prepareStatement("select distinct type from book");    
          stmt4=con.prepareStatement("select title from book where author=?");    
          stmt5=con.prepareStatement("select title from book where type=?"); 
          stmt6=con.prepareStatement("select title,author,type,cost,descp from book where title=?"); 
          stmt7=con.prepareStatement("insert into orders(un,ei,title,cost,qu,time) values (?,?,?,?,?,?)");
        
       }
   
       catch (Exception e) 
       {  System.out.println(e); }
   }
   
   public Boolean checkLogin(String uname,String pwd)
   {  
	   try 
       { pst.setString(1, uname); 
         pst.setString(2, pwd);    
           
         rs=pst.executeQuery();
         if(rs.next())
           { ei=rs.getString(1);
             M=new Mailer(uname,ei);
             C=new Cal1(uname,ei);
             con.close();
             return true;
           }
         else
           { con.close();
             return false; }
         
        } 
   
        catch (Exception e) 
        {  System.out.println("error while validating"+e);
           return false;
        }
   }
   
   public void insert(String u,String p,int c,String ei,String a)
   { try 
    { stmt1.setString(1,u);  
      stmt1.setString(2,p);
      stmt1.setInt(3,c);
      stmt1.setString(4,ei);
      stmt1.setString(5,a); 
      stmt1.executeUpdate();
      con.close();
    }
    catch (Exception e) 
    {  System.out.println("error while validating"+e); }
   }
   
   public String[] author()
   { String[] aut=new String[50];
     int i=0;
	 try
	 { rs=stmt2.executeQuery();
       while(rs.next())
       { aut[i++]=rs.getString(1); }
       return aut;
	 }
	 catch (Exception e) 
	 {  System.out.println("error while validating"+e); }
	 return aut;
   }
   
   public String[] books()
   { String[] titl=new String[50];
     int i=0;
	 try
	 { rs=stmt3.executeQuery();
       while(rs.next())
       { titl[i++]=rs.getString(1); }
       return titl;
	 }
	 catch (Exception e) 
	 {  System.out.println("error while validating"+e); }
	 return titl;
   }
   
   public String[] itema(String cont)
   { String[] tita=new String[50];
     int i=0;
	 try
	 { stmt4.setString(1,cont); 
	   rs=stmt4.executeQuery();
       while(rs.next())
       { tita[i++]=rs.getString(1); }
       return tita;
	 }
	 catch (Exception e) 
	 {  System.out.println("error while validating"+e); }
	 return tita;
   }
   
   public String[] itemt(String cont)
   { String[] titt=new String[50];
     int i=0;
	 try
	 { stmt5.setString(1,cont); 
	   rs=stmt5.executeQuery();
       while(rs.next())
       { titt[i++]=rs.getString(1); }
       return titt;
	 }
	 catch (Exception e) 
	 {  System.out.println("error while validating"+e); }
	 return titt;
   }
   
   public String[] getinfo(String abc)
   {
	    String[] titt=new String[50];
	     int i=0;
		 try
		 { stmt6.setString(1,abc); 
		   rs=stmt6.executeQuery();
	       while(rs.next())
	       { titt[i++]=rs.getString(1);
	         titt[i++]=rs.getString(2);
	         titt[i++]=rs.getString(3);
	         titt[i++]=Integer.toString(rs.getInt(4));
	         titt[i++]=rs.getString(5);
	        }
	       return titt;
		 }
		 catch (Exception e) 
		 {  System.out.println("error while validating"+e); }
		 return titt;
   }
   
   
   public void order(String u1,String ei1,String t,int c,int q,String d)
   { try 
    { stmt7.setString(1,u1);  
      stmt7.setString(2,ei1);
      stmt7.setString(3,t);
      stmt7.setInt(4,c);
      stmt7.setInt(5,q); 
      stmt7.setString(6,d);
      stmt7.executeUpdate();
      con.close();
    }
    catch (Exception e) 
    {  System.out.println("error while validating"+e); }
   }
   
  
}