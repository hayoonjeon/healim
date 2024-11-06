package com.ict.healim.service;

import com.ict.healim.vo.JoinVO;

public interface JoinService {
	//회원가입
	public int join(JoinVO jvo);
	
	// 이메일 중복여부 확인
	public boolean isEmailAvailable(String mberId);
	
	// 마이페이지 정보보기
	public JoinVO getMyPage(String mberid);
	
	// 마이페이지 수정
	public int MyPageUpdate(JoinVO jvo);
	
	// 회원가입 로그 저장
	public int joinLog(JoinVO jvo);
}
