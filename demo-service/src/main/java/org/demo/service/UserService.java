package org.demo.service;

import org.demo.model.vo.UserVo;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
	
	/**
	 * 新增用户接口
	 * 
	 * @param userVo
	 * @return
	 */
	public String changeUserStatus(UserVo userVo);

	/**
	 * 分页查询到所有用户信息
	 * 
	 * @param userVo
	 * @return
	 */
	public String getUserList(UserVo userVo);

	/**
	 * 用户密码修改接口。
	 * 
	 * @param userVo
	 * @return
	 */
	public String updateUserPwd(JSONObject message, String oprator);

	/**
	 * 用户密码修改接口。
	 * 
	 * @param userVo
	 * @return
	 */
	
}
