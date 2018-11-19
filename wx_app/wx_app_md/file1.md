###微信小程序项目之失物招领平台-1.项目的创建  
1.开发工具：微信web开发者工具  
2.相关文档：[微信公共平台](https://developers.weixin.qq.com/miniprogram/dev/quickstart/basic/role.html)  
3.使用到的微信小程序UI组件库：[wuss-weapp](https://github.com/phonycode/wuss-weapp)  
4.使用微信web开发者工具创建一个小程序项目，项目名：lostandfound(appId可到微信公众平台申请，若没有appId小程序的一些相关的功能无法使用)  
5.将wuss-wapp的dist文件拷贝到lostandfound项目的路径下  
6.项目的结构图如下：  
![wx_project_1](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_1.jpg)  
7.在app.json文件中创建5个页面，添加代码如下  
```json
{
  "pages": [
    "pages/lostandfound/lostandfound",
    "pages/lostandfound/comment/comment",
    "pages/send/send",
    "pages/find/find",
    "pages/userMsg/userMsg"
     
  ],
  "window": {
    "backgroundColor": "#F6F6F6",
    "backgroundTextStyle": "light",
    "navigationBarBackgroundColor": "#F6F6F6",
    "navigationBarTitleText": "云开发 QuickStart",
    "navigationBarTextStyle": "black"
  }
}

```  
其中pages中的第一个页面对象（"pages/lostandfound/lostandfound"）为小程序启动的第一个页面  

8.进行第一个主页面的开发，在pages目录-->lostandfound-->lostandfound.json
，在lostandfound.json文件中添加如下代码，引入我们需要的组件库.  
```json
{"usingComponents": {
    "w-button": "/dist/w-button/index",
    "w-tabs":"/dist/w-tabs/index",
    "w-avatar": "/dist/w-avatar/index"
  }
  
  }
```  
9.在lostandfound.js文件中写入页面初始数据  
```javascript

  pages({
   
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
          ]
          }

      /*省去了小程序的生命周期函数*/
         
         //页面之间的跳转方法
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
       }
  })
   
    
```  
10.lostandfound.wxml文件添加代码，将导航栏固定在底部
```html
   <!-- 导航栏-->
    <view class='tabs'>
          <w-tabs bind:onChange="handleChange" currentIndex="0" options="{{ tabs1 }}" />
    </view>
```  
11.lostandfound.wxss文件  
```css
  .tabs{
    position: fixed;
    width: 100%;
    bottom: 0;
  }
```  
12.其他三个页面的编写方式同lostandfound.
13.编译运行小程序的效果图  
![wx_project_2](https://github.com/yangxuechen/LostAndFound/blob/master/wx_app/wx_app_images/wx_project_2.jpg)

  
