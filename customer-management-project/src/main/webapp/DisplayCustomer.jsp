<%@page import="com.jsp.customer_management_project.Dto.Customerdto"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.customer_management_project.Service.customerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<Style>
    body {
        padding: 0;
        margin: 0;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        background: url("Image.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
    table {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        /* border-collapse: collapse; */
        width: 800px;
        height: 200px;
        border: 2px solid #bdc3c7;
        border-radius: 10px;
        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2),-1px -1px 8px rgba(0, 0, 0, 0.2);
       
    }
    tr {
        transition: all .2 ease-in;
        cursor: pointer;
    }
    th,td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    #header {
        /* background-color: rgba(0, 0, 0, 0.2);  */
         color: #3a40e6;
    }
    h1 {
        font-weight: 600;
        text-align: center;
        /* background-color: #16a085; */
        color: #fff;
        padding: 10px 0px;
    }
    tr:hover {
        /* background-color: #f5f5f5; */
        background-color: rgba(0, 0, 0, 0.2); 
        transform: scale(1.0);
        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2),-1px -1px 8px rgba(0, 0, 0, 0.2);
    }

    /* media query */
    @media only screen and (max-width: 768px) {
        table {
            width: 90%;
        }
    }
</Style>
<body>
 <%
       customerService service2 = new customerService();
       List<Customerdto> customerdtos = service2.displayCustomer();
       %>
       <h1>Customer Table</h1>
         <table border='2'>
      <tr id="header"> 
      <th>CustomerId</th>
      <th>CustomerName</th>
      <th>CustomerEmail</th>
      <th>CustomerPhone</th>
      <th>ProductId</th>
      <th>Delete</th>
      <th>Update</th>
      </tr>
      <% for(Customerdto customerdto:customerdtos) { %>
      <tr> 
      <td><%=customerdto.getCustomerId() %></td>
      <td><%=customerdto.getCustomerName() %></td>
     <td><%=customerdto.getCustomerEamil() %></td>
      <td><%=customerdto.getPhone()%></td>
       <td><%=customerdto.getProduct().getProductId() %></td>
      <td><a href="DeleteCustomer?customerId=<%=customerdto.getCustomerId()%>"><button>Delete</button></a></td>
      <td><a href="updateCustomer?customerId=<%= customerdto.getCustomerId()%>"><button>Update</button></a></td>

      </tr>
      <%} %>
   </table>
   <a href="CustomerLogin.jsp"><button>Back</button></a>
</body>
</html>