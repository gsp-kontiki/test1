package com.lieying.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lieying.user.bean.DataTable;
import com.lieying.user.bean.SearchParameter;
import com.lieying.user.bean.UserBean;
import com.lieying.user.entity.SysUser;
import com.lieying.user.global.RequestParameterConstant;
import com.lieying.user.service.UserService;
import com.lieying.user.util.CommonUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	

	@Resource(name="userService")
    private UserService userService;

    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public String userList(@RequestParam() Map<String,Object> message,Model model) {
    	SearchParameter params = new SearchParameter();
    	model.addAttribute("searchParameter", params);
        return "user/userList";
    }
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/userJsonList")
    @ResponseBody
    public DataTable<SysUser> userJsonList(@RequestParam() Map<String,Object> message,Model model) {
    	DataTable<SysUser> dataTable = userService.getDataTable(message);
		return dataTable;
    }
    
	@RequiresPermissions("user:manage")
    @RequestMapping(value = "/goUserAdd", method = RequestMethod.GET)
	public String goUserAdd(Model model,@RequestParam() Map<String,Object> message) {
    	SysUser user = new SysUser();
		UserBean userBean = new UserBean();
		userBean.setUser(user);
		userBean.setNameParam(CommonUtil.convertToCharSetUTF8((String)message.get(RequestParameterConstant.NAME)));
		model.addAttribute("userBean", userBean);
		return "user/userEdit";
	}
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String userAdd(@ModelAttribute("userBean") UserBean userBean,RedirectAttributes redirectAttr) {
		userService.saveUserBean(userBean);
		redirectAttr.addAttribute(RequestParameterConstant.NAME, userBean.getNameParam());
		return "redirect:/user/userList";
	}
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/goUserEdit", method = RequestMethod.GET)
	public String goUserEdit(Model model,@RequestParam() Map<String,Object> message) {
    	SysUser user = userService.getUser(Long.parseLong((String)message.get(RequestParameterConstant.ID)));
		UserBean userBean = new UserBean();
		userBean.setUser(user);
		userBean.setNameParam(CommonUtil.convertToCharSetUTF8((String)message.get(RequestParameterConstant.NAME)));
		model.addAttribute("userBean", userBean);
		return "user/userEdit";
	}
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public String userEdit(@ModelAttribute("userBean") UserBean userBean,RedirectAttributes redirectAttr) {
		userService.updateUserBean(userBean);
		redirectAttr.addAttribute(RequestParameterConstant.NAME, userBean.getNameParam());
		return "redirect:/user/userList";
	}
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/goUserPasswordChange", method = RequestMethod.GET)
	public String goUserPasswordChange(Model model,@RequestParam() Map<String,Object> message) {
    	SysUser user =  userService.findOne(new Long((String)message.get(RequestParameterConstant.ID)));
		UserBean userBean = new UserBean();
		userBean.setUser(user);
		userBean.setNameParam(CommonUtil.convertToCharSetUTF8((String)message.get(RequestParameterConstant.NAME)));
		model.addAttribute("userBean", userBean);
		return "user/userPasswordChange";
	}
    
    @RequiresPermissions("user:manage")
    @RequestMapping(value = "/userPasswordChange", method = RequestMethod.POST)
	public String userPasswordChange(@ModelAttribute("userBean") UserBean userBean ,Model model) throws Exception {
    	String result = userService.updatePassword(userBean);
    	if(result != null) {
    		model.addAttribute("error", result);
    	} else {
    		model.addAttribute("success", "修改密码成功!");
    	}
    	return "login/userPasswordChange";
	}

    @RequiresPermissions("user:manage")
    @RequestMapping("/userRemove")
	public String userRemove(Model model,@RequestParam() Map<String,Object> message,RedirectAttributes redirectAttr) {
    	userService.deleteUserByIds(message);
		message.put(RequestParameterConstant.NAME, CommonUtil.convertToCharSetUTF8((String)message.get(RequestParameterConstant.NAME)));
		redirectAttr.addAllAttributes(message);
		return "redirect:/user/userList";
	}

    
    @RequestMapping(value = "/checkUserIsExist", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> checkUserIsExist(Model model,@RequestParam() Map<String,Object> message) {
    	SysUser user = userService.findByUsername((String)message.get(RequestParameterConstant.USER_NAME));
		Map<String,String> returnMap = new HashMap<String, String>();
		if(null != user){
			returnMap.put("user", "exist");
		}else{
			returnMap.put("user", "notexist");
		}
		return returnMap;
	}
    
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)  
    public String register(@ModelAttribute("user") SysUser user, RedirectAttributes redirectAttributes) {  
    	userService.saveUser(user);
        UsernamePasswordToken token = new UsernamePasswordToken();  
        token.setUsername(user.getUserName());  
        token.setPassword(user.getPassword().toCharArray());  
        SecurityUtils.getSubject().login(token);  
        return "redirect:/";  
    } 
    
    @RequestMapping(value = "/userRegister",method = RequestMethod.GET)  
    public String goToregister(Model model) {  
    	SysUser user = new SysUser();
    	model.addAttribute("user", user);
        return "user/userRegister";  
    } 
    
    @InitBinder    
    protected void initBinder(WebDataBinder binder) {    
    }
    
}
