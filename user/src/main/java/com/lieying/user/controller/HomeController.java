package com.lieying.user.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lieying.user.bean.UserBean;
import com.lieying.user.entity.Response;
import com.lieying.user.entity.SysUser;
import com.lieying.user.service.UserService;
import com.lieying.user.util.CustomTimestampEditor;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="userService")
	private UserService userService;

	@RequestMapping(value =  { "/", "/index" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("loggedinUser", userName);
		log.info("Welcome home {} ! The client locale is {}.",userName, locale);
		return "login/index";
	}

	@RequestMapping("/hello1")
	public String hello1() {
		SecurityUtils.getSubject().checkRole("admin");
		return "login/success";
	}

	/**
	 * 登录接口
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody Response<SysUser> login(@RequestParam() Map<String,Object> message) {
		Response<SysUser> response = new Response<SysUser>();
		SysUser user = null;
		String username =(String)message.get("username");
		String mail = (String)message.get("mail");
		String telephone = (String)message.get("telephone");
		String password = (String)message.get("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = null;
		try {
			if(null != StringUtils.trimToNull(username)){
				token = new UsernamePasswordToken(username, password);
			}else if(null != StringUtils.trimToNull(mail)){
				token = new UsernamePasswordToken(mail, password);
			}else if(null != StringUtils.trimToNull(telephone)){
				token = new UsernamePasswordToken(telephone, password);
			}else{
				throw new Exception("请输入账号/邮箱/手机号");
			}
			subject.login(token);
		} catch (UnknownAccountException e) {
			response.setSuccess(false);
			response.setMsg("用户名/密码错误");
			response.setCode("LYL00001");
			return response;
		} catch (IncorrectCredentialsException e) {
			response.setSuccess(false);
			response.setMsg("用户名/密码错误");
			response.setCode("LYL00001");
			return response;
		} catch(LockedAccountException e){
			response.setSuccess(false);
			response.setMsg("该用户已被锁定");
			response.setCode("LYL00002");
			return response;
		}catch(AuthenticationException e){
			e.printStackTrace();
			if(e.getMessage().contains("No account information found for authentication token")){
				response.setSuccess(false);
				response.setMsg("用户名/密码错误");
				response.setCode("LYL00001");
			}else{
				response.setSuccess(false);
				response.setMsg("其他错误：" + e.getMessage());
				response.setCode("LYL00003");
			}
			return response;
			//其他错误，比如锁定，如果想单独处理请单独catch处理
		}catch (Exception e) {
			response.setSuccess(false);
			response.setMsg("其他错误：" + e.getMessage());
			response.setCode("LYL00003");
			return response;
			//其他错误，比如锁定，如果想单独处理请单独catch处理
		}
		response.setCode("LYL00000");
		response.setMsg("用户登录成功");
		response.setSuccess(true); 
		if(null != StringUtils.trimToNull(username)){
			user = userService.findByUsername(username);
		}else if(null != StringUtils.trimToNull(mail)){
			user = userService.findByMail(mail);
		}else if(null != StringUtils.trimToNull(telephone)){
			user = userService.findByTelephone(telephone);
		}
		user.setPassword(null);
		response.setData(user);
		return response;
	}

	/**
	 * 判断用户是否注册 
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/isRegister", method = RequestMethod.POST)
	public @ResponseBody Response<SysUser> isRegister(@RequestParam() Map<String,Object> message) {
		Response<SysUser> response = new Response<SysUser>();
		SysUser user = null;
		String username =(String)message.get("username");
		if(null != StringUtils.trimToNull(username)){
			user = userService.findByUsername(username);
			if(null != user){
				response.setCode("LYS00002");
				response.setMsg("该用户名已注册");
				response.setSuccess(true);
				return response;
			}
		}
		String mail = (String)message.get("mail");
		if(null != StringUtils.trimToNull(mail)){
			user = userService.findByMail(mail);
			if(null != user){
				response.setCode("LYS00003");
				response.setMsg("该邮箱已注册");
				response.setSuccess(true);
				return response;
			}
		}
		String telephone = (String)message.get("telephone");
		if(null != StringUtils.trimToNull(telephone)){
			user = userService.findByTelephone(telephone);
			if(null != user){
				response.setCode("LYS00004");
				response.setMsg("该电话号码已注册");
				response.setSuccess(true);
				return response;
			}
		}
		
		if(null == user){
			response.setCode("LYS00001");
			response.setMsg("该用户没有被注册");
			response.setSuccess(false);
		}
		return response;
	}
	
	/**
	 * 注册接口
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody Response<SysUser> register(@RequestParam() Map<String,Object> message) {
		Response<SysUser> response = new Response<SysUser>();
		SysUser user = new SysUser();
		setUser(user,message);
		try {
			user = userService.saveUser(user);
		}catch (Exception e) {
			response.setCode("LYR00002");
			response.setMsg("注册失败" + e.getMessage());
			response.setSuccess(false);
			return response;
		}
		response.setCode("LYR00001");
		response.setMsg("注册成功");
		response.setSuccess(true);
		response.setData(user);
		return response;
	}

	private void setUser(SysUser user, Map<String, Object> message) {
		String username =(String)message.get("username");
		user.setUserName(username);
		String nickname =(String)message.get("nickname");
		user.setNickName(nickname);
		String mail = (String)message.get("mail");
		user.setEmail(mail);
		String telephone = (String)message.get("telephone");
		user.setTelephone(telephone);
		String password = (String)message.get("password");
		user.setPassword(password);
		String sex = (String)message.get("sex");
		if(null != sex){
			user.setSex(Integer.parseInt(sex));
		}
		String origin = (String)message.get("origin");
		if(null != origin){
			user.setSex(Integer.parseInt(origin));
		}
		String city = (String)message.get("city");

		user.setCity(city);
		//TODO
		//birthday  String birthday = (String)message.get("birthday");
		user.setLocked(false);
		user.setDisabled(false);
		long cur = System.currentTimeMillis();
		user.setCreateDate(new Timestamp(cur));
		user.setUpdateDate(new Timestamp(cur));

	}

	/**
	 * user log out
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutNew (HttpServletRequest request, HttpServletResponse response,Model model){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		model.addAttribute("logout", "success");
		return "login/login";
	}

	/**
	 *  Access-Denied redirect.
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinUser", (String)SecurityUtils.getSubject().getPrincipal());
		return "accessDenied";
	}


	//@RequiresPermissions("user:changePassword")
	@RequestMapping(value = "/toChangPasswordPage", method = RequestMethod.GET)
	public String toChangPasswordPage(Model model,@RequestParam() Map<String,Object> message) {
		//Subject subject = SecurityUtils.getSubject();
		//String username = (String)subject.getPrincipal();
		//SysUser user = userService.findByUsername(username);
		UserBean userBean = new UserBean();
		//userBean.setUser(user);
		model.addAttribute("userBean", userBean);
		return "login/userPasswordChange";
	}

	//@RequiresPermissions("user:changePassword")
	@RequestMapping(value = "/userPasswordChange", method = RequestMethod.POST)
	public String userPasswordChange(@ModelAttribute("userBean") UserBean userBean ,RedirectAttributes redirectAttr) throws Exception {
		userService.updatePassword(userBean);
		return "redirect:/login/index";
	}


	@InitBinder    
	protected void initBinder(WebDataBinder binder) {    
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)); 
	}

}
