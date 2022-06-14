package com.ezen.controller.action;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	/*
	 * 컨트롤러(서블릿)에서 command를 전달 받아서 해당하는 업무 로직을 생성해서 반환함.
	 */
	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory: " + command);

		if (command.equals("movie_list")) {
			action = new MovieListAction();
		} else if (command.equals("movie_write_form")) {
			action = new MovieWriteFormAction();
		} else if (command.equals("movie_write")) {
			action = new MovieWriteAction();
		} else if (command.equals("movie_update_form")) {
			action = new MovieUpdateFormAction();
		} else if (command.equals("movie_update")) {
			action = new MovieUpdateAction();
		} else if (command.equals("movie_delete_form")) {
			action = new MovieDeleteFormAction();
		} else if (command.equals("movie_delete")) {
			action = new MovieDeleteAction();
		}
		return action;
	}
}
