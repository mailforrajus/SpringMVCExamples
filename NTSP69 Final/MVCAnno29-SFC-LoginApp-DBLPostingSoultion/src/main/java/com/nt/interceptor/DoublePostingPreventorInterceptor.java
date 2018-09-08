package com.nt.interceptor;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component("dppi")
public class DoublePostingPreventorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		HttpSession ses=null;
		int cTkn=0, sTkn=0;
		RequestDispatcher rd=null;
		
		
		if(req.getServletPath().equalsIgnoreCase("/login.htm")){
			 //get Acess to Sesssion obj
			ses=req.getSession();
			if(req.getMethod().equalsIgnoreCase("GET")){  //initial phase request
		        //generate server side token 
				ses.setAttribute("sToken", new Random().nextInt(10000));
				return true;
			}
			else if(req.getMethod().equalsIgnoreCase("POST")){
				//read client and server token values
				cTkn=Integer.parseInt(req.getParameter("cToken"));
				sTkn=(Integer)ses.getAttribute("sToken");
				//match the tokens
				if(cTkn==sTkn){
					//if matching , change server side token value
					ses.setAttribute("sToken", new Random().nextInt(10000));
					return true;
				}
				else{
					//if not matching display error page
					rd=req.getRequestDispatcher("/dbl_post_error.jsp");
					rd.forward(req,res);
					return false;
				}//else
			}//else if
		}
		return true;
	
	}//method
	
}//class
