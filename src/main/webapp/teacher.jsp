<html>
  <body>
    
    <h1>Student Management</h1> 
   
    <h2>Hello,  <%=session.getAttribute("id") %>  </h2>
     Please select below <br>
    <a href="/teacher/add_course">add new course</a>
    <a href="/teacher/view_student"> view student</a>
    <a href="/teacher/delete_course">delete course</a>
      
  </body>
</html>