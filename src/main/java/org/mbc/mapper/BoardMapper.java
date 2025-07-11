package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// interface는 클래스와 다르게 메서드가 추상화처럼 되어있다
	// 추상메서드는 시그니쳐만 있으며 {실행문이 없다} 그래서 ; 으로 끝낸다
	
	// a. 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 좀 있다
	@Select("SELECT * FROM tbl_board WHERE bno > 0") // bno > 0 :pk로 선언되어있어서 인덱싱으로 빠른 추출이 가능
	public List<BoardVO> getList(); // 추상메서드라서 실행문이 없이 ;로 끝남
	
	// b. 그래서 xml을 이용하여 sql문 처리를 진행한다
	// c. xml을 이용하려면 src/main/resources 폴더 아래쪽에 org폴더 아래에 mbc폴더 아래에 mapper 폴더를 만들고
	// 		인터페이스와 이름이 같은 xml 파일을 생성한다
	//		 이것이 마이바티스 사용법이다

	public List<BoardVO> getList2();
	// xml을 이용한 쿼리 매퍼용 메서드
	
	
	// C : insert 데이터를 삽입하는 쿼리문 
	// 1. insert 처리 후에 결과 int로 받는 방법 
	// 2. pk를 먼저 생성 한 후에 insert가 되는 방법
	public void insert(BoardVO board);// xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); // xml에서 쿼리 작성
	
	public BoardVO read(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다
	
	public int delete(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 삭제 후 몇개가 삭제가 됐는지 리턴한다
	
	
	public int update (BoardVO board); // xml에서 쿼리 작성
	// 번호가 들어가면 필드 수정 후 몇개가 수정 됐는지 리턴한다

} //class종료
