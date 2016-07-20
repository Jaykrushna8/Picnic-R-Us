<%-- 
    Document   : AddOrder
    Created on : 3 Jul, 2014, 11:25:02 PM
    Author     : R.B.Shah
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Book Order</title>
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
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            function bindselmenu() {
    
    var checked_vals = [];
    $('#chkmenu input:checkbox:checked').each(function(index) {
        var ss ="menumembers_" + $(this).val(); 
        debugger;
       var ss2 = document.getElementById(ss).value;
        checked_vals.push($(this).val() + "_" + ss2);
    });
    if(checked_vals != "")
    {
        $('#selectedmenu').val(checked_vals);
        return true;
                }
                else
                {
                    alert("Select atleast one menu.");
                    return false;
                }
            }
        </script>
        
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
       <form method="post" action="BookOrder">
       
        <div style="margin-left: 15%;">
        <table cellspacing="10" cellpadding="10" style="color: black;" class="form">
            <thead>
                <tr>
                    <th colspan="3">Order Booking</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Date</td>
                    <td>:</td>
                    <td><input type="date" name="picdate" value="" style="width: 150px;" placeholder="picnic date"/>
                    <input type="hidden" name="CustId" value="${CustId}" style="width: 150px;" /></td>
                </tr>
                <tr>
                    <td>Venue</td>
                    <td>:</td>
                    <td><input type="text" name="picvenue" value="" style="width: 150px;" placeholder="pinic place"/>
                     </td>
                </tr>
                <tr>
                    <td>Number of persons</td>
                    <td>:</td>
                    <td><input type="number" name="picmembers" value="" style="width: 150px;" placeholder="number of persons"/>
                     </td>
                </tr>
                
             <tr>
                 <td style="vertical-align: top;">Select Items</td>
                    <td style="vertical-align: top;">:</td>
                    <td>
                        <table id="chkmenu">
                            
                        <c:forEach items="${MenuList}" var="MenuLst">
                            <tr>
                                <td>
                                <input type="checkbox" name="${MenuLst.name}" value="${MenuLst.id}">${MenuLst.name}
                                </td>
                                <td>&nbsp;</td>
                                <td>
                                    <input placeholder="Enter No. of Dishes" type="number" id="menumembers_${MenuLst.id}" name="menumembers_${MenuLst.id}" value="" style="width: 150px;" />
                                    
                                </td>
                            </tr>
                            </c:forEach>
                            <input type="hidden" id="selectedmenu" name="selectedmenu" value="" style="width: 150px;" />
                        </table>  
                    </td>
</tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Submit" name="btnsubmit" onclick="return bindselmenu();"/>&nbsp;<input type="reset" value="Reset" name="btnreset" /></td>
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
