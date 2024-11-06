package com.ict.healim.dao;

import java.util.List;

import com.ict.healim.vo.HospitalVO;

public interface HospitalDAO {
	public List<HospitalVO> getHospitalList(int offset, int limit);
	public List<HospitalVO> getNursingList(int offset, int limit);
	public int getHospitalCount(String facilityType);
	public int getHospitalHit(String h_id);
	public HospitalVO getHospitalDetail(String h_id);

}
