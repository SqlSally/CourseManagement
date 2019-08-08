package ga.rugal.servlet.service;


import ga.rugal.servlet.dao.CourseDao;
import ga.rugal.servlet.dao.RegistrationDao;
import ga.rugal.servlet.dao.StudentDao;
import ga.rugal.servlet.entity.Registration;
import ga.rugal.servlet.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {

  private StudentDao studentDao;
  private CourseDao courseDao;
  private RegistrationDao registrationDao;

  public TeacherService(StudentDao studentDao, CourseDao courseDao, RegistrationDao registrationDao) {
    this.studentDao = studentDao;
    this.courseDao = courseDao;
    this.registrationDao = registrationDao;
  }

  public List<Student> findStudentByCid(int cid) {
    ArrayList<Student> arrayList = new ArrayList<Student>();
    for (Registration r : registrationDao.findBySid(cid)) {
      arrayList.add(studentDao.select(r.sid));
    }
    return arrayList;
  }

  public String DeleteCourse(int sid, int cid) {

    if (studentDao.select(sid) == null || courseDao.select(cid) == null) {
      return null;
    }

    registrationDao.delete(sid, cid);
    return "Delete Successfully";
  }

}
