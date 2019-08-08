

<html>
  <body>
    Hello, <%=session.getAttribute("id")%>
    <form action='/teacher/add_course' method="POST">
       CourseID: <input type ='number' name='cid'><br> 
       CourseName: <input type ='text' name='cname'><br> 
      <input type="submit">
      <input type='reset'>
    </form>
  </body>
</html>