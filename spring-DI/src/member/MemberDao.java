package member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public class MemberDao  {
	
	private static long nextId=0;
	private Map<String, Member> map= new HashMap<String, Member>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(),member);
	}
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	public Collection<Member> selectAll(){
		//컬렉션 그대로 반환
		return map.values();
	}

}
