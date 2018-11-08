### 失物招领需求文档

-**角色**  
1.管理员  
2.用户（微信接口登陆）    

-**功能**  
一.用户功能  
1.用户捡到物品，将信息发布。  
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.物品名称</font>   
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.图片</font>   
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.拾到物品的地点</font>  
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.将物品放置地点</font>   
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.日期</font>   
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;.发布者</font>  

2.用户管理自己发布的信息（删除，修改）  
3.用户浏览失物招领信息  
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;a.(根据物品种类分类浏览)  </font>  
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;b.(根据日期浏览) </font>  
<font size=2>&nbsp;&nbsp;&nbsp;&nbsp;c.(关键字检索浏览)   </font>  

4.用户的评论功能（考虑）  
  
二.管理员功能  
1.用户管理  
2.物品分类管理  

**前台实现**  
1.微信小程序（与java后台进行数据交互)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[微信小程序开发资源](https://github.com/justjavac/awesome-wechat-weapp)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可能用到的框架：Taro（多端统一开发框架，支持用 React 的开发方式编写一次代码，生成能运行在微信小程序、H5、React Native 等的应用）[链接](https://github.com/NervJS/taro)      
2.移动端网页  



**后台实现**  
java(springboot+mybatis+mysql)  

**前期准备**  
1.服务器+域名  
2.微信开发者工具  

**用例图**  
![userCaseDiagram](https://github.com/yangxuechen/LostAndFound/blob/master/requirementsDocument/images/usecasediagram.png)  

**E-R图**  
![E-R图](https://github.com/yangxuechen/LostAndFound/blob/master/requirementsDocument/images/ER_LostAndFound.png)

**web端原型图**  
![index](https://github.com/yangxuechen/LostAndFound/blob/master/requirementsDocument/images/userIndex.html.png)  
![releaseNews](https://github.com/yangxuechen/LostAndFound/blob/master/requirementsDocument/images/releaseNews.html.png)






