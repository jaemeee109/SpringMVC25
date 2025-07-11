package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 이 클래스는 서비스 계층임을 명시
@AllArgsConstructor // 롬복이 생성자를 자동 주입함 (new BoardServiceImpl (mapper));
@Log4j2 // 로깅 처리용
public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService (구현클래스)
	// BoardServiceImpl 누르면 메서드 자동생성 됨
	
	
	private BoardMapper mapper; //  DB 쿼리용 객체 (CRUD) 

	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 매퍼를 이용해 DB에 등록함
		
		log.info("===BoardServiceImpl.register메서드 실행===");
		mapper.insertSelectKey(board);	
		log.info("======= 정상 등록 후 리스트 출력 테스트 =======");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 매퍼의 select문이 동작해야 한다
		
		log.info("=== BoardServiceImpl.get 메서드 실행 ===");
		

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update 쿼리가 실행된다
		log.info("=== BoardServiceImpl.modify 메서드 실행 ===");
		return mapper.update(board)==1; // 수정 됐으면 1(1건이 삭제됐기 때문에), 수정 되지 않았으면 0
	} //modify종료

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행됨
		
		log.info("=== BoardServiceImpl.remove 메서드 실행 ===");
		return mapper.delete(bno)==1; // 삭제가 됐으면 1(1건이 삭제됐기 때문에), 삭제가 되지 않았으면 0
	}//remove 종료

	@Override
	public List<BoardVO> getList() {
		// getList() 메서드가 호출되면 매퍼에 getList2()를 호출한다
		
		log.info("=== BoardServiceImpl.getList 메서드 실행 ===");
		return mapper.getList2();
	}
	//조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService (구현클래스)

}
