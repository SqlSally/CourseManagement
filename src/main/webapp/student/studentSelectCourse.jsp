
  
<html>
  <body>
    Hello, <%=session.getAttribute("id")%>
    <form action='/student/select_course' method="POST">
        CourseID: <input type ='number' name='cid'><br> 
        Score: <input type ='number' name='cid'><br>
      <input type="submit">
      <input type='reset'>
    </form>
 <body>
<html>