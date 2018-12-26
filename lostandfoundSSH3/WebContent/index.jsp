<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
  <meta charset="UTF-8">
  <title>登陆</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="page">
  <div class="container">
    <div class="left">
      <div class="login">Login</div>
      <div class="eula"><a href="register.jsp">注册</a></div>
    </div>
    <div class="right">
      <svg viewBox="0 0 320 300">
        <defs>
          <linearGradient
                          inkscape:collect="always"
                          id="linearGradient"
                          x1="13"
                          y1="193.49992"
                          x2="307"
                          y2="193.49992"
                          gradientUnits="userSpaceOnUse">
            <stop
                  style="stop-color:#ff00ff;"
                  offset="0"
                  id="stop876" />
            <stop
                  style="stop-color:#ff0000;"
                  offset="1"
                  id="stop878" />
          </linearGradient>
        </defs>
        <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
      </svg>
      <div class="form">
      <form action="userLogin.action" method="post">
         <label for="userName">UserName</label>
        <input type="text" id="userName" name="userName">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <input type="submit" id="submit" value="Log In">
      </form>
       
      </div>
    </div>
  </div>
</div>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js'></script>

  

    <script  src="js/index.js"></script>




</body>
</html>
