

<html>
  <body>
    Hello, <%=session.getAttribute("id")%>
    <form action='/teacher/view_student' method="POST">
       CourseID: <input type ='number' name='cid'><br> 
      <input type="submit">
      <input type='reset'>
    </form>
  </body>
</html>