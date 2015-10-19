package com.bruce.action;

import org.springframework.stereotype.Service;

import com.bruce.util.TimeUtils;

@Service
public class StarTask {
	
//	 @Autowired
//	private LevelRuleService levelService;
	 
	public void runTask(){
		System.out.println("定时任务开始"+TimeUtils.getNowTime());
		
//		levelService.updateAllStar();
		//这里进行你需要的业务操作
		
		System.out.println("定时任务结束"+TimeUtils.getNowTime());
	}
	
}
