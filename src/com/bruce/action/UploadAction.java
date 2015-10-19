
package com.bruce.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uploadAction")
public class UploadAction {
	 
	 @RequestMapping("/upload")
	 public void upload( HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置内存缓冲区，超过后写入临时文件
			factory.setSizeThreshold(10240000);//10M
			// 设置临时文件存储位置
			String base = "d:/ups";
			File file = new File(base);
			if(!file.exists())
				file.mkdirs();
			factory.setRepository(file);
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置单个文件的最大上传值
			upload.setFileSizeMax(10002400000l);//100M
			// 设置整个request的最大值
			upload.setSizeMax(10002400000l);//1000M
			upload.setHeaderEncoding("UTF-8");
			
			try {
				List<?> items = upload.parseRequest(request);
				FileItem item = null;
				String fileName = null;
				for (int i = 0 ;i < items.size(); i++){
					item = (FileItem) items.get(i);
					fileName = base + File.separator + item.getName();
					// 保存文件
					if (!item.isFormField() && item.getName().length() > 0) {
						item.write(new File(fileName));
					}
				}
				Runtime.getRuntime().exec("explorer D:\\ups");  
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		

}
