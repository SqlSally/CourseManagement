<%-- 
    Document   : studentDeleteCourse
    Created on : 2019年8月7日, 下午1:46:25
    Author     : sally
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter the courseID you would like to delete </title>
  <form action='/student/delete_course' method="POST">
    CourseID: <input type ='number' name='cid'><br> 
    <input type="submit">
    <input type='reset'>
  </form>
  
</body>
</html>
