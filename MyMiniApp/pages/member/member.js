// pages/member/member.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    message:"准备查询",
    phone:"18911230117",
    name:"",
    credits:"",
    flag:false
  },
  mysearch: function(){
   this.setData({message:"正在查询: "+this.data.phone});
   var myPage = this;
   wx.request({
     url: 'http://10.1.80.80:8080/myapp/api/member',
     data:{phone:this.data.phone},
     success(result){
       console.log(result);
       myPage.setData({
         name:result.data.name,
         credits:result.data.credits,
         flag:true
       });
     },
     fail(){
       console.log("请求失败");  
     }
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