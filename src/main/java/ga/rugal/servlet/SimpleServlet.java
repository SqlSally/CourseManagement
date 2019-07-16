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
package ga.rugal.servlet;

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

public class SimpleServlet extends HttpServlet {

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

    //StudentDao studentDao = new StudentDao(connection);
    //directly return
//    PrintWriter out = response.getWriter();
//    out.println("<html><body>");
//    out.println("<h1>Student Management</h1>");
//    out.println("<h2>Please enter student info</h2>");
//    out.println("<form action='/action_page.php'>");
//    out.println("ID: <input type ='number' name='ID'><br> value=");
//    out.println("Name: <input type='text' name='Name'><br>");
//    out.println("Telephone: <input type='text' name='telephone'><br>");
//    out.println("<input type=\"button\" onclick=\"alert('Insert successfully!')\" value=\"submit!\">");
//    out.println("<input type='reset'>");
//    out.println("</form>");
//    out.println("</body></html>");
    // studentDao.insert(new Student(0, "sally", "123456789"));
    //forward / dispatch
    request.getRequestDispatcher("another.jsp").forward(request, response);
    //redirect
//   response.sendRedirect("/");

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
