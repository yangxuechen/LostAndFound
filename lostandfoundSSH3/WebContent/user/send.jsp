<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布信息</title>
<script src="js/jquery-3.3.1.min.js"></script>
	<link href="css/myUIstyle.css" rel="stylesheet" />
    <script src="js/base.js"></script>
</head>
<body>
<div class="top">
         <div class="dropdown" style="float: right">
             <button class="dropbtn">${sessionScope.user.getUserName()}</button>
             <div class="dropdown-content">
                 <a href="userLogout.action">退出</a>
             </div>

         </div>
     </div>
<ul>
    <li id="click_1"><a href="#">主页</a></li>
    <div class="funBackgroungColor">
        <li id="fun1" class="hidden"><a href="toIndexPage.action">动态</a></li>
       <!--   <li id="fun2" class="hidden"><a href="#">功能2</a></li> -->
    </div>
    <li id="click_2"><a href="#">信息</a></li>
    <div class="funBackgroungColor">
        <li id="fun3" class="hidden"><a href="toUserMsgPage.action">我的信息</a></li>
       <!--  <li id="fun4" class="hidden"><a href="#">功能4</a></li> -->
    </div>
    <li id="click_3"><a href="#">发布</a></li>
    <div class="funBackgroungColor">
        <li id="fun5" style="background-color: #4CAF50"><a href="#">发布信息</a></li>
        <li id="fun6" ><a href="toMySend.action">我的发布</a></li>
    </div>
    <li id="click_4"><a href="#">帮助</a></li>
    <div class="funBackgroungColor">
        <li id="fun7" class="hidden"><a href="userLogout.action">退出</a></li>
      <!--    <li id="fun8" class="hidden"><a href="#">功能8</a></li> -->
    </div>
</ul>

<div style="margin-left:18%;padding:1px 16px;">
    <h2>发布</h2>
   <form action="sendMessage.action"  method="post" enctype="multipart/form-data">
   <label>类别</label>
      <select name="category">
        <option value="1">书籍</option>
        <option value="2">服饰</option>
        <option value="3">证件</option>
        <option value="4">其他</option>
      </select><br>
      <label>描述</label>
      <input type="text" name="content"><br>
      <label>图片</label>
      <input type="file" name="upload"><br>
      <input type="submit" value="发布">
   </form>
</div>

</body>
</html>