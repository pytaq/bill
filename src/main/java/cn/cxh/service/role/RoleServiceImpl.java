package cn.cxh.service.role;

import java.sql.Connection;
import java.util.List;

import cn.cxh.dao.RoleDao;
import cn.cxh.pojo.Role;

public class RoleServiceImpl implements RoleService{

	
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		List<Role> roleList = null;
//		try {
//			connection = BaseDao.getConnection();
//			roleList = roleDao.getRoleList(connection);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		return roleList;
	}
	
}
