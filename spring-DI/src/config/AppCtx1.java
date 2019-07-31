package config;

import java.io.ObjectInputStream.GetField;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import member.MemberDao;

@Configuration
@ComponentScan(basePackages = "member")
public class AppCtx1 {
	
	@Bean
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
}