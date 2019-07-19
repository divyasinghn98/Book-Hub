package minip;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.Color;

public class Admin 
{ JFrame f = new JFrame("Admin");
  JTable table;
  private JLabel lblAdmin;
  private JLabel lblOrderDetails;
  
  Admin()
  {  f.getContentPane().setBackground(new Color(255, 204, 255));
     f.setSize(1380,750);
     f.getContentPane().setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
	 DefaultTableModel model = new DefaultTableModel(); 
     table = new JTable(model); 
     table.setBounds(100,100,1000,1000);
     f.getContentPane().add(table);
     
     JScrollPane scrollPane = new JScrollPane(table);
     scrollPane.setBounds(192,348,1000,171);
     f.getContentPane().add(scrollPane);
     
     lblAdmin = new JLabel("ADMIN");
     lblAdmin.setIcon(new ImageIcon(Admin.class.getResource("/minip/Images/aa.png")));
     lblAdmin.setFont(new Font("Arial", Font.PLAIN, 25));
     lblAdmin.setBounds(582, 118, 206, 124);
     f.getContentPane().add(lblAdmin);
     
     lblOrderDetails = new JLabel("ORDER DEATILS:-");
     lblOrderDetails.setFont(new Font("Arial", Font.ITALIC, 15));
     lblOrderDetails.setBounds(273, 299, 134, 26);
     f.getContentPane().add(lblOrderDetails);

     
     model.addColumn("USER NAME"); 
     model.addColumn("EMAIL ID"); 
     model.addColumn("BOOK PURCHASED"); 
     model.addColumn("COST"); 
     model.addColumn("QUANTITY"); 
     model.addColumn("DATE AND TIME OF PURCHASE"); 
     
     table.getColumnModel().getColumn(0).setPreferredWidth(50);
     table.getColumnModel().getColumn(1).setPreferredWidth(150);
     table.getColumnModel().getColumn(2).setPreferredWidth(100);
     table.getColumnModel().getColumn(3).setPreferredWidth(50);
     table.getColumnModel().getColumn(4).setPreferredWidth(40);
     table.getColumnModel().getColumn(5).setPreferredWidth(150);
     
     DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
     renderer.setHorizontalAlignment( SwingConstants.CENTER );
    
	  try
     { Connection con=DriverManager.getConnection("jdbc:Mysql://localhost/30d","root","divya1998");
       PreparedStatement stmt8;
       ResultSet rs;
       stmt8=con.prepareStatement("select * from orders");
   
       rs=stmt8.executeQuery();
       while(rs.next())
       {  
 	      model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),Integer.toString(rs.getInt(4)),Integer.toString(rs.getInt(5)),rs.getString(6)});
       } 
	  
     }
	 catch (Exception e) 
	 {  System.out.println("error while validating"+e); }

 }

}
