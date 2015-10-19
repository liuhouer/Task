<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OSM</title>
 <script type='text/javascript' src="bin/jquery.js"></script>
    <script type="text/javascript" src="bin/jquery-ui.js"></script>

    <link rel="stylesheet" href="bin/css/jquery-ui.css">

    <script type="text/javascript" src="minplayer/src/minplayer.compatibility.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.flags.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.async.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.plugin.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.display.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.image.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.file.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.playLoader.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.base.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.html5.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.flash.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.minplayer.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.youtube.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.players.vimeo.js"></script>
    <script type="text/javascript" src="minplayer/src/minplayer.controller.js"></script>
    <script type="text/javascript" src="src/osmplayer.js"></script>
    <script type="text/javascript" src="src/osmplayer.parser.default.js"></script>
    <script type="text/javascript" src="src/osmplayer.parser.youtube.js"></script>
    <script type="text/javascript" src="src/osmplayer.parser.rss.js"></script>
    <script type="text/javascript" src="src/osmplayer.parser.asx.js"></script>
    <script type="text/javascript" src="src/osmplayer.parser.xspf.js"></script>
    <script type="text/javascript" src="src/osmplayer.playlist.js"></script>
    <script type="text/javascript" src="src/iscroll/src/iscroll.js"></script>
    <script type="text/javascript" src="src/osmplayer.pager.js"></script>
    <script type="text/javascript" src="src/osmplayer.teaser.js"></script>

    <!-- Include the OSM Player template files. -->
    <link rel="stylesheet" href="templates/default/css/osmplayer_default.css">
    <script type="text/javascript" src="templates/default/js/osmplayer.default.js"></script>
    <script type="text/javascript" src="templates/default/js/osmplayer.controller.default.js"></script>
    <script type="text/javascript" src="templates/default/js/osmplayer.pager.default.js"></script>
    <script type="text/javascript" src="templates/default/js/osmplayer.playLoader.default.js"></script>
    <script type="text/javascript" src="templates/default/js/osmplayer.playlist.default.js"></script>
    <script type="text/javascript" src="templates/default/js/osmplayer.teaser.default.js"></script>

    <!-- Here is how you make it come alive... -->
    <script type="text/javascript">
      $(function() {
        $("#osmplayer").osmplayer({
          width: '600px',
          height: '400px',
          playlist: 'playlist.xml'
        });
      });
    </script>
</head>
<body>
<div id="osmplayer"></div>
</body>
</html>