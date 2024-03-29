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
package ga.rugal.servlet.entity;

/**
 *
 * @author sally
 */
public class Student {

  public final int sid;
  public final String name;
  public final String telephone;

  public Student(int sid, String name, String telephone) {
    this.sid = sid;
    this.name = name;
    this.telephone = telephone;

  }

}
