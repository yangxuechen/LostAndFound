// pages/find/find.js
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
    selected:false,
    content:"",
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
        // wx.navigateTo({
        //   url: '/pages/find/find',
        // })
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

  //查询
  tofind(event){
    console.log(event);
    var value=event.detail.value;

    //test
    console.log(value);
    if(value!=""){
      
      this.setData({
        selected: true,
        content: value
      })
    }

  },

  //搜索框获得焦点，重新查询
  update(event){
    this.setData({
      selected:false,
      content:""
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

     wx.hideTabBar({
       
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