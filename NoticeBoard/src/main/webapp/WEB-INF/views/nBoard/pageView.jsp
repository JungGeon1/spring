<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 카카오 api -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=83c20064cc01d434b441d9ae9303903d&libraries=services"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>



.li {
	float: right;
	padding-right: 40px;
}

.both {
	clear: both;
}
#contents {

	margin: 0 auto;
	height: 100%;
}

.boardBox {
	width: 1100px;
	height: 1000px;
	
	margin: 0 auto;
	overflow: scroll;
}

.boardinner {
	width: 380px;
	height: 450px;
	float: left;
	margin-left: 10px;
}

.boardinnerImg {
	width: 380px;
	height: 450px;
}

.img {
	width: 380px;
	height: 380px;
	margin-top: 35px;
	margin-left: 250px;
}

.wordBreak {
	word-break: break-all;
}

.commetBox {
	width: 1100px;
	margin: 0 auto;
	margin-top: 5px;
	
}.reCommetBox {
	width: 1100px;
	
	margin: 0 auto;
    display: none; 
    border: 1px solid white;
}

.btnBox {
	width: 1100px;
	
	margin: 0 auto;
}.left{
	float: right;
	padding-right: 55px;
}.right{
	float: right;
	
}.comment{
	width: 1100px;
	margin: 0 auto;
	border-bottom : 1px solid white;
	margin-bottom: 5px;
	
}

#commentText {
	margin-left: 15px;
	width: 90%;
	display: inline;
	width: 90%;
}.reCommentText {
	margin-left: 15px;
	width: 80%;
	display: inline;
	
}.cmtBtnBox{
	margin-top: 5px;
}#viewBtnBox{
	display: none;
}
/* 카카오지도 */
#mapBox{
height: 600px;
width: 100%;
}
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {width:100%;height:500px;}
#menu_wrap {top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<input id="idx" type="text" value="${idx}" hidden="">
		<input id="id" type="text" value="${nbm_id}" hidden="" readonly="readonly">
		<div class="boardBox">

			<div class="boardinner wordBreak" id="textBox"></div>
			<div class="boardinner" id="imgBox"></div>
			<div class="both left" id="viewBtnBox"> 
				<button class="btn btn-default" onclick="location.href='/nb/updatePage?idx=${idx}'">수정</button>
				<button class="btn btn-default" onclick="deleteBoard()">삭제</button>
			</div>
<div id="mapBox">			
	<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white" hidden="">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text"  id="keyword"  size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
	</div>
</div>

			
			
		</div>
	
		<div class="commetBox">
			<c:if test="${nbm_id ne null}">
				<input type="text" placeholder="댓글을 입력해 주세요" class="form-control" id="commentText">
				<button class="btn btn-default" onclick="insertComment()">OK</button>
			</c:if>
			<div id="commentList">
				
			</div>
			
		</div>
	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {

			var idx = $('#idx').val();
			viewsUp(idx);
			getViewData(idx);
			commentList()
		});
	//뿌려줄 정보를 받아온다
		function getViewData(idx) {

			$.ajax({
						url : 'rest/viewPage?category=page&idx=' + idx,
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							var html = '';
							var img = '';
							html += '<div><h2>' + data.u_title + '</h2></div>';
							html += '<div><h3>' + data.u_id + '</h3></div>';
							html += '<div><h4>' + data.u_date + '</h4></div>';
							html += '<div><p>' + data.u_contents + '</p></div>';
							img += '<img class="img" src="uploadfile/'+data.u_image+'" alt="'+data.u_image+'">';
							
							if(data.u_id=='${nbm_id}'){
								$('#viewBtnBox').css('display','block');
							}
							searchPlaces(data.u_address);
							$('#textBox').html(html);
							$('#imgBox').html(img);
						}

					});

			return false;

		}
	//조회수를 올려준다-> 본인글이면 조회수가 안올라가게 수정 예정
		function viewsUp(idx) {

			$.ajax({
				url : 'rest/viewUp/' + idx,
				type : 'put',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					//alert(data);
				}

			});

			return false;
		}
	//게시글 삭제
		function deleteBoard() {

			var idx = $('#idx').val();
			if (confirm('삭제하시겠습니까')) {
				$.ajax({
					url : 'rest/delete/' + idx + '?category=page',
					type : 'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						alert('삭제되었습니다. 리스트로 이동합니다.');
						location.href = '/nb/pageList';
					}

				});

			}
		}
		
	//댓글입력
		function insertComment() {
		if($('#commentText').val()==''){
			alert('댓글을 작성해주세요');
			return;
		}
			$.ajax({
					url:'rest/comment',
					type:'Post',
					data: {
						 n_id : $('#id').val(),
						 n_comment : $('#commentText').val(),
						 u_idx :$('#idx').val()
					},error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 등록되었습니다.');
							commentList();
							$('#commentText').val(null);
						}
					}
			});
				
				return false;
			
		}
	//답글입력
		function insertReComment(n_idx) {
			
			if($('#'+n_idx+'reCommentText').val()==''){
				alert('답글을 작성해주세요');
				return;
			}
		
			$.ajax({
					url:'rest/comment/re',
					type:'Post',
					data: {
						u_idx :$('#idx').val(),
						n_id : $('#id').val(),
						n_comment : $('#'+n_idx+'reCommentText').val(),
						n_grpno : $('#'+n_idx+'n_grpno').val(),
						n_grpord: $('#'+n_idx+'n_grpord').val(),
						n_depth :$('#'+n_idx+'n_depth').val()
					
					},error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 등록되었습니다.');
							commentList();
							$('#reCommentText').val(null);
							reCmClose(n_idx);
						}
					}
			});
				
				return false;
			
		}
	//답글 입력폼 조작
		function reComment(n_idx) {
			
			$('#'+n_idx+'').css('display','block');
			 return false;
			
		} function reCmClose(n_idx) {
			
			$('#'+n_idx+'').css('display','none');
			return false;
		
	} 
	//댓글삭제	
		function deleteCm(n_idx) {
			
			if(confirm('삭제하시겠습니까?')){
				$.ajax({
					url:'rest/comment/cDelete/'+n_idx,
					type:'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 삭제되었습니다.');
							commentList();
							
						}
					}
				});
				
				return false;
				
			}
			
		}
		
		//댓글 정보 리스트  desc
		function commentList() {
			$.ajax({
					url:'rest/comment/cList/'+$('#idx').val(),
					type:'get',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data.length);
						var html='';
						if(data.length==0){
							html +='<div class="comment">작성된 댓글이 없습니다.</div>';	
							$('#commentList').html(html);
							return false;
						}
					
						for(var i=0; i<data.length;i++){

						html +='<div class="comment">';	
						html += '<div><span>' + data[i].n_id + '</span>';
						html += '<span class="right">' + data[i].n_date + '</span></div>';
						html += '<div class="cmtBtnBox">' + data[i].n_comment;
						html += '<button class="btn btn-default btn-xs right" onclick="reComment('+data[i].n_idx+')">Recm</button>';
						if(data[i].n_id=='${nbm_id}'){
						html +='<button class="btn btn-default btn-xs right" onclick="deleteCm('+data[i].n_idx+')" >Del</button>'
						}
						html +='</div>';
						html +='</div>';
						//------------------------------------------
						html+='<div class="reCommetBox" id="'+data[i].n_idx+'">';
						html+='	<input type="text" value="'+data[i].n_grpno+'"   id="'+data[i].n_idx+'n_grpno" hidden>';
						html+='	<input type="text" value="'+data[i].n_grpord+'" id="'+data[i].n_idx+'n_grpord"  hidden>';
						html+='	<input type="text" value="'+data[i].n_depth+'" id="'+data[i].n_idx+'n_depth" hidden>';
						html+='	<input type="text" placeholder="답글을 입력해 주세요" class="form-control reCommentText" id="'+data[i].n_idx+'reCommentText">';
						html+='<button class="btn btn-default btn-xs" id="closeBtn" onclick="reCmClose('+data[i].n_idx+')">cancle</button><button class="btn btn-default btn-xs" onclick="insertReComment('+data[i].n_idx+')">OK</button>';
						html+='</div>';
						}
					$('#commentList').html(html);
				}
				
				
				
			});
		}
//카카오지도api 해당 지도에  db에 저장된 주소를 검색시켜서 위치 출력ㄴ--------------------------------------------------------------
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다


// 키워드 검색을 요청하는 함수입니다
function searchPlaces(u_adress) {

    var keyword = u_adress;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}	
	</script>
</body>
</html>