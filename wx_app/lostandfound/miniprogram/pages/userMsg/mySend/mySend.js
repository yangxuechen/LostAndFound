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
    imgArr: [

    ],
    queryResult: [],
    tempImagePath: "",
    page: 1,
    pageSize: 4,
    hasMoreData: true,
    result:""
  },

  handleChange(e) {
    const index = e.detail.value;
    console.log(e);
    console.log("value: " + e.detail.value);
    switch (index) {
      case 0:
        // wx.navigateTo({
        //   url: '/pages/lostandfound/lostandfound',
        // })
        break;
      case 1:
        wx.switchTab({
          url: '/pages/send/send',
        })
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

  //图片预览
  previewImg: function (e) {
    //  console.log("e:" + e.currentTarget.dataset.index);
    var index = e.currentTarget.dataset.index;
    //  console.log("index:"+index);
    //  console.log("fileId:"+this.data.queryResult[index].imgsFileId);

    var imgArr = this.data.queryResult[index].imgsFileId;
    //  console.log("opinid:"+imgArr)
    var imgs = this.data.imgArr;
    imgs.push(imgArr);

    wx.previewImage({
      current: imgArr,     //当前图片地址
      urls: imgs,               //所有要预览的图片的地址集合 数组形式
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    });
  },

  //上传数据到云端数据库
  onAdd: function () {
    const db = wx.cloud.database()
    db.collection('postList').add({
      data: {
        postId: 2,
        author: "james",
        content: "湖人总冠军",
        date: "2018-11-28",
        commentSize: 99
      },
      success: res => {
        // 在返回结果中会包含新创建的记录的 _id
        this.setData({
          counterId: res._id,
          count: 1
        })
        wx.showToast({
          title: '新增记录成功',
        })
        console.log('[数据库] [新增记录] 成功，记录 _id: ', res._id)
      },
      fail: err => {
        wx.showToast({
          icon: 'none',
          title: '新增记录失败'
        })
        console.error('[数据库] [新增记录] 失败：', err)
      }
    })
  },

  //查询数据
  onQuery: function () {
    var pageNum = this.data.page;
    if (pageNum == 1) {
      this.queryPageOne();
    } else {
      this.queryByPage();
    }
  },

  /**
   * 第一页查询
   */
  queryPageOne: function () {
    const db = wx.cloud.database();
    var that = this;

    wx.cloud.callFunction({
      name:"login",
      success:res=>{
        console.log("云函数结果" + JSON.stringify(res.result));
        var resul=res.result;
        console.log("openid:"+resul.openid);
        this.setData({
          result: resul.openid
        });
       
        var openid = this.data.result;
        console.log("测试openid:" + openid);
        //页码
        var pageNum = that.data.page;
        //一页的记录数1gf
        var pageSize = that.data.pageSize;
        //queryREsult
        var res = that.data.queryResult;
        // 查询当前用户所有的 counters
        db.collection('postList').where({ _openid: openid }).limit(pageSize).orderBy('date', 'desc').get({
          success: res => {

            //追加数据
            // this.data.queryResult.unshift(res.data);
            this.setData({
              // queryResult: JSON.stringify(res.data, null, 2)
              queryResult: this.data.queryResult.concat(res.data),
              page: pageNum + 1
            })
            console.log('[数据库] [查询记录] 成功: ', res.data);

            //下载图片内容
            this.downloadImageContent();
          },
          fail: err => {
            wx.showToast({
              icon: 'none',
              title: '查询记录失败'
            })
            console.error('[数据库] [查询记录] 失败：', err)
          }
        })

      }
    });
   
  },
  /**
   * 分页查询 不是第一页使用这个方法
   */
  queryByPage: function () {
    const db = wx.cloud.database();
    var that = this;
    
    var openid = this.data.result;
    //页码
    var pageNum = that.data.page;
    //一页的记录数1gf
    var pageSize = that.data.pageSize;
    //queryREsult
    var res = that.data.queryResult;
    // 查询当前用户所有的 counters
    db.collection('postList').where({_openid:openid }).skip((pageNum - 1) * pageSize).limit(pageSize).orderBy('date', 'desc').get({
      success: res => {

        //追加数据
        // this.data.queryResult.unshift(res.data);
        this.setData({
          // queryResult: JSON.stringify(res.data, null, 2)
          queryResult: this.data.queryResult.concat(res.data),
          page: pageNum + 1
        })
        console.log('[数据库] [查询记录] 成功: ', res.data);

        //下载图片内容
        this.downloadImageContent();
      },
      fail: err => {
        wx.showToast({
          icon: 'none',
          title: '查询记录失败'
        })
        console.error('[数据库] [查询记录] 失败：', err)
      }
    })
  },

  //下载图片内容
  downloadImageContent() {
    var postList = this.data.queryResult;
    for (var i = 0; i < postList.length; i++) {
      console.log("test fileId " + i + postList[i].imgsFileId);

      wx.cloud.downloadFile({
        fileID: postList[i].imgsFileId,
        success: res => {
          console.log("临时路径：" + res.tempFilePath);

          var tempPath = 'postList[' + i + '].imgsFileId';
          this.setData({
            [tempPath]: res.tempFilePath
          })
        }
      })
    }


  },

  //下载云数据库的图片
  downImage: function (fileId) {
    wx.cloud.downloadFile({
      fileID: 'cloud://d-24c49d.642d-d-24c49d/my-image.jpg', // 文件 ID
      success: res => {
        // 返回临时文件路径
        console.log(res.tempFilePath);
        this.setData({
          tempImagePath: res.tempFilePath
        })
      },
      fail: console.error
    })
  },


  //授权登陆
  login: function () {
    wx.getSetting({
      success: (response) => {
        console.log(response)
        if (!response.authSetting['scope.userInfo']) {
          wx.authorize({
            scope: 'scope.userInfo',
            success: () => {
              console.log('yes')
            }
          })
        }
      }
    })
  },
  

  //删除事件
  delete(event){
    var that=this;
   // console.log(event);
    console.log("打印event事件："+event.currentTarget.dataset.postId);
    var index = event.currentTarget.dataset.postId;
    var postId=this.data.queryResult[index]._id;
    //弹出模态框
    wx.showModal({
      title: '删除',
      content: '确定要删除该记录吗?',
      success:function(res){
        if(res.confirm){
          //点击确认，删除
          console.log("点击删除");
          var postList = that.data.queryResult;
          postList.splice(index,1);
          that.setData({
            queryResult:postList
          })
       //   this.deletePostById(postId);
          //删除post
          const db = wx.cloud.database();
          try {
            return db.collection('postList').doc(postId).remove();

          } catch (e) {
            console.error(e)
          }
          //通过postid删除评论 云函数
          wx.cloud.callFunction({
            name:"deleteComments",
            data:{
              postId:postId
            },
            success:res =>{
              console.log("调用云函数成功，删除成功");
            },
            fail: res =>{
              console.log("调用云函数失败，删除失败");
            }
          })
        }else if(res.cancel){
          console.log("点击取消");
        }
      }
    })

  },

 //通过postId来删除post
  deletePostById(postId){
     const db=wx.cloud.database();
    try {
      return  db.collection('postList').doc(postId).remove()
    } catch (e) {
      console.error(e)
    }
    //  db.collection("postList").doc(postId).remove({
    //    success:res=>{
        
    //      console.log("删除成功");

    //      this.setData({
    //        page:1,
    //        queryResult:[]
    //      });
    //      this.onQuery();

    //      //调用云函数删除评论

    //    },
    //    fail:res=>{
    //      console.log("删除失败");
    //    }
    //  })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    wx.hideTabBar({

    });

    //查询数据
    // onQuery();
    this.onQuery();
    //  this.downImage();




    // 查看是否授权,授权登陆
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          var app = getApp();
          wx.getUserInfo({
            success: function (res) {
              console.log(res.userInfo);
              app.globalData.userInfo = res.userInfo;

              //测试是否给全局变量userInfo赋值
              console.log("全局变量userInfo :" + app.globalData.userInfo);
            }
          })
        }
      }
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
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
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
  },

  /**
 * 页面相关事件处理函数--监听用户下拉动作
 */
  onPullDownRefresh: function () {

    //获取最新记录
    this.setData({
      page: 1,
      queryResult: []
    });
    console.log("更新后的page:" + this.data.page)
    this.queryPageOne();
    wx.stopPullDownRefresh();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    this.onQuery();

  },
})