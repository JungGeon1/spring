package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("changePwService2")
public class ChangePasswordService2 {
	
	@Autowired
	//@Qualifier("sys")
	private MemberDao memberDao;

	/*
	 * public ChangePasswordService2(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
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
