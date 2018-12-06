// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db = cloud.database();
// 云函数入口函数
exports.main = async (event, context) => {
   console.log("enent打印："+event);

  var postId = event.postId;
  var count=event.commentSize;
  try {
    return await db.collection('postList').doc(postId).update({
      // data 传入需要局部更新的数据
      data: {
        // 表示将 done 字段置为 true
        commentSize: count
      }
    })
  } catch (e) {
    console.error(e)
  }
  
    // db.collection('postList').doc(postId).update({
    //   data:{
    //     commentSize:1
    //   },
    //   success:res =>{
    //     console.log("成功");
    //   },
    //   success:res =>{
    //     console.log("失败");
    //   }
    // })
    return postId;
}