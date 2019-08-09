<%@ page import="java.util.List" %> 
<%@ page import="ga.rugal.servlet.entity.Course" %> 

<html>
  <body>
    Hello, <%=session.getAttribute("id")%>
    your all courses:<br>
    <form action='/student/view_course' method="POST">

      <table style="width:100%">
        <tr>
          <th>Selection</th>
          <th>Course ID</th> 
          <th>Course Name</th>
        </tr>

        <% for (Course i : (List<Course>) request.getAttribute("findCourseBySid")) {%>
        <tr>
          <td><input type="checkbox" name = "selectedDeleteCourse" value="<%= i.cid%>"/>   </td>
          <td><%= i.cid%></td>
          <td><%= i.course%></td>
        </tr>
        <%  }%>

      </table>
      <input type="submit">
      <input type="reset">
      
    </form>
  </body>
</html>
