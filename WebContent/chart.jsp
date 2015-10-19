<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>FusionChart图表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style type="text/css">
	body{
		width: 1920px;
		height: 2160px;
		margin:0px;
		font-family: Arial;
		background-color: #FFB6C1;
	}
	</style>
  </head>
  <script type="text/javascript" src="javaScript/jquery-1.7.js"></script>
<script type="text/javascript" src="javaScript/FusionCharts.js"></script> 
  <body>
    <button onclick="test('swf/MSLine.swf')">折线图</button><br>
    <button onclick="test('swf/MSBar2D.swf')">横向直方图</button><br>
    <button onclick="test('swf/MSColumn2D.swf')">柱状图</button><br>
    <button onclick="test('swf/MSArea.swf')">面积图</button><br>
           <!-- 这个div用于放置生成chart -->
    <div id="chart"></div>
    
    <script type="text/javascript">
    
    //此处配置用于chart分风格,如标题,颜色,字体等),详细配置请查看chart API.
    var  chartHead = "<chart  bgAlpha='0,0' animation='1' plotFillRatio='100' showPlotBorder='0' ";
		 chartHead += "  formatNumberScale='0' ";
         chartHead += " baseFontSize='20' baseFontColor='#FAF0E6' showValues='0' showBorder='0' useRoundEdges='0' ";
         chartHead += " canvasBgAlpha='100' canvasBgcolor='#8FBC8B' ";
         chartHead += " canvasBorderColor='f1f1f1' canvasBorderThickness='3' canvasBorderAlpha='100' ";
         chartHead += " showAlternateHGridColor='1' hoverCapBgcolor='#8B4513' alternateHGridColor='#3CB371' alternateHGridAlpha='100'";
         chartHead += " divLineThickness='1' divLineAlpha='0' divLineColor='#FAF0E6' numdivlines='6'";
         chartHead += " anchorRadius='5' anchorBorderThickness='3' lineThickness='5'";
         chartHead += " legendBorderAlpha='100' legendBorderColor='#FAF0E6' legendBgAlpha='0' legendShadow='1'>";
		
    function test(chartName){ 
    	var categorie = "<categories>";
		var datasetA = "<dataset seriesName='第一条线' color='fb9147' >";
		var datasetB = "<dataset seriesName='第二条线' color='7BFC00' >";
		
    	//							  swf文件路径     图表id:随便起,  宽         高  
    	var chart01 = new FusionCharts(chartName, "chartId01", 1270, 550,"0", "0");
    	//使用ajax请求获取所需数据
    		$.ajax({
				url:"chartAction/getDatas.action",
				async:true,
				type:"POST",
				success:function(returnedData){
					var list=eval(returnedData);
					for ( var i = 0; i < list.length; i++) {
						categorie+="<category label='"+list[i].LABEL+"'/>";
						datasetA +="<set value='"+list[i].A+"'/>";
						datasetB +="<set value='"+list[i].B+"'/>";
					}

				categorie += "</categories>";
				datasetA +="</dataset>";
				datasetB +="</dataset>";

				chart01.setTransparent(true);//chart背景透明
				//为chart写入数据
				chart01.setXMLData( chartHead + categorie + datasetA + datasetB  + "</chart>");
				chart01.render("chart");//将chart写入到id为chart的div中
			}
		});
    }
    </script>
    
  </body>
</html>
