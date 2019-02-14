package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.TopicDao;
import com.entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {
	ResultSet rs=null;
	public List<Topic> topicList() {
		String sql="select * from topic";
		rs=this.executeQuery(sql);
		List<Topic> topicList=new ArrayList<Topic>();
		try {
			while(rs.next()){
				Topic topic=new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
				topicList.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, null, rs);
		}
		return topicList;
	}

	public int addTopic(Topic topic) {
		String sql="INSERT INTO `topic` (`tname`) VALUES (?)";
		
		return this.executeUpdate(sql, topic.getTname());
	}

	public int updateTopic(Topic topic) {
		String sql="UPDATE `topic` SET `tname`=? WHERE `tid`=?";
		return this.executeUpdate(sql, topic.getTname(),topic.getTid());
	}

	public Topic getTopic(int id) {
		String sql="select * from topic where tid=?";
		rs=this.executeQuery(sql,id);
		Topic topic=null;
		try {
			while(rs.next()){
				topic=new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, null, rs);
		}
		return topic;
	}

	public int deleteTopic(int id) {
		String sql="delete from `topic` WHERE `tid`=?";
		return this.executeUpdate(sql,id);
	}

	public boolean getTopicName(String tname) {
		String sql="select * from topic where tname=?";
		rs=this.executeQuery(sql,tname);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, null, rs);
		}
		return false;
	}

	public boolean hasTid(int tid) {
		String sql="select * from news where ntid=?";
		rs=this.executeQuery(sql,tid);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, null, rs);
		}
		return false;
	}

}
