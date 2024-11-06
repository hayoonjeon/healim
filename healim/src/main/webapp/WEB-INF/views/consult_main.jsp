<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담 목록</title>
<style type="text/css">

  .topper {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px; /* 로고의 상단 여백 조정 */
    }

    .topper img {
        width: 300px; /* 로고 크기를 원하는 크기로 조정 */
        height: auto;
    }

* {
	box-sizing: border-box;
	
}

body {
	width: 80%;
	background-color: #e7f1ff;
	margin: 0 auto;
	padding: 0;
}

.container {

	width: 70%;
	margin: 0 auto;
	background-color: #fff;
	margin-top: 10px;
	border-radius: 20px;
}

.question {
	font-size: 16px;
	font-weight: bold;
	color: #333;
	margin-bottom: 10px;
	cursor: pointer;

}

.answer {
	font-size: 14px;
	color: #007bff;
	margin-bottom: 15px;
}

.answer span {
	color: #888;
}

.question-box {
	margin-bottom: 20px;
	border-bottom: 1px solid #e0e0e0;
	padding-bottom: 10px;
	padding:30px;
}

.content-area {
	margin-top: 10px;
	display: none;
}

   /* 플로팅 네비게이션 스타일 */
    .floating-nav {
      position: fixed;
      top: 50%;
      left: 20px;
      transform: translateY(-50%);
      width: 80px;
      background-color: #fff;
      border-radius: 15px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 10px;
      text-align: center;
      opacity: 0.8;
    }

    .floating-nav ul {
      list-style-type: none;
      padding: 0;
    }

    .floating-nav li {
      margin: 30px 0;
      text-align: center;
    }

    .floating-nav img {
      width: 40px;
      height: 40px;
      display: block;
      margin: 0 auto 10px;
    }

    .floating-nav a {
      text-decoration: none;
      color: #000;
      font-size: 14px;
      display: block;
      text-align: center;
    }

    .floating-nav a:hover {
      text-decoration: underline;
    }



</style>
</head>
<body>
<div class="topper">
<h1><a href="/home"><img src="/resources/img/main.png"></a></h1>

	<nav class="floating-nav">
  <ul>
    <li>
      <img src="/resources/img/hom4.jpg" alt="홈 이미지">
      <a href="/home">홈</a>
    </li>
    <li>
      <img src="/resources/img/sangdam.jpg" alt="상담 사례 이미지">
      <a href="/consult_main">상담<br>사례</a>
    </li>
    <li>
      <img src="/resources/img/sisul.jpg" alt="시설 찾기 이미지">
      <a href="/region_selected">시설<br>찾기</a>
    </li>
    <li>
      <img src="/resources/img/my.jpg" alt="마이 페이지 이미지">
      <a href="/myPage">마이<br>페이지</a>
    </li>
  </ul>
</nav>


</div>


	<div class="container">
		<div class="question-box" onclick="toggleDetail(this, '1')">
			<div class="question">입원 가능 여부 문의드립니다</div>
			<div class="answer">답변완료 · <span>8일 전 상담</span><span>(김포종합병원)</span></div>
			<div class="content-area"></div>
		</div>
	</div>

	<div class="container">
		<div class="question-box" onclick="toggleDetail(this, '2')">
			<div class="question">병실 예약이 가능한가요?</div>
			<div class="answer">답변완료 · <span>5일 전 상담</span><span>(수원병원)</span></div>
			<div class="content-area"></div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		// 질문 클릭 시 상세 내용을 토글하는 함수
		function toggleDetail(element, consultId) {
			var contentArea = $(element).find('.content-area');
			var url = '/hospitalConsultDetail?id=' + consultId; // ID 값을 URL에 포함

			if (contentArea.is(':visible')) {
				contentArea.slideUp();
			} else {
				$.ajax({
					url: url, 
					type: 'GET', 
					success: function(response) {
						contentArea.html(response).slideDown();
					},
					error: function(xhr, status, error) {
						console.error('AJAX Error: ' + status + ' - ' + error);
					}
				});
			}
		}
	</script>


</body>
</html>
