###微信小程序项目之失物招领平台-5.我的主页页面编写  
1.先附上我的主页的效果图  
![wx_project_6](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_6.jpg)
2.userMsg.js文件  
```javascript
 // pages/userMsg/userMsg.js
 Page({
 
   /**
    * 页面的初始数据
    */
   data: {
     tabs1: [
       {
         text: '首页',
       },
       {
         text: '发布',
       },
       {
         text: '查询',
       },
       {
         text: '我的',
       },
     ],
   },
 
   handleChange(e) {
     const index = e.detail.value;
     console.log(e);
     console.log("value: " + e.detail.value);
     switch (index) {
       case 0:
         wx.redirectTo({
           url: '/pages/lostandfound/lostandfound',
         })
         break;
       case 1:
         wx.redirectTo({
           url: '/pages/send/send',
         })
         break;
       case 2:
         wx.redirectTo({
           url: '/pages/find/find',
         })
         break;
       case 3:
         // wx.navigateTo({
         //   url: '/pages/userMsg/userMsg',
         // })
         break;
     }
   },
   handleSelected() {
     this.setData({
       index: 2,
     });
   },
   handleClick(e) {
     const { index, title } = e.detail;
     console.log('点击了tab:' + index, title);
   },
 
 /**
  * 跳转到我的发布页面
  */
   toMySend(event){
 
      wx.navigateTo({
        url: 'mySend/mySend',
      })
   },
   /**
    * 生命周期函数--监听页面加载
    */
   onLoad: function (options) {
 
   },
 
   /**
    * 生命周期函数--监听页面初次渲染完成
    */
   onReady: function () {
 
   },
 
   /**
    * 生命周期函数--监听页面显示
    */
   onShow: function () {
 
   },
 
   /**
    * 生命周期函数--监听页面隐藏
    */
   onHide: function () {
 
   },
 
   /**
    * 生命周期函数--监听页面卸载
    */
   onUnload: function () {
 
   },
 
   /**
    * 页面相关事件处理函数--监听用户下拉动作
    */
   onPullDownRefresh: function () {
 
   },
 
   /**
    * 页面上拉触底事件的处理函数
    */
   onReachBottom: function () {
 
   },
 
   /**
    * 用户点击右上角分享
    */
   onShareAppMessage: function () {
 
   }
 })
```  
3.userMsg.json文件  
```json
{
  "navigationBarTitleText": "我的",
  "usingComponents": {
    "w-button": "/dist/w-button/index",
    "w-tabs": "/dist/w-tabs/index",
    "w-avatar": "/dist/w-avatar/index"
  }
}
```  
4.userMsg.wxml文件  
```html
<!--pages/userMsg/userMsg.wxml-->
<!-- 头像及用户名部分 -->
<view class='avatar-backgrond'>
     <!-- <view class="avatar"> 
        	<w-avatar src="{{item.avatar}}" size="large" >W</w-avatar>  <!--头像 -->
  <!-->   </view> -->
     <view  class='userInfo'>
       <image src="/images/photo_1.jpg" class='userinfo-avatar'> </image>
     </view>
     <view class='username'>
         <text >yxc</text>
     </view>
</view>

<view class='function' catchtap='toMySend'>
  <text>我的发布</text>
</view>

<!--分割线 -->
<view class='divLine'></view>

<!-- 导航栏-->
<view class='tabs'>
 <w-tabs bind:onChange="handleChange" currentIndex="3" options="{{ tabs1 }}" />
</view>

```  
5.userMsg.wxss文件  
```css
/* pages/userMsg/userMsg.wxss */
.tabs{
  position: fixed;
  width: 100%;
  bottom: 0;
}

.avatar-backgrond{
  width: 100%;
  height: 350rpx;
  background-color: rgb(14, 161, 14);
}

.avatar{

     /* 居中 */
  margin-top: 100rpx;  
  display: flex;
  justify-content: center;
  overflow: hidden;
  width: 161rpx;
  height: 161rpx;
  border-radius: 50%;
}

.userinfo-avatar{
  margin-top: 50rpx;
  width: 200rpx;
  height:200rpx;
  border-radius: 50%;
  display: flex;
  overflow: hidden;
  text-align: center;
}

.userInfo{
  display: flex;
flex-direction: row;
justify-content:center;
}

.username{
  text-align: center;
  color: white;
}

/*分割线样式*/
.divLine{
 background: #E0E3DA;
 width: 100%;
 height: 5rpx;
}

.function{
  width: 100%;
  height: 90rpx;
  margin-top: 30rpx;
  margin-left: 30rpx;
}
```  
6.其中点击我的发布跳转到的页面同首页一样  

