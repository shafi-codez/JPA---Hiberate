<%-- 
    Document   : displayAll
    Created on : Oct 13, 2012, 11:10:34 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>US census population data 2010-11</h1>
        <table id="table-design">
            <%  ArrayList<String> rowValArr = (ArrayList<String>) session.getAttribute("rowObj"); %>
            <thead>
             <%  for(String S1 : rowValArr){ %>
             <tr> <%
                    String[] rowValArr1 = S1.split(","); 
                    for(String S2 : rowValArr1 ){ 
                      %><th><%
                      out.print(S2);
                      %></th><%
                    }
                    %></tr><%
                }
            %>          
        </thead>
        </table>
    </body>
</html>
