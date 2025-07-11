-- 시퀀스 객체 생성
create sequence seq_board;
-- 시퀀스 삭제 (차후에 활용)
drop sequence seq_board;

create table tbl_board(
	bno number(10,0), -- 게시글 번호 (시퀀스)
	title varchar2(200) not null, -- 게시글 타이틀
	content varchar2(2000) not null, -- 게시글 내용
	writer varchar2(50) not null, -- 게시글 작성자 (차후에 member와 연동)
	regdate date default sysdate, -- 게시글 작성일 (자동으로 DB날짜 입력됨)
	updatedate date default sysdate -- 게시글 수정일 (자동으로 DB알짜 입력됨)
); -- board 테이블 생성

alter table tbl_board add constraint pk_board primary key (bno);
-- tbl_board 구조변경(수정) 기본키를 bno로 지정함

-- 더미데이터 입력하기
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목1','테스트내용1','user01')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목2','테스트내용2','user02')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목3','테스트내용3','user03')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목4','테스트내용4','user04')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목5','테스트내용5','user05')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목6','테스트내용6','user06')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목7','테스트내용7','user07')
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목8','테스트내용8','user08')

select*from tbl_board;

