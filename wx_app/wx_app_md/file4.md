###微信小程序项目之失物招领平台-4.信息发布页面的编写  
1.send.js文件，添加数据及方法  
```javascript
// pages/send/send.js
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
    items: [
      { name: '1', value: '证件' },
      { name: '2', value: '书籍' },
      { name: '3', value: '服饰' },
      { name: '4', value: '食品' },
      { name: '5', value: '其他' }
    ],
    images: [],
    category:"",
    content:""
  },
    
    //单选框选择事件
  radioChange: function (e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value);
    this.setData({
      category: e.detail.value
    })
  },

  //上传图片
  chooseImage() {
    var that = this;
    if (this.data.images.length < 3) {
      wx.chooseImage({
        sizeType: ['original', 'compressed'],
        success: function (res) {
          that.setData({
            images: that.data.images.concat(res.tempFilePaths)
          })
        }
      })
    } else {
      wx.showToast({
        title: '最多上传三张图片',
        icon: 'loading',
        duration: 3000
      });
    }
  },

  // 删除图片
  deleteImg: function (e) {
    var imgs = this.data.images;
    var index = e.currentTarget.dataset.index;
    imgs.splice(index, 1);
    this.setData({
      images: imgs
    });
  },
  //失去焦点时获取输入框内容
  bindTextAreaBlur: function (e) {
    console.log(e.detail.value)
    this.setData({
      content: e.detail.value,
    })
  },
  //失物招领表单的提交
  lostandfoundMsgFormSubmit(e){
    var category = this.data.category;
    var content=this.data.content;

    //test
       console.log("category:"+category);
       console.log("content:"+content);
      var images=this.data.images;
      for(var i=0;i<images.length;i++){
        console.log("图片地址："+images[i]);
      }
      this.setData({
        images:[]
      });
     wx.showToast({
       title: '发布成功',
       duration:2000
     })
  },
//菜单导航栏的跳转
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
2.send.json文件中引入相应的UI组件  
```json
  {
    "usingComponents": {
      "w-button": "/dist/w-button/index",
      "w-tabs": "/dist/w-tabs/index",
          "w-cell": "/dist/w-cell/index",
          "w-cell-group": "/dist/w-cell-group/index",
          "w-input": "/dist/w-input/index"
    }
  }
```  
3.send.wxss文件  
```css
/* pages/send/send.wxss */
.tabs{
  position: fixed;
  width: 100%;
  bottom: 0;
}

.big-logos {
  float: left;
  margin-top: 10rpx;
  margin-bottom: 10rpx;
  width: 100%;
  height: 200rpx;
  border: 1px solid #ccc;
}
.big-logos .big-logos_img {
  float: left;
  width: 100%;
  height: 200rpx;
}
.big-logos .big-logos_img image {
  float: left;
  width: 250rpx;
  height: 200rpx;
}



.big-logos .logoinfo {
  float: left;
 width: 250rpx;
  height: 200rpx;
  margin-top: -196rpx;
}
.big-logos .logoinfo image {
  float: left;
  width: 250rpx;
  height: 200rpx;
}
.delete-btn{
  width: 10%;
  height: 50rpx;
}
.submit-btn-view{
  margin-top: 50rpx;
}
.submit-btn{
   background-color: green;
   color: white;
}

.space{
  width: 100%;
  height: 80rpx;
}
```  
4.send.wxml文件  
```html
  <!--pages/send/send.wxml-->
  <view>
      <form bindreset="lostandfoundMsgFormSubmit">
        <label>1.选择类别</label>
          <radio-group class="radio-group" bindchange="radioChange">
             <label class="radio" wx:for="{{items}}">
                <radio value="{{item.name}}" checked="{{item.checked}}"/>{{item.value}}
             </label>
          </radio-group>
          <!-- 留下距离-->
          <view class='space'></view>
        <label>2.输入内容</label>
          <w-cell-group>
  	          <!-- <w-input clear count="200" type="textarea" placeholder="输入"	bindblur='bindTextAreaBlur'/> -->
              <textarea placeholder="请输入200字以内" bindblur='bindTextAreaBlur' maxlength='200'></textarea>
          </w-cell-group>
  
           <!-- 留下距离-->
          <view class='space'></view>
        <label>3.上传图片</label>
  
        
        <!-- 图片上传-->
             <view class="big-logos">
          <view class='big-logos_img'>
             <image bindtap="chooseImage" src='/images/wx_app_add.jpg'></image> 
             <image bindtap="chooseImage" src='/images/wx_app_add.jpg'></image> 
            <image bindtap="chooseImage" src='/images/wx_app_add.jpg'></image>   
          </view>
          <block wx:for="{{images}}" wx:key="{{index}}"> 
              <view class='logoinfo'>    
                <image src='{{item}}' catchtap='deleteImg'></image>    
              </view>
  
          </block>    
        </view> 
         <!-- 图片上传-->
   
                <!-- 留下距离-->
          <view class='space'></view>
          <view class='submit-btn-view'>
                   <button formType="reset" class='submit-btn' >发布</button>
          </view>
  
      </form>
  </view>
  <view class='tabs'>
     <w-tabs bind:onChange="handleChange" currentIndex="1" options="{{ tabs1 }}" />
  </view>

```  
5.信息发布页面运行效果图  
![wx_project_5](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_5.jpg)