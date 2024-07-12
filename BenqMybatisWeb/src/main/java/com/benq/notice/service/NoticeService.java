package com.benq.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.benq.common.SqlSessionTemplate;
import com.benq.notice.model.dao.NoticeDAO;
import com.benq.notice.model.vo.Notice;

public class NoticeService {

	private SqlSession session;
	private NoticeDAO nDao;
	
	public NoticeService() {
		session = SqlSessionTemplate.getSqlSession();
		nDao = new NoticeDAO();
	}
	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(session, notice);
		return result;
	}
	public List<Notice> selectAllNotice() {
		List<Notice> nList = nDao.selectList(session);
		return nList;
	}

}
