<%-- 
    Document   : ListOrder
    Created on : 5 Jul, 2014, 11:45:08 PM
    Author     : R.B.Shah
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Order</title>
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
            <li><a href='Customer?action=editCustomer&id=<%=session.getAttribute("username")%>'>Edit Profile</a></li>
            <li><a href="BookOrder?action=bkodr&id=<%=session.getAttribute("username")%>">Order booking</a></li>
            <li><a href="BookOrder?action=lstodr&id=<%=session.getAttribute("username")%>">Orders</a></li>
            <li><a href="Customer?action=menus">Menus</a></li>
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
        <h1 class="addlink">List Orders</h1>
        <br/>
        <br/>
            </div>
        <div style="margin-left: 15%;">
         <table border=1 align="center" class="grid">
        <thead style="color: black;">
            <tr>
                <th>Order Id</th>
                <th>Number of Person</th>
                <th>Picnic Date</th>
                <th>Picnic Place</th>
                <th>Total Amount</th>
                
            </tr>
        </thead>
        <tbody style="color: black;">
            <c:forEach items="${ListOrder}" var="ListOdr">
                <tr>
                   <td><c:out value="${ListOdr.orderId}" /></td>
                   <td><c:out value="${ListOdr.numOfPerson}" /></td>
                   <td><c:out value="${ListOdr.picnicDate}" /></td>
                   <td><c:out value="${ListOdr.picnicPlace}" /></td>
                   <td><c:out value="${ListOdr.totalAmount}" /></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
    </body>
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
</html>
