package minip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display implements ActionListener
{  JFrame f = new JFrame("Book Details");
   Database db;
   JButton btnBuyNow,btnAddToCart,btnBack;
   JLabel l1,lt,la,li,lc,lco;
   JTextField tco;
   String[] inf;
   Cal C;
   Mainp M;
   Bill B;
   private JLabel lblNewLabel;
   
   Display(String[] inf) 
   { this.inf=inf;
	 f.getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
	 f.getContentPane().setBackground(new Color(255, 204, 255));
	 f.setSize(1380,750);
     f.getContentPane().setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
     lco = new JLabel("No. of Copies");
     lco.setForeground(new Color(102, 102, 255));
     lco.setBackground(new Color(0, 204, 255));
     lco.setBounds(227, 391, 103, 26);
	 lco.setFont(new Font("Arial", Font.PLAIN, 15));
	 f.getContentPane().add(lco);
		
	 tco = new JTextField();
	 tco.setBounds(324, 378, 108, 39);
	 f.getContentPane().add(tco);
	 tco.setColumns(10);
		
	 btnAddToCart = new JButton("Add to Cart");
	 btnAddToCart.setFont(new Font("Arial", Font.PLAIN, 15));
	 btnAddToCart.setIcon(new ImageIcon(Display.class.getResource("/minip/Images/c.png")));
	 btnAddToCart.setBackground(new Color(255, 51, 0));
	 btnAddToCart.setBounds(666, 370, 178, 57);
	 f.getContentPane().add(btnAddToCart);
		
     btnBack = new JButton("BACK");
     btnBack.setForeground(new Color(51, 0, 0));
     btnBack.setIcon(new ImageIcon(Display.class.getResource("/minip/Images/ba.png")));
     btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
	 btnBack.setBackground(new Color(0, 0, 255));
	 btnBack.setBounds(283, 457, 149, 57);
	 f.getContentPane().add(btnBack);
     
     JTextArea textArea = new JTextArea();
     textArea.setBackground(new Color(204, 204, 255));
     textArea.setBounds(353, 138, 322, 166);
     f.getContentPane().add(textArea);
     
     textArea.append("\n\n  Author:- ");
     textArea.append(inf[1]);
     textArea.append("\n\n  Type:- ");
     textArea.append(inf[2]);
     textArea.append("\n\n  Cost:- ");
     textArea.append(inf[3]);
     textArea.append("\n\n  Description:- ");  
     textArea.append(inf[4]);
     textArea.setEditable(false);
     
     l1= new JLabel(inf[0]);
     l1.setBackground(new Color(255, 255, 255));
     l1.setIcon(new ImageIcon(Display.class.getResource("/minip/Images/bo.png")));
     l1.setForeground(new Color(102, 255, 204));
     l1.setHorizontalAlignment(SwingConstants.CENTER);
     l1.setFont(new Font("Arial", Font.ITALIC, 25));
     l1.setBounds(357, 56, 318, 48);
     f.getContentPane().add(l1);
     
     lblNewLabel = new JLabel("New label");
     lblNewLabel.setIcon(new ImageIcon(Display.class.getResource("/minip/Images/1a.jpg")));
     lblNewLabel.setBounds(0, 0, 1364, 711);
     f.getContentPane().add(lblNewLabel);
     
     btnAddToCart.addActionListener(this);
	 btnBack.addActionListener(this);
	 
   }
   
   public void actionPerformed(ActionEvent e)
   { db=new Database();
       
       if(e.getSource()==btnAddToCart)
       { btnBuyNow = new JButton("BUY NOW");
         btnBuyNow.setFont(new Font("Arial", Font.PLAIN, 15));
  	     btnBuyNow.setIcon(new ImageIcon(Display.class.getResource("/minip/Images/bn.png")));
  	     btnBuyNow.setBackground(new Color(51, 255, 0));
  	     btnBuyNow.setBounds(666,457, 178, 57);
         f.getContentPane().add(btnBuyNow);
         btnBuyNow.addActionListener(this);
         
         int q=Integer.parseInt(tco.getText());
         C=new Cal();
         C.calc(inf[0],inf[3],q);
       }
       
       
       else if(e.getSource()==btnBack)
       {  f.setVisible(false);
          M=new Mainp();
       }
       
       else
       { f.setVisible(false);
         B=new Bill();
       }
   }
}
