package com.ict.healim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.healim.dao.HospitalDAO;
import com.ict.healim.vo.HospitalVO;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDAO hospitalDAO;
	
	@Override
	public List<HospitalVO> getHospitalList(int offset, int limit) {
		// TODO Auto-generated method stub
		return hospitalDAO.getHospitalList(offset, limit);
	}
	@Override
	public List<HospitalVO> getNursingList(int offset, int limit) {
		// TODO Auto-generated method stub
		return hospitalDAO.getNursingList(offset, limit);
	}
	@Override
	public int getHospitalCount(String facilityType) {
		// TODO Auto-generated method stub
		return hospitalDAO.getHospitalCount(facilityType);
	}
	@Override
	public int getHospitalHit(String h_id) {
		return hospitalDAO.getHospitalHit(h_id);
	}
	
	@Override
	public HospitalVO getHospitalDetail(String h_id) {
		return hospitalDAO.getHospitalDetail(h_id);
	}
	@Override
	public List<HospitalVO> getHospitalList(String h_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
