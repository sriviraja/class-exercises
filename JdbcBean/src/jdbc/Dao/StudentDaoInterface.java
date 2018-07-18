/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.Dao;

import java.util.List;
import jdbc.Model.StudentBean;

/**
 *
 * @author test
 */
public interface StudentDaoInterface {
    public boolean insertdata(StudentBean s)throws Exception;
    public boolean updatedata(StudentBean s)throws Exception;
    public boolean deletedata(StudentBean s) throws Exception;
    public List<StudentBean> fetchDetails() throws Exception;
}
