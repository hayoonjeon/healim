package com.ict.healim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ict.healim.dao.AdminDAO;
import com.ict.healim.vo.AdminVO;

@Service("adminServiceImpl")
@Primary
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	public List<AdminVO> getAdminList(){
		
		return adminDAO.getAdminList();
	}


	@Override
	public int getAdminInsert(AdminVO avo) {
		// TODO Auto-generated method stub
		return adminDAO.getAdminInsert(avo);
	}


	@Override
	public int getAdminDelete(String admin_id) {
		// TODO Auto-generated method stub
		return adminDAO.getAdminDelete(admin_id);
	}


	@Override
	public AdminVO getAdminDetail(String admin_id) {
		// TODO Auto-generated method stub
		return adminDAO.getAdminDetail(admin_id);
	}


	@Override
	public int getPopupEdit(AdminVO avo) {
		// TODO Auto-generated method stub
		return adminDAO.getPopupEdit(avo);
	}

	@Override
	public int getAdminUpdate(AdminVO avo) {
		// TODO Auto-generated method stub
		return adminDAO.getAdminUpdate(avo);
	}


}
