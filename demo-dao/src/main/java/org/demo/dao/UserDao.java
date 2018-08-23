package org.demo.dao;

import java.util.List;

import org.demo.model.po.UserPo;
import org.demo.model.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<UserVo, UserPo> {
	/**
	 * 通过用户的id得到该用户的数量（判断用户是否存在）
	 * 
	 * @param id
	 * @return
	 */
	int getCountById(long id);

	/**
	 * 更新用户状态方法
	 * 
	 * @param userVo
	 * @return
	 */
	int updateUser(UserVo userVo);

	/**
	 * 更新用户密码的方法
	 * 
	 * @param userVo
	 * @return
	 */
	int updatePwd(UserVo userVo);

	/**
	 * 
	 * @param object
	 * @param object2
	 * @param i
	 * @param j
	 * @return
	 */
	List<UserPo> getUserList(UserVo userVo);

	/**
	 * 修改用户自己的密码
	 * 
	 * @param userVo
	 * @return
	 */
	int updateSelfPwd(String newPwd, int userId);
	
	
	
	/**
	 * 
	 * 用户登录检测
	 * @return
	 */
	UserPo login(UserVo userVo);

	int checkUser(UserVo userVo);

	int updateUserPwd(String string, int i);

	int getUserListCount(UserVo userVo);

	String getPasswd(int userId);
}
