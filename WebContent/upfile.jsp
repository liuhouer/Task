<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="com.jspsmart.upload.*"%> 
<jsp:useBean scope="page" />
<HTML>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<BODY>
<%
// ��ʼ��
final String upFileType="zip|rar|doc|txt|jpg|xls";//�ϴ��ļ�����
final int MAXFILESIZE=2097152;//�ϴ��ļ���С����2M
String errMsg=null;    //������Ϣ
boolean err=false;     //�����־
int fileSize=0;        //�ļ���С
mySmartUpload.initialize(pageContext);
mySmartUpload.upload();
//�жϽ�Ҫ�ϴ��ļ����������Ƿ񳬹�����
int count = mySmartUpload.getSize();
if(count>MAXFILESIZE){
 out.print ("<script>alert('�ϴ�ʧ�ܣ��ļ���С:"+count/1024+"K�������޶��ķ�Χ(���"+MAXFILESIZE/1024+"K)');this.history.go(-1);</script>"); 
}
// ѭ��ȡ���ϴ������ļ�
    for(int i=0;i<mySmartUpload.getFiles().getCount();i++)
 {
        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(i);

        if (!myFile.isMissing())
  {       
   String myFileName=myFile.getFileName();//�õ��ļ���  
   String fileType=myFile.getFileExt();//�õ��ļ���չ��
   fileType=fileType.toLowerCase();   //����չ��ת����Сд
   if (upFileType.indexOf(fileType)==-1)
   {
    err=true;
    errMsg="�ļ�"+myFileName+"�ϴ�ʧ�ܣ�ֻ�����ϴ����¸�ʽ���ļ���"+upFileType;
    out.print ("<script>alert('"+errMsg+"');this.history.go(-1);</script>");
   }
   myFile.saveAs("D:\\ups\\"+myFileName);

  }
 }
  out.print("<script>alert('�ϴ��ļ��ɹ�!�ļ���С��"+count/1024+"K');this.history.go(-1);</script>");

%>
</BODY>
</HTML>