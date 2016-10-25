package com.lieying.user;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Base {
public ApplicationContext context;
	
	@Before
	public void before(){                                                                    
		context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml","classpath:conf/shiro/spring-shiro-web.xml"});
	}
}
