<%-- 
    Document   : analytics
    Created on : Oct 11, 2012, 1:11:59 AM
    Author     : Admin
--%>

<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>  
<%@page import="com.iit.mp2.Constants"%> 
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to US census population analytics page !</h1>
        <form action="ProcessServlet" method="post">
            <div class="styled-select">
            <table border="0" cellpadding="1">
                <thead>
                    <tr>
                        <th>
                            <select name="questioniare" >
                                <option><%= Constants.OPTION1%></option>
                                <option><%= Constants.OPTION2%></option>
                                <option><%= Constants.OPTION3%></option>
                                <option><%= Constants.OPTION4%></option>
                                <option><%= Constants.OPTION5%></option>
                                <option><%= Constants.OPTION6%></option>
                                <option><%= Constants.OPTION7%></option>
                            </select>
                        </th>
                        <th>
                        <% List regions = (List) session.getAttribute("regions");%>
                    <select name="regions" >
                        <option>ALL</option>
                        <c:forEach var="listItems" items="${regions}">  
                            <option><c:out value="${listItems}" />  </option>
                        </c:forEach> 

                    </select>
                
                </th>
                <th>
                    
                    <% List states = (List) session.getAttribute("states");%>
                    <select name="states" >
                        <option>ALL</option>
                        <c:forEach var="listItems" items="${states}">  
                            <option><c:out value="${listItems}" />  </option>
                        </c:forEach> 

                    </select>
                    
                </th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="Submit" value="Submit" class="button">
                            <input type="submit" name="DisplayALL" value="DisplayALL" class="button">
                            Result per year/region/state>>>
                        </td>
                        <td> 
                            <%
                                if (session.getAttribute("result") != null) {
                                    List disp_res = (List) session.getAttribute("result");
                                    for (Iterator i = disp_res.iterator(); i.hasNext();) {
                                        Object listElement = i.next();
                                        out.println(listElement.toString());
                                    }
                                    session.removeAttribute("result");
                                }
                            %>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            </div>


        </form>
    </body>
</html>
