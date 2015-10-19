package com.bruce.test;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bruce.common.json.JsonUtil;




public class ckgc {
	public static final JsonUtil jsonUtil = new JsonUtil();
	
	
	db db = new db();
	@SuppressWarnings("static-access")
	Connection conn = db.getConnection();
	public  void findOne(){
		try {
			CallableStatement cs = conn.prepareCall("{call proc_findById(?)}");
			cs.setInt(1, 1); //设置输入参数
            ResultSet resultSet=cs.executeQuery();//执行存储过程
		    while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getString(4));
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  String findAll() throws Exception{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			CallableStatement cs = conn.prepareCall("{call proc_findAll()}");
            ResultSet resultSet=cs.executeQuery();//执行存储过程
            List list = new ArrayList();
		    while (resultSet.next()) {
				HashMap m = new HashMap();  
                m.put("id", resultSet.getString("id"));  
                m.put("note", resultSet.getString("note") );
                m.put("opened", resultSet.getString("opened") );  
                m.put("createtime", resultSet.getString("createtime") );  
                m.put("userid", resultSet.getString("userid") );  
                list.add(m);  
				
			}
		    jsonMap.put("jsonlist", list);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonUtil.object2Json(jsonMap);
	}
	
	
	public static void main(String[] args) throws Exception {
		ckgc ckgc = new ckgc();
		//ckgc.findOne();
		String js = ckgc.findAll();
		
		System.out.println(js);
	}

}
