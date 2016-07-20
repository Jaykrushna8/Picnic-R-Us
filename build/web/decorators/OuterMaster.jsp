<%-- 
    Document   : OuterMaster
    Created on : Jun 18, 2014, 12:16:48 AM
    Author     : Dpm
--%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRU - <decorator:title/></title>
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

  <div class="row-top">
    <div class="main">
      <div class="wrapper">
        <h1><a href="index.html">PRU<span>.com</span></a></h1>
        <nav>
          <ul class="menu">
              <li><a href="Login.jsp">Login</a></li>
            <li><a href="#">Registration</a></li>
          </ul>
        </nav> 
      </div>
    </div>
  </div>
  <div class="row-bot">
    <div class="row-bot-bg">
      <div class="main">
        <h2>Impressive Selection <span>for any Picnic</span></h2>
        <div class="new">    
            <decorator:body />
         <%-- <div class="slider">
            <ul class="items">
              <li> <img src="images/slider-img1.jpg" alt="" /> </li>
              <li> <img src="images/slider-img2.jpg" alt="" /> </li>
              <li> <img src="images/slider-img3.jpg" alt="" /> </li>
            </ul>
          </div>--%>
        </div>
      </div>
    </div>
  </div>
</header>
<!--==============================content================================-->
<%-- <section id="content">
  <div class="main">
    <div class="wrapper img-indent-bot">
      <article class="col-1"> <a href="#"><img class="img-border" src="images/banner-1.jpg" alt=""></a> </article>
      <article class="col-1"> <a href="#"><img class="img-border" src="images/banner-2.jpg" alt=""></a> </article>
      <article class="col-2"> <a href="#"><img class="img-border" src="images/banner-3.jpg" alt=""></a> </article>
    </div> 
    <div class="wrapper">
      <article class="column-1">
        <div class="indent-left">
          <div class="maxheight indent-bot">
            <h3>Our Services</h3>
            <ul class="list-1">
              <li><a href="#">Duis autem vel eum iriure dolor</a></li>
              <li><a href="#">Hendrerit in vulputate velit esse molestie </a></li>
              <li><a href="#">Consequat vel illum dolore</a></li>
              <li><a href="#">Feugiat nulla facilisis at vero eros</a></li>
              <li><a href="#">Accumsan et iusto odio dignissim qui</a></li>
              <li><a href="#">Blandit praesent luptatum azril</a></li>
              <li><a href="#">Delenit augue duis dolore te feugait</a></li>
            </ul>
          </div>
          <a class="button-1" href="#">Read More</a> </div>
      </article>
      <article class="column-2">
        <div class="maxheight indent-bot">
          <h3 class="p1">Content Here</h3>
          </div>
        <a class="button-2" href="#">Read More</a> </article>
    </div>
  </div>
</section> --%>
<!--==============================footer=================================-->
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
