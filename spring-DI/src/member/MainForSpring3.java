package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppContext;

public class MainForSpring3 {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberDao dao1=ctx.getBean("memberDao",MemberDao.class);
		MemberDao dao2=ctx.getBean("memberDao",MemberDao.class);
		
		System.out.println("dao1==dao2:"+(dao1==dao2));
	}
}
