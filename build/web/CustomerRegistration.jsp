<%-- 
    Document   : CustomerRegistration
    Created on : Jun 25, 2014, 12:39:06 AM
    Author     : Dpm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - New Registration</title>
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
         <form method="Get" name="form1" action="/Login">
            <div class="row-top">
    <div class="main">
      <div class="wrapper">
        <h1><a href="#">PRU<span>.com</span></a></h1>
        <nav>
          <ul class="menu">
              <li><a href="Login?action=Login">Login</a></li>
            <li><a href="Customer?action=addCustomer">Registration</a></li>
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
       <form method="post" action="Customer">
        
        <div style="margin-left: 15%;">
        <table cellspacing="10" cellpadding="10" style="color: black;" class="form">
            <thead>
                <tr>
                    <th colspan="3">CUSTOMER REGISTRATION</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Customer Name</td>
                    <td>:</td>
                    <td>
                        <input placeholder="first name" type="text" name="firstName" value="${customer.firstName}" style="width: 150px;" />&nbsp;
                        <input placeholder="middle name" type="text" name="middleName" value="${customer.middleName}" style="width: 150px;"/>&nbsp;
                        <input placeholder="last name" type="text" name="lastName" value="${customer.lastName}" style="width: 150px;"/>
                    <input type="hidden" name="id" value="${customer.id}" style="width: 150px;" />&nbsp;</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>:</td>
                    <td><input placeholder="address line1" type="text" name="addressLine1" value="${customer.addressLine1}" style="width: 150px;" />&nbsp;
                        <input placeholder="address line2" type="text" name="addressLine2" value="${customer.addressLine2}" style="width: 150px;"/>&nbsp;
                        <input placeholder="address line3" type="text" name="addressLine3" value="${customer.addressLine3}" style="width: 150px;"/>&nbsp;
                        <input placeholder="address line4" type="text" name="addressLine4" value="${customer.addressLine4}" style="width: 150px;"/></td>
                </tr>
                <tr>
                    <td>Mobile No.</td>
                    <td>:</td>
                    <td><input  placeholder="mobile number" type="text" maxlength="10" name="mobileNumber" value="${customer.mobileNumber}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Email ID</td>
                    <td>:</td>
                    <td><input placeholder="email address" type="email" name="emailId" value="${customer.emailId}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><input placeholder="password" type="password" name="password" value="${customer.password}" style="width: 150px;" /></td>
                
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
