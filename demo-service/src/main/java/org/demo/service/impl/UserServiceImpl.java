package org.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.demo.common.JsonUtil;
import org.demo.dao.UserDao;
import org.demo.model.po.UserPo;
import org.demo.model.vo.UserVo;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * 日志
	 */
	private final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	@Override
	public String changeUserStatus(UserVo userVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserList(UserVo userVo) {
		// TODO Auto-generated method stub
		String result  = null;
		List<UserPo> poList = null;
		try {
			try {
				poList = new ArrayList<UserPo>();
				poList = userDao.getUserList(userVo);
				result = JsonUtil.writeObject2JSON(poList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateUserPwd(JSONObject message, String oprator) {
		// TODO Auto-generated method stub
		return null;
	}

}
