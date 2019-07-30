package member;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service("changeService")
public class ChangePasswordService {
	
	//private MemberDao memberDao= new MemberDao();
	@Autowired(required = false)
	//@Qualifier("sys")
	private MemberDao memberDao;
	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */

	/*
	 * public ChangePasswordService(MemberDao dao) { memberDao =dao;
	 * 
	 * }
	 */
	public  void changePassord(String email, String oldPassord, String newPassord) throws MemberNotFoundException, IdPasswordNotMatchException {
		Member member= memberDao.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPassord, newPassord);
		
		memberDao.update(member);
	}
}
