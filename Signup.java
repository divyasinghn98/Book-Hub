package minip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup implements ActionListener
{  JFrame f = new JFrame("Sign Up");
   JLabel l1,l2,l3,l4,l5,l6;
   JTextField t1,t3,t4,t5;
   JPasswordField t2;
   JButton b1;
   Database db;
   Login L;
   private JLabel label;
	
   Signup()
   { f.getContentPane().setBackground(new Color(255, 204, 255));
 f.setSize(1380,750);
     f.getContentPane().setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
     l1=new JLabel("Sign Up");
     l1.setHorizontalAlignment(SwingConstants.CENTER);
     l1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
     l1.setForeground(new Color(0, 51, 153));
     f.getContentPane().add(l1);
     
     l2=new JLabel("Username");
     l2.setHorizontalAlignment(SwingConstants.CENTER);
     l2.setFont(new Font("Arial", Font.PLAIN, 15));
     f.getContentPane().add(l2);
     t1=new JTextField();
     f.getContentPane().add(t1);
     
     l3=new JLabel("Password");
     l3.setHorizontalAlignment(SwingConstants.CENTER);
     l3.setFont(new Font("Arial", Font.PLAIN, 15));
     f.getContentPane().add(l3);
     t2=new JPasswordField();
     f.getContentPane().add(t2);
	 
     l4=new JLabel("Contact \nNumber");
     l4.setFont(new Font("Arial", Font.PLAIN, 15));
     f.getContentPane().add(l4);
     t3=new JTextField();
     f.getContentPane().add(t3);
     
     l5=new JLabel("Email Id");
     l5.setHorizontalAlignment(SwingConstants.CENTER);
     l5.setFont(new Font("Arial", Font.PLAIN, 15));
     f.getContentPane().add(l5);
     t4=new JTextField();
     f.getContentPane().add(t4);
     
     l6=new JLabel("Address");
     l6.setHorizontalAlignment(SwingConstants.CENTER);
     l6.setFont(new Font("Arial", Font.PLAIN, 15));
     f.getContentPane().add(l6);
     t5=new JTextField();
     f.getContentPane().add(t5);
     
     b1 =new JButton("Submit");
     b1.setIcon(new ImageIcon(Signup.class.getResource("/minip/Images/s.png")));
     b1.setFont(new Font("Arial", Font.PLAIN, 15));
	 f.getContentPane().add(b1);
     
     l1.setBounds(442,29,94,44);
	 l2.setBounds(275,109,109,27);
	 l3.setBounds(275,168,109,20);
	 l4.setBounds(275,249,120,20);
	 l5.setBounds(275,327,109,20);
	 l6.setBounds(284,412,100,20);
	 t1.setBounds(421,105,186,31);
	 t2.setBounds(421,168,186,31);
	 t3.setBounds(421,239,186,31);
	 t4.setBounds(421,316,186,31);
	 t5.setBounds(421,383,186,95);
	 b1.setBounds(438,558,153,57);
	 
	 label = new JLabel("");
	 label.setIcon(new ImageIcon(Signup.class.getResource("/minip/Images/22.jpg")));
	 label.setBounds(786, 143, 340, 335);
	 f.getContentPane().add(label);
	 
	 b1.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e)
   { db=new Database();
   
       String u=t1.getText();
       String p=t2.getText();
       int c=Integer.parseInt(t3.getText());
       String ei=t4.getText();
       String a=t5.getText();
       
       f.setVisible(false);
       db.insert(u,p,c,ei,a);
       L=new Login();   
   }
}