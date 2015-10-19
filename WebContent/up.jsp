<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.servlet.*"%>
<%@page import="org.apache.commons.fileupload.disk.*"%>

<%
request.setCharacterEncoding("UTF-8");
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
// upload.setHeaderEncoding(request.getCharacterEncoding());
System.out.println("request:" + request);
List items = upload.parseRequest(request);

Iterator iter = items.iterator();
while (iter.hasNext()) {
	FileItem item = (FileItem) iter.next();

	if (item.isFormField()) {/*
								 * String name = item.getFieldName(); String value = item.getString();
								 * System.out.println("name = " + name); System.out.println("value = " +
								 * value); System.out.println("/r/n");
								 */
	} else {
		String fieldName = item.getFieldName();

		String fileName = item.getName();
		System.out
				.println("文件类型   " + fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()));
		// boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();
		getListInSession(request).add(fileName);
		getListInSession(request).add(UUID.randomUUID());

		// String[] str=fieldName.split("\\.");
		// int l=str.length-1;
		// System.out.println("文件类型 "+str[l]);
		//					
		System.out.println("fieldName = " + fieldName);
		System.out.println("fileName = " + fileName);
		// System.out.println("文件存储路径 "+request.getRealPath("/")+"uploadfile/");
		// 路径 D:\Program Files\apache-tomcat-6.0.18\webapps\rockontrol_oa\UploadFiles\2009042991039312\
		String filePath = "d:/ups/";
		File savePath = new File(filePath);
		System.out.println(savePath.getAbsolutePath());
		if (!savePath.exists()) {
			savePath.mkdir();
		}
		item.write(new File(filePath + fileName));

	}
}
System.out.println("-------- final--------");
} catch (Exception ex) {
ex.printStackTrace();
}

%>