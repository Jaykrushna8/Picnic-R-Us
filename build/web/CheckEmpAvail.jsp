<%-- 
    Document   : CheckEmpAvail
    Created on : 29 Jun, 2014, 11:25:04 PM
    Author     : R.B.Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - Check Employee Availability</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
        <link href="css/fullcalendar.css" rel="stylesheet" type="text/css"/>
<link href="css/fullcalendar.print.css" rel="stylesheet" type="text/css"/>
        <script src="js/moment.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/fullcalendar.js" type="text/javascript"></script>
        <script src="js/fullcalendar.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui.custom.min.js" type="text/javascript"></script>
        <script src="js/cufon-yui.js" type="text/javascript"></script>
        <script src="js/cufon-replace.js" type="text/javascript"></script>
        <script src="js/Dynalight_400.font.js" type="text/javascript"></script>
        <script src="js/FF-cash.js" type="text/javascript"></script>
        <script src="js/tms-0.3.js" type="text/javascript"></script>
        <script src="js/tms_presets.js" type="text/javascript"></script>
        <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
        <script src="js/jquery.equalheights.js" type="text/javascript"></script>
        <script>
            $(document).ready(function() {
        $('#calendar').fullCalendar({
            theme: true,
            editable: true,
                events: [
                                    {
                                            title: '5',
                                            start: '2014-07-06',
                                            end: '2014-07-06'
                                    },
                                    {   
                                            title: '3',
                                            start: '2014-07-07',
                                            end: '2014-07-07'
                                    },
                                    {
                                            title: '0',
                                            start: '2014-07-08',
                                            end: '2014-07-08'
                                    },
                                    {
                                            title: '1',
                                            start: '2014-07-09',
                                            end: '2014-07-09'
                                    },
                                    {
                                            title: '9',
                                            start: '2014-07-10',
                                            end: '2014-07-10'
                                    },
                                    {
                                            title: '3',
                                            start: '2014-07-11',
                                            end: '2014-07-11'
                                    },
                                    {
                                            title: '7',
                                            start: '2014-07-12',
                                            end: '2014-07-12'
                                    },
                                    {
                                           title: '6',
                                            start: '2014-07-13',
                                            end: '2014-07-13'
                                    }
                            ]
            //events: "CalendarData"
        });
    });
        </script>
        <style>

	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		width: 900px;
		margin: 40px auto;
	}

</style>

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
       <div class="row-bot" style="height: auto">
    <div class="row-bot-bg">
        <div id="calendar"></div></div></div>
       
    </body>
</html>
