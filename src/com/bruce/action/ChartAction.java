
package com.bruce.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.common.json.JsonUtil;

@Controller
@RequestMapping("/chartAction")
public class ChartAction {
	 
	 @RequestMapping("/getDatas")
	 public void getDatas( HttpServletRequest request,
				HttpServletResponse response) {
		 try {
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			PrintWriter pw = response.getWriter();
			
			//模拟连接数据库读取数据
			List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			for (int i = 0; i < 15; i++) {
				map = new HashMap<String, Object>();
				map.put("LABEL", (2000+i)+"年");
				map.put("A", 10+(i*2)-2);
				map.put("B", 15+(i*3)-5);
				list.add(map);
			}
			
			//将数据用json串的格式发送到页面
			    JsonUtil ju = new JsonUtil();
			
				pw.println(ju.object2Json(list));
				pw.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		

}
