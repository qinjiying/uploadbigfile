package org.demo.dao;

import java.util.List;

import org.demo.model.po.UserPo;
import org.demo.model.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<UserVo, UserPo> {
	/**
	 * ͨ���û���id�õ����û����������ж��û��Ƿ���ڣ�
	 * 
	 * @param id
	 * @return
	 */
	int getCountById(long id);

	/**
	 * �����û�״̬����
	 * 
	 * @param userVo
	 * @return
	 */
	int updateUser(UserVo userVo);

	/**
	 * �����û�����ķ���
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
	 * �޸��û��Լ�������
	 * 
	 * @param userVo
	 * @return
	 */
	int updateSelfPwd(String newPwd, int userId);
	
	
	
	/**
	 * 
	 * �û���¼���
	 * @return
	 */
	UserPo login(UserVo userVo);

	int checkUser(UserVo userVo);

	int updateUserPwd(String string, int i);

	int getUserListCount(UserVo userVo);

	String getPasswd(int userId);
}
