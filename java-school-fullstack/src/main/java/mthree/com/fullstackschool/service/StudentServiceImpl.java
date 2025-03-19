package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.CourseDao;
import mthree.com.fullstackschool.dao.StudentDao;
import mthree.com.fullstackschool.model.Course;
import mthree.com.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    //YOUR CODE STARTS HERE
    private final StudentDao studentDao;


    @Autowired
    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    //YOUR CODE ENDS HERE

    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        return studentDao.getAllStudents();

        //YOUR CODE ENDS HERE
    }

    public Student getStudentById(int id) {
        //YOUR CODE STARTS HERE

        try {
            return studentDao.findStudentById(id);
        } catch (DataAccessException e) {
            Student notFound = new Student();
            notFound.setStudentFirstName("Student Not Found");
            notFound.setStudentLastName("Student Not Found");
            return notFound;
        }

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        if (student.getStudentFirstName() == null || student.getStudentFirstName().trim().isEmpty()) {
            student.setStudentFirstName("First Name blank, student NOT added");
        }
        if (student.getStudentLastName() == null || student.getStudentLastName().trim().isEmpty()) {
            student.setStudentLastName("Last Name blank, student NOT added");
        }
        return studentDao.createNewStudent(student);

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE

        if (id != student.getStudentId()) {
            student.setStudentFirstName("IDs do not match, student not updated");
            student.setStudentLastName("IDs do not match, student not updated");
            return student;
        }
        studentDao.updateStudent(student);
        return student;

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE

        studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        studentDao.deleteStudentFromCourse(studentId, courseId);

        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        studentDao.addStudentToCourse(studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}
