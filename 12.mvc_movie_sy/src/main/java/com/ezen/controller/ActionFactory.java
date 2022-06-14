package com.ezen.controller;

import com.ezen.controller.action.MovieListAction;


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
//      } else if (command.equals("board_write_form")) { // 게시글 등록 화면 출력
//         action = new BoardWriteFormAction();
//      } else if (command.equals("board_write")) {
//         action = new BoardWriteAction();
//      } else if (command.equals("board_view")) {
//         action = new BoardViewAction();
//      } else if (command.equals("board_check_pass_form")) {
//         action = new BoardCheckPassFormAction();
//      } else if (command.equals("board_check_pass")) {
//         action = new BoardCheckPassAction();
//      } else if (command.equals("board_update_form")) {
//    	  action = new BoardUpdateFormAction();
//      } else if (command.equals("board_update")) {
//    	  action = new BoardUpdateAction();
//      } else if (command.equals("board_delete")) {
//    	  action = new BoardDeleteAction();
       }
      

      return action;
   }
}