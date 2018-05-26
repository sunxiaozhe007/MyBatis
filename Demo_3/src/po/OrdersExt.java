package po;


import java.util.List;

public class OrdersExt extends Orders {

	// user.`username`,
	// user.`sex`
	private String username;

	private String sex;

	//�û���Ϣ
	private User user;

	//������ϸ��Ϣ
	private List<Orderdetail> detailList;

	public List<Orderdetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Orderdetail> detailList) {
		this.detailList = detailList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "OrdersExt{" +
				"username='" + username + '\'' +
				", sex='" + sex + '\'' +
				", user=" + user +
				'}';
	}
}
