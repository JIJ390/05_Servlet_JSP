package edu.kh.membership.dao;

import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.Member;

public interface MembershipDao {

	List<Member> getMemberList();
	
	/**
	 * 회원 추가
	 * @param member
	 * @return true
	 * @throws IOException
	 */
	boolean addMember(Member member) throws IOException;
	
	void saveFile() throws IOException;

	
}
