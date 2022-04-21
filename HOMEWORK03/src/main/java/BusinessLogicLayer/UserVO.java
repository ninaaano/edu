package BusinessLogicLayer;


public class UserVO {
	private String id; // 아이디
	private String pwd; // 비밀번호
	private String gender; // 성별
	private String birth; // 생년월일
	private String job; // 직업
	private String tel; // 번호
	private String addr; // 주소
	private boolean active; // 확인
	
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


