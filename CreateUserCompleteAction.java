package com.internousdev.mars.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mars.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

	public class CreateUserCompleteAction extends ActionSupport implements SessionAware {
//CreateUserCompleteActionクラスはActionSupportで定義しているものは継承(エラーメッセ)理由は23行のexecuteにつながってる
//追加分は定義する

//アクセス修飾子 Class クラス名 implements インターフェース  インターフェースを実装して作る
		private String familyName;
		private String firstName;
		private String familyNameKana;
		private String firstNameKana;
		private String sex;
		private String email;
		private String userId;
		private String password;
		private Map<String, Object> session;//map<string,object>は一対一対応の関係が格納
		public String execute() {//一番最初に実行される
			if(session.isEmpty()){
				return "sessionError";
			}
			familyName=session.get("familyName").toString();
			firstName=session.get("firstName").toString();
			familyNameKana=session.get("familyNameKana").toString();
			firstNameKana=session.get("firstNameKana").toString();
			sex=session.get("sex").toString();
			if(sex.equals("男性"))sex="0";
			else sex="1";
			email=session.get("email").toString();
			userId=session.get("userId").toString();
			password=session.get("password").toString();

			String result = ERROR;//初期値エラー
			UserInfoDAO UserInfoDao = new UserInfoDAO();//キー名 変数名 インスタンス
			int count = UserInfoDao.createUser(familyName,firstName,familyNameKana,firstNameKana,sex,email,userId,password);
			if(count > 0) {//一つでもあればサクセス
				result = SUCCESS;//結果
			}
			return result;//リザルトに戻す(エラーに)
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Map<String, Object> getSession() {//map<string,object>は一対一対応の関係が格納
			return session;
		}
		public void setSession(Map<String, Object> session) {//map<string,object>は一対一対応の関係が格納
			this.session = session;
		}
}
