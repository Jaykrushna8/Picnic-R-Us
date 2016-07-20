<%-- 
    Document   : EmployeeAvailability
    Created on : Jun 22, 2014, 9:29:39 PM
    Author     : Dpm
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Employee Availibility</title>
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
              <li><a href="Home?action=avblEmployee">Post Availability</a></li>
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
             <p ><a href="Home?action=homeEmployee" style="color: black;">Back</a></p>
        </div>
            <div style="margin-left: 35%;">
<form action="EmployeeAvailability" method="post">
  
    <h1 style="color: black;">EMPLOYEE AVAILABILITY</h1>
    <br>
        <table border="0" cellspacing="10" cellpadding="10" style="color: black;" class="form">
            <thead>
                <tr style="text-align: center">
                    <th colspan="3"></th>
                </tr>
            </thead>
            <br />
            
            <tbody>
                <tr>
                    <td>Employee ID</td>
                    <td>:&nbsp;</td>
                    <td><label id="empId"><%= session.getAttribute("username")%></label>
                        <input type="hidden" name="employeeId" value=<%= session.getAttribute("username")%> /> 
                    </td>
                    
                </tr>
                <tr>
                    <td>Month</td>
                    <td>:&nbsp;</td>
                    <td><select name="month">
                            <option>January</option>
                            <option>February</option>
                            <option>March</option>
                            <option>April</option>
                            <option>May</option>
                            <option>June</option>
                            <option>July</option>
                            <option>August</option>
                            <option>September</option>
                            <option>October</option>
                            <option>November</option>
                            <option>December</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Date From</td>
                    <td>:&nbsp;</td>
                    <td><input name="dateFrom" type="date" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Date To</td>
                    <td>:&nbsp;</td>
                    <td><input name="dateTo" type="date" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Other Comments</td>
                    <td>:&nbsp;</td>
                    <td><input type="text" name="otherComment" value="" style="width: 300px;" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Submit" name="btnsubmit" />&nbsp;<input type="reset" value="Reset" name="btnreset" /></td>
                </tr>
            </tbody>
        </table>

   
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
