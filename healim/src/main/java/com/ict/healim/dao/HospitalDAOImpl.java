package com.ict.healim.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.healim.vo.HospitalVO;

@Repository
public class HospitalDAOImpl implements HospitalDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<HospitalVO> getHospitalList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("hospital.selectH",map);
	}
	@Override
	public List<HospitalVO> getNursingList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("hospital.selectN",map);
	}
	@Override
	public int getHospitalCount(String facilityType) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("facilityType", facilityType);
		return sqlSessionTemplate.selectOne("hospital.count", map);
	}
	
	@Override
	public int getHospitalHit(String h_id) {
		return sqlSessionTemplate.update("hospital.hit", h_id);
	}
	@Override
	public HospitalVO getHospitalDetail(String h_id) {
		return sqlSessionTemplate.selectOne("hospital.hDetail", h_id);
	}

}
