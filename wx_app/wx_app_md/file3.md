###微信小程序项目之失物招领平台-3.评论页面的编写  
1.在lostandfound.js文件中加入点击评论图标跳转到评论页面的方法  
```javascript
  /**
   * 跳转到文章评论页面
   */
  onTapToComment(event) {
    //获取postId
    var postId = event.currentTarget.dataset.postId;
    console.log(postId);
    wx.navigateTo({
      url: 'comment/comment?id=' + postId,
    })
```  
2.在comment.js的onload方法中接收lostandfound页面传递来的postId  
```javascript
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var postId = options.id;//从上一个页面获取文章id

    //test
    console.log("comment.js ..." + postId);
  },

```  
3.comment.js文件，添加需要的数据，以及相应方法  
```javascript
// pages/lostandfound/comment/comment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
     comments:[
       {
        authorImg:"/images/photo_1.jpg",
        author:"James",
        date:"11-17",
         content:"聚集着翘首以盼、兴高采烈的当地民众"
       },
       {
         authorImg: "/images/photo_1.jpg",
         author: "James",
         date: "11-17",
         content: "聚集着翘首以盼、兴高采烈的当地民众"
       },
       {
         authorImg: "/images/photo_1.jpg",
         author: "James",
         date: "11-17",
         content: "聚集着翘首以盼、兴高采烈的当地民众"
       },
       {
         authorImg: "/images/photo_1.jpg",
         author: "James",
         date: "11-17",
         content: "聚集着翘首以盼、兴高采烈的当地民众"
       },
     ],
     content:"",
  },

  //失去焦点时获取里面评论内容
  bindTextAreaBlur: function (e) {
    console.log(e.detail.value)
    this.setData({
      content: e.detail.value,
    })
  },

  //按钮点击触发事件 提交评论
  formSubmit(e){
    // this.bindTextAreaBlur();
    //test
    var content=this.data.content;
    if(content!=""){
      console.log("发表评论：" + content);
      //显示成功
      wx.showToast({
        title: '发表成功',
        duration: 1000
      });

      //清空输入框
      this.setData({
        content: ""
      })
    }
   
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var postId = options.id;//从上一个页面获取文章id

    //test
    console.log("comment.js ..." + postId);
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
4.comment.wxss文件，加入需要的样式表  
```css
/* pages/lostandfound/comment/comment.wxss */

.page{
  margin: 10rpx 10rpx 10rpx 10rpx;
}
.userMsg{
  display: flex;
  flex-direction: row;
}

.name-date{
  display: flex;
  flex-direction: column;
}
.userMsg-name{
  font-size: smaller;
  margin-left: 20rpx;
}

.userMsg-date{
  font-size:small;
  margin-top: 10rpx;
  margin-left: 20rpx;
}
.comment-content{
  font-size: small;
  margin-left: 30rpx;
  margin-top: 20rpx;
}

/*分割线样式*/
.divLine{
  margin-top: 30rpx;
 background: #E0E3DA;
 width: 100%;
 height: 5rpx;
}

/*固定在底部的评论框*/
.comment-send{
  display: flex;
  flex-direction: row;
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 100rpx;
  border-top-style: solid;
  border-width: 3rpx;
  border-color: rgba(100, 94, 86, 0.856)
}

.comment-form{
  margin-top: 5rpx;
  margin-left: 20rpx;
  height: 100rpx;
  width: 70%;

}
.comment-input{
  width: 100%;
}
.comment-image{
  width: 50rpx;
  height: 50rpx;
}

.comment-button{
  position: absolute;
  right: 5rpx;
  top: 5rpx;
  height: 20rpx;
}
.btn{
  background-color: rgb(23, 167, 250);
}
```  
5.comment.json文件添加需要用的的组件  
```json
  {
      "navigationBarTitleText": "评论",
      "usingComponents": {
        "w-avatar": "/dist/w-avatar/index",
          "w-input": "/dist/w-input/index",
          "w-cell-group": "/dist/w-cell-group/index"
      }
  }
```
6.comment.wxml文件的编写  
```html
  <!--pages/lostandfound/comment/comment.wxml-->
  <view class='page'>
    <block wx:for="{{comments}}" wx:for-item="item" wx:for-index="index">
        <view class='userMsg'>
      	<w-avatar size="large" src="{{item.authorImg}}">W</w-avatar>
        <view class='name-date'>
           <text class='userMsg-name'>{{item.author}}</text>
           <text class='userMsg-date'>{{item.date}}</text>
        </view>
    </view>
    <view>
      <text class='comment-content'>{{item.content}}</text>
    </view>
    <view class='divLine'></view>
    </block>
  
  </view>
    <!-- 固定在底部的评论框-->
    <view class='comment-send'>
  
         <!-- <input placeholder="写评论" maxlength="200"></input> -->
      <image class='comment-image' src='/images/wx_app_comment.jpg'></image>
  	<!-- <w-input
  	 clear
  	 count="100"
  	 type="textarea"
  	 placeholder="评论"
  	/> -->
  
      <!-- 评论表单-->
      <form class='comment-form' bindsubmit='formSubmit'>
         <textarea placeholder="写评论" maxlength="200"  cursor-spacing="30" bindblur='bindTextAreaBlur' class='comment-input' value='{{content}}'></textarea>
  
      <view class='comment-button'>
            <button  size='mini' class='btn' formType='submit'>发表</button>
      </view>
  
      </form>
         
     
    </view>
  

```  
7.comment页面运行效果图  
![wx_project_4](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_4.jpg)