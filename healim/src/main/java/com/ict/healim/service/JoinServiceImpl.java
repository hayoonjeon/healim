package com.ict.healim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.healim.dao.JoinDAO;
import com.ict.healim.vo.JoinVO;

@Service
public class JoinServiceImpl implements JoinService{
	
	@Autowired
	private JoinDAO joinDAO;
	
	
	// 회원가입
	@Override
	public int join(JoinVO jvo) {
		// 하이픈 제거하고 데이터베이스에 입력
		String dbPassword = jvo.getMbtlnum();
		dbPassword = dbPassword.replaceAll("-", "");
		jvo.setMbtlnum(dbPassword);
		return joinDAO.join(jvo);
	}
	// 이메일 중복여부
	@Override
	public boolean isEmailAvailable(String mberId) {
		// TODO Auto-generated method stub
		return joinDAO.countByEmail(mberId) == 0;
	}
	
	// 핸드폰 번호에 하이픈을 추가하는 메서드
    private String formatMbtlnum(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            return phoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        } else if (phoneNumber.length() == 11) {
            return phoneNumber.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
        }
        return phoneNumber;
    }
    
    
	
 // 마이페이지 정보보기
	@Override
	public JoinVO getMyPage(String mberid) {
		JoinVO jvo = joinDAO.getMyPage(mberid);
		// 핸드폰 번호에 하이픈을 추가하여 설정
        String mbtlnum = formatMbtlnum(jvo.getMbtlnum());
        jvo.setMbtlnum(mbtlnum);
        return jvo;
	}
	
	// 마이페이지 변경사항 수정
	@Override
	public int MyPageUpdate(JoinVO jvo) {
		// 하이픈 제거하고 데이터베이스에 입력
		String dbPassword = jvo.getMbtlnum();
		dbPassword = dbPassword.replaceAll("-", "");
		jvo.setMbtlnum(dbPassword);
		return joinDAO.MyPageUpdate(jvo);
	}
	@Override
	public int joinLog(JoinVO jvo) {
		return joinDAO.joinLog(jvo);
	}
	

	

}
