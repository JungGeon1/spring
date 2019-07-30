package member;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service("registService")
public class MemberRegisterService {
	@Autowired(required = false)
	//@Qualifier("sys")
	private MemberDao memberDao;
	//bean에서 프로퍼티로 사용시 이 메소드 호출
	
	//public MemberRegisterService(MemberDao memberDao) {
	//	this.memberDao=memberDao;
	//}
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	public void regist(RegisterRequest request) throws AleadyExistingMemberException {
		Member member =memberDao.selectByEmail(request.getEmail());
		
		if(member!=null) {
			
			throw new AleadyExistingMemberException();
		}
		Member newMember=new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		memberDao.insert(newMember);
		
	}

	
}
