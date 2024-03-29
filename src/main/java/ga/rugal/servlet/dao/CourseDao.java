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

import ga.rugal.servlet.entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sally
 */
public class CourseDao {

  private Connection conn;

  public CourseDao(Connection conn) {
    this.conn = conn;
  }

  public Course insert(Course course) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("insert into public.course (cid,cname) values (?,?) ");
      prepareStatement.setInt(1, course.cid);
      prepareStatement.setString(2, course.course);
      boolean execute = prepareStatement.execute();

      return new Course(course.cid, course.course);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void update(Course course) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("update public.course set cname = ?  where cid = ?");
      prepareStatement.setString(1, course.course);
      prepareStatement.setInt(2, course.cid);
      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(int cid) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("delete from public.course where cid = ?");
      prepareStatement.setInt(1, cid);
      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Course select(int cid) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("select * from public.course where cid = ?");
      prepareStatement.setInt(1, cid);

      ResultSet executeQuery = prepareStatement.executeQuery();
      if (executeQuery.next()) {
        return new Course(executeQuery.getInt("cid"), executeQuery.getString("cname"));
      }
    } catch (SQLException ex) {
      Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public List<Course> getAll() {
    try {
      ArrayList<Course> arrayList = new ArrayList<>();
      PreparedStatement prepareStatement = conn.prepareStatement("select * from public.course");

      ResultSet executeQuery = prepareStatement.executeQuery();
      while (executeQuery.next()) {
        arrayList.add(new Course(executeQuery.getInt("cid"), executeQuery.getString("cname")));
      }
      return arrayList;

    } catch (SQLException ex) {
      Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
