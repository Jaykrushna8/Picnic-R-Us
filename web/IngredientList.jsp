<%-- 
    Document   : IngredientList
    Created on : Jun 25, 2014, 10:45:27 PM
    Author     : Dpm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Ingredients</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script src="js/cufon-yui.js" type="text/javascript"></script>
        <script src="js/cufon-replace.js" type="text/javascript"></script>
        <script src="js/Dynalight_400.font.js" type="text/javascript"></script>
        <script src="js/FF-cash.js" type="text/javascript"></script>
        <script src="js/tms-0.3.js" type="text/javascript"></script>
        <script src="js/tms_presets.js" type="text/javascript"></script>
        <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
        <script src="js/jquery.equalheights.js" type="text/javascript"></script>
    </head>
    <body id="page1">
         <form method="Get" name="form1" action="Home">
            <div class="row-top">
    <div class="main">
      <div class="wrapper">
        <h1><a href="#">PRU<span>.com</span></a></h1>
        <nav>
          <ul class="menu">
              <li><a href="Home?action=listEmployee">Employee List</a></li>
            <li><a href="EmployeeAvailability?action=EmpCal">Employee Availability</a></li>
            <li><a href="AdminOrderProcessing?action=newOrders">New Orders</a></li>
            <li><a href="AdminOrderProcessing?action=approvedOrders">Make Payment(Orders)</a></li>
            <li><a href="Home?action=masters">Masters</a></li>
            <li><a href="Home?action=Logout">Logout</a></li>
          </ul>
        </nav> 
      </div>
    </div>
            </div>
              </form>
        <div class="row-bot">
    <div class="row-bot-bg">
      <div class="main">
        <h2>Impressive Selection <span>for any Picnic</span></h2>
        <div class="new">    
           <div class="slider">
            <div style="margin-left: 15%;">
        <h1>Ingredients</h1>
        <br/>
        <br/>
            <p class="addlink"><a href="Ingredient.jsp?id=0">Add Ingredient</a></p>
            </div>
               <div style="margin-left:15%">
         <table border="1" align="center" class="grid">
        <thead style="color: black;">
            <tr>
                <th>Id</th>
<!--                <th>Employee Id</th>-->
                <th>Ingredient Name</th>
                <th>Description</th>
                <th>Per Unit Price</th>
                <th>Unit Of Measure</th>
<!--                <th>Type</th>-->
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody style="color: black;">
            <c:forEach items="${Ingredients}" var="ingredient">
                <tr>
                    <td><c:out value="${ingredient.id}" /></td>
                     <td><c:out value="${ingredient.name}" /></td>
                    <td><c:out value="${ingredient.description}" /></td>
                    <td><c:out value="${ingredient.perUnitPrice}" /></td>
                   <td><c:out value="${ingredient.unitOfMeasureId}" /></td>
                    <%--<td><c:out value="${employee.emailId}" /></td>
                    <td><c:out value="${employee.employeeType}" /></td>--%>
                    <td><a href="Ingredient?action=edit&id=${ingredient.id}" style="color:black;">Update</a></td>
                    <td><a href="Ingredient?action=delete&id=${ingredient.id}" style="color:black;">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
              

        </div>
          </div>
          </div>
             </div>
      </div>
    </div>
  </div>
        <footer>
  <div class="main">
    
  </div>
</footer>
<script type="text/javascript">Cufon.now();</script>
<script type="text/javascript">
$(window).load(function () {
    $('.slider')._TMS({
        duration: 1000,
        easing: 'easeOutQuint',
        preset: 'slideDown',
        slideshow: 7000,
        banners: false,
        pauseOnHover: true,
        pagination: true,
        pagNums: false
    });
});
</script>
    </body>
</html>

