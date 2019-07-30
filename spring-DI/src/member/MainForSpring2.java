package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring2 {
	//private static Assembler assembler = new Assembler();
	// 스프링 컨테이너 생성 : 조립기 설정파일 appCtx1.xml
	private static ApplicationContext ctx= new GenericXmlApplicationContext("classpath:appCtx5.xml");

	public static void main(String[] args) throws IOException {

		System.out.println("스프링 컨테이너에서 받은 객체  ");
		System.out.println("reg");
		MemberRegisterService registerService1=ctx.getBean("registService", MemberRegisterService.class);
		MemberRegisterService registerService2=ctx.getBean("registService", MemberRegisterService.class);
		//참조변수비교
		boolean chk=registerService1==registerService2;
		System.out.println(registerService1);
		System.out.println(registerService2);
		System.out.println("reg1==reg2:"+chk);
		
		System.out.println("==============================================================================");
		System.out.println("스프링 컨테이너에서 받은 객체  ");
		System.out.println("pw");
		ChangePasswordService  passwordService1= ctx.getBean("changeService",ChangePasswordService.class);
		ChangePasswordService  passwordService2= ctx.getBean("changeService",ChangePasswordService.class);
		
		chk=passwordService1==passwordService2;
		System.out.println(passwordService1);
		System.out.println(passwordService2);
		System.out.println("pw1+pw2:"+chk);
	}

	private static void processNewCommand(String[] args) {
		System.out.println(args.length);
		if (args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService service = ctx.getBean("registService", MemberRegisterService.class);
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		if(!request.isPasswordEqualToConfirmPassword()){
			System.out.println("암호 확인이 일치하지 않습니다.");
			return;
		}
		try {
			service.regist(request);
			System.out.println("등록되었어여~~");
		} catch (AleadyExistingMemberException e) {
			e.printStackTrace();
			System.out.println("이미 존재한다 이 말이야~");
		}
	}

	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService service= ctx.getBean("changeService",ChangePasswordService.class );
		
		try {
			service.changePassord(args[1], args[2], args[3]);
			System.out.println("변경되었습니다~");
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			System.out.println("없어임마아~");
		} catch (IdPasswordNotMatchException e) {
			e.printStackTrace();
			System.out.println("틀려임마아~");
		}
		
	

	}

	private static void printHelp() {
		System.out.println("");
		System.out.println("잘못된 명령 입니다. 아래 사용법을 확인하세요");
		System.out.println("new 이메일 사용자 암호 암호왁인");
		System.out.println("change 이멜 현재암호 새로운암호");
	}
}
