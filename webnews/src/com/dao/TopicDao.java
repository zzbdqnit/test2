package com.dao;

import java.util.List;

import com.entity.Topic;

public interface TopicDao {

	List<Topic> topicList();

	int addTopic(Topic topic);

	int updateTopic(Topic topic);

	Topic getTopic(int id);

	int deleteTopic(int id);

	boolean getTopicName(String tname);

	boolean hasTid(int tid);

}
