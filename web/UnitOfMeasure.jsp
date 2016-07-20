<%-- 
    Document   : UnitOfMeasure
    Created on : Jun 25, 2014, 1:07:29 AM
    Author     : Dpm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Add Unit Of Measure</title>
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
        <form method="Post" action="UnitOfMeasure">
             <div class="row-bot">
    <div class="row-bot-bg">
      <div class="main">
        <h2>Impressive Selection <span>for any Picnic</span></h2>
        <div class="new">    
           <div class="slider">
            <div style="margin-left: 15%;"> <p class="addlink" ><a href="UnitOfMeasure?action=listUnitOfMeasure">Unit of measures List</a></p></div>
        <div style="margin-left: 35%;">
        
        <table cellspacing="10" cellpadding="10" style="color: black;" class="form">
            <thead>
                <tr>
                    <th colspan="3">UNIT OF MEASURE</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Unit Name</td>
                    <td>:</td>
                    <td><input type="hidden" name="id" value="${UnitOfMeasure.id}" style="width: 150px;" />&nbsp;<input type="text" name="name" value="${UnitOfMeasure.name}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>:</td>
                    <td><input type="text" name="description" value="${UnitOfMeasure.description}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Unit Icon</td>
                    <td>:</td>
                    <td><input type="text" maxlength="10" name="icon" value="${UnitOfMeasure.icon}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Submit" name="btnsubmit" />&nbsp;<input type="reset" value="Reset" name="btnreset" /></td>
                </tr>
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
        </form>
    </body>
</html>
