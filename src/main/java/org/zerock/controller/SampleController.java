package org.zerock.controller;


import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller 
// servlet-controller.xml에서 <context:component-scan base-package="org.zerock.sample"></context:component-scan>
@RequestMapping("/sample/*") // http://192.168.111.104:80/controller/sample/의 모든것에 반응
@Log4j2 // resources폴더에 log4j2.xml 필수
public class SampleController {
	
	@RequestMapping("") // http://192.168.111.104:80/controller/sample/
	public void basic( ) {
		
		log.info("SampleController.basic() 메서드 실행 ");
		log.info("리턴이 void이기 때문에 basic.jsp파일을 찾습니다");
		log.info("현재 /WEB-INF/view/basic.jsp가 없으므로 크롬에는 오류가 납니다");
		// 리턴이 void임 : 파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다
		// 기본적으로 url에 경로에 대한 jsp를 찾으려고 한다
		
	}//basic 메서드 종료
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	// http://192.168.111.104:80/controller/sample/basic -> get메서드와 post메서드에 동작
	public void basicGet() {
		
		log.info("SampleController.basicGet() 메서드 실행");
		log.info("get방식과 post방식 둘다 반응한다");
		
	} // basicGet 메서드 종료
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("SampleController.basicGet2() 메서드 실행");
		log.info("get방식만 반응한다");
	} // basicGet2 메서드 종료
	
	@PostMapping ("/basicOnlyPost")
	public void basicPost2() {
		log.info("SampleController.basicPost2() 메서드 실행");
		log.info("Post방식만 반응한다");
	} // basicPost2 메서드 종료
	
	
	@GetMapping("/ex01") // http://192.168.111.104:80/controller/sample/ex01?name=kcs@age=5
	public String ex01 (SampleDTO dto) { // SampleDTO dto = new SampleDTO();
		
		log.info("SampleController.ex01() 메서드 실행");
		log.info("get방식에 반응한다");
		log.info("입력 DTO 확인" + dto);
		
		return "ex01"; // WEB-INF/views/ex01.jsp -> servlet-context.xml이 하는일
		
	} // ex01 메서드 종료
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("owner") String name, 
			@RequestParam("age") int age) {
		// 프론트의 변수와 백엔드의 변수가 다를 때 !! (웬만하면 사용x, 초보자는 일치 시킬 것)
		
		
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
		
	} // ex02종료
	
	@GetMapping("/ex02List")
	// http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		// 리스트로 넘어오는 데이터 처리
		
		log.info("리스트로 넘어온 데이터 처리 : " + ids);
		log.info("리스트 2번째 값 확인 : " + ids.get(1)); // 배열의 2번째 값을 가져옴 ids.get(1)
		
		return "ex02List";
		
	} //ex02List 종료
	
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		// url 경로에 배열로 들어오는 파라미터
		// /ex02Bean?list[0].name=kcs&list[2].age=[5]
		
		log.info("list SampleDTOs : " + list);
		
		
		return "exo02Bean";
	} // ex02Bean 종료
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("to do : " + todo);
		
		return "ex03";
		
	} // ex03 종료
	
	@GetMapping("/ex04") // http://192.168.111.104:80/controller/sample/ex04
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) { // int page는 게시판의 페이징 기법 예시
		// @ModelAttribute("page") 안쓰면 백엔드에는 전달이 되지만 프론트에는 전달이 안됨
		// 스프링에서 기본적으로 제공되는 model 객체를 사용하게 설정한다
		log.info("dto : " + dto ); // name, age
		log.info("page : " + page );
		
		return "/sample/ex04"; // views/sample/exo04.jsp 를 찾는다
		
	} // ex04 종료
	
	
	@GetMapping("/ex05")
	public void ex05() {
		
		log.info("SampleController.ex05메서드 실행");
		
		// 리턴이 void인 경우에는 자동으로 [/WEB-INF/views/sample/ex05.jsp]를 찾는다 
		// 초보자 사용 금지 !
	}// ex05종료
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		// @ResponseBody SampleDTO : 응답 body에 객체를 담아 리턴을 한다
		
		log.info("SampleController.ex06메서드 실행");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kcs");
		dto.setAge(5);
		
		return dto;
		
	}// ex06종료
	
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		// ResponseEntity<String> : 응답 헤더 (200 ok, 404, 304)를 만들어 리턴
		
		log.info("SampleController.ex07메서드 실행");
		
		String msg = "{\"name\":\"kcs\"}"; // json으로 {name : kcs} 
	
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		// 헤더에 타입 추가용
		
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
		// msg 에는 json 데이터/ header에는 json타입 / 상태값은 200 -> ok
		
	}// ex07종료
	
}

