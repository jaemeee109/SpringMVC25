package org.mbc.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {

	@Setter(onMethod_=@Autowired)
	private BoardService service; // 인터페이스를 필드로 선언한다
	// 인터페이스에 연결된 구현 클래스가 자동으로 연동됨 BoardServiceImpl
	
	@Test
	public void testExist() {
		
		log.info("==========================");
		log.info(service); // 인터페이스를 호출
		assertNotNull(service); // 빈객체가 아님을 테스트
		log.info("==========================");
		
		// org.mbc.service.BoardServiceImpl@3c78e551
		// 인터페이스를 호출했는데 구현클래스가 호출됨을 확인한다
		// 구현클래스에 구현메서드를 실행문에 작성하면 동작이 되는 걸 알수있음
		
	} // testExist종료
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 만든 제목");
		board.setContent("서비스에서 만든 내용");
		board.setWriter("서비스 작성자");
		
		service.register(board);
		log.info("====================");
		log.info("생성 된 게시물의 번호 : " + board.getBno());
		log.info("====================");
		
		
		
	} // testRegister종료
	
	@Test
	public void testGetList() {
		
		log.info("====================");
		service.getList().forEach(board -> log.info(board));
		log.info("====================");
		
	}//testGetList 종료
	
	@Test
	public void testGet() {
		
		log.info("====================");
		log.info(service.get(8L));
		log.info("====================");
		
		
	} //testGet 종료
	
	@Test
	public void testDelete() {
		
		log.info("====================");
		log.info("삭제 결과 : " + service.remove(2L));
		log.info("====================");
		
		
	} //testDelete 종료
	
	@Test
	public void testModify() {
		
		BoardVO board = service.get(1L); // 1번 게시물 호출
		
		if (board == null) {
			log.info("=========찾는 게시물이 없습니다===========");
			return ;
		}
		log.info("====================");
		board.setTitle("서비스에서 수정 된 제목");
		log.info("수정 된 결과 출력 : " + service.modify(board));
		log.info("====================");
		
		
	} //testModify 종료
	
}//class 종료
