package com.lieying.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lieying.user.entity.Response;
import com.lieying.user.entity.SysUser;

@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/main/webapp") 
@ContextConfiguration(locations={"classpath*:conf/spring.xml","classpath*:spring-mvc.xml"})
public class TestHomeController {

	private MockHttpServletRequest request;    
    private MockHttpServletResponse response;
    private MockMvc mockMvc;
    
    @Autowired    
    private HomeController homeController ; 
    
	@Before      
	public void setUp(){ 
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
		request = new MockHttpServletRequest();        
		request.setCharacterEncoding("UTF-8");        
		response = new MockHttpServletResponse();        
	}  

	 /**  
     * @Title：testLogin  
     * @Description: 测试用户登录    
     */    
    @Test    
    public void testLogin() {     
        try {   
        	Map<String,Object> message = new HashMap<String, Object>();
        	message.put("username", "gsp");
//        	message.put("mail", "longshaog@yeah.net");
//        	message.put("telephone", "13975896701");
        	message.put("password", "gsp19187");
            Response<SysUser> response = homeController.login(message) ; 
            System.out.println(response);
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    }    
    
    /**  
     * @Title：testRegister  
     * @Description: 测试用户注册    
     */
    @Test    
    public void testRegister() {     
        try {   
        	Map<String,Object> message = new HashMap<String, Object>();
        	message.put("username", "ss");
//        	message.put("mail", "longshaog@yeah.net");
//        	message.put("telephone", "13975896701");
        	message.put("password", "gsp19187");
            Response<SysUser> response = homeController.register(message) ; 
            System.out.println(response);
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    } 
    /**  
     * @Title：testIsRegister
     * @Description: 测试该用户是否登录
     */
    @Test 
    public void testIsRegister(){
    	try {   
        	Map<String,Object> message = new HashMap<String, Object>();
        	message.put("username", "ss1");
//        	message.put("mail", "longshaog@yeah.net");
//        	message.put("telephone", "13975896701");
            Response<SysUser> response = homeController.isRegister(message) ; 
            System.out.println(response);
        } catch (Exception e) {    
            e.printStackTrace();    
        } 
    }
}
