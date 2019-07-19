package minip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

public class Login implements ActionListener
{ JFrame f = new JFrame("Login");
  JLabel l1,l2,l3;
  JTextField t1;
  JPasswordField t2;
  JButton b1,b2;
  Database db;
  Signup S;
  Mainp M;
  Admin A;
  public String u;
  private JLabel lblNewLabel;
  private JLabel lblNewLabel_1;
  
  Login()
  {
	    f.getContentPane().setBackground(new Color(255, 204, 255));
	    f.setSize(1380,750);
	    f.getContentPane().setLayout(null);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	  
	    l1=new JLabel("Login ");
	    l1.setBackground(new Color(204, 255, 255));
	    l1.setIcon(new ImageIcon(Login.class.getResource("/minip/Images/lo.png")));
	    l1.setForeground(new Color(51, 255, 51));
	    l1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
	    l1.setHorizontalAlignment(SwingConstants.CENTER);
	    f.getContentPane().add(l1);
	   
	    l2=new JLabel("Username");
	    l2.setForeground(new Color(51, 0, 102));
	    l2.setFont(new Font("Arial", Font.PLAIN, 20));
	    l2.setIcon(new ImageIcon(Login.class.getResource("/minip/Images/u.png")));
	    f.getContentPane().add(l2);
	  
	    t1=new JTextField();
	    f.getContentPane().add(t1);
	    
	    l3=new JLabel("Password");
	    l3.setForeground(new Color(51, 0, 102));
	    l3.setFont(new Font("Arial", Font.PLAIN, 20));
	    l3.setIcon(new ImageIcon(Login.class.getResource("/minip/Images/pw.png")));
	    f.getContentPane().add(l3);
	  
	    t2=new JPasswordField();
	    f.getContentPane().add(t2);
	    
	    b1 =new JButton("Login");
	    b1.setFont(new Font("Arial", Font.PLAIN, 15));
	    f.getContentPane().add(b1);
	    
	    b2 =new JButton("Sign Up");
	    b2.setFont(new Font("Arial", Font.PLAIN, 15));
	    f.getContentPane().add(b2);
	    
	    l1.setBounds(523,84,219,78);
	    l2.setBounds(438,244,167,54);
	    t1.setBounds(681,244,131,37);
	    l3.setBounds(438,334,167,66);
	    t2.setBounds(681,350,131,37);
	    b1.setBounds(861,542,97,37);
	    b2.setBounds(377,542,97,37);
	    
	    lblNewLabel = new JLabel("");
	    lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/minip/Images/l1.png")));
	    lblNewLabel.setBounds(967, 137, 345, 341);
	    f.getContentPane().add(lblNewLabel);
	    
	    lblNewLabel_1 = new JLabel("New label");
	    lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/minip/Images/11a.jpg")));
	    lblNewLabel_1.setBounds(0, -11, 1469, 711);
	    f.getContentPane().add(lblNewLabel_1);
	   
	    b1.addActionListener(this);
	    b2.addActionListener(this);
  }  
     
  public void actionPerformed(ActionEvent e)
  { db=new Database();
  
	  if(e.getSource()==b1)
      { u=t1.getText();
        String p=t2.getText();
        
        if(u.equals("admin")&& p.equals("admin123"))
        { f.setVisible(false);
          A=new Admin();
        }
        
        else
        { if(db.checkLogin(u,p))
          {f.setVisible(false);
           M=new Mainp();
          }
         else
         { JOptionPane.showMessageDialog(null, "Invalid Username or Password !!","Failed!!",
                JOptionPane.ERROR_MESSAGE); }
        }
      }
	  
	  if(e.getSource()==b2)
	  { f.setVisible(false);
	    S=new Signup();
	  }
  }
}
