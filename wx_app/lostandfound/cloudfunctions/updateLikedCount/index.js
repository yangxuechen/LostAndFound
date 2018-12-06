// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db = cloud.database();

// 云函数入口函数
exports.main = async (event, context) => {
  var commentId = event.commentId;
  var count = event.likedCount;
  try {
    return await db.collection('commentList').doc(commentId).update({
      // data 传入需要局部更新的数据
      data: {
        // 表示将 done 字段置为 true
        likedCount: count
      }
    })
  } catch (e) {
    console.error(e)
  }
}