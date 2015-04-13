package com.qsh;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MyController {

	/**
	 * 直接 PrintWriter输出json
	 * 
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public void getjson(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");

		System.out
				.println(" 直接 PrintWriter输出json :" + username + "--->" + pass);

		PrintWriter writer = rep.getWriter();
		JSONObject object = new JSONObject();
		if (username.equals("zhr") && pass.equals("123")) {
			object.put("results", "login success");
		} else {
			object.put("results", "login fail");
		}

		writer.println(object.toString());
		writer.flush();
		writer.close();

	}

}
