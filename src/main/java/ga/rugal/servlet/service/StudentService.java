/*
 * Copyright 2019 sally.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.servlet.service;

import ga.rugal.servlet.dao.CourseDao;
import ga.rugal.servlet.dao.RegistrationDao;
import ga.rugal.servlet.dao.StudentDao;
import ga.rugal.servlet.entity.Course;
import ga.rugal.servlet.entity.Registration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sally
 */
public class StudentService {

  private StudentDao studentDao;
  private CourseDao courseDao;
  private RegistrationDao registrationDao;

  public StudentService(StudentDao studentDao, CourseDao courseDao, RegistrationDao registrationDao) {
    this.studentDao = studentDao;
    this.courseDao = courseDao;
    this.registrationDao = registrationDao;
  }

  public Registration selectCourse(int sid, int cid) {

    if (studentDao.select(sid) == null || courseDao.select(cid) == null) {
      return null;
    }

    return registrationDao.insert(new Registration(0, sid, cid, -1));
  }

  public List<Course> findCourseBySid(int sid) {
    ArrayList<Course> arrayList = new ArrayList<Course>();
    for (Registration r : registrationDao.findBySid(sid)) {
      arrayList.add(courseDao.select(r.cid));
    }
    return arrayList;
  }

}
