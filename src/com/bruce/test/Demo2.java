package com.bruce.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.bruce.common.image.CutInfo;
import com.bruce.common.image.ImageTools;
import com.bruce.common.image.deal.ZoomScaleDeal;

public class Demo2 {
	
	
	/**
	 * @bruce
	 * @剪切并且压缩图片
	 *
	 */
	@SuppressWarnings("unused")
	public static void cutImages(){
		CutInfo cutInfo = new CutInfo();
		String imgPath = "d:/2.jpg";
		int [] wh = ImageTools.getImageWH(new File(imgPath));
		cutInfo.setViewWidth(2000);
		cutInfo.setViewHeight(2000);
		cutInfo.setCutWidth(1000);
		cutInfo.setCutHeight(1000);
		cutInfo.setCutX(900);
		cutInfo.setCutY(100);
		
		String saveFile = "d:/5.jpg";
		
		boolean b = ImageTools.cutImage(cutInfo, imgPath, saveFile);
		if(b){
			System.out.println("剪切并且压缩图片成功！");
		}else{
			System.err.println("发生异常！");
		}
	}

	/**
	 * @bruce
	 * @压缩图片大小和比例
	 *
	 */
	public static void condense() {
		ZoomScaleDeal zs = new ZoomScaleDeal((float)0.6);
		try {
			ImageTools.writeImage("d:/222.jpg", zs.dealImage("d:/2.jpg"));
			System.out.println("压缩成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("压缩失败！");
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cutImages();
		condense();
		
	}

}
