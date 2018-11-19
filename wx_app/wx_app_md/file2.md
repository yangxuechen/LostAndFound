###微信小程序项目之失物招领平台-2.lostanfound页面的编写  
1.在lostandfound.js中添加需要的数据  
```javascript
  // pages/lostandfound/lostandfound.js
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
  
      postList:[
        {
          avatar:"/images/photo_3.jpg",
          author:"yxc",
          content:"和预想的一样，今天火箭正式宣布和卡梅隆-安东尼“分手”，作为首位报道火箭和安东尼分道扬镳的记者蒂姆-麦克马洪在接受腾讯-ESPN 记者Coral采访时表示：火箭从长远考虑，不得不和甜瓜提前结束这次合作",
          contentImg: ["/images/photo_1.jpg", "/images/photo_1.jpg", "/images/photo_1.jpg", "/images/photo_1.jpg",],
          date:"2018-11-17",
          commentImg:"wx_app_comment.jpg",
          commentSize:99,
          postId:1
        },
        {
          avatar: "/images/photo_3.jpg",
          author: "yxc",
          content: "和预想的一样，今天火箭正式宣布和卡梅隆-安东尼“分手”，作为首位报道火箭和安东尼分道扬镳的记者蒂姆-麦克马洪在接受腾讯-ESPN 记者Coral采访时表示：火箭从长远考虑，不得不和甜瓜提前结束这次合作",
          contentImg: ["/images/photo_1.jpg"],
          date: "2018-11-17",
          commentImg: "wx_app_comment.jpg",
          commentSize: 99,
          postId: 2
        },
        {
          avatar: "/images/photo_3.jpg",
          author: "yxc",
          content: "和预想的一样，今天火箭正式宣布和卡梅隆-安东尼“分手”，作为首位报道火箭和安东尼分道扬镳的记者蒂姆-麦克马洪在接受腾讯-ESPN 记者Coral采访时表示：火箭从长远考虑，不得不和甜瓜提前结束这次合作",
          contentImg: [],
          date: "2018-11-17",
          commentImg: "wx_app_comment.jpg",
          commentSize: 99,
          postId: 3
        },
        {
          avatar: "/images/photo_3.jpg",
          author: "yxc",
          content: "和预想的一样，今天火箭正式宣布和卡梅隆-安东尼“分手”，作为首位报道火箭和安东尼分道扬镳的记者蒂姆-麦克马洪在接受腾讯-ESPN 记者Coral采访时表示：火箭从长远考虑，不得不和甜瓜提前结束这次合作",
          contentImg: ["/images/photo_1.jpg", "/images/photo_1.jpg", "/images/photo_1.jpg", "/images/photo_1.jpg",],
          date: "2018-11-17",
          commentImg: "wx_app_comment.jpg",
          commentSize: 99,
          postId: 4
        },
      ],
      
      imgArr:[
        "http://bpic.588ku.com/element_origin_min_pic/16/10/30/528aa13209e86d5d9839890967a6b9c1.jpg",
        "http://bpic.588ku.com/element_origin_min_pic/16/10/30/528aa13209e86d5d9839890967a6b9c1.jpg"
      ],
  
    },
  
    handleChange(e) {
      const index = e.detail.value;
      console.log(e);
      console.log("value: "+e.detail.value);
      switch(index){
        case 0:
            // wx.navigateTo({
            //   url: '/pages/lostandfound/lostandfound',
            // })
            break;
        case 1:
          wx.redirectTo({
            url: '/pages/send/send',
          })
          // wx.navigateTo({
          //   url: '/pages/send/send',
          // })
            break;
        case 2:
          wx.redirectTo({
            url: '/pages/find/find',
          })
            break;
        case 3:
          wx.redirectTo({
            url: '/pages/userMsg/userMsg',
          })
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
    
    //图片预览
      previewImg:function(e){
        var imgArr=this.data.imgArr;
        wx.previewImage({
          current: imgArr[0],     //当前图片地址
          urls: imgArr,               //所有要预览的图片的地址集合 数组形式
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        });
      },
    /* 省去了小程序的生命周期函数等*/
   
  })
```  
2.lostandfound.wxss文件  
```css
/* pages/lostandfound/lostandfound.wxss */

.tabs{
  position: fixed;
  width: 100%;
  bottom: 0;
}
.page{
  margin: 10rpx 10rpx 10rpx 10rpx;
}

.body{
  display: flex;
  flex-direction: column;
   margin: 10rpx 10rpx 10rpx 10rpx;
}

.author{
  width: 100%;
  height: 100rpx;
  font-size: small;
}

.content{
   width: 100%;
  font-size: small;

}
.contnet-img{
  display: flex;
  flex-direction: row;
}
.image{
  width: 220rpx;
  height: 220rpx;
  margin-top: 10rpx;
  margin-bottom: 10rpx;
}

.date-content{
  font-size: xx-small;
}

.comment-image{
  width: 50rpx;
  height: 50rpx;
  margin-left: 480rpx;
}

.date-comment{
  display: flex;
  flex-direction: row;
}

/*分割线样式*/
.divLine{
 background: #E0E3DA;
 width: 100%;
 height: 5rpx;
}

.save-bottom{
  width: 100%;
  height: 110rpx;
}
```  
3.lostandfound.wxml文件的编写  
```html
 <!--pages/lostandfound/lostandfound.wxml-->
 <!-- 导航栏-->
  <view class='tabs'>
        <w-tabs bind:onChange="handleChange" currentIndex="0" options="{{ tabs1 }}" />
  </view>
 
  <!--内容-->
 <view>
    <view class='page'>
       <!--循环遍历失物招领内容 -->
       <block wx:for="{{postList}}" wx:for-item="item" wx:for-index="index">
           <view class='body'>
           <view class='author'>
              	<w-avatar src="{{item.avatar}}">W</w-avatar>  <!--头像 -->
                <text>{{item.author}}</text> <!--用户名 -->
           </view>
              <!-- 文本内容-->
              <text class='content'>{{item.content}}</text>
         <!--图片内容 -->
        <view class='content-img' wx:if="{{item.contentImg.length!=0}}">
           <block wx:for="{{item.contentImg}}" wx:for-item="img">
             <image src='{{img}}' class='image' catchtap='previewImg'></image>
           </block>
        </view>
        <view class='date-comment'>
            <!-- 日期-->
            <text class='date-content'>{{item.date}}</text>
            <!--评论 -->
            <view catchtap='onTapToComment' data-post-id="{{item.postId}}">
                         <image src='/images/wx_app_comment.jpg' class='comment-image'></image>
            <text class='date-content'>{{item.commentSize}}</text>
            </view>
 
        </view>
       </view>
       <!-- 分割线-->
       <view class='divLine'></view>
       </block>
       <!-- 解决底部导航栏遮挡部分内容的问题-->
       <view class='save-bottom'></view>
     
    </view>
      
 </view> 

```  

4.lostandfound页面运行效果图  
![wx_project_3](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_3.jpg)