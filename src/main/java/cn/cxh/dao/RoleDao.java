package cn.cxh.dao;

import java.sql.Connection;
import java.util.List;
import cn.cxh.pojo.Role;

public interface RoleDao {
	
	public List<Role> getRoleList(Connection connection)throws Exception;

}
