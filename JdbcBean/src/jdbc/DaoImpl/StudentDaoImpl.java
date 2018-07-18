/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import jdbc.Dao.StudentDaoInterface;
import jdbc.Database.DatabaseConnectivity;
import jdbc.Model.StudentBean;

/**
 *
 * @author test
 */
public class StudentDaoImpl  implements StudentDaoInterface{

    @Override
    public boolean insertdata(StudentBean s) throws Exception {
         int i=0; //To change body of generated methods, choose Tools | Templates.
         boolean status=false;
         Connection con=DatabaseConnectivity.connect();
         Statement statement=con.createStatement();
         String query1="insert into dao values("+s.getStudentId()+",'"+s.getStudentName()+"')";
         i=statement.executeUpdate(query1);
         if(i>0)
                status=true;
         return status;
    }

    @Override
    public boolean updatedata(StudentBean s) throws Exception {
          int i=0; //To change body of generated methods, choose Tools | Templates.
         boolean status=false;
         Connection con=DatabaseConnectivity.connect();
         Statement statement=con.createStatement();
         String query1="update dao set id="+s.getStudentId()+"where name='"+s.getStudentName()+"'";
         i=statement.executeUpdate(query1);
         if(i>0)
                status=true;
         return status;
    }

    @Override
    public boolean deletedata(StudentBean s) throws Exception {
          int i=0;  
         boolean status=false;
         Connection con=DatabaseConnectivity.connect();
         Statement statement=con.createStatement();
         String query1="delete from dao where id="+s.getStudentId();
         i=statement.executeUpdate(query1);
         if(i>0)
                status=true;
         return status;
    }

      public List<StudentBean> fetchDetails() throws Exception {
		List<StudentBean> li=new LinkedList<StudentBean>();
		ResultSet rs=null;
		Connection con=DatabaseConnectivity.connect();
		Statement statement=con.createStatement();
		String Query="Select * from dao";
		rs=statement.executeQuery(Query);
		while(rs.next())
		{
			StudentBean sb=new StudentBean();
			sb.setStudentId(rs.getInt(1));
			sb.setStudentName(rs.getString(2));
			
			li.add(sb);
		}
		return li;
	}
    }
    
    

