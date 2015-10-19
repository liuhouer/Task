<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.7.2.js"></script>
 <link href="js/video-js/video-js.css" rel="stylesheet" type="text/css">
  <!-- video.js must be in the <head> for older IEs to work. -->
  <script src="js/video-js/video.js"></script>
  <script>
    videojs.options.flash.swf = "js/video-js/video-js.swf";
  </script>
<title>Video.js | HTML5 Video Player</title>
</head>
<body>
  <video id="video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
      poster="video/avril.jpg"
      data-setup="{}">
    <source src="video/wishyouwerehere.mp4" type='video/mp4' />
    <source src="http://video-js.zencoder.com/oceans-clip.mp4" type='video/mp4' />
    <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm' />
    <source src="http://video-js.zencoder.com/oceans-clip.ogv" type='video/ogg' />
    <track kind="captions" src="js/video-js/demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="js/video-js/demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
  </video>
  <input type="button"  onclick="progress()" value="显示进度">
  <input type="button"  onclick="play()" value="播放">
  <input type="button"  onclick="pause()" value="暂停">
  <input type="button"  onclick="setProgress()" value="设置进度"><input type="text" id="setlang" value="500"/>
  <input type="button"  onclick="Lengths()" value="视频时长">
  <input type="button"  onclick="buffereds()" value="缓冲比">
  <input type="button"  onclick="buffersPercents()" value="下载比例">
  <input type="button"  onclick="voicesHigh()" value="音量大小">
  <input type="button"  onclick="WandH()" value="视频大小">
  
  
   <!-- 获取对象：
var myPlayer = _V_(“my_video_1″);
后面那个就是就是video标签的id值，这是myPlayer就是播放器对象了。

播放：
myPlayer.play();
暂停：
myPlayer.pause();
获取播放进度：
var whereYouAt = myPlayer.currentTime();
设置播放进度：
myPlayer.currentTime(120);
视频持续时间，加载完成视频才可以知道视频时长，且在flash情况下无效
var howLongIsThis = myPlayer.duration();
缓冲，就是返回下载了多少
var whatHasBeenBuffered = myPlayer.buffered();
百分比的缓冲
var howMuchIsDownloaded = myPlayer.bufferedPercent();
声音大小（0-1之间）
var howLoudIsIt = myPlayer.volume();
设置声音大小
myPlayer.volume(0.5);

取得视频的宽度
var howWideIsIt = myPlayer.width();

设置宽度：
myPlayer.width(640);
获取高度
var howTallIsIt = myPlayer.height();
设置高度：
myPlayer.height(480);
一步到位的设置大小：
myPlayer.size(640,480);

全屏
myPlayer.enterFullScreen();
离开全屏
myPlayer.enterFullScreen(); -->
  <script type="text/javascript">
  
    var myPlayer = _V_("video_1");
   
    function progress(){
    	var whereYouAt = myPlayer.currentTime();
    	alert('你看到了'+whereYouAt);
    }
    
    function play(){
    	myPlayer.play();
    }
    
    function pause(){
    	myPlayer.pause();
    }
    
    function setProgress(){
    	var where = $("#setlang").val();
    	if(!isNaN(where)){
    	myPlayer.currentTime(where);
    	}else{
    		alert('请填个数字');
    	}
    }
    
    function Lengths(){
    	var howLongIsThis = myPlayer.duration();
    	alert(howLongIsThis);
    }
    
    function buffereds(){
    	var whatHasBeenBuffered = myPlayer.buffered();
    	alert(whatHasBeenBuffered);
    }
    
    function buffersPercents(){
    	//百分比的缓冲
    	var howMuchIsDownloaded = myPlayer.bufferedPercent();
    	alert(howMuchIsDownloaded);
    }
    
    function voicesHigh(){
    	var howLoudIsIt = myPlayer.volume();
    	alert(howLoudIsIt);
    }
    
    function WandH(){
    	//取得视频的宽度
    	var howWideIsIt = myPlayer.width();

    	//获取高度
    	var howTallIsIt = myPlayer.height();
    	alert(howWideIsIt+':'+howTallIsIt);
    }
    
    function full(){
    	myPlayer.enterFullScreen();
    }
    
    function exitFull(){
    	myPlayer.exitFullScreen();
    }
  </script>
  
  
  
 

</body>
</html>