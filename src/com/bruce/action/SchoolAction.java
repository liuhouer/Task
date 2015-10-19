package com.bruce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bruce.manager.SchoolManager;
import com.bruce.model.School;
import com.bruce.util.TokenHandler;


@Controller
@RequestMapping("/SchoolAction")
@SessionAttributes({ "list", "School" })
public class SchoolAction {

	@Autowired
	private SchoolManager SchoolManager;

	@RequestMapping("/toAdd")
	public String toAdd(HttpSession session) {
		TokenHandler.generateToken(session);
		return "schoolAdd";
	}


	@RequestMapping("/addSchool")
	public String addSchool(School School,HttpServletRequest request,HttpSession session) {
		 boolean isFirstPost =  TokenHandler.isTokenValid(request);
	      String result ="index";
		if (isFirstPost) {// 首次提交
			// 本次机会用过了，清除token
			TokenHandler.clearMvcToken(session);
			School.setZt(String.valueOf(1));
			this.SchoolManager.addSchool(School);
		}else{
			 result =  "rePostError";
		}
		return result;
	}



}
