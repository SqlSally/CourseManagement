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
package ga.rugal.servlet.dao;

import ga.rugal.servlet.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sally
 */
public class StudentDao {

  private Connection conn;

  public StudentDao(Connection conn) {
    this.conn = conn;
  }

  public void insert(Student student) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("insert into public.student (name, telephone,sid) values (?,?,?)");
      prepareStatement.setString(1, student.name);
      prepareStatement.setString(2, student.telephone);
      prepareStatement.setInt(3, student.sid);

      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void update(Student student) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("update public.student set name = ? , telephone = ?  where sid = ?");
      prepareStatement.setString(1, student.name);
      prepareStatement.setString(2, student.telephone);
      prepareStatement.setInt(3, student.sid);
      System.out.println(prepareStatement);
      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(int sid) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("delete from public.student where sid = ?");
      prepareStatement.setInt(1, sid);

      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Student select(int sid) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("select * from public.student where sid = ?");
      prepareStatement.setInt(1, sid);

      ResultSet executeQuery = prepareStatement.executeQuery();
      if (executeQuery.next()) {
        return new Student(executeQuery.getInt("sid"), executeQuery.getString("name"), executeQuery.getString("telephone"));
      }
    } catch (SQLException ex) {
      Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

}
