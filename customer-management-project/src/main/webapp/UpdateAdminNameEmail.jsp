<%@page import="com.jsp.customer_management_project.Dto.Admindto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins',sans-serif;
}
body {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: url("Image.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
}
header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    padding: 20px 100px;
    /* background-color: red; */
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 99;
}
.logo {
    font-size: 2em;
    color: #fff;
    user-select: none;
} 
.navigation a {
    position: relative;
    font-size: 1.1em;
    color: #fff;
    text-decoration: none;
    font-weight: 500;
    margin-left: 40px;
}
.navigation a::after {
    content: '';
    position: absolute;
    left: 0px;
    bottom: -6px;
    width: 100%;
    height: 3px;
    background: #fff;
    border-radius: 5px;
    transform-origin: right;
    transform: scaleX(0);
    transition: transfrom .5s;
}
.navigation a:hover:after {
  transform: scaleX(1);
  transform-origin: left;
}
.navigation .btnlogin-popup {
    width: 130px;
    height: 50px;
    background: transparent;
    border: 2px solid #fff;
    outline: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1.1rem;
    color: #fff;
    font-weight: 500;
    margin-left: 40px;
    transition: .5s;
} 
.navigation .btnlogin-popup:hover {
    background: #fff;
    color: #162938;
} 
.wrapper {
    position: relative;
    width: 400px;
    height: 440px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .5);
    border-radius: 20px;
    backdrop-filter: blur(20px);
    box-shadow: 0 0 30px rgba(0, 0, 0, .5);
    display: flex;
    justify-content: center;
    align-items: center;
}
.wrapper .form-box {
    width: 100%;
    padding: 40px; 
}
.form-box h2
{
    font-size: 2em;
    color: #162938;
    align-items: center;
}
.input-box {
    position: relative;
    width: 100%;
    height: 50px;
    border-bottom: 2px solid #162938;
    margin: 30px 0;
}
.input-box label {
    position: absolute;
    top: 50%;
    left: 5px;
    transform: translateY(-50%);
    font-size: 1em;
    color: #162938;
    font-weight: 500;
    pointer-events: none;
    transition: 0.5s;
}
.input-box input:focus~label,
.input-box input:valid~label {
    top: -5px;
}

.input-box input {
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    font-size: 1em;
    color: #162938;
    font-weight: 600;
}
.btn {
    width: 100%;
    height: 45px;
    background-color: #162938;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1em;
    color: #fff;
    font-weight: 500;
}
 </style>
</head>

<body>
<%  Admindto admindto = (Admindto) request.getAttribute("oneproduct"); %>
    <header>
        <h2 class="logo">Customer-Management</h2>
        <nav class="navigation">
            <a href="AdminLogin.jsp">Home</a>
            <a href="#">Add-Admin</a>
            <a href="DisplayAdmin.jsp">Display</a>
            <a href="#">Contact</a>
            <button class="btnlogin-popup"></button>
        </nav>
    </header>
    <div class="wrapper">
        <div class="form-box login">
            <h2>NewAdminInsert</h2>
          <form action="UpdateAdminName" method="post">
                <div class="input-box">
                   
		 <input type="number" name="adminId" placeholder="Enter the adminId" value="<%= admindto.getAdminId() %>"><br>
                   <label>AdminId</label>
                </div>
                <div class="input-box">
                    <span class="icon"></span>
                <input type="text" name="adminName" placeholder="Enter the Admin name"  value="<%= admindto.getAdminName() %>"><br>
                    <label>AdminName</label>
                </div>
                <div class="input-box">
                    <span class="icon"></span>
                <input type="email" name="adminEmail" placeholder="Enter the Admin Email" value="<%= admindto.getAdminEmail()%>"><br>
                    <label>AdminEmail</label>
                </div>
                <button type="submit" class="btn">Update</button>
            </form>
        </div>
    </div>

</body>
</html>