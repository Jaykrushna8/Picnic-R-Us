<%-- 
    Document   : Login
    Created on : Jun 19, 2014, 11:39:33 PM
    Author     : Pushpraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Login</title>
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
<form method="Post" action="Login">
     <div class="row-bot">
    <div class="row-bot-bg">
      <div class="main">
        <h2>Impressive Selection <span>for any Picnic</span></h2>
        <div class="new">    
           <div class="slider">
            <div style="margin-left: 35%;">
        <table border="0" cellpadding="10" cellspacing="10" class="form">
            <thead>
                <tr>
                    <th colspan="3" style="color: black;">LOGIN</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="color: black;vertical-align: middle;font-weight: bold;">Username</td>
                    <td>:</td>
                    <td><input type="text" name="username" value="" size="80" style="width: 200px;" /></td>
                </tr>
                <tr>
                    <td style="color: black;vertical-align: middle;font-weight: bold;">Password</td>
                    <td>:</td>
                    <td><input type="password" name="password" value="" size="80" style="width: 200px;" /></td>
                
                </tr>
                <tr>
                
                    <td></td>
                    <td></td>   
                    <td><input type="submit" value="Login" name="action" /></td>
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
