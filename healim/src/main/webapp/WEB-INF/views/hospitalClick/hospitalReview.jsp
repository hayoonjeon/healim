<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용 후기</title>
    <style>
        body {
            margin: 0 auto;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: white;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
        }
        .rating-section {
            text-align: center;
            margin-bottom: 30px;
        }
        .rating-number {
            font-size: 48px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .rating-stars {
            margin-bottom: 10px;
        }
        .rating-distribution {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }
        .rating-bar {
            width: 100px;
            height: 10px;
            background-color: #ddd;
            margin: 0 5px;
            position: relative;
        }
        .rating-bar-filled {
            height: 100%;
            background-color: #4caf50;
            position: absolute;
            top: 0;
            left: 0;
        }
        .review-button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-align: center;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
        }
        .review {
            margin-bottom: 30px;
            border-top: 1px solid #e0e0e0;
            padding-top: 20px;
        }
        .review-header {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }
        .review-rating {
            font-size: 24px;
            margin-right: 10px;
            color: #fbc02d;
        }
        .review-name {
            font-size: 16px;
            color: #555;
        }
        .review-content {
            font-size: 14px;
            color: #333;
            margin-bottom: 10px;
        }
        .review-response {
            font-size: 14px;
            color: #555;
            background-color: #f1f1f1;
            padding: 10px;
            border-radius: 5px;
        }
        .review-date {
            font-size: 12px;
            color: #888;
            margin-top: 5px;
        }
        .starselection ,option{
        font-size: 34px;
            margin-right: 10px;
            color: #fbc02d;
        }
        textarea{
        width: 90%;
        height:15vh;
        resize: none;
        }
/*         select{
        border: none;
        } */
    </style>
</head>
<body>
    <div class="container">
        <div class="rating-section">
            <div class="rating-number">5</div>
            <div class="rating-stars">⭐⭐⭐⭐⭐</div>
            <div class="rating-distribution">
                <div>5점</div>
                <div class="rating-bar">
                    <div class="rating-bar-filled" style="width: 100%;"></div>
                </div>
                <div>100%</div>
            </div>
            <div class="rating-distribution">
                <div>4점</div>
                <div class="rating-bar">
                    <div class="rating-bar-filled" style="width: 0%;"></div>
                </div>
                <div>0%</div>
            </div>
            <div class="rating-distribution">
                <div>3점</div>
                <div class="rating-bar">
                    <div class="rating-bar-filled" style="width: 0%;"></div>
                </div>
                <div>0%</div>
            </div>
            <div class="rating-distribution">
                <div>2점</div>
                <div class="rating-bar">
                    <div class="rating-bar-filled" style="width: 0%;"></div>
                </div>
                <div>0%</div>
            </div>
            <div class="rating-distribution">
                <div>1점</div>
                <div class="rating-bar">
                    <div class="rating-bar-filled" style="width: 0%;"></div>
                </div>
                <div>0%</div>
            </div>
            
        </div>
		<!-- 후기 입력 상자 -->
        <div class="review">
            <div class="review-header">
                <div class="review-rating">
	                <select class="starselection">
	                	<option>⭐⭐⭐⭐⭐</option>
	                	<option>⭐⭐⭐⭐</option>
	                	<option>⭐⭐⭐</option>
	                	<option>⭐⭐</option>
	                	<option>⭐</option>
	                </select>
                </div>
                <div class="review-name"><input type="text" placeholder="닉네임 입력"></div>
                <div class="review-date">오늘</div>
            </div>
            <div class="review-content">
                <textarea rows="" cols=""></textarea>
            </div>
            <div class="review-button">후기 남기기</div>
        </div>

        <!-- 리뷰 1 -->
        <div class="review">
            <div class="review-header">
                <div class="review-rating">⭐⭐⭐⭐⭐</div>
                <div class="review-name">김정이별39622</div>
                <div class="review-date">6개월 전</div>
            </div>
            <div class="review-content">
                원무과에서 발빠르게 입원수속 해주시고 친절한 간호사님들, 원장님의 편안한 진료까지 참 잘돌보인 원네요. 양, 한방 치료를 같이 받을 수 있어서 이전 또한 빠른 회복에 도움이 된 것 같아요 몸이 조금이라도 아플 때 바로 치료 받을 수 있어 요양병원에 들어오기 전보다 정말 잘챙겼다는 생각이 들었던 곳
            </div>
            <div class="review-response">
                항상 최선을 다하는 송파그랜드요양병원이 되도록 노력하겠습니다. 늘 가정에 평안하시길 바랍니다.<br>
                송파그랜드요양병원 직원 일동.<br>
                6개월 전
            </div>
        </div>

        <!-- 리뷰 2 -->
        <div class="review">
            <div class="review-header">
                <div class="review-rating">⭐⭐⭐⭐⭐</div>
                <div class="review-name">가득찬수선화3702</div>
                <div class="review-date">1년 전</div>
            </div>
            <div class="review-content">
                요양병원을 알아보던 중 지인의 추천을 송파그랜드요양병원으로 입원하게되었습니다. 입원상담을 원하여 전화를드리니 상담하시는분께서 친절하고 이해가 쉽게 잘 설명해주셨고 한번 내원하여서 보셨드되면하여 상담선생님과 병실을 구경하게 됐습니다 덕분에 환자분도 잘 적응하시게되었습니다. 환자식단도 할머님 입맛에 맞으셔서 맛있게 드신다하시네요. 재활치료도 가능하시며 도수치료로 같이 병행합니다.
            </div>
            <div class="review-response">
                잘 모시도록 하겠습니다.<br>
                1년 전
            </div>
        </div>
    </div>
</body>
</html>
