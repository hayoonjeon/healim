package com.ict.healim.service;

import java.util.List;

import com.ict.healim.vo.MainBoardVO;
import com.ict.healim.vo.MemberVO;
import com.ict.healim.vo.SearchVO;

public interface MainBoardService {
	
	
	
		// 게시판 id로 정보(제목) 읽어오기 - mainBoard jsp페이지용 
		public List<MainBoardVO> getBbsList(SearchVO scvo,Integer limit);
		//게시물 id로 정보 받아오기 (list가 아닌 vo형식)
		public MainBoardVO getWrList(String wr_id, String bbs_id);
		//게시판 제목 알아오기
		public String getBbsName(String bbs_id);
		//게시물 작성
		public int setBoardVO(MainBoardVO boardVO);
		//게시물 수정
		public int updateBoardVO(MainBoardVO boardVO);
		//게시물 삭제
		public int deleteBoardVO(MainBoardVO boardVO);
		//댓글 작성
		public int setComment(MainBoardVO boardVO);
		//댓글 불러오기 (게시물불러올때  같이 진행될것)
		public List<MainBoardVO> getCommList(String wr_id);
		//답글달기위해서 parentid갖는 child(임의이름)list에서 가장 높은 sortordr 찾기
		public int getChildSelect(String parent_id);
		//게시판 아이디로 해당 게시판 게시물 갯수 알아내기
		public int getCountWrList(SearchVO sc);
		//조회수증가
		public int updateViewNum(String wr_id);
		//병원이름으로 병원아이디검색
		public int getH_Id(String h_name);
		//멤버검색
		public MemberVO getUserInfo(String mber_id);
		//병원아이디로 상담사례 게시물 검색
		public List<MainBoardVO> getHospitalConsult(String h_id);
		//상담사례가 답변완료인지 체크하기 
		public int getCountHospitalConsultReple(String wr_id);
		//상담사례까 있는지 없는지 체크하ㅣㄱ
		public int getCheckConsultReple(String h_id);
		//병원아이디로 후기 검색하기
		public List<MainBoardVO> getReview(String h_id);
		
		
		
		
		
}
