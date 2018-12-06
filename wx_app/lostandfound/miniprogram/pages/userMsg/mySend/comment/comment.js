// pages/lostandfound/comment/comment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //  comments:[
    //    {
    //      id:1,
    //     authorImg:"/images/photo_1.jpg",
    //     author:"James",
    //     date:"11-17",
    //      content:"聚集着翘首以盼、兴高采烈的当地民众",
    //      count:12,
    //      status:false
    //    },
    //    {
    //      id: 2,
    //      authorImg: "/images/photo_1.jpg",
    //      author: "James",
    //      date: "11-17",
    //      content: "聚集着翘首以盼、兴高采烈的当地民众",
    //      count: 12,
    //      status: false
    //    },
    //    {
    //      id: 3,
    //      authorImg: "/images/photo_1.jpg",
    //      author: "James",
    //      date: "11-17",
    //      content: "聚集着翘首以盼、兴高采烈的当地民众",
    //      count: 12,
    //      status: false
    //    },
    //    {
    //      id: 4,
    //      authorImg: "/images/photo_1.jpg",
    //      author: "James",
    //      date: "11-17",
    //      content: "聚集着翘首以盼、兴高采烈的当地民众",
    //      count: 12,
    //      status: false
    //    },
    //  ],
    content: "",
    postId: null,
    userName: null,
    avatarUrl: null,
    date: null,
    likedCount: 0,
    userInfo: {
      avatarUrl: "",//用户头像
      nickName: "",//用户昵称
    },
    page: 1,
    pageSize: 20,
    queryResult: []
  },

  /**
  * 第一页查询
  */
  queryPageOne: function () {
    const db = wx.cloud.database();
    var postId = this.data.postId;
    var that = this;
    //页码
    var pageNum = that.data.page;
    //一页的记录数1gf
    var pageSize = that.data.pageSize;
    //queryREsult
    var res = that.data.queryResult;
    // 查询当前用户所有的 counters
    db.collection('commentList').where({ postId: postId }).limit(pageSize).orderBy('likedCount', 'desc').get({
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

  /**
 * 分页查询 不是第一页使用这个方法
 */
  queryByPage: function () {
    const db = wx.cloud.database();
    var postId = this.data.postId;
    var that = this;
    //页码
    var pageNum = that.data.page;
    //一页的记录数1gf
    var pageSize = that.data.pageSize;
    //queryREsult
    var res = that.data.queryResult;
    // 查询当前用户所有的 counters
    db.collection('commentList').where({ postId: postId }).skip((pageNum - 1) * pageSize).limit(pageSize).orderBy('likedCount', 'desc').get({
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
  //查询数据
  onQuery: function () {
    var pageNum = this.data.page;
    if (pageNum == 1) {
      this.queryPageOne();
    } else {
      this.queryByPage();
    }
  },

  //失去焦点时获取里面评论内容
  bindTextAreaBlur: function (e) {
    console.log(e.detail.value)
    this.setData({
      content: e.detail.value,
    })
  },

  /**
   * 按钮点击触发事件 提交评论
   **/
  formSubmit(e) {
    // this.bindTextAreaBlur();
    //test

    //获取时间
    this.getNowData();
    var content = this.data.content;
    var userName = this.data.userInfo.nickName;
    var avatarUrl = this.data.userInfo.avatarUrl;
    var postId = this.data.postId;
    var date = this.data.date;
    var likedCount = this.data.likedCount;
    console.log("测试数据：" + content + " ," + userName + " ," + avatarUrl + " ," + postId + ", " + date);

    if (content != "") {
      console.log("发表评论：" + content);

      const db = wx.cloud.database()

      db.collection('commentList').add({
        data: {
          postId: postId,
          userName: userName,
          content: content,
          date: date,
          likedCount: likedCount,
          avatarUrl: avatarUrl,
          status: false
        },
        success: res => {


          //更新评论
          this.setData({
            queryResult: [],
            page: 1
          });
          this.onQuery();


          wx.showToast({
            title: '发表评论成功',
          })
          console.log('[数据库] [新增记录] 成功，记录 _id: ', res._id)
        },
        fail: err => {
          wx.showToast({
            icon: 'none',
            title: '发表评论失败'
          })
          console.error('[数据库] [新增记录] 失败：', err)
        }
      });


      //清空输入框
      this.setData({
        content: ""
      })
      //更新评论数
      this.updateCommentCount(postId);

    }

  },

  /**
   * 更新评论数
   */

  updateCommentCount(postId) {


    const db = wx.cloud.database();

    db.collection("postList").where({ _id: postId }).get({
      success: res => {
        console.log(res);
        var count = res.data[0].commentSize;
        count++;

        //调用云函数更新评论数
        wx.cloud.callFunction({
          name: 'updateCommentSize',
          data: {
            postId: postId,
            commentSize: count
          },
          success: res => {
            console.log("调用云函数成功，更新成功");
          },
          fail: res => {
            console.log("调用云函数失败，更新失败");
          }
        })
        // console.log("count:"+count);
        // const db = wx.cloud.database();
        // db.collection("postList").doc(postId).update({
        //   data:{
        //     commentSize:count
        //   },
        //   success:res=>{
        //     console.log("增加评论数成功")
        //   },
        // })


      },
      fail: res => {

      }
    })


  },

  /**
   * 获取当前时间
   */
  getNowData() {
    var myDate = new Date();
    console.log("当前时间  " + myDate);
    var str = (myDate.getMonth() + 1) + "-" + myDate.getDate();
    console.log("当前时间  " + str);
    this.setData({
      date: str
    })
  },

  //点赞计数
  toLike(event) {
    var id = event.currentTarget.dataset.commentId;
    console.log("id:" + id);
    //  console.log(event);
    var status = this.data.queryResult[id].status;
    var count = this.data.queryResult[id].likedCount;
    console.log("status:" + status + "count:" + count);

    var commentStatus = 'queryResult[' + id + '].status';
    var commentCount = 'queryResult[' + id + '].likedCount';
    if (status == false) {
      count++;
      this.setData({
        [commentStatus]: true,
        [commentCount]: count
      })

    } else {
      count--;
      this.setData({
        [commentStatus]: false,
        [commentCount]: count
      })
    }
    //更新数据库信息
    this.updateLikedCount(id);
  },

  //更新数据库点赞数
  updateLikedCount(index) {

    var id = this.data.queryResult[index]._id;
    var likedCount = this.data.queryResult[index].likedCount;
    wx.cloud.callFunction({
      name: 'updateLikedCount',
      data: {
        commentId: id,
        likedCount: likedCount
      },
      success: res => {
        console.log("调用云函数成功，更新成功");
      },
      fail: res => {
        console.log("调用云函数失败，更新失败");
      }
    })

    // const db=wx.cloud.database();
    // db.collection("commentList").doc(id).update({
    //    data:{
    //      likedCount:likedCount,
    //    },
    //   success: res => {

    //   },
    //   fail: err => {

    //   }
    // })
  },

  //获取用户信息
  uploadAvatar() {
    var that = this;
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
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {


    var postId = options.id;//从上一个页面获取文章id
    var count = options.commentSize;
    //test
    console.log("comment.js ..." + postId + "," + count);

    this.setData({
      postId: postId
    });

    //查询评论记录
    this.onQuery();
    //获取用户信息
    this.uploadAvatar();
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