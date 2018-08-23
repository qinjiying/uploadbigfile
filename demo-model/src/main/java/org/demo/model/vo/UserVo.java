package org.demo.model.vo;

public class UserVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 自增长
		private long id;
		// 用户名称
		private String userName;
		// 用户密码
		private String userPwd;
		// 0：普通用户 1：管理员
		private int userRole;
		// 用户状态：0：禁用1：启用
		private Integer userStatus;

		public UserVo() {
			super();
		}

		public UserVo(long id, String userName, String userPwd, int userRole, int userStatus) {
			super();
			this.id = id;
			this.userName = userName;
			this.userPwd = userPwd;
			this.userRole = userRole;
			this.userStatus = userStatus;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPwd() {
			return userPwd;
		}

		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}

		public int getUserRole() {
			return userRole;
		}

		public void setUserRole(int userRole) {
			this.userRole = userRole;
		}

		public Integer getUserStatus() {
			return userStatus;
		}

		public void setUserStatus(Integer userStatus) {
			this.userStatus = userStatus;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


}
