<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body id="bootstrap-overrides">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carousel </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  
.container { 
  margin-top:100px;
  
  position: relative;
  /* border: 3px solid green;  */
}

 /* .center {
  margin: 100px;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}  */

  /* Make the image fully responsive */
  .carousel-inner img {
  	width: 100%;
    height: 50%;
  }
  .images {
  	width:20%;
  	height:20%;
  }
  </style>
</head>
<body>
<div class="container">
	<div class="center">
<div id="demo" class="carousel slide" data-ride="carousel" >
	<div class="slide">
  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img  src="img/handbag1.jpg" alt="Los Angeles"style="width:100%;">
    </div>
    <div class="carousel-item">
      <img src="img/handbag2.jpg" alt="Chicago"style="width:100%;">
    </div>
    <div class="carousel-item">
      <img src="img/handbag3.jpg" alt="New York"style="width:100%;">
    </div>
  </div>
  </div>
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
</div>
</div>

</body>
</html>