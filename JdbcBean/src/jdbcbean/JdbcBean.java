/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbean;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import jdbc.DaoImpl.StudentDaoImpl;
import jdbc.Model.StudentBean;

/**
 *
 * @author test
 */
public class JdbcBean {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      char cont='y';
     while(cont=='y'|| cont=='Y')
     {
        System.out.println("1.Insert\n2.Update\n3.Delete\n4.Select");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice");
        
        int ch=sc.nextInt();
        switch(ch){
            case 1:
        boolean status=false;
        StudentBean sb=new StudentBean();
        sb.setStudentId(700);
        sb.setStudentName("heidi");
        StudentDaoImpl sdao=new StudentDaoImpl();
        status=sdao.insertdata(sb);
        if(status)
                System.out.println("Data inserted");
        
        break;
        
            case 2:
        
        StudentBean sb1=new StudentBean();
        sb1.setStudentId(501);
        sb1.setStudentName("viraja");
        sdao=new StudentDaoImpl();
        status=sdao.updatedata(sb1);
        if(status)
                System.out.println("Data updated");
        else
             System.out.println("No such record");   
        
        break;
        
            case 3:
         StudentBean sb2=new StudentBean();
         sb2.setStudentId(300);
        //sb.setStudentName("miya");
        sdao=new StudentDaoImpl();
        status=sdao.deletedata(sb2);
        if(status)
                System.out.println("Data deleted");
        else
             System.out.println("No such record");    
        break;
        
            case 4:
                 sdao=new StudentDaoImpl();
		List<StudentBean> l=sdao.fetchDetails();
		StudentBean sb3=new StudentBean();
		Iterator<StudentBean> itr=l.iterator();
		while(itr.hasNext())
		{
			   sb3=(StudentBean)itr.next();
			   System.out.println(sb3.getStudentId()+"    "+sb3.getStudentName());
		}

        
        
        }
        System.out.println("press y/n");
        cont=sc.next().charAt(0);
    }
   }
    
}
