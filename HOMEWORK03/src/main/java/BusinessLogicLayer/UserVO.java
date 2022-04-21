package BusinessLogicLayer;


public class UserVO {
	private String id; // ���̵�
	private String pwd; // ��й�ȣ
	private String gender; // ����
	private String birth; // �������
	private String job; // ����
	private String tel; // ��ȣ
	private String addr; // �ּ�
	private boolean active; // Ȯ��
	
	public UserVO() {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", gender=" + gender + ", birth=" + birth
				+ ", job=" + job + ", tel=" + tel + ", addr=" + addr + ", active=" + active + "]";
	}
}


