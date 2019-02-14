package com.service.impl;

import java.util.List;

import com.dao.TopicDao;
import com.dao.impl.TopicDaoImpl;
import com.entity.Topic;
import com.service.TopicService;

public class TopicServiceImpl implements TopicService{
	TopicDao topicDao=new TopicDaoImpl();
	
	public List<Topic> topicList() {
		return topicDao.topicList();
	}

	public int addTopic(Topic topic) {
		return topicDao.addTopic(topic);
	}

	public Topic getTopic(int id) {
		return topicDao.getTopic(id);
	}

	public int updateTopic(Topic topic) {
		
		return topicDao.updateTopic(topic);
	}

	public int deleteTopic(int id) {
		
		return topicDao.deleteTopic(id);
	}

	public boolean getTopicName(String tname) {
		return topicDao.getTopicName(tname);
	}

	public boolean hasTid(int tid) {
		
		return topicDao.hasTid(tid);
	}

}
