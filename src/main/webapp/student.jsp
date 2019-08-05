<html>
  <body>
    
    <h1>Student Management</h1> 
   
    <h2>Hello,  <%=session.getAttribute("id") %>  </h2>
     Please select below <br>
    <a href="/student/select_course">select course</a>
    <a href="/student/view_course">view course</a>
    <a href="/student/delete_course">delete course</a>
      
  </body>
</html>