package com.service;

import java.util.List;

import com.entity.Topic;

public interface TopicService {
	List<Topic> topicList();
	int addTopic(Topic topic);
	Topic getTopic(int id);
	int updateTopic(Topic topic);
	int deleteTopic(int id);
	boolean getTopicName(String tname);
	boolean hasTid(int tid);
	
}
