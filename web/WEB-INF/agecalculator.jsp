<%-- 
    Document   : agecalculator
    Created on : 25-Sep-2022, 3:43:00 AM
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            Enter your age: <input type="text" name="age"><br>
            <input type="submit" value="Age next birthday">
        </form>
        <p>${error}</p>
        <p>${valid}</p>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
