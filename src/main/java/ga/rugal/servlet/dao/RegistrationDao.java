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

import ga.rugal.servlet.entity.Registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sally
 */
public class RegistrationDao {

  private Connection conn;

  public RegistrationDao(Connection conn) {
    this.conn = conn;
  }

  public Registration insert(Registration registration) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("insert into public.registration (sid,cid,score) values (?,?,?) RETURNING rid");
      prepareStatement.setInt(1, registration.sid);
      prepareStatement.setInt(2, registration.cid);
      prepareStatement.setInt(3, registration.score);
      ResultSet rs = prepareStatement.executeQuery();
      rs.next();
      return new Registration(rs.getInt(1), registration.sid, registration.cid, registration.score);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void update(Registration registration) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("update public.registration set score = ?  sid =? cid= ? where rid = ?");
      prepareStatement.setInt(1, registration.score);
      prepareStatement.setInt(2, registration.sid);
      prepareStatement.setInt(3, registration.cid);
      prepareStatement.setInt(4, registration.rid);

      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(int rid) {
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("delete from public.registration where rid = ?");
      prepareStatement.setInt(1, rid);
      boolean execute = prepareStatement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Registration> findBySid(int sid) {

    ArrayList<Registration> arrayList = new ArrayList<>();
    try {
      PreparedStatement prepareStatement = conn.prepareStatement("select * from public.Registration where sid = ?");
      prepareStatement.setInt(1, sid);

      ResultSet executeQuery = prepareStatement.executeQuery();
      while (executeQuery.next()) {
        arrayList.add(new Registration(executeQuery.getInt("rid"), executeQuery.getInt("sid"), executeQuery.getInt("cid"), executeQuery.getInt("score")));
      }
      return arrayList;
    } catch (SQLException ex) {
      Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

}
