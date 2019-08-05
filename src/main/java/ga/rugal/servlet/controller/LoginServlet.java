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

public class LoginServlet extends HttpServlet {

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

    String title = request.getParameter("title");

    //TODO:skip username and password login
    request.getSession().setAttribute("id", request.getParameter("id"));
    request.getSession().setAttribute("password", request.getParameter("password"));
    request.getSession().setAttribute("title", title);

    switch (title) {
      case "student":
        request.getRequestDispatcher("student.jsp").forward(request, response);
        break;
      case "teacher":
        request.getRequestDispatcher("teacher.html").forward(request, response);
        break;
      default:
        request.getRequestDispatcher("admin.html").forward(request, response);
        break;
    }
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
