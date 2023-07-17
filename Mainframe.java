package club;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Mainframe extends JFrame implements ActionListener {
	JLabel chaxunL;
	JLabel chaxunA;
	JLabel chaxunC;
	JLabel chaxunD;
	JLabel chaxunE;
	JLabel chaxunF;
	JLabel chaxunG;
	JLabel chaxunH;
	JLabel chaxunI;
	JTextField chaxunT;
	JButton chaxunB;
 
 JLabel gengxinL;
 JTextField idT,activityT,birthdateT,heightT;
 JButton gengxinB;
 
 
 JLabel charuL;
 JTextField idcT,activitycT,birthdaycT,heightcT;
 JButton charuB;
 
 
 Mainframe(){
  this.setBounds(600,400,150,800);
  this.setLayout(new FlowLayout());
  this.setVisible(true); 
  
	chaxunL=new JLabel("名称");
	chaxunA=new JLabel("社团名称");
	chaxunC=new JLabel("主要活动");
	chaxunD=new JLabel("成立时间");
	chaxunE=new JLabel("人员数量");
	chaxunF=new JLabel("社团名称");
	chaxunG=new JLabel("主要活动");
	chaxunH=new JLabel("成立时间");
	chaxunI=new JLabel("人员数量");
	chaxunT=new JTextField(10);
	chaxunB=new JButton("     查询      ");
  this.add(chaxunL);
  this.add(chaxunT);
  this.add(chaxunB);
  chaxunB.addActionListener(this);

  gengxinL=new JLabel("           更新输入框           ");
	idT=new JTextField(10);
	activityT=new JTextField(10);
	birthdateT=new JTextField(10);
	heightT=new JTextField(10);
	gengxinB=new JButton("          更新          ");
	this.add(gengxinL);
	 this.add(chaxunF);
	this.add(idT);
	 this.add(chaxunG);
	this.add(activityT);
	 this.add(chaxunH);
	this.add(birthdateT);
	 this.add(chaxunI);
	this.add(heightT);
	this.add(gengxinB);
  gengxinB.addActionListener(this);
  
  charuL=new JLabel("        插入输入框       ");
  idcT=new JTextField(10);
  activitycT=new JTextField(10);
  birthdaycT=new JTextField(10);
  heightcT=new JTextField(10);
 charuB=new JButton("插入");
  this.add(charuL);
  this.add(chaxunA);
  this.add(idcT);
	 this.add(chaxunC);
  this.add(activitycT);
	 this.add(chaxunD);
  this.add(birthdaycT);
	 this.add(chaxunE);
  this.add(heightcT);
  this.add(charuB);
  charuB.addActionListener(this);
  this.validate();
 }

 @Override
 public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==chaxunB) {
	 String [] tableHead;
     String [][] content; 
     JTable table ;
     JFrame win= new JFrame();
     Query findRecord = new  Query();
     String tableActivity=chaxunT.getText();
     findRecord.setDatabaseName("club");
     findRecord.setSQL("select * from "+tableActivity+"");
     content = findRecord.getRecord();
     tableHead=findRecord.getColumnName();
     table = new JTable(content,tableHead); 
     win.add(new JScrollPane(table));
     win.setBounds(12,100,400,200);
     win.setVisible(true); 
     win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 if(e.getSource()==gengxinB) {
		 Connection con;
	      Statement sql; 
	      ResultSet rs;
	      con = GetDBConnection.connectDB("club","root","12345678");
	      if(con == null ) return;
//	      String jiLu="('R11q','王三','2000-10-23',1.66),"+
//	                  "('R10q','李武','1989-10-23',1.76)";    //2条记录
//	      String sqlStr ="insert into mess values"+jiLu;
	      
	      String h1=heightT.getText();
	      float f=Float.parseFloat(h1);
	      String b1=activityT.getText();
	      
	      String c1=birthdateT.getText();
	      
	      String id1=idT.getText();
	      
	      String sqlStr ="update club set height ="+f+",activity ='"+b1+"',birthdate ='"+c1+"' where id ='"+id1+"'";
	      System.out.println(sqlStr);
	      try { 
	          sql=con.createStatement(); 
	          int ok = sql.executeUpdate(sqlStr);
	          String tableactivity=chaxunT.getText();
	          rs = sql.executeQuery("select * from "+tableactivity+"");
	          while(rs.next()) { 
	             String number=rs.getString(1);
	             String activity=rs.getString(2);
	             Date date=rs.getDate(3);
	             float height=rs.getFloat(4);
	             System.out.printf("%s\t",number);
	             System.out.printf("%s\t",activity);
	             System.out.printf("%s\t",date); 
	             System.out.printf("%.2f\n",height);
	          }
	          con.close();
	      }
	      catch(SQLException ee) { 
	         System.out.println("记录中number值不能重复"+ee);
	      }
	 }
	 
	 if(e.getSource()==charuB) {
		 Connection con;
	      Statement sql; 
	      ResultSet rs;
	      System.out.println(111);
	      con = GetDBConnection.connectDB("club","root","12345678");
	      if(con == null ) return;
	      System.out.print(6666);
//	      String jiLu="('R11q','王三','2000-10-23',1.66),"+
//	                  "('R10q','李武','1989-10-23',1.76)";    //2条记录
//	      String sqlStr ="insert into mess values"+jiLu;
	      System.out.printf("%s\t",222);
	      String h1=heightcT.getText();
	      String id1=idcT.getText();
	      String activity1=activitycT.getText();
	      String date1=birthdaycT.getText();
	      float f=Float.parseFloat(h1);
	      String sqlStr ="insert into club values('"+id1+"','"+activity1+"','"+date1+"',"+f+")";
	      System.out.println(111);
	      System.out.println(sqlStr);
	      
	      try { 
	          sql=con.createStatement(); 
	          int ok = sql.executeUpdate(sqlStr);
	          String tableactivity=chaxunT.getText();
	          rs = sql.executeQuery("select * from "+tableactivity+"");
	          while(rs.next()) { 
	             String number=rs.getString(1);
	             String activity=rs.getString(2);
	             Date date=rs.getDate(3);
	             float height=rs.getFloat(4);
	             System.out.printf("%s\t",number);
	             System.out.printf("%s\t",activity);
	             System.out.printf("%s\t",date); 
	             System.out.printf("%.2f\n",height);
	          }
	          con.close();
	      }
	      catch(SQLException ee) { 
	         System.out.println("记录中number值不能重复"+ee);
	      }
	 }
 }

 public static void main(String[] args) {
	 new Mainframe();

 }

}
