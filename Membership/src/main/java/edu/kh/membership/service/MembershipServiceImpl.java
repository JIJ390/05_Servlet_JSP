package edu.kh.membership.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.kh.membership.dao.MembershipDao;
import edu.kh.membership.dao.MembershipDaoImpl;
import edu.kh.membership.dto.Member;

public class MembershipServiceImpl implements MembershipService{
//	dao 객체 부모 참조 변수 선언
	private MembershipDao dao = null;
	private String[] gradeArr = {"일반", "골드", "다이아"};
	
	
//	기본 생성자
//	- MemberServiceImpl 객체 생성 시 
//	  MemberDaoImpl     객체도 생성
	public MembershipServiceImpl() throws FileNotFoundException, 
		                              ClassNotFoundException, 
		                              IOException {
		dao = new MembershipDaoImpl();
//		throws 로 받아와서 예외 처리 필요
//		또 던짐
	}
	
	

//	회원 추가
	@Override
	public boolean addMember(String name, String phone) throws IOException {
//		1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
		
		List<Member> memberList = dao.getMemberList();
		
//		중복 검사
		for (Member member : memberList) {
			if (member.getPhone().equals(phone)) {
				return false;
			}
		}
		
		Member member = new Member(name, phone, 0, Member.COMMON);
		
//		boolean result = dao.addMember(member);
		
		return dao.addMember(member);
		
	}
	
	
//	dao 에서 조회한 memberList를 그대로 반환
//	(해당 서비스 메서드는 따로 처리한 조건 / 기능이 없어서 
//	중간에서 전달만 해주는 역할
//	* view 에서 dao를 선언하지 않음
	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}	
	
	
//	이름 검색
	@Override
	public List<Member> selectName(String searchName) {
//		DAO 를 이용해서 회원 전체 목록 조회
		
		List<Member> memberList = dao.getMemberList();
		
//		memberList 에 저장된 요소(회원) 중 
//		이름이 같은 회원을 찾아서
//		검색 결과를 저장할 별도 List 에 추가
		List<Member> searchList = new ArrayList<Member>();
		
		for (Member member : memberList) {
			if (member.getName().equals(searchName)) {
				searchList.add(member);
			}
		}
		
		
		return searchList;
	}

	@Override
	public String[] updateAmount(Member target, int acc) throws IOException {
		int before = target.getAmount();
		
		target.setAmount(acc + before);
		
		int currentAmount = target.getAmount();
//		같은 메서드를 여러번 호출하는건 효율이 나쁨
		
		String grade = null;
		
		if      (currentAmount <= 100000)  grade = Member.COMMON;
		else if (currentAmount <= 1000000) grade = Member.GOLD;
		else                               grade = Member.DIAMOND;
//		(target.getGrade() != grade) if 문 돌리기 위해서 grade 사용
		
		
		StringBuilder sb = new StringBuilder();
		String[] message = new String[2];
		
		sb.append(target.getName());
		sb.append(" 회원님의 누적 금액 : ");
		sb.append(before + " -> " + currentAmount);
		
		message[0] = sb.toString();
		
		String str = null;
		
		if (!target.getGrade().equals(grade)) {
			str = String.format("* %s * 등급으로 변경되었습니다", grade);
			target.setGrade(grade);
			message[1] = str;
		}
		
		dao.saveFile();
		
		return message;
	}
	
	@Override
	public String updateMember(Member target, String phone) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) {
			if (member.getPhone().equals(phone)) {
				return "### 실패 : 중복되는 휴대폰 번호가 존재합니다 ###";
			}
		}
		
		String before = target.getPhone();

		target.setPhone(phone);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(target.getName());
		sb.append(" 회원님의 전화 번호가 변경되었습니다");
//		sb.append(before + " -> " + phone);
		
		dao.saveFile();
		
		return sb.toString();
	}
	
	@Override
	public boolean deleteMember(Member target) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
//		boolean List.remove(Object obj)
//		-> List 에 저장된 요소 중 obj 와 같은 요소 제거
//		* 조건 : 요소 객체 equals 오버라이딩
		boolean result = memberList.remove(target);
		
		dao.saveFile();
		
//		memberList 에서 지워진 것 target 자체는 사라지지 않음
		return result;
	}
}
