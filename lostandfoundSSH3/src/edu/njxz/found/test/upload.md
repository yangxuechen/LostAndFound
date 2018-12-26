### SSH框架之上传图片到项目文件夹下并在前端显示  
1.前端jsp页面上传代码   
```jsp
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
``` 