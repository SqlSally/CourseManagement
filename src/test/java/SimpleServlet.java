
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/**
 *
 * @author sally
 */
public class SimpleServlet extends HttpServlet {

  private static Connection connection;

  static {

    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:5432/postgres";
      connection = DriverManager.getConnection(url, "sally", "");

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ga.rugal.servlet.controller.SimpleServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(ga.rugal.servlet.controller.SimpleServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  private void doGetdoGet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

    StudentDao studentDao = new StudentDao(connection);
    studentDao.insert(new Student(1, "Rugal", "123456789"));
    resp.getWriter().println("Sally,hello");
  }

}
