package com.ict.healim.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.healim.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<AdminVO> getAdminList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("admin.select");
	}

	@Override
	public int getAdminInsert(AdminVO avo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("admin.insert", avo);
	}

	@Override
	public int getAdminDelete(String admin_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("admin.delete", admin_id);
	}

	@Override
	public  AdminVO  getAdminDetail(String admin_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("admin.detail", admin_id);
	}


	@Override
	public int getAdminUpdate(AdminVO avo) {
		// TODO Auto-generated method stub
		System.out.println("--------update");
		System.out.println(avo.getAdmin_id());
		System.out.println(avo.getAdmin_pw());
		System.out.println(avo.getAuthority_level());
		return sqlSessionTemplate.update("admin.update", avo);
	}

	@Override
	public int getPopupEdit(AdminVO avo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
