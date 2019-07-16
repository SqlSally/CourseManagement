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
import java.sql.SQLException;

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
      PreparedStatement prepareStatement = conn.prepareStatement("insert into public.student (name, telephone) values (?,?)");
      prepareStatement.setString(1, student.name);
      prepareStatement.setString(2, student.telephone);

      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
