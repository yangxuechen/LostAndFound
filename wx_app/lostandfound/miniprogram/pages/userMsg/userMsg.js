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

    userInfo: {
      avatarUrl: "",//用户头像
      nickName: "",//用户昵称
    }

  },

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
        wx.switchTab({
          url: '/pages/send/send',
        })
        break;
      case 2:
        wx.switchTab({
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

    wx.hideTabBar({
      
    });
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
        })
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