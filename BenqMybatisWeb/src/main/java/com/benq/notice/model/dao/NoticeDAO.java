package com.benq.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.benq.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectList(SqlSession session) {
		List<Notice> nList = session.selectList("NoticeMapper.selectList");
		return nList;
	}

}
