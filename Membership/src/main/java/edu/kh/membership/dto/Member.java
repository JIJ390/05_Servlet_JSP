package edu.kh.membership.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member implements Serializable{

//	등급을 나타내는 상수
	public static final String COMMON  = "일반"; 
	public static final String GOLD    = "골드"; 
	public static final String DIAMOND = "다이아"; 

//	회원 정보를 저장할 필드
	private String name;
	private String phone;
	private int    amount;
	private String grade;
	
}
