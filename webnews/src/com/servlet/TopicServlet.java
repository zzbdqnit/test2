package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Topic;
import com.service.TopicService;
import com.service.impl.TopicServiceImpl;

public class TopicServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		TopicService topicService=new TopicServiceImpl();
		
		String pro=request.getParameter("pro");
		if(pro==null){
			List<Topic> topicList=topicService.topicList();
			request.setAttribute("topicList", topicList);
			request.getRequestDispatcher("/topic/topicList.jsp").forward(request, response);
		}else{
			//���
			if(pro.equals("add")){
				String tname=request.getParameter("tname");
				Topic topic=new Topic();
				topic.setTname(tname);
				int result=topicService.addTopic(topic);
				if(result!=0){
					out.println("<script type='text/javascript'>alert('��ӳɹ���');location.href='../topic/TopicServlet';</script>");
				}
				else{
					out.println("<script type='text/javascript'>alert('���ʧ�ܣ�');location.href='../topic/addTopic.jsp';</script>");
				}
			}
			//��ѯ
			else if(pro.equals("get")){
				String id=request.getParameter("id");
				int tid=0;
				if(id!=null && id!=""){
					tid=Integer.parseInt(id);
				}
				Topic topic=topicService.getTopic(tid);
				request.setAttribute("topic", topic);
				request.getRequestDispatcher("/topic/getTopic.jsp").forward(request, response);
			}
			//�޸�
			else if(pro.equals("update")){
				String id=request.getParameter("id");
				String tname=request.getParameter("tname");
				int tid=0;
				if(id!=null && id!=""){
					tid=Integer.parseInt(id);
				}
				if(topicService.getTopicName(tname)){
					out.println("<script type='text/javascript'>alert('ͬ�����⣬�޸�ʧ�ܣ�');location.href='../topic/TopicServlet';</script>");
				}
				else{
					Topic topic=new Topic();
					topic.setTname(tname);
					topic.setTid(tid);
					int result=topicService.updateTopic(topic);
					if(result!=0){
						out.println("<script type='text/javascript'>alert('�޸ĳɹ���');location.href='../topic/TopicServlet';</script>");
					}
					else{
						out.println("<script type='text/javascript'>alert('�޸�ʧ�ܣ�');location.href='../topic/updateTopic.jsp';</script>");
					}
				}
				
			}
			//�����޸�ҳ�棬��ѯ������ʾ
			else if(pro.equals("toupdate")){
				String id=request.getParameter("id");
				int tid=0;
				if(id!=null && id!=""){
					tid=Integer.parseInt(id);
				}
				Topic topic=topicService.getTopic(tid);
				request.setAttribute("topic", topic);
				request.getRequestDispatcher("/topic/updateTopic.jsp").forward(request, response);
			}
			//ɾ��
			else {
				String id=request.getParameter("id");
				int tid=0;
				if(id!=null && id!=""){
					tid=Integer.parseInt(id);
				}
				
				if(topicService.hasTid(tid)){
					out.println("<script type='text/javascript'>alert('�������������ţ�ɾ��ʧ�ܣ�');location.href='../topic/TopicServlet';</script>");
				}else{
					int result=topicService.deleteTopic(tid);
					if(result!=0){
						out.println("<script type='text/javascript'>alert('ɾ���ɹ���');location.href='../topic/TopicServlet';</script>");
					}
					else{
						out.println("<script type='text/javascript'>alert('ɾ��ʧ�ܣ�');location.href='../topic/TopicServlet';</script>");
					}
				}
				
				
			}
			
		}
	}

}
