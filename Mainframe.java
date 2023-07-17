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
  
	chaxunL=new JLabel("����");
	chaxunA=new JLabel("��������");
	chaxunC=new JLabel("��Ҫ�");
	chaxunD=new JLabel("����ʱ��");
	chaxunE=new JLabel("��Ա����");
	chaxunF=new JLabel("��������");
	chaxunG=new JLabel("��Ҫ�");
	chaxunH=new JLabel("����ʱ��");
	chaxunI=new JLabel("��Ա����");
	chaxunT=new JTextField(10);
	chaxunB=new JButton("     ��ѯ      ");
  this.add(chaxunL);
  this.add(chaxunT);
  this.add(chaxunB);
  chaxunB.addActionListener(this);

  gengxinL=new JLabel("           ���������           ");
	idT=new JTextField(10);
	activityT=new JTextField(10);
	birthdateT=new JTextField(10);
	heightT=new JTextField(10);
	gengxinB=new JButton("          ����          ");
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
  
  charuL=new JLabel("        ���������       ");
  idcT=new JTextField(10);
  activitycT=new JTextField(10);
  birthdaycT=new JTextField(10);
  heightcT=new JTextField(10);
 charuB=new JButton("����");
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
//	      String jiLu="('R11q','����','2000-10-23',1.66),"+
//	                  "('R10q','����','1989-10-23',1.76)";    //2����¼
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
	         System.out.println("��¼��numberֵ�����ظ�"+ee);
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
//	      String jiLu="('R11q','����','2000-10-23',1.66),"+
//	                  "('R10q','����','1989-10-23',1.76)";    //2����¼
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
	         System.out.println("��¼��numberֵ�����ظ�"+ee);
	      }
	 }
 }

 public static void main(String[] args) {
	 new Mainframe();

 }

}
