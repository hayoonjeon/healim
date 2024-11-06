package com.ict.healim.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.healim.vo.JoinVO;
@Repository
public class JoinDAOImpl implements JoinDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 회원가입
	@Override
	public int join(JoinVO jvo) {
		return sqlSessionTemplate.insert("member.join", jvo);
	}
	// 이메일 중복여부 체크
	@Override
	public int countByEmail(String mberId) {
		return sqlSessionTemplate.selectOne("member.countByEmail", mberId);
	}
	// 마이페이지 정보보기
	@Override
	public JoinVO getMyPage(String mberid) {
		return sqlSessionTemplate.selectOne("member.myPage", mberid);
	}
	// 마이페이지 변경사항 저장
	@Override
	public int MyPageUpdate(JoinVO jvo) {
		return sqlSessionTemplate.update("member.update", jvo);
	}
	
	@Override
	public int joinLog(JoinVO jvo) {
		return sqlSessionTemplate.insert("member.logInsert", jvo);
	}
	
	
	
	
}
