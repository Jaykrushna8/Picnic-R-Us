<%-- 
    Document   : Items
    Created on : Jul 3, 2014, 12:18:56 AM
    Author     : Pushpraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.pru.model.ManuItemModel" %>
<%@page import="com.pru.dal.ManuItemDAO" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Menu Items</title>
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
        <form method="Get" action="Customer">
        <h1 style="color:black">Menu Item(Dish)</h1>
        <br/>
        <br/>
        <div> <p class="addlink" ><a href="Customer?action=menus" style="color:green">Back</a></p></div>
        <div>
        <table border=1 align="center" class="grid">
        <thead style="color: black;">
            <tr>
                <th>Id</th>
                <th>Item Name</th>
                <th>Item Type</th>
                <th>Description</th>
                <th>Per Head Cost</th>
                
            </tr>
        </thead>
        <tbody style="color: black;">
            <c:forEach items="${MenuItems}" var="MenuItem">
                <tr>
                    <td><c:out value="${MenuItem.id}" /></td>
                     <td><c:out value="${MenuItem.name}" /></td>
                     <td><c:out value="${MenuItem.menuItemType}"/></td>
                    <td><c:out value="${MenuItem.description}" /></td>
                    <td><c:out value="${MenuItem.perHeadCost}" /></td>
                   
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
              

        </div>
        </form>
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