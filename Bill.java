package minip;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.Font;

public class Bill extends Cal implements ActionListener
{  JFrame f = new JFrame("Main Page");
   double tot=0;
   Final F;

	Bill()
	{  f.getContentPane().setBackground(new Color(255, 204, 255));
  f.setSize(1380,750);
       f.getContentPane().setLayout(null);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JTextArea textArea = new JTextArea();
       textArea.setBackground(new Color(204, 204, 255));
       textArea.setBounds(268, 168, 257, 166);
       f.getContentPane().add(textArea);
       
       JTextArea textArea_1 = new JTextArea();
	   textArea_1.setBackground(new Color(204, 204, 255));
	   textArea_1.setBounds(524, 168, 181, 166);
	   f.getContentPane().add(textArea_1);
       
       JButton btnPalceOrder = new JButton("Palce Order");
       btnPalceOrder.setBackground(new Color(255, 204, 255));
       btnPalceOrder.setIcon(new ImageIcon(Bill.class.getResource("/minip/Images/pl.png")));
       btnPalceOrder.setFont(new Font("Arial", Font.PLAIN, 15));
       btnPalceOrder.setBounds(425, 421, 166, 57);
       f.getContentPane().add(btnPalceOrder);
       
       JLabel lblOrder = new JLabel("Order");
       lblOrder.setFont(new Font("Arial", Font.PLAIN, 15));
       lblOrder.setBounds(286, 139, 67, 23);
       f.getContentPane().add(lblOrder);
       
       JLabel lblCost = new JLabel("Cost");
       lblCost.setFont(new Font("Arial", Font.PLAIN, 15));
       lblCost.setBounds(524, 143, 34, 14);
       f.getContentPane().add(lblCost);
       
       JLabel lblQuantity = new JLabel("Quantity");
       lblQuantity.setFont(new Font("Arial", Font.PLAIN, 15));
       lblQuantity.setBounds(612, 143, 87, 14);
       f.getContentPane().add(lblQuantity);
       
       JLabel lblTotal = new JLabel("Total  =");
       lblTotal.setFont(new Font("Arial", Font.PLAIN, 15));
       lblTotal.setBounds(468, 355, 57, 14);
       f.getContentPane().add(lblTotal);
       
       JLabel lbltot = new JLabel();
       lbltot.setFont(new Font("Arial", Font.PLAIN, 15));
       lbltot.setBounds(524, 355, 109, 14);
       f.getContentPane().add(lbltot);
       
		Iterator itr=a.iterator();
		while(itr.hasNext())
		{ Cal1 b2=(Cal1)itr.next();
		  tot=tot+(b2.c*b2.q);
		  textArea.append( b2.b);
		  textArea.append("\n");
		  
		  textArea_1.append( b2.c+"       *    "+b2.q);
		  textArea_1.append("\n");
		}
	    
		 textArea.append("Tax and Shipping Charges ");
		 textArea_1.append("50.236  ");
		 tot=tot+50.236;
		 lbltot.setText("INR "+tot);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(Bill.class.getResource("/minip/Images/plc.png")));
		 lblNewLabel.setBounds(832, 139, 219, 230);
		 f.getContentPane().add(lblNewLabel);
		 
		 
		 btnPalceOrder.addActionListener(this);
	} 
		 public void actionPerformed(ActionEvent e)
		   { f.setVisible(false);
		     F=new Final(tot);
		   }
}
