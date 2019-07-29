package memeber;

public class ChangePasswordService {
	
	//private MemberDao memberDao= new MemberDao();
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao dao) {
		memberDao =dao;
		
	}
	public  void changePassord(String email, String oldPassord, String newPassord) throws MemberNotFoundException, IdPasswordNotMatchException {
		Member member= memberDao.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPassord, newPassord);
		
		memberDao.update(member);
	}
}
