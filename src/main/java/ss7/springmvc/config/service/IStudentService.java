package ss7.springmvc.config.service;


import ss7.springmvc.config.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> findAll(String sort, String by);
    boolean add(Student student);
    void update(Student student);
    void deleteById(Integer id);
    Student findById(Integer id);


}
