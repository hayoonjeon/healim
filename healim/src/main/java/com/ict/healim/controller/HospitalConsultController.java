package com.ict.healim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HospitalConsultController {
	@RequestMapping(value = "/hospitalConsultDetail", method = RequestMethod.GET)
	public ModelAndView hospitalConsultDetail(@RequestParam("id") String id, Model model) {
		ModelAndView mv = new ModelAndView("hospitalClick/hospitalConsultDetail");

		// 예시 데이터 - 실제로는 DB에서 가져오도록 처리 가능
		String hospitalName, detail1, detail2, detail3, detail4, detail5, detail6, detail7, detail8, response;

		switch (id) {
		case "1":
			hospitalName = "김포종합병원";  //병원이름
			detail1 = "예"; //현 상태 이전 여부
			detail2 = "예"; // 현재 진행 유형
			detail3 = "예"; // 현재 질병명
			detail4 = "예"; //식사여부
			detail5 = "예"; //기저귀 착용
			detail6 = "예"; //재활 가능 여부
			detail7 = "예"; //현재 상태
			detail8 = "94"; //연령
			response = "   안녕하세요, 상담해주셔서 감사합니다. 환자분께서는 허리 수술 후 요양병원에서 오랜 기간 지내셨고,"
					+ "최근 갑작스러운 의식불명 상태에 놓이신 상황이라 보호자분의 걱정이 매우 크실 거라 생각됩니다. "
					+ "현재 고혈압으로 인한 의식불명 상태이며, 식사 또한 어려운 상황이므로 추가적인 치료와 안정이 필요할 수 있습니다."
					+ "다만, 저희 병원에서는 현재 환자분의 상태에 맞는 입원 치료가 가능할지 여부를 면밀히 검토해야 합니다. "
					+ "현재 병원 상황에 따라 보호자님께서 원하시는 즉각적인 입원이 어려울 수 있으니, 조금만 양해해주시면 "
					+ "환자분의 상태와 저희 병원의 입원 가능 여부를 신속하게 안내드리겠습니다."
					+ "입원이 필요하신 경우, 보호자님과 상의 후 최선의 치료 방법을 제공해드릴 수 있도록 하겠습니다. "
					+ "추가적으로 궁금한 사항이 있으시면 언제든지 문의해주시기 바랍니다.감사합니다.";   //병원답변
			break;
		case "2":
			hospitalName = "수원병원";
			detail1 = "예";
			detail2 = "아니요";
			detail3 = "아니요";
			detail4 = "아니요";
			detail5 = "예";
			detail6 = "예";
			detail7 = "아니요";
			detail8 = "예";
			response = "안녕하세요, 상담해주셔서 감사합니다. 환자분께서는 무릎 수술 후 회복 중이신 상황이며, "
			        + "최근 수술 부위에 통증이나 불편함이 생기신 점에 대해 우려가 크실 거라 생각됩니다. "
			        + "현재 무릎 관절의 상태와 주변 조직의 회복 상태를 면밀히 검토해본 결과, 추가적인 재활 치료가 필요할 수 있습니다. "
			        + "저희 병원에서는 환자분의 무릎 상태에 맞는 치료 계획을 수립하여 더욱 안정적인 회복이 가능하도록 도와드리겠습니다. "
			        + "입원이 필요할 경우, 환자분의 상태를 주기적으로 모니터링하며 적절한 치료를 제공할 예정입니다. "
			        + "또한 재활 치료를 통해 일상생활로의 복귀를 도울 수 있도록 최선을 다하겠습니다."
			        + "추가적으로 궁금한 사항이 있으시면 언제든지 문의해주시기 바랍니다. 감사합니다."; //병원답변

			break;
		default:
			hospitalName = "해당하는 병원이 없습니다.";
			detail1 = "해당하는 상담 내용이 없습니다.";
			detail2 = "해당하는 상담 내용이 없습니다.";
			detail3 = "해당하는 상담 내용이 없습니다.";
			detail4 = "해당하는 상담 내용이 없습니다.";
			detail5 = "해당하는 상담 내용이 없습니다.";
			detail6 = "해당하는 상담 내용이 없습니다.";
			detail7 = "해당하는 상담 내용이 없습니다.";
			detail8 = "해당하는 상담 내용이 없습니다.";
			response = "상담 내용이 없습니다.";
			break;
		}

		mv.addObject("hospitalName", hospitalName);
		mv.addObject("detail1", detail1);
		mv.addObject("detail2", detail2);
		mv.addObject("detail3", detail3);
		mv.addObject("detail4", detail4);
		mv.addObject("detail5", detail5);
		mv.addObject("detail6", detail6);
		mv.addObject("detail7", detail7);
		mv.addObject("detail8", detail8);
		mv.addObject("response", response);

		return mv;
	}

}