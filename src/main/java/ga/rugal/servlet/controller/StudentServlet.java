package ga.rugal.servlet.controller;

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

public class StudentServlet extends HttpServlet {

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

    //directly return
//    PrintWriter out = response.getWriter();
//    studentDao.insert(new Student(0, "sally", "123456789"));
    //forward / dispatch
    request.getRequestDispatcher("student.html").forward(request, response);

//    //redirect
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
