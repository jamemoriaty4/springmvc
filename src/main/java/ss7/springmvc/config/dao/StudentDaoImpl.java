package ss7.springmvc.config.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ss7.springmvc.config.model.Student;
import ss7.springmvc.config.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("Select * from student");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setSex(rs.getBoolean("sex"));
                students.add(s);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll(String sort, String by) {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("Select * from student order by "+sort+" "+by);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setSex(rs.getBoolean("sex"));
                students.add(s);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Student student) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("INSERT INTO Student(name,address,phone,sex) " +
                    " VALUES (?,?,?,?)");
            callSt.setString(1,student.getName());
            callSt.setString(2,student.getAddress());
            callSt.setString(3,student.getPhone());
            callSt.setBoolean(4,student.getSex());

            int count = callSt.executeUpdate();
            return count!=0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("delete from student where id = ?");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("Select * from student where id = ?");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            if(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setSex(rs.getBoolean("sex"));
                return s;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("update Student set name=?,address=?,phone=?,sex=? where  id =?");
            callSt.setString(1,student.getName());
            callSt.setString(2,student.getAddress());
            callSt.setString(3,student.getPhone());
            callSt.setBoolean(4,student.getSex());
            callSt.setInt(5,student.getId());
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
