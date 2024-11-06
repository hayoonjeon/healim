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
    <div class="top2">
        <div class="top2text">
            <h2>상담내역 관리</h2>
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
          <li style="background-color:;" onclick="location.href='/consultation';">상담내역</li>
          <li onclick="location.href='/freeboard';">자유게시판</li>
        </ul>

        <!-- 테이블 표 -->
        <form action="" method="post" >
	        <table>
	          <thead>
	            <tr>
	              <th><input type="checkbox" /></th>
	              <th>그룹</th>
	              <th>작성자</th>
	              <th>제목</th>
	              <th>생성일시</th>
	              
	              <th>부가기능</th>
	            </tr>
	          </thead>
	          <tbody>
	            <tr>
	              <td><input type="checkbox" /></td>
	              <td>상담내역</td>
	              <td>DragonCat007</td>
	              <td><a href="" class="notice_title">2024년 10월 추가 서버 점검 안내</a></td>
	              <td>2024-10-10 09:08:30</td>
	              
	              <td>
	              	<input type="button" value="답변" onclick="location.href='/counselor';">
					<input type="button" value="수정" onclick="">
					<input type="button" value="삭제" onclick="">
				  </td>	
	            </tr>
	          </tbody>
	        </table>
        </form>
        <form action="" method="post">
	        <div class="gray_bt">
	          <button style="margin-top: 10px;">선택 숨김</button>
	        </div>
        </form>
      </section>

            </div>
        </div>



    </div>



<!--푸터 --------------------------------------------------------------------------- -->


    <div class="footer"></div>

    </div>
    


</body>
</html>