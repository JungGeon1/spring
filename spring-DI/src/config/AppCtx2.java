package config;

import java.io.ObjectInputStream.GetField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import member.ChangePasswordService2;
import member.MemberDao;
import member.MemberRegisterService2;

@Configuration
public class AppCtx2 {
	
	@Autowired 
	MemberDao dao;
	
	@Bean(name="registService2")
	public MemberRegisterService2 getmMemberRegisterService2() {
		MemberRegisterService2 service= new MemberRegisterService2();
		
		//service.setMemberDao(getMemberDao());
		
		return service;
	};
	@Bean(name="changePwService2")
	public ChangePasswordService2 getChangePasswordService2() {
		ChangePasswordService2 service = new  ChangePasswordService2();
		
		//service.setMemberDao(getMemberDao());
		
		return service;
		
	}
}