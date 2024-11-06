<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <link href="/resources/css/admin.css" rel="stylesheet" />
</head>



<body>
    <!--탑1 --------------------------------------------------------------------------- -->
    <div class="page">
    <div class="top1">
        <div><img class="bt_header" href="#" src="/resources/img/admin_img/logo.png" alt="header" /></div>        
        <div class="administrator">ADMINISTRATOR</div>
        <div class="gohome">
	        <div></div>
	        <div class="house">
		        <a href="/home">
			        <img class="houseimg" src="/resources/img/admin_img/check_img.svg">
			        <button class="homepagebutton"  style="cursor: pointer;">홈페이지</button>
		        </a>
	        </div>
	        <div class="logoutbox">
		        <a href="/login">
			        <img class="houseimg" src="/resources/img/admin_img/right-from-bracket-solid.svg">
			        <button class="logoutbutton" style="cursor: pointer;">로그아웃</button>
		        </a>
	        </div>
        </div>
    </div>
    
<!--탑2 --------------------------------------------------------------------------- -->



    <div class="main">
        
<!-- 네비게이션--------------------------------------------------------------------------- -->
        <div class="nav">
            <ul class="nav_button">
                <li><a href="/index"><img class="nav_img" src="/resources/img/admin_img/button-0.svg"
                      alt="메인페이지 " /></a></li>
                <li><a href="/member"><img class="nav_img" src="/resources/img/admin_img/button-1.svg"
                      alt="회원관리" /></a></li>
                <li><a href="/admin_board"><img class="nav_img" src="/resources/img/admin_img/button-2.svg"
                      alt="게시판 관리" /></a></li>
                <li><a href="/hospital_info"><img class="nav_img" src="/resources/img/admin_img/button-3.svg"
                      alt="병원정보수정" /></a></li>
                <li><a href="/admin"><img class="nav_img" src="/resources/img/admin_img/button-4.svg"
                      alt="관리자관리" /></a></li>
             </ul>

        </div>


<!-- 메인 테이블--------------------------------------------------------------------------- -->
<div class="content">
        <!-- 타이틀 -->
    <div class="top2">
        <div class="top2text">
            <h2>게시판 관리 </h2>
        </div>   
   

    </div>
            <div class="searchsection">
                <!-- 검색창  /  빈 div 건드리지 마시오 -->
                <div></div>
                <div class="searchbox">
                    <input type="search">
                    <input type="submit" value="검색">
                </div>           
            </div>
            <!-- 테이블 박스 -->
            <div class="tablebox">
                <section style="margin-bottom: 80px">
        <!-- 탭 메뉴 -->
        <ul class="menu">
          <li onclick="location.href='/admin_board';">전체</li>
          <li onclick="location.href='/notice';">공지사항</li>
          <li onclick="location.href='/questions';">문의사항</li>
          <li onclick="location.href='/consultation';">상담내역</li>
          <li onclick="location.href='/freeboard';">자유게시판</li>
        </ul>

        <!-- 테이블 표 -->
        <table>
          <thead>
            <tr>
              <th><input type="checkbox" /></th>
              <th>그룹</th>
              <th>작성자</th>
              <th>제목</th>
              <th>생성일시</th>
              <th>SNS 사용</th>
              <th>검색 사용</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>DragonCat007</td>
              <td>2024년 10월 추가 서버 점검 안내</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin01</td>
              <td>2024년 10월 서버 점검 안내</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>문의사항</td>
              <td>kingofkingsman</td>
              <td>A 모양함의 의료 정보가 최신화된 정보인지 궁금합니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>qwer0808</td>
              <td>-- 긴급공지 --</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin03</td>
              <td>상담 문의 드립니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>qwer0808</td>
              <td>상담 문의 드립니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin02</td>
              <td>-- 안내사항 --</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
          </tbody>
        </table>
        <div class="button_wrap">
          <button class="gray_bt">선택숨김</button>
        </div>
      </section>

      <section>
        <h2 style="margin: 5px">숨김 내역</h2>
        <table>
          <thead>
            <tr>
              <th><input type="checkbox" /></th>
              <th>그룹</th>
              <th>작성자</th>
              <th>제목</th>
              <th>삭제일시</th>
              <th>SNS 사용</th>
              <th>검색 사용</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>DragonCat007</td>
              <td>2024년 10월 추가 서버 점검 안내</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin01</td>
              <td>2024년 10월 서버 점검 안내</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>문의사항</td>
              <td>kingofkingsman</td>
              <td>A 모양함의 의료 정보가 최신화된 정보인지 궁금합니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>qwer0808</td>
              <td>-- 긴급공지 --</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin03</td>
              <td>상담 문의 드립니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>상담내역</td>
              <td>qwer0808</td>
              <td>상담 문의 드립니다.</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
            <tr>
              <td><input type="checkbox" /></td>
              <td>공지사항</td>
              <td>Admin02</td>
              <td>-- 안내사항 --</td>
              <td>2024-10-10 09:08:30</td>
              <td><input type="checkbox" checked /></td>
              <td><input type="checkbox" checked /></td>
            </tr>
          </tbody>
        </table>
        <div class="button_wrap">
          <button class="blue_bt">선택복구</button>
          <button class="gray_bt">선택숨김</button>
        </div>
      </section>


            </div>
        </div>



    </div>



<!--푸터 --------------------------------------------------------------------------- -->


    <div class="footer"></div>

    </div>
    


</body>
</html>