<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신체 상태 및 인지 상태</title>
<style>
.container {
  margin: 0 auto;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: white;
}

.section-title {
	font-size: 24px;
	font-weight: bold;
	color: #007bff;
}

.status-table th, .status-table td {
	padding: 10px;
	border: 1px solid #ddd;
}

.status-table th {
	background-color: #f1f1f1;
	font-weight: bold;
}

textarea {
	width: 70%;
	height: 400px;
	padding: 15px;
	border: 1px solid #ddd;
	border-radius: 10px; /* 모서리를 둥글게 */
	box-shadow: none; /* 기본 그림자 제거 */
	resize: none; /* 크기 조정 불가 */
	font-size: 16px;
	line-height: 1.5;
	font-family: Arial, sans-serif;
}
textarea:focus {
	outline: none; /* 포커스 시 기본 아웃라인 제거 */
	border-color: #007bff; /* 포커스 시 테두리 색상 변경 */
	box-shadow: none; /* 포커스 시 그림자 제거 */
}
.small{
color: gray;
font-size: medium;
}
</style>
</head>
<body>

 <div class="container">
    <div class="section-title">신체 상태 및 인지 상태</div>
   

    <table class="status-table">
			<tr>
				<th>현 상태 이전 여부</th>
				<td>${detail1}</td>
				<th>현재 진행 유형</th>
				<td>${detail2}</td>
			</tr>
			<tr>
				<th>현재 질병명</th>
				<td>${detail3}</td>
				<th>식사여부</th>
				<td>${detail4}</td>
			</tr>
			<tr>
				<th>기저귀 착용</th>
				<td>${detail5}</td>
				<th>재활 가능 여부</th>
				<td>${detail6}</td>
			</tr>
			<tr>
				<th>현재 상태</th>
				<td>${detail7}</td>
				<th>연령</th>
				<td>${detail8}</td>
			</tr>
		</table>
</div>

<div class="hospital-answer">
    <hr>
    <h1> ${hospitalName} <a class="small">의  답변</a></h1>
    <textarea id="response" name="response" rows="50" cols="80">
        ${response}
    </textarea>
</div>
 
 
 
 
</body>
</html>
