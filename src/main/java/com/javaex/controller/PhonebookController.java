package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	//Controller 접수받는일
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//action 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("list".equals(action)) {
			
			System.out.println("리스트요청");

			//db데이터 가져오기
			PhonebookDao phonebookDao = new PhonebookDao();
			List<PersonVo> personList = phonebookDao.getPersonList();
			System.out.println(personList);
			
			//화면그리기 --> 포워드
			//request 에 리스트주소 넣기
			request.setAttribute("personList", personList);
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);
		
		}else if("writeform".equals(action)) {
			
			System.out.println("등록 폼 요청, 저장해줘아님");
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
		
		}else if("insert".equals(action)) {
			
			System.out.println("등록 요청 데이터3개 저장해줘");
			
			//나머지파라미터 꺼내서 PersonVo 로 묶기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
		
			/*
			PersonVo personVo = new PersonVo();
			personVo.setName(name);
			personVo.setHp(hp);
			personVo.setCompany(company);
			*/
		
			PersonVo personVo = new PersonVo(name, hp, company);
			
			
			//Dao를 메모리에 올린다
			//insertPerson(personVo) 사용해서 db에 저장한다
			PhonebookDao phonebookDao = new PhonebookDao();
			phonebookDao.insertPerson(personVo);
		}
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
