<%-- 
    Document   : AddUpdateEmployee
    Created on : Jun 22, 2014, 1:12:37 AM
    Author     : Pushpraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Add New Employee</title>
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
        <form method="post" action="Employee">
            <div> <p align="right" ><a href="Employee?action=listEmployee" style="color:black">back</a></p></div>
       
        <table border="0" cellspacing="10" cellpadding="10" style="color: black;" class="form">
            <thead>
                <tr>
                    <th colspan="3">EMPLOYEE REGISTRATION</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Employee Name</td>
                    <td>:</td>
                    <td>
                        
                        <input placeholder="first name" type="text" name="firstName" value="${employee.firstName}" style="width: 150px;" />&nbsp;
                        <input placeholder="middle name" type="text" name="middleName" value="${employee.middleName}" style="width: 150px;"/>&nbsp;
                        <input placeholder="last name" type="text" name="lastName" value="${employee.lastName}" style="width: 150px;"/>
                    <input type="hidden" name="id" value="${employee.id}" style="width: 150px;" />&nbsp;</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>:</td>
                    <td><input placeholder="address line1" type="text" name="addressLine1" value="${employee.addressLine1}" style="width: 150px;" />&nbsp;
                        <input placeholder="address line2" type="text" name="addressLine2" value="${employee.addressLine2}" style="width: 150px;"/>&nbsp;
                        <input placeholder="address line3" type="text" name="addressLine3" value="${employee.addressLine3}" style="width: 150px;"/>&nbsp;
                        <input placeholder="address line4" type="text" name="addressLine4" value="${employee.addressLine4}" style="width: 150px;"/></td>
                </tr>
                <tr>
                    <td>Mobile No.</td>
                    <td>:</td>
                    <td><input placeholder="mobile no" type="text" maxlength="10" name="mobileNumber" value="${employee.mobileNumber}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Email ID</td>
                    <td>:</td>
                    <td><input placeholder="email address" type="email" name="emailId" value="${employee.emailId}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><input placeholder="password" type="password" name="password" value="${employee.password}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Employee Type</td>
                    <td>:</td>
                    <td><select name="employeeType">
                            <option value="Part Time" ${employee.employeeType == "Part Time" ? 'selected' : ''}>Part Time</option>
                            <option value="Full Time" ${employee.employeeType == "Full Time" ? 'selected' : ''}>Full Time</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Date of Birth</td>
                    <td>:</td>
                    <td><input placeholder="date of birth" type="date" name="dob" value="${employee.dob}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>:</td>
                    <td><input  placeholder="salary" type="number" name="salary" value="${employee.salary}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Submit" name="btnsubmit" />&nbsp;<input type="reset" value="Reset" name="btnreset" /></td>
                </tr>
            </tbody>
        </table>
        </div>
        </form>
                
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
