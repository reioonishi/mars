package com.internousdev.mars.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

	public class CreateUserAction extends ActionSupport implements SessionAware {
//CreateUserActionクラスはActionSupportを継承(extends)
//implementsはSessionAwarewインターフェースを実装して作る
		private String familyName;
		private String firstName;
		private String familyNameKana;
		private String firstNameKana;
		private String sex;
		private List<String> sexList = new ArrayList<String>();
		private String email;
		private String userId;
		private String password;
		private static final String MALE = "男性";//finalは定数化・その内容が書き換わる必要がない変数
		private static final String FEMALE = "女性";//継承不可
		private String defaultSexValue = MALE;
		private Map<String, Object> session;//map<string,object>は一対一対応の関係が格納
		private int returnflg;

		public String execute() {//一番最初に実行される
			if(session.isEmpty()){
				return "sessionError";
			}
			String result = ERROR;//初期値

			session.remove("familyNameErrorMessageList");//removeは取り除く
			session.remove("firstNameErrorMessageList");
			session.remove("famimyNameKanaErrorMessageList");
			session.remove("firstNameKanaErrorMessageList");
			session.remove("emailErrorMessageList");
			session.remove("userIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			if(returnflg!=0){
				return SUCCESS;
			}
			session.put("familyName", familyName);
			session.put("firstName", firstName);
			session.put("familyNameKana", familyNameKana);
			session.put("firstNameKana", firstNameKana);

			// sexがnullである場合はデフォルトを入れる
			if(sex==null) {
				session.put("sex", MALE);//キー名 変数名
			}else {
				session.put("sex", String.valueOf(session.get("sex")));
			}
			sexList.add(MALE);
			sexList.add(FEMALE);
			session.put("sexList", sexList);
			session.put("email", email);
			session.put("userId", userId);
			session.put("password", password);
			result = SUCCESS;
			return result;
		}

		public String getFamilyName() {
			return familyName;
		}
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getFamilyNameKana() {
			return familyNameKana;
		}
		public void setFamilyNameKana(String familyNameKana) {
			this.familyNameKana = familyNameKana;
		}
		public String getFirstNameKana() {
			return firstNameKana;
		}
		public void setFirstNameKana(String firstNameKana) {
			this.firstNameKana = firstNameKana;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public List<String> getSexList() {
			return sexList;
		}
		public void setSexList(List<String> sexList) {
			this.sexList = sexList;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getuserId() {
			return userId;
		}
		public void setuserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getDefaultSexValue() {
			return defaultSexValue;
		}
		public void setDefaultSexValue(String defaultSexValue) {
			this.defaultSexValue = defaultSexValue;
		}
		public Map<String, Object> getSession() {//map<string,object>は一対一対応の関係が格納
			return session;
		}
		public void setSession(Map<String, Object> session) {//map<string,object>は一対一対応の関係が格納
			this.session = session;
		}
		public int getReturntflg() {
			return returnflg;
		}

		public void setReturnflg(int resultflg) {
			this.returnflg = resultflg;
		}

	}