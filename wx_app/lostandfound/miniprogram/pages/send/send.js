// pages/send/send.js
var app=getApp();
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
    content:"",

    array: ['证件类', '书籍类', '服饰类', '食品类',"电子产品类","其他"],
    objectArray: [
      {
        id: 0,
        name: '证件类'
      },
      {
        id: 1,
        name: '书籍类'
      },
      {
        id: 2,
        name: '服饰类'
      },
      {
        id: 3,
        name: '食品类'
      },
      {
        id: 4,
        name: '电子产品类'
      },
      {
        id: 5,
        name: '其他'
      }
    ],
    index: 0,
  
      postId:null,
      category:null,
      content:null,
      author:null,
      date:null,
      commentSize:0,
      imgsFileId:null,
      avatar:null,
    userInfo: {
      avatarUrl: "",//用户头像
      nickName: "",//用户昵称
    },
    avatarFileId:null
  },

  //pick
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
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

  //上传图片
  uploadImages(){
    var images = this.data.images;
    for (var i = 0; i < images.length; i++) {
      console.log("图片地址：" + images[i]);
      wx.showLoading({
        title: '上传中',
      })

      //生成随机字符串
      var str=Math.random().toString(36).substr(2);
      console.log("随机字符串："+str);

      const filePath = images[i];
      const cloudPath = str+ filePath.match(/\.[^.]+?$/)[0];
 
      wx.cloud.uploadFile({
        cloudPath,
        filePath,
        success: res => {
          console.log('[上传文件] 成功：', res)

          console.log("fileId:" + res.fileID);
          this.setData({
            imgsFileId: res.fileID
          });
  
        },
        fail: e => {
          console.error('[上传文件] 失败：', e)
          wx.showToast({
            icon: 'none',
            title: '上传失败',
          })
        },
        complete: () => {
          wx.hideLoading();
          //上传数据
          this.onAdd();
        }
      })
    }
  },

  //失物招领表单的提交
  lostandfoundMsgFormSubmit(e){
    var category = this.data.index;
    var content1=this.data.content;

    //test
       console.log("category:"+category);
       console.log("content:"+content1);
      
   
    this.setData({
      id:1,
      content:content1,
      author:"yxc"
    })

     
      //上传图片
      this.uploadImages() ;
     
   
  
 
      this.setData({
        images:[]
      });
    //  wx.showToast({
    //    title: '发布成功',
    //    duration:2000
    //  })
  },

  //获取用户信息
  uploadAvatar(){
    //用户头像
    var that = this;
    /**
     * 获取用户信息
     */
    wx.getUserInfo({
      success: function (res) {
        console.log(res);
        var avatarUrl = 'userInfo.avatarUrl';
        var nickName = 'userInfo.nickName';
        that.setData({
          [avatarUrl]: res.userInfo.avatarUrl,
          [nickName]: res.userInfo.nickName,
        });
     
      }
    });
    
    
  },

//上传数据
  onAdd: function () {

    var postId=this.data.postId;
    var author=this.data.userInfo.nickName;
    var content = this.data.content;
    var date = this.data.date;
    var commentSize = this.data.commentSize;
    var imgsFileId = this.data.imgsFileId;
    var avatarUrl=this.data.userInfo.avatarUrl;
  
     //测试赋值是否成功
    console.log("测试赋值是否成功"+postId+" "+author+" "+content+" "+imgsFileId);
    
   
    
    const db = wx.cloud.database()
    // db.collection('counters').add({
    //   data: {
    //     count: 10
    //   },

    db.collection('postList').add({
      data: {
        postId: postId,
        author: author,
        content: content,
        date: date,
        commentSize: commentSize,
        imgsFileId:imgsFileId,
        avatarUrl: avatarUrl
      },
      success: res => {
        // 在返回结果中会包含新创建的记录的 _id
        this.setData({
          counterId: res._id,
          count: 1
        })
        wx.showToast({
          title: '发布成功',
        })
        // console.log('[数据库] [新增记录] 成功，记录 _id: ', res._id)
      },
      fail: err => {
        wx.showToast({
          icon: 'none',
          title: '发布失败'
        })
        // console.error('[数据库] [新增记录] 失败：', err)
      }
    })
  },
  
  //获取当前时间，并将当前时间转化成字符串
dateFoematString(){

  
},

//菜单导航栏的跳转
  handleChange(e) {
    const index = e.detail.value;
    console.log(e);
    console.log("value: " + e.detail.value);
    switch (index) {
      case 0:
        wx.switchTab({
          url: '/pages/lostandfound/lostandfound',
        })
        break;
      case 1:
        // wx.navigateTo({
        //   url: '/pages/send/send',
        // })
        break;
      case 2:
        wx.switchTab({
          url: '/pages/find/find',
        })
        break;
      case 3:
        wx.switchTab({
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

    wx.hideTabBar({
      
    });
    //获取用户信息
    this.uploadAvatar();

    var myDate=new Date();
    console.log("当前时间  " + myDate);
    var str = myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" + myDate.getDate()+"  "+myDate.getHours()+":"+myDate.getMinutes();
    console.log("当前时间  " + str);
    this.setData({
        date:str
    })
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