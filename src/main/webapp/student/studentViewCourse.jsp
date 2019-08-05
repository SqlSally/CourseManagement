<%@ page import="java.util.List" %> 
<%@ page import="ga.rugal.servlet.entity.Course" %> 

<html>
  <body>
    Hello, <%=session.getAttribute("id")%>
    your all courses:<br>
    <% for (Course i : (List<Course>) request.getAttribute("findCourseBySid")) {%>
    <%= i.cid%> 
    <%= i.course%><br>
    <%  }%>
  </body>
</html>
