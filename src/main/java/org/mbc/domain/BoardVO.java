package org.mbc.domain;

import java.util.Date;

import lombok.Data;

@Data // import lombok.Data; (생성자, 게터/세터/toString등..)
public class BoardVO {
	// 객체용으로 vo는 읽기전용 속성을 강하게 만드는 객체 (getter위주의 세팅)
	// dto는 게터/세터 모두 가지고 활용하는 객체
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; // import java.util.Date;
	private Date updateDate;

}
