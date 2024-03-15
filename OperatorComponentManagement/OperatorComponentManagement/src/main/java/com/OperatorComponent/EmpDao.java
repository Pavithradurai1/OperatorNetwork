package com.OperatorComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class EmpDao {
 
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbcexe","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
//	public static int save(Emp e){
//		int status1=0;
//		try{
//			Connection con=EmpDao.getConnection();
//			PreparedStatement ps=con.prepareStatement("insert into details(Type,Model,Status,Location,VendorID) values (?,?,?,?,?)");
//			ps.setString(1,e.getType());
//			ps.setString(2,e.getModel());
//			ps.setString(3,e.getStatus());
//			ps.setString(4,e.getLocation());
//			ps.setString(5,e.getVid());
//			
//			status1=ps.executeUpdate();
//			
//			con.close();
//		}catch(Exception ex){ex.printStackTrace();}
//		
//		return status1;
//	}
	public static int update(Emp e){
		int status1=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update details set Type=?,Model=?,Status=?,Location=?,VendorID=? where ComponentId=?");
			ps.setString(1,e.getType());
			ps.setString(2,e.getModel());
			ps.setString(3,e.getStatus());
			ps.setString(4,e.getLocation());
			ps.setString(5,e.getVid());
			ps.setString(6,e.getCid());
			
			
			status1=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status1;
	}
	public static int delete(String cid){
		int status1=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from details where ComponentId=?");
			ps.setString (1,cid);
			status1=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status1;
	}
	public static Emp getComponentById( String  cid){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from details where ComponentId=?");
			ps.setString (1,cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setCid(rs.getString (1));
				e.setType(rs.getString(2));
				e.setModel(rs.getString(3));
				e.setStatus(rs.getString(4));
				e.setLocation(rs.getString(5));
				e.setVid(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllComponents(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from details");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setCid(rs.getString (1));
				e.setType(rs.getString(2));
				e.setModel(rs.getString(3));
				e.setStatus(rs.getString(4));
				e.setLocation(rs.getString(5));
				e.setVid(rs.getString(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
