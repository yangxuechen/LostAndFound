<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script src="js/jquery-3.3.1.min.js"></script>
	<link href="css/myUIstyle.css" rel="stylesheet" />
	<link href="css/user/index.css" rel="stylesheet">
    <script src="js/base.js"></script>
</head>
<body>
<!--  
<div class="top">
         <div class="dropdown" style="float: right">
             <button class="dropbtn">${sessionScope.user.getUserName()}</button>
             <div class="dropdown-content">
                 <a href="userLogout.action">退出</a>
             </div>

         </div>
     </div> -->
<ul>	
    <li id="click_1"><a href="#">主页</a></li>
    <div class="funBackgroungColor">
        <li id="fun1" class="hidden"><a href="toIndexPage.action">动态</a></li>
       <!--  <li id="fun2" ><a href="#">功能2</a></li> -->
    </div>
    <li id="click_2"><a href="#">信息</a></li>
    <div class="funBackgroungColor">
        <li id="fun3" class="hidden"><a href="toUserMsgPage.action">我的信息</a></li>
       <!--  <li id="fun4" class="hidden"><a href="#">功能4</a></li> -->
    </div>
    <li id="click_3"><a href="#">发布</a></li>
    <div class="funBackgroungColor">
        <li id="fun5" ><a href="toSendPage.action">发布信息</a></li>
        <li id="fun6" style="background-color: #4CAF50"><a href="#">我的发布</a></li>
    </div>
    <li id="click_4"><a href="#">帮助</a></li>
    <div class="funBackgroungColor">
        <li id="fun7" class="hidden"><a href="userLogout.action">退出</a></li>
      <!--    <li id="fun8" class="hidden"><a href="#">功能8</a></li> -->
    </div>
</ul>

<div style="margin-left:18%;padding:1px 16px;">
   <div class="container">
      <c:forEach var="post" items="${postList}">
        <div>
           <img class="avatar" alt="头像" src="images/myLove.jpg">
           <label><c:out value="${post.getUser().getUserName()}" /></label><br>
       </div>
     
         <div class="content">  
             <a href="#"><c:out value="${post.getMessageDescription()}" /></a>
         </div>
         <div>
           <img class="content-img" alt="img-content" src="${ post.getMessagePhoto()}">
         </div>
         <div >
           <a href="toCommentPage.action?messageId=${post.getMessageId()}"><img class="comment-img" alt="comment" src="images/comment.png"></a> 
          
         </div>
         <div class="date">
             <c:out value="${post.getMessageDate()}" /><br>
         </div>
         <div class="div"></div>
      </c:forEach>
   </div>

 <button class="btn">More</button>
</div>
 
</body>
</html>