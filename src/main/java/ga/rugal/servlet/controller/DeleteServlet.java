/*
 * Copyright 2019 rugal.
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

import ga.rugal.servlet.dao.StudentDao;
import ga.rugal.servlet.entity.Student;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

  private static Connection connection;

  static {

    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:5432/postgres";
      connection = DriverManager.getConnection(url, "sally", "");

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    //directly return
//    PrintWriter out = response.getWriter();
//    studentDao.insert(new Student(0, "sally", "123456789"));
    //forward / dispatch
    request.getRequestDispatcher("delete.html").forward(request, response);

//    //redirect
//   response.sendRedirect("/");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    StudentDao studentDao = new StudentDao(connection);
    Student student = new Student(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("telephone"));
    studentDao.delete(student.sid);
    resp.getWriter().println("Delete successfully!");

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
