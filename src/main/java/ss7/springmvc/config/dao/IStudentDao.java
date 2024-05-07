package ss7.springmvc.config.dao;



import ss7.springmvc.config.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();
    List<Student> findAll(String sort, String by);
    boolean add(Student student);
    void deleteById(Integer id);
    Student findById(Integer id);
    void update(Student student);
}
