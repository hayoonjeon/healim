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
            <h2> 회원 관리</h2>
        </div>   
   

    </div>
            <div class="searchsection">
                <!-- 검색창  /  빈 div 건드리지 마시오 -->
                <div></div>
                <div class="searchbox">
                    <!-- <input type="search">
                    <input type="submit" value="검색"> -->
                </div>           
            </div>
            <!-- 테이블 박스 -->
            <div class="tablebox">
                <form action="">
      <section>
         <div class="tableData">
        <table class="">
            <thead>
              <tr>
                <th rowspan="2"><input type="checkbox" name="allmember"></th>
                <th colspan="2">아이디</th>
                <th rowspan="2">본인확인</th>
                <th colspan="2">댓글</th>
                <th rowspan="2">신고횟수</th>
                <th>메일수신</th>
                <th>상태</th>
                <th>휴대폰</th>
                <th>최근접속</th>
                <th rowspan="2">관리</th>
              </tr>
              <tr>
                <th>이름</th>
                <th>닉네임</th>
                <th>게시물</th>
                <th>방문 수</th>
                <th>광고 차단</th>
                <th>권한</th>
                <th>전화번호</th>
                <th>가입일</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td rowspan="2"><input type="checkbox" name="member"></td>
                <td colspan="2" class="userId">donky</td>
                <td rowspan="2" class="verify">
                  <input type="checkbox" name="allmember">휴대폰
                </td>
                <td colspan="2" class="commentNumber">댓글</td>
                <td rowspan="2" class="reportNumber">신고횟수</td>
                <td><input type="checkbox" name="allmember"></td>
                <td>상태</td>
                <td>휴대폰</td>
                <td>최근접속</td>
                
                <td rowspan="2"><button class="last modify">수정</button><button class="delete">삭제</button></td>
              </tr>
              <tr>
                <td>이다빛</td>
                <td>davich</td>
                <td>게시물</td>
                <td>방문 수</td>
                <td><input type="checkbox" name="allmember"></td>
                <td>권한</td>
                <td>전화번호</td>
                <td>가입일</td>
              </tr>
            </tbody>
  
          </table>
         </div>
          <div class="buttons">
            <button class="selectdelete">선택삭제</button>
        </div>
      </section>
      </form>
                

            </div>
        </div>



    </div>



<!--푸터 --------------------------------------------------------------------------- -->


    <div class="footer"></div>

    </div>
    


</body>
</html>