package edu.njxz.found.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.njxz.found.dao.CategoryDao;
import edu.njxz.found.dao.MessageDao;
import edu.njxz.found.dao.UserDao;
import edu.njxz.found.entity.Category;
import edu.njxz.found.entity.Message;
import edu.njxz.found.entity.User;
import edu.njxz.found.entity.vo.Post;
import edu.njxz.found.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
        messageDao.insert(message);
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
        messageDao.updateMessage(message);
	}

	@Override
	public List<Message> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return messageDao.findByUserId(userId);
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageDao.findAll();
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		List<Message> messageList=this.findAll();
		List<Post> postList=new LinkedList<Post>();
		for(Message m:messageList) {
			User user=userDao.findUserById(Integer.parseInt(m.getMessageUserid()));
		//	System.out.println(user.getUserName());
			Category category=categoryDao.findById(m.getMessageCategotyid());
		//	System.out.println(category.getCategoryName());
			Post post=new Post();
			
			//设置属性
			post.setMessageId(m.getMessageId());
			post.setMessageDescription(m.getMessageDescription());
			post.setUser(user);
			post.setCategory(category);
			post.setMessagePhoto(m.getMessagePhoto());
			
			  //将时间转化成yyyy-MM-dd格式的字符串
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        String str=sdf.format(m.getMessageDate());
			post.setMessageDate(str);
			postList.add(post);
			
		}
		return postList;
	}

	@Override
	public String savePhoto(File upload) {
		// TODO Auto-generated method stub
		//生成随机字符串
		String sources="2549hgtflkjadsf89nbvcMNBVCxZwe5989iuytFFJHGfDASwERtrty";
		Random random=new Random();
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<5;i++) {
			stringBuilder.append(sources.charAt(random.nextInt(sources.length()))+"");
		}
		String str=stringBuilder.toString();
		////D:\\JavaWeb\\eclipse\\workspace\\lostandfoundSSH3\\WebContent\\images
		String path="D:\\JavaWeb\\eclipse\\workspace\\lostandfoundSSH3\\WebContent\\images\\"+str+".jpg";
	//	String path="C:\\Users\\yangxuechen\\Desktop\\myLove.jpg";
        //2.保存照片
        File file=new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return "0";
            }
        }
        if(upload==null) {
        	System.out.println("upload is null");
        }
        if(!file.exists()) {
        	System.out.println("file is null");
        }
        try{
            FileUtils.copyFile(upload,file);
        }catch (IOException e){
            e.printStackTrace();
            return "0";
        }
        return str+".jpg";
	}

	@Override
	public List<Post> findAllPostByUserId(int id) {
		// TODO Auto-generated method stub
		List<Message> messageList=this.findByUserId(id);
		List<Post> postList=new LinkedList<Post>();
		for(Message m:messageList) {
			User user=userDao.findUserById(Integer.parseInt(m.getMessageUserid()));
		//	System.out.println(user.getUserName());
			Category category=categoryDao.findById(m.getMessageCategotyid());
		//	System.out.println(category.getCategoryName());
			Post post=new Post();
			
			//设置属性
			post.setMessageId(m.getMessageId());
			post.setMessageDescription(m.getMessageDescription());
			post.setUser(user);
			post.setCategory(category);
			post.setMessagePhoto(m.getMessagePhoto());
			
			  //将时间转化成yyyy-MM-dd格式的字符串
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        String str=sdf.format(m.getMessageDate());
			post.setMessageDate(str);
			postList.add(post);
			
		}
		return postList;
	}

}
