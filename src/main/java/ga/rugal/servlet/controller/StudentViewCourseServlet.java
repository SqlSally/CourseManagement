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
package ga.rugal.servlet.controller;

/**
 *
 * @author sally
 */
import ga.rugal.servlet.dao.CourseDao;
import ga.rugal.servlet.dao.RegistrationDao;
import ga.rugal.servlet.dao.StudentDao;
import ga.rugal.servlet.entity.Course;
import ga.rugal.servlet.service.StudentService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewCourseServlet extends HttpServlet {

  private static Connection connection;

  static {

    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:5432/postgres";
      connection = DriverManager.getConnection(url, "sally", "");

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(SimpleServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(SimpleServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    StudentService studentService = new StudentService(new StudentDao(connection), new CourseDao(connection), new RegistrationDao(connection));
    List<Course> findCourseBySid = studentService.findCourseBySid(Integer.parseInt((String) request.getSession().getAttribute("id")));
    request.setAttribute("findCourseBySid", findCourseBySid);
    request.getRequestDispatcher("studentViewCourse.jsp").forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    StudentService studentService = new StudentService(new StudentDao(connection), new CourseDao(connection), new RegistrationDao(connection));

    String[] parameterValues = req.getParameterValues("selectedDeleteCourse");
    int parseInt = Integer.parseInt((String) req.getSession().getAttribute("id"));
    int count = 0;
    for (String i : parameterValues) {

      if (studentService.DeleteCourse(parseInt, Integer.parseInt(i)) != null) {
        count++;
      }
    }
    resp.getWriter().println("You want to delete " + parameterValues.length + " courses, and successfully removed " + count);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("Servlet " + this.getServletName() + " has started");
  }

  @Override
  public void destroy() {
    System.out.println("Servlet " + this.getServletName() + " has stopped");
  }

}
