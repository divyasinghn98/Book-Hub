package minip;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    

public class Final 
{ 
  Final(double tot)
  {  JFrame f = new JFrame("Thank You");
     f.getContentPane().setBackground(new Color(255, 204, 255));
	 f.setSize(1380,750);
     f.getContentPane().setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JLabel l1=new JLabel("Thank You for Shopping with BOOK HUB");
     l1.setForeground(new Color(0, 204, 255));
     l1.setIcon(new ImageIcon(Final.class.getResource("/minip/Images/l2 (2).jpg")));
     l1.setHorizontalAlignment(SwingConstants.CENTER);
     l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
     f.getContentPane().add(l1);
     l1.setBounds(361,164,624,140);
     
     JLabel lblPlease = new JLabel("Please do the payment of "+tot+" INR on delivery of your order ");
     lblPlease.setForeground(new Color(0, 204, 255));
     lblPlease.setFont(new Font("Monotype Corsiva", Font.ITALIC, 26));
     lblPlease.setBounds(195, 394, 624, 33);
     f.getContentPane().add(lblPlease);
     
     JLabel lblConfirmationMailSent = new JLabel("A confirmation Mail sent to your registered email address");
     lblConfirmationMailSent.setForeground(new Color(0, 204, 255));
     lblConfirmationMailSent.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
     lblConfirmationMailSent.setBounds(195, 453, 552, 33);
     f.getContentPane().add(lblConfirmationMailSent);
     
     JLabel lblNewLabel = new JLabel("New label");
     lblNewLabel.setIcon(new ImageIcon(Final.class.getResource("/minip/Images/1a.jpg")));
     lblNewLabel.setBounds(0, 0, 1364, 711);
     f.getContentPane().add(lblNewLabel);
	 Mailer.sendmail(tot); 
  }    
}

class Mailer
{  static String u,ei;
	  
  Mailer(String un,String eid)
  { u=un;
    ei=eid;    	  
  }
	  
  public static void sendmail(double tot)
  {  String sto=ei;
	 //from,password,to,subject,message  
	  send("bookhubstore1998@gmail.com","Div@12345",sto,"Test","\nHello "+u+"\nThank You for shopping with Book Hub\nYour order is expected to be delivered within 7 days\nplease do the payment "+tot+" on delivery");  
	  //change from, password and to  
  }
	
	
   public static void send(String from,String password,String to,String sub,String msg)
   {  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  