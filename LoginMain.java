package club;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class LoginFrame extends JFrame implements ActionListener{
    JLabel nameL,pwdL;
    JTextField nameT,pwdT;
    JButton ok,cancel;
    LoginFrame(){
     this.setBounds(600,400,500,100);
     this.setLayout(new FlowLayout());
     this.setVisible(true);
     JLabel a=new JLabel("�û���:");
     nameT=new JTextField(10);
     JLabel b=new JLabel("����:");
     pwdT=new JTextField(10);
     ok=new JButton("ȷ��");
     this.add(a);
     this.add(nameT);
     this.add(b);
     this.add(pwdT);
     this.add(ok);

     ok.addActionListener(this);
     this.validate();
    }
 @Override
 
 public void actionPerformed(ActionEvent e) {
	 Connection con=null;
		      Statement sql; 
		      ResultSet rs;
		      try{  Class.forName("com.mysql.cj.jdbc.Driver"); //����JDBC_MySQL����
		      }
		      catch(Exception ee){}
		     String uri = 
		"jdbc:mysql://localhost:3306/students?"+
		"useSSL=true&serverTimezone=GMT";


		      String user ="root";
		      String password ="12345678";
		      try{  
		         con = DriverManager.getConnection(uri,user,password); //���Ӵ���
		      }
		      catch(SQLException ee){ }
		      try { 
		    	  String nameIn=nameT.getText();
		    	  String pwdIn=pwdT.getText();
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT * FROM user where name='"+nameIn+"'");//��ѯmess��
		          System.out.println(sql.toString());
		          String name=null;
		          String pwd=null;
		          while(rs.next()) {
		             name=rs.getString(1);
		             pwd=rs.getString(2);
		             System.out.printf("%s\t",name);
		             System.out.printf("%s\t",pwd);
		             
		          }
		          if(nameIn.equals(name)&&pwdIn.equals(pwd))
		          {
		        	  System.out.println("��¼�ɹ�");
		          
		          }
		          con.close();
		      }
		      catch(SQLException ee) { 
		         System.out.println(e);
		      }
  
 }
 
}
public class LoginMain {

 public static void main(String[] args) {
	 LoginFrame dlf=new LoginFrame();
  // TODO Auto-generated method stub

 }

}