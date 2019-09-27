<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap"
	rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#header {
	text-align: center;
}

.li {
	float: right;
	padding-right: 40px;
}

.both {
	clear: both;
}



h3{
    margin: 20px auto 0
    font-size: 20px
    font-weight: 700
    text-align: center
}

.youtube{
    box-sizing: border-box
    margin: 20px auto
    padding: 30px
    width: 650px
    border: 1px solid #ddd
    background: #f5f5f5
    font-family: 'Roboto'
    font-size: 14px
    overflow: hidden
}

iframe{
        display: block
         width: 100%
         height: 80%
}
.video-title{
          box-sizing: border-box
          padding: 30px 15px
          height: 75px
          background: #fff
}
  

#yList{
          box-sizing: border-box
          margin-top: 9px
          border: 1px solid #ddd
          height: 60px
          overflow: hidden
}
          
.thumb{
          float: left
          width: 100px
          height: 100%
}
 .title{
           box-sizing: border-box
            display: table
            padding: 10px
            overflow: hidden
}

</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<%-- <input id="idx" type="text" value="${idx}" hidden=""> --%>
		<div>
			<input id="searchKeyword" type="text"><button onclick="youTubeSearch()">검색</button>
		</div>
		<div class="youTubeBox">
			<h3>SEARCH VOIDEO</h3>

			<div class="youtube">
				<div class="youtube-selected">
					<div id="youtube-player"></div>
					<p id="video-title" class="video-title"></p>
				</div>
				<div id="youtube-list" class="youtube-list">
					<ul id="yList">
					</ul>
				</div>
			</div>
		</div>

		
	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {

			var idx = $('#idx').val();
			
			

		});
	function youTubeSearch() {
		
			var keyWord=$('#searchKeyword').val();
			if($('#searchKeyword').val()==''){
				
				alert('검색어를 입력해 주세요');
				return;
			}

			$.ajax({
							dataType : "json",
							url : 'https://www.googleapis.com/youtube/v3/search'
									+ '?part=snippet'
									+ '&maxResults=10'
									+ '&order=viewCount'
									+ '&q='+keyWord
									+ '&type=video'
									+ '&videoDefinition=high'
									+ '&key=AIzaSyBId8ZWS-VaeUGI9L5qwadxCWveRGeBh8Y'
						})
				.done(
						function(data) {
							/* Initial */
							var tag = document.createElement('script');
							tag.src = "https://www.youtube.com/iframe_api";
							var firstScriptTag = document
									.getElementsByTagName('script')[0];
							firstScriptTag.parentNode.insertBefore(tag,
									firstScriptTag);

							var player;

							onYouTubeIframeAPIReady = function(event) {
								player = new YT.Player('youtube-player', {
									videoId : data.items[0].id.videoId
								});
							}

							$('#video-title').text(data.items[0].snippet.title);
						

							/* List */
							var length = data.items.length;

							for (var i = 0; i < length; i++) {
								var item = data.items[i];
								var videoThumb = item.snippet.thumbnails.medium.url;
								var videoTitle = item.snippet.title;

								li = '<li>'
										+ '<img src="'+videoThumb+'" class="thumb">'
										+ '<a class="title" onclick="youTubeSearch()">'
										+ videoTitle +'</a>'
										+ '</li>';
								$('#yList').append(li);
							}

						});
		
	}

	
	</script>
</body>
</html>