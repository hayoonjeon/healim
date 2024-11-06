package com.ict.healim.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.healim.service.MainBoardService;
import com.ict.healim.vo.MainBoardPagingVO;
import com.ict.healim.vo.MainBoardVO;
import com.ict.healim.vo.MemberVO;
import com.ict.healim.vo.SearchVO;
import com.ict.healim.vo.SessionUserVO;

@Controller
public class MainBoardController {
	@Autowired
	private MainBoardService mainBoardService;
	


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

//메인보드의 메인페이지... 제목 3개만 보이게 임시설정해둠
	@RequestMapping("/mainBoard")
	public ModelAndView mainBoard(Model model,SearchVO scvo) {
		ModelAndView mv = new ModelAndView("mainBoard/mainBoard");
		
		int limit = 5;
		
		
		
		scvo.setBbs_id("NOTI");
		List<MainBoardVO> list1 = mainBoardService.getBbsList(scvo, limit);
		scvo.setBbs_id("INQU");
		List<MainBoardVO> list2 = mainBoardService.getBbsList(scvo, limit);
		scvo.setBbs_id("CONS");
		List<MainBoardVO> list3 = mainBoardService.getBbsList(scvo, limit);
		scvo.setBbs_id("FREE");	
		List<MainBoardVO> list4 = mainBoardService.getBbsList(scvo, limit);

		mv.addObject("list1", list1);
		mv.addObject("list2", list2);
		mv.addObject("list3", list3);
		mv.addObject("list4", list4);

		return mv;
	}

	@RequestMapping("/boardListAll")
	public ModelAndView getBoardList(@RequestParam("bbs_id") String bbs_id, SearchVO sc) {
		ModelAndView mv = new ModelAndView("mainBoard/boardListAll");
		String bbsName = mainBoardService.getBbsName(bbs_id);
		
		sc.setBbs_id(bbs_id);
		
		//페이지 용 전체 게시물 갯수 구하기(활성화, 댓글 x , 답글포함)
		int totalCnt = mainBoardService.getCountWrList(sc);
		//혹시모르니 totalcnt 넣어두기(검색 총 몇 건 용..?)
		mv.addObject("totalCnt", totalCnt);
		
		MainBoardPagingVO pgvo = new MainBoardPagingVO(totalCnt,sc);
		List<MainBoardVO> list = mainBoardService.getBbsList(sc, null);
		System.out.println("sc 페이지사이즈 : "+sc.getPageSize());
		System.out.println("sc 옵셋 : "+sc.getOffset());
		System.out.println("sc 키워드 : "+sc.getKeyword());
			
		
		mv.addObject("pg", pgvo);
		mv.addObject("sc", sc);
		mv.addObject("list", list);
		mv.addObject("bbsName", bbsName);
		mv.addObject("bbs_id", bbs_id);
		System.out.println("boardListAll bbsid 확인" + bbs_id);

		return mv;
	}

	@RequestMapping("/boardOneList")
	public ModelAndView boardOneList(HttpServletRequest request,HttpSession session) {
		String wr_id = request.getParameter("wr_id"); //댓글기준에서는 parentid
		String bbs_id = request.getParameter("bbs_id");

		ModelAndView mv = new ModelAndView("mainBoard/boardOneList");
		
		//조회수 증가시키기
		 mainBoardService.updateViewNum(wr_id);
		

		System.out.println("wrid,bbsid 확인(boardOneList) :" + wr_id + "," + bbs_id);
		
		try {
			//세션 vo 사용하기 ( 글삭제,수정버튼 등 용도)
			SessionUserVO suvo = (SessionUserVO) session.getAttribute("sessionUser");
			String sessionUserId = (suvo != null) ? suvo.getUser_id() : null;
			
			String mber_nm = null;
			 if (sessionUserId != null) {
		            // 세션 ID를 이용해 사용자 정보를 가져옴 (댓글용 닉네임 등)
					//세션아이디로 세션 닉네임 주기 ( 댓글용)
		            MemberVO mbvo = mainBoardService.getUserInfo(sessionUserId);
		    		/* String password = mbvo.getPassword(); */
		        	mber_nm = mbvo.getMber_nm();
		        } else {
		            System.out.println("로그인 정보가 없습니다.");
		        }
			
	
	
		
		 	// 상세보기
				MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id);
				//댓글도 불러오기
				List<MainBoardVO> list = mainBoardService.getCommList(wr_id); //원글 wr_id를  parent_id로 갖는 '댓글' 검색.
				
				mv.addObject("list", list);

				mv.addObject("mvo", mvo);
				mv.addObject("sessionUserId", sessionUserId);
				mv.addObject("mber_nm", mber_nm);

				return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("mainBoard/boardError");
		
	}

	@RequestMapping("/boardOneListWrite")
	public ModelAndView boardOneListWrite(@RequestParam("bbs_id") String bbs_id,HttpSession session) {
		ModelAndView mv = new ModelAndView("mainBoard/writePage");
		
		//세션 vo 사용하기 ( 글삭제,수정버튼 등 용도)
		SessionUserVO suvo = (SessionUserVO) session.getAttribute("sessionUser");
		String sessionUserId = (suvo != null) ? suvo.getUser_id() : null;
		
		
		mv.addObject("bbs_id", bbs_id);
		mv.addObject("sessionUserId", sessionUserId);
		
		if (sessionUserId == null) {
			return new ModelAndView("login&join/login");
		}
		
		System.out.println("/boardOneListWrite에서 bbs_id 전달됨: " + bbs_id);
		return mv;
		
		
	
		
	}

	@RequestMapping("/boardOneListWriteOK")
	public ModelAndView boardOneListWriteOK(MainBoardVO mvo, HttpServletRequest request) {
		String bbs_id = request.getParameter("bbs_id");
		String mber_id = request.getParameter("mber_id");
		String parent_id = request.getParameter("parent_id");
		String sort_ordr = request.getParameter("sort_ordr");
		//병원이름 검색한거로 병원 id 검색하기
		String h_name = request.getParameter("h_name");
		int h_id = mainBoardService.getH_Id(h_name);
		
		mvo.setH_id(h_id != 0 ? h_id : 0); // h_id가 없을 경우 빈 문자열 설정
		 
		
		
		
		
		
		
		try {
			ModelAndView mv = new ModelAndView("redirect:/boardListAll");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			

			
			
			
			
			MultipartFile file = mvo.getFile_name();
			if (file.isEmpty()) {
				mvo.setAtch_file_id("");
			} else {
				UUID uuid = UUID.randomUUID();
				String atch_file_id = uuid.toString() + "_" + file.getOriginalFilename();
				mvo.setAtch_file_id(atch_file_id);

				// 업로드
				file.transferTo(new File(path,atch_file_id));
			}

			System.out.println("writeOK전용체크"+bbs_id+parent_id+sort_ordr);
			mv.addObject("bbs_id", bbs_id);  //리다이렉트용
			mv.addObject("parent_id", parent_id); //리다이렉트용
			
			//mber_id로  패스워드, 비번 따내기.
			MemberVO mbvo = mainBoardService.getUserInfo(mber_id);
			
			String password = mbvo.getPassword();
			String mber_nm = mbvo.getMber_nm();
			
			mvo.setMber_nm(mber_nm);
			mvo.setPassword(password);
			
			
			
			int result = mainBoardService.setBoardVO(mvo);
			if (result > 0) {

				return mv;
			}

			return new ModelAndView("mainboard/boardError");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("mainboard/boardError");
		}
	}

	// 이미지저장 등
	@RequestMapping(value = "/boardSaveImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(@RequestParam("s_file") MultipartFile file, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			String fname = null;
			if (file.getSize() > 0) {
				String path = request.getSession().getServletContext().getRealPath("/resources/upload");
				UUID uuid = UUID.randomUUID();
				fname = uuid.toString() + "_" + file.getOriginalFilename();
				// 업로드
				file.transferTo(new File(path, fname));
			}

			map.put("path", "resources/upload");
			map.put("fname", fname);
			return map;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/boardDownloadFile")
	public void fileDown(HttpServletRequest request, HttpServletResponse response) {
		try {
			String f_name = request.getParameter("atch_file_id");
			System.out.println(f_name);
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + f_name);
			String r_path = URLEncoder.encode(path, "UTF-8");

			String tname = f_name.substring(f_name.indexOf("_") + 1, f_name.length());
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + tname);

			// 실제 가져오기
			File file = new File(new String(path.getBytes(), "UTF-8"));
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();

			FileCopyUtils.copy(in, out);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 업데이트페이지 이동
	@RequestMapping("/boardOneListUpdate")
	public ModelAndView boardOneListUpdate(@ModelAttribute("wr_id") String wr_id,
			@ModelAttribute("bbs_id") String bbs_id) {
		ModelAndView mv = new ModelAndView("mainBoard/updatePage");
		// DB 에서 b_idx를 이용해서 정보 가져오기. 전에 만들었던 getWr 그대로 사용. 실제 수정은 UpdateOK에서 진행
		MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id);
		if (mvo != null) {
			mv.addObject("mvo", mvo);
			System.out.println("wrid 확인 : " + wr_id);
			System.out.println("bbsid 확인 :" + bbs_id);
			return mv;
		}

		return null;
	}

	// 실제 업데이트 하는 곳
	@PostMapping("/boardOneListUpdateOK")
	public ModelAndView boardOneListUpdateOK(MainBoardVO mvo, HttpServletRequest request) {
		String bbs_id = request.getParameter("bbs_id");
		String wr_id = request.getParameter("wr_id");
		ModelAndView mv = new ModelAndView("redirect:/boardOneList");

		/*
		 * 비밀번호 체크 BbsVO bvo2 = bbsService.getBbsDetail(b_idx); String dbpassword  =
		 * bvo2.getpassword (); if (passwordEncoder.matches(bvo.getpassword (), dbpassword )) {
		 */
		// 원글 수정
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = mvo.getFile_name();
			String old_atch_file = mvo.getOld_atch_file_id();

			if (file.isEmpty()) {
				mvo.setAtch_file_id(old_atch_file);
			} else {
				UUID uuid = UUID.randomUUID();
				String atch_file_id = uuid.toString() + "_" + file.getOriginalFilename();
				mvo.setAtch_file_id(atch_file_id);

				// 실제업로드
				file.transferTo(new File(path, atch_file_id));
			}
			// 리다이렉트용 게시판id, 글id 주기
			mv.addObject("bbs_id", bbs_id);
			mv.addObject("wr_id", wr_id);

			int result = mainBoardService.updateBoardVO(mvo); 
			if (result > 0) {
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * } else { // 비밀번호가 틀리다. mv.setViewName("bbs/update"); mv.addObject("password chk",
		 * "fail"); mv.addObject("bvo", bvo); return mv; }
		 */

		return new ModelAndView("mainBoard/error");

	}

	// 삭제페이지 이동
	@RequestMapping("/boardOneListDelete")
	public ModelAndView boardOneListDelete(HttpServletRequest request) {

		String wr_id = request.getParameter("wr_id");
		String bbs_id = request.getParameter("bbs_id");

		ModelAndView mv = new ModelAndView("mainBoard/deletePage");
		MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id);
		mv.addObject("mvo", mvo);

		return mv;
	}

	@RequestMapping("/boardOneListDeleteOk")
	public ModelAndView boardOneListDeleteOk(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String wr_id = request.getParameter("wr_id");
		String bbs_id = request.getParameter("bbs_id");
		// 삭제창에서 입력한 비밀번호값 받아오기.
		String passwordInput = request.getParameter("passwordInput");
		// 글제목, 게시판제목으로 글 검색
		MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id);
		// 게시물의 사용자 패스워드 DB에서 뽑아내옴
		System.out.println(wr_id);
		System.out.println(bbs_id);
		String password  = mvo.getPassword();
		System.out.println(password);
		// 비밀번호 체크
		if (password .matches(passwordInput)) {//passwordEncoder.matches(password , passwordInput)  아직 암호화 테스트안해봄. 회원정보없어서..
			// 맞으면 삭제 진행.
			int result = mainBoardService.deleteBoardVO(mvo);
			if (result > 0) {
				mv.setViewName("redirect:/boardListAll");
				mv.addObject("bbs_id",bbs_id);
				return mv;
			}
		} else {
			// 비밀번호가 틀리다.
			mv.setViewName("mainBoard/deletePage");
			mv.addObject("passwordchk", "fail");
			mv.addObject("mvo", mvo); //재시도할떄도 password  비교해야함
			return mv;
		}

		return new ModelAndView("mainBoard/boardError");
	}

	
	@RequestMapping("/comment_insert")
	public ModelAndView comment_insert(MainBoardVO mvo,HttpServletRequest request, HttpSession session) {
		//리다이렉트할 페이지 우선 정함.
		ModelAndView mv = new ModelAndView("redirect:/boardOneList");
		String parent_id = request.getParameter("parent_id"); //부모글의 wr_id 리다이렉트용. 여기서 wr_id= 부모글 id.
		String bbs_id = request.getParameter("bbs_id"); //부모글의 게시판. bbs_id 리다이렉트용
		//세션아이디로 계정의 비밀번호, 유저네임 필요함.
		String mber_id = request.getParameter("mber_id");
	
		
		
		//멤버에서 아이디로 유저네임, 비밀번호 검색
		try {
			MemberVO mbvo = mainBoardService.getUserInfo(mber_id);
			
			String password = mbvo.getPassword();
			String mber_nm = mbvo.getMber_nm();
			
			System.out.println("commentinsert에서 redirect boardonelist 확인용 "+parent_id+bbs_id); //리다이렉트 확인용
			
			//mvo에  setComment를 위해서 넣어야함 
			mvo.setMber_nm(mber_nm);
			mvo.setPassword(password);
			
			int result = mainBoardService.setComment(mvo); // 댓글넣기. 공통 명령어씀 
			mv.addObject("bbs_id", bbs_id);		//리다이렉트용
			mv.addObject("wr_id", parent_id);	//주의-리다이렉트용. parent_id는 원글의 wr_id다.
		
	            return mv;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("login&join/login");
	
		
		
		
	
	}
	
	@RequestMapping("/comment_delete")
	public ModelAndView comment_delete(HttpServletRequest request) {

		String wr_id = request.getParameter("wr_id");
		String bbs_id = request.getParameter("bbs_id");

		ModelAndView mv = new ModelAndView("mainBoard/commentDeletePage");
		MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id);
		mv.addObject("mvo", mvo);

		return mv;
	}
	@RequestMapping("/comment_deleteOk")
	public ModelAndView comment_deleteOk(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String parent_id = request.getParameter("parent_id"); //댓글의 원게시물 게시물아이디
		String wr_id = request.getParameter("wr_id"); //댓글 게시물아이디
		String bbs_id = request.getParameter("bbs_id"); // 댓글게시판아이디
		// 삭제창에서 입력한 비밀번호값 받아오기.
		String passwordInput = request.getParameter("passwordInput");
		// 글제목, 게시판제목으로 글관련 mvo 검색
		MainBoardVO mvo = mainBoardService.getWrList(wr_id, bbs_id); //댓글삭제시 댓글비교용으로 db 갓다옴.
		// 게시물의 사용자 패스워드 DB에서 뽑아내옴
		System.out.println("댓글삭제용"+wr_id);
		System.out.println("댓글삭제용"+bbs_id);
		String password  = mvo.getPassword(); //댓글비교용 db의 pw. 
		// 비밀번호 체크
		if (passwordEncoder.matches(passwordInput,password )) {
			// 맞으면 삭제 진행.
			int result = mainBoardService.deleteBoardVO(mvo);
			if (result > 0) {
				mv.setViewName("redirect:/boardOneList");
				mv.addObject("bbs_id",bbs_id);
				mv.addObject("wr_id",parent_id);  //삭제되었으면 원 게시물로 이동해야함.
				return mv;
			}
		} else {
			// 비밀번호가 틀리다.
			System.out.println("댓글삭제실패용parent_id"+parent_id);
			System.out.println("댓글삭제실패용wr_id"+wr_id);
			System.out.println("댓글삭제실패용bbs_id"+bbs_id);
			mv.setViewName("mainBoard/commentDeletePage");
			mv.addObject("password chk", "fail");
			mv.addObject("mvo", mvo); //재시도할떄도 password  비교해야함
			return mv;
		}

		return new ModelAndView("mainBoard/boardError");
	}
	
	@RequestMapping("/boardOneListWrite2")
	public ModelAndView boardOneListWrite2(HttpServletRequest request,HttpSession session) {
		String parent_id = request.getParameter("parent_id");
		String bbs_id = request.getParameter("bbs_id");
		//페이지불러오기 
		ModelAndView mv = new ModelAndView("mainBoard/writePage2");
		
		//세션에서 아이디검색하고, 저장해야함
		//세션 vo 사용하기 ( 글삭제,수정버튼 등 용도)
		SessionUserVO suvo = (SessionUserVO) session.getAttribute("sessionUser");
		String sessionUserId = (suvo != null) ? suvo.getUser_id() : null;
		
		// 세션 아이디가 없으면 로그인 페이지로 리다이렉트
	    if (sessionUserId == null) {
	        return new ModelAndView("login&join/login");  // 로그인 페이지 URL에 맞게 수정
	    }
		
		
		//세션아이디로 세션 닉네임 주기 ( 댓글용)
		MemberVO mbvo;
		try {
			mbvo = mainBoardService.getUserInfo(sessionUserId);
			/* String password = mbvo.getPassword(); */
			String mber_nm = mbvo.getMber_nm();
			
			
			//parent_id를 갖는 글 검색해서 가장높은 sortordr 검색하기(나중에추가하기)
			Integer maxSort_ordr= mainBoardService.getChildSelect(parent_id); //null이 될수도 있기때문에 Integer 쓴다 
			int sort_ordr = (maxSort_ordr == null ? 1 : maxSort_ordr + 1);

			
			
			
			//부모글 bbs id wrid  주기 ... 
			mv.addObject("sessionUserId", sessionUserId);
			mv.addObject("bbs_id", bbs_id);
			mv.addObject("parent_id", parent_id);
			mv.addObject("sort_ordr", sort_ordr);
			System.out.println("write2전용maxSort_ordr"+maxSort_ordr);
			System.out.println("write2전용bbsid"+bbs_id);
			System.out.println("write2전용parent_id"+parent_id);
			System.out.println("write2전용sort_ordr"+sort_ordr);
			
			
			//기존 답글들 1씩  update 하기 
			
			
			
			
			
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("mainBoard/boardError");
	}

	
}