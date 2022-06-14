package com.ezen.controller.action;

public class ActionFactory {
	
	private ActionFactory() {
	   }

	   private static ActionFactory instance = new ActionFactory();

	   public static ActionFactory getInstance() {
	      return instance;
	   }
	/*
	 * [문제2]
	 * 문제에서 제시한 업무별 URL 및 액션 클래스명을 참조하여 싱글톤 형식의 ActionFactory 
	 * 클래스를 작성하고 사용자의 요청 파라미터(=command)에 대해 적합한 업무 모듈을 생성하여 
	 * 반환하는 getAction() 메소드를 작성하시오. 
	 */
	public Action getAction(String command){
		 Action action = null;
		
		if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("mypage_form")) {
			action = new MyPageFormAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("emp_update")) {
			action = new EmpUpdateAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		}
		
		 return action;
	}
		
}
