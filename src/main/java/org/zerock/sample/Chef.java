package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링에게 의존성 처리하라고 하는거
@Data // import lombok.Data;
public class Chef {
	private String name;
	private int age;
	

}
