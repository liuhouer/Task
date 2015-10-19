<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1" />
<meta name="description"
	content="minPlayer : A minimalistic, plugin-based &quot;core&quot; media player for the web." />

<!-- Include jQuery and jQuery UI -->
 <script type='text/javascript' src="bin/jquery.js"></script>
    <script type="text/javascript" src="bin/jquery-ui.js"></script>

    <link rel="stylesheet" href="bin/css/jquery-ui.css">

<!-- The following can be replaced by a single javascript include bin/minplayer.compressed.js -->
<script type="text/javascript"
	src="minplayer/src/minplayer.compatibility.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.flags.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.async.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.plugin.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.display.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.image.js"></script>
<script type="text/javascript" src="minplayer/src/minplayer.file.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.playLoader.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.base.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.html5.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.flash.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.minplayer.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.youtube.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.players.vimeo.js"></script>
<script type="text/javascript"
	src="minplayer/src/minplayer.controller.js"></script>
<!-- Include the template CSS and JS files. -->
<link rel="stylesheet"
	href="templates/default/css/minplayer_default.css">
<script type="text/javascript"
	src="templates/default/js/minplayer.playLoader.default.js"></script>
<script type="text/javascript"
	src="templates/default/js/minplayer.controller.default.js"></script>
<script type="text/javascript"
	src="templates/default/js/minplayer.default.js"></script>
<script type="text/javascript">
	$(function() {
		$("#h264").minplayer({
			 width: '600px',
	          height: '400px',
		});
	});
</script>
<title>minPlayer</title>
</head>
<body>
	<video id="h264" src="video/刘瑞琦-你给我听好.flv"></video>
</body>

<!-- 
<script type="text/javascript">
  $(function() {
    $("#limelight").osmplayer({
      width: '100%',
      height: '600px'
    });
  });
</script>
<video id="limelight" src="http://link.videoplatform.limelight.com/media/?mediaId=0baeffa8ed8349758d18654614bd42a3&playerForm=b75b8d0290574a609d3af729b49d9e15"></video>

 -->
</html>