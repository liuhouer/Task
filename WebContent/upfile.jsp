<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="com.jspsmart.upload.*"%> 
<jsp:useBean scope="page" />
<HTML>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<BODY>
<%
// 初始化
final String upFileType="zip|rar|doc|txt|jpg|xls";//上传文件类型
final int MAXFILESIZE=2097152;//上传文件大小限制2M
String errMsg=null;    //错误信息
boolean err=false;     //错误标志
int fileSize=0;        //文件大小
mySmartUpload.initialize(pageContext);
mySmartUpload.upload();
//判断将要上传文件的总容量是否超过上限
int count = mySmartUpload.getSize();
if(count>MAXFILESIZE){
 out.print ("<script>alert('上传失败！文件大小:"+count/1024+"K超出了限定的范围(最大"+MAXFILESIZE/1024+"K)');this.history.go(-1);</script>"); 
}
// 循环取得上传所有文件
    for(int i=0;i<mySmartUpload.getFiles().getCount();i++)
 {
        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(i);

        if (!myFile.isMissing())
  {       
   String myFileName=myFile.getFileName();//得到文件名  
   String fileType=myFile.getFileExt();//得到文件扩展名
   fileType=fileType.toLowerCase();   //将扩展名转换成小写
   if (upFileType.indexOf(fileType)==-1)
   {
    err=true;
    errMsg="文件"+myFileName+"上传失败！只允许上传以下格式的文件："+upFileType;
    out.print ("<script>alert('"+errMsg+"');this.history.go(-1);</script>");
   }
   myFile.saveAs("D:\\ups\\"+myFileName);

  }
 }
  out.print("<script>alert('上传文件成功!文件大小："+count/1024+"K');this.history.go(-1);</script>");

%>
</BODY>
</HTML>