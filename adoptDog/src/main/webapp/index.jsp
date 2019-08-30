<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%session.setAttribute("m_Id", "ukpyo");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>


*{
padding: 0;
margin: 0;
}
#conents{
width: 1810px;
margin: 0 auto;

}

#dImg{
width: 430px;
height: 380px;
}

 #MOVE_TOP{
  	text-decoration: none;
    position: fixed;
    right: 2%;
    bottom: 30px;
    display: none;
    color: black; 
    font-size:30px;  
 
}
#applyBox{
	display: none;
}
#editBox{
	display: none;
}#listOff{
	display: none;
}#onSearch:hover{
	text-decoration: underline;
}#applyListBox{
display: none;
}
.border{
	width: 1808px;
	height: 200px;
	overflow: auto;
	border: 1px soild #ddd;
	
	
}textarea {
	width: 400px;
	height:200px;
}#item{
float:left;
width: 450px;
height:660px;
border: 1px solid #ddd;
}#searchItem{

width: 450px;
height:660px;
border: 1px solid #ddd;
}

#itemIn{
width: 430px;
height: 650px;
margin: 0 auto;

}#searchItemIn{
width: 430px;
height: 650px;
margin: 0 auto;

}
#applyItem{
border: 1px solid #ddd;
}
#dogChar{
height:40px;
width: 430px;
overflow: auto;
}.listBtn {

    width:100px;
    background-color: #000000;
    border: none;
    color:#fff;
    padding: 15px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 17px;
    margin : 10px 0;
    cursor: pointer;

}/* .itemBtn {

    width:50px;
    background-color: #000000;
    border: none;
    color:#fff;
    padding: 12px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 12px;
    margin : 10px 0;
    cursor: pointer;

} */



</style>
</head>
<body>
<div id="conents">
<div id="applyBox">
<button onclick="cansleApply()">x</button>
<form id="apply">
  <table>
       <tr>
          <td>유기번호</td><td><input type="text" id="a_desertionNo" name="a_desertionNo" readonly="readonly" ></td>
      </tr>
      <tr>
          <td>아이디 </td><td><input type="text" id="m_id" name="m_id" required="required" readonly="readonly"  value="<%=session.getAttribute("m_Id") %>" ></td>
      </tr>
       <tr>
          <td>신청제목</td><td><input type="text" id="a_title" name="a_title" required="required"></td>
       </tr>
        <tr>
          <td>신청내용</td><td><textarea id="a_text" name="a_text" required="required"></textarea></td>
       </tr>
      <tr><td><input type="submit" value="신청" class="itemBtn"></td></tr>
  </table>
</form>
</div>

<div id="editBox">
<button onclick="cansleEdit()">x</button>
<form id="edit">
  <table>
  	<tr>
          <td>게시글번호</td><td><input type="text" id="e_idx" name="a_idx" readonly="readonly"></td>
      </tr>
       <tr>
          <td>유기번호</td><td><input type="text" id="e_desertionNo" name="a_desertionNo" readonly="readonly"></td>
      </tr>
      <tr>
          <td>아이디 </td><td><input type="text" id="e_id" name="m_id" readonly="readonly"></td>
      </tr>
       <tr>
          <td>신청제목</td><td><input type="text" id="e_title" name="a_title" required="required"></td>
       </tr>
        <tr>
          <td>신청내용</td><td><textarea id="e_text" name="a_text" required="required"></textarea></td>
       </tr>
      <tr><td><input type="submit" value="수정" class="itemBtn"></td></tr>
  </table>
</form>
</div>

	
	<div><button class="listBtn" id="listOn" onclick="showList()">신청목록</button><button class="listBtn" id="listOff" onclick="cansleApplyList()">목록닫기</button></div>
	<div id="applyListBox">
	<div class="searchBox">
	
		<form id="searchList">
			<h3>검색</h3>
			<select name="stype" id="stype">
				<option value="sboth">아이디+번호</option>
				<option value="sid">아이디</option>
				<option value="snumber">번호</option>
			</select>
			<input type="text" name="keyword" id="keyword"> <input type="submit" value="검색" class="itemBtn">
		</form>
	</div>	
	<div id="applyList">
	</div>
	</div>
	<div id="apiSearch"></div>
	
	<div id='list'></div>
	<a id="MOVE_TOP" href="#">TOP</a>
	
	<%-- <%      
	
			int loginChk=0;
			if(session.getAttribute("m_Id")!=null){
				loginChk=1;
			}
	%> --%>
	
	</div>
</body>
<script>


 $(document).ready(function() {
		var count=1;
		list(count);
		
	//무한스크롤 이벤트	
	 $(function(){
	        $(window).scroll(function(){
	            let $window = $(this);
	            let scrollTop = $window.scrollTop();
	            let windowHeight = $window.height();
	            let documentHeight = $(document).height();
	            
	            console.log("documentHeight:" + documentHeight + " | scrollTop:" + scrollTop + " | windowHeight: " + windowHeight );
	            
	            
	            if( scrollTop + windowHeight + 50 > documentHeight ){
	            	count++;
	                list(count);
	            }
	        })
	       
	    })
});
	
	/* 스크롤 top 이벤트 */
	$(window).scroll(function (){
		if($(this).scrollTop()>500){
			$('#MOVE_TOP').fadeIn();
		}else{
			$('#MOVE_TOP').fadeOut();
		}
	});	
	$('#MOVE_TOP').click(function() {
		$('html,body').animate({
			scrollTop :0
		},500);
		return false;
	});
		
 
	//api 뽑아오기
	    
function list(count) {

		$.ajax({
					//url : 'dogList',
					url : 'http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20190430&pageNo='+count+'&numOfRows=10&upkind=417000&ServiceKey=w6tghMtfkPZl5OXy9wZ9CkT5WTgS0LAnwimWMdM2Bdqma5ru5Zf6vRLWPxELbS6A%2FZEU4mr333w4PAaHsdixGQ%3D%3D',
					type : 'GET',
					dataType : 'xml',

					error : function(error) {
						alert(error);
					},
					success : function(data) {
						var html='';
						console.log(data);
						$.each($(data).find('item'), function(idx, val) {
							console.log(val);
							var dNO=$(val).find('desertionNo').text();
						
							
							
							html+='<div id="item">';
							html+='<div id="itemIn">';
					  		html+='<div>유기번호 : '+$(val).find('desertionNo').text()+'</div>';
							html+='<br>';
							html+='<div>견종 : '+$(val).find('kindCd').text()+'</div>';
							html+='<div>성별 : '+$(val).find('sexCd').text()+'</div>';
							html+='<div>나이 : '+$(val).find('age').text()+'</div>';
							html+='<div>체중 : '+$(val).find('weight').text()+'</div>';
							html+='<div>담당자 : '+$(val).find('chargeNm').text()+'</div>';
							html+='<div>담당자 연락쳐 : '+$(val).find('officetel').text()+'</div>';
							html+='<div>상태 : '+$(val).find('processState').text()+'</div>';
							html+='<div id="dogChar">특징 : '+$(val).find('specialMark').text()+'</div>';
							html+='<br>';
							html+='<img id="dImg" src="'+$(val).find('popfile').text()+'">';
							html +='<div><button onclick="insert('+dNO+')">입양신청</button></div><br>\n';
							html+='</div>';
							html+='</div>';
						     
						
						});
						$('#list').append(html);
					}

			});
	}

	
	//신청하기 누를시 신청폼에 값을 바인딩해주고 입양이 진행중인지 확인해주는 함수
function insert(dNO){
	$.ajax({
		url : 'http://localhost:8080/abandonedDog/rest/chk?dno='+dNO,
        type : 'GET',
        dataType : 'text',
        error : function(error){
            
            alert(error);
            
        },
        success : function(data){
        	if(data=='success'){
        	$('#applyBox').css('display','block');
            $('#a_desertionNo').val(dNO);
            $('html,body').animate({
    			scrollTop :0
    		},400);  
            
        }else{
        	alert('이미 분양이 진행중입니다.');
        }
      }          
        
   });
	return false;
	
}	
	


//취소
function cansleApply() {
	$('#applyBox').css('display','none');
}
function cansleEdit() {
	$('#editBox').css('display','none');
}
function cansleApplyList() {
	$('#applyListBox').css('display','none');
	$('#listOff').css('display','none');
	$('#listOn').css('display','block');
}function cansleSearch() {
	$('#apiSearch').css('display','none');
}
	
/* 	function applyChk(dNO) {
		
		
		 $.ajax({
            url : 'http://localhost:8080/abandonedDog/rest/chk?dno='+dNO,
            type : 'GET',
            error : function(error){
                
                alert(error);
                
            },
            success : function(data){
            	$('#apply').css('display','block');
                $('#a_desertionNo').val(dNO);
                $('html,body').animate({
        			scrollTop :0
        		},400);            
            
                }          
            
        });
		return false;
		
	} */
	
	
	
	
	//insert
	$('#apply').submit(function(){
                 
		
               $.ajax({
                url : 'http://localhost:8080/abandonedDog/rest',
                type : 'POST',
                data :$('#apply').serialize(),
                dataType: 'text',
                error : function(error){
                    alert(error);
                },success : function(data){
              
                    //alert(data);
                    if(data=='success'){
                        alert('신청이 완료되었습니다');
                        cansleApply();
                        showList();
                    } 
                }
            });
            
            this.reset();
            return false;
        });
	//list
function showList() {
		$('#applyListBox').css('display','block');
		$('#applyList').addClass('border');
		$('#listOff').css('display','inline');
		$('#listOn').css('display','none');
		$.ajax({
			url : 'http://localhost:8080/abandonedDog/rest',
			type: 'GET',
			error : function(error) {
				alert(error);
			},success : function(data){
				   var html = '';
				  
	                for(var i=0; i<data.length;i++){
	                	
	                    html += '<div id="applyItem">\n';
	                    
	                    html += '유기번호 : <a id="onSearch" onclick="apiSearch('+data[i].a_desertionNo+')">' + data[i].a_desertionNo  +'</a>\n';
	                    html += '아이디 : '  + data[i].m_id  +'\n';
	         	        //html += '신청날짜 : ' + data[i].a_date+'\n';
	         	        html += '신청날짜 : ' + changeDate(data[i].a_date)+'\n';
	                    html += '신청제목 : ' + data[i].a_title +'\n';
	                    html += '신청내용 : ' + data[i].a_text +'<br>\n';
	                    html += '<button class="itemBtn" onclick="edit('+ data[i].a_idx +')">수정하기</button>\n';
	                    html += '<button class="itemBtn" onclick="del('+ data[i].a_idx +')">삭제하기</button>\n';
	              	    html += '</div>\n';
	                }
	                
	                $('#applyList').html(html);
			}
			
		});
		
	}
	
	

	//날짜 자르기용
	function changeDate(secDate) {
		var date = secDate.substr(0,16);
		return date;
	}
	
	//delete
	function del(idx) {
		 if(confirm('입양 안 하시게여?...인성..?')){
	           $.ajax({
	                url : 'http://localhost:8080/abandonedDog/rest/'+idx+'?id='+'<%=session.getAttribute("m_Id")%>',
	                type : 'DELETE',
	                dataType:'text',
	                success : function(data){
	                    
	                    if(data=='success'){
	                        alert('삭제되었습니다');
	                        showList();
	                      
	                    }else{
	                    	 alert('거 남에꺼 건들이지 마쇼');
		                      showList();
	                    	
	                    }       
	                }
	            });
	           
	        }
		 
	}
	
	//edit
	function edit(idx) {
		 $('#editBox').css('display','block');
		 $.ajax({
             url : 'http://localhost:8080/abandonedDog/rest/'+idx,
             type : 'GET',
             error : function(error){
                 
                 alert(error);
                 
             },
             success : function(data){
                
                $('#e_idx').val(data.a_idx);
                $('#e_desertionNo').val(data.a_desertionNo);
                $('#e_id').val('<%=session.getAttribute("m_Id")%>');
                $('#e_title').val(data.a_title);
                $('#e_text').val(data.a_text);
       
             
                 }          
             
         });
		
	}
	   
	$('#edit').submit(function(){
		if(confirm('수정하시겠습니까?')){ 
		   $.ajax({
                      url : 'http://localhost:8080/abandonedDog/rest',
                      type : 'Put',
                      contentType : 'application/json; charset=utf-8',
                      dataType : 'text',
                      data : JSON.stringify({
                    	  a_idx : $('#e_idx').val(),
                    	  a_desertionNo : $('#e_desertionNo').val(),
                    	  m_id : $('#e_id').val(),
                          a_title : $('#e_title').val(),
                          a_text : $('#e_text').val()
                      }), error : function(error){
                          alert(error);
                      }, success : function(data){
                          if(data=='success'){
                          alert('수정완료');
                           showList();
                          } else{
                        	  
                        	 alert('거 본인꺼나 다시 확인하쇼');
                          }
                      }
                  });
			 this.reset();
		 cansleEdit();
		}
	return false
		   
    });
   
//api검색
function apiSearch(dno) {
	
	alert(dno+' 를 찾아옵니다!');
	
		$.ajax({
			//url : 'dogList',
			url : 'http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20190430&pageNo=1&numOfRows=400&upkind=417000&ServiceKey=w6tghMtfkPZl5OXy9wZ9CkT5WTgS0LAnwimWMdM2Bdqma5ru5Zf6vRLWPxELbS6A%2FZEU4mr333w4PAaHsdixGQ%3D%3D',
			type : 'GET',
			dataType : 'xml',

			error : function(error) {
				alert(error);
			},
			success : function(data) {
				alert('왔어..!!왔어!!!');
				var html='';
				console.log(data);
				$.each($(data).find('item'), function(idx, val) {
					
				if($(val).find('desertionNo').text()==dno){
					
					html+='<br>';
					html+='<h3>신청된 정보입니다</h3>';
					html+='<br>';
					html+='<div id="searchItem">';
					html+='<div id="searchItemIn">';
					html+='<div>유기번호:'+$(val).find('desertionNo').text()+'</div>';
					html+='<div>견종:'+$(val).find('kindCd').text()+'</div>';
					html+='<div>성별:'+$(val).find('sexCd').text()+'</div>';
					html+='<div>나이:'+$(val).find('age').text()+'</div>';
					html+='<div>체중:'+$(val).find('weight').text()+'</div>';
					html+='<div>담당자:'+$(val).find('chargeNm').text()+'</div>';
					html+='<div>담당자 연락쳐:'+$(val).find('officetel').text()+'</div>';
					html+='<div>상태:'+$(val).find('processState').text()+'</div>';
					html+='<div>특징:'+$(val).find('specialMark').text()+'</div>';
					html+='<img id="dImg" src="'+$(val).find('popfile').text()+'">';
					html+='<div><button class="itemBtn" onclick="cansleSearch()">닫기</button></div>';
					html+='</div>';
					html+='</div>';
					
				}    
				
			});
			
			
			$('#apiSearch').html(html);
			$('#apiSearch').css('display','block');
			}

		});
		
	 
}

 

 //searchlist
$('#searchList').submit(function () {
		
		$.ajax({
			url : 'http://localhost:8080/abandonedDog/rest/searchList?stype='+$('#stype').val()+'&keyword='+$('#keyword').val(),
			type: 'GET',
			error : function(error) {
				alert(error);
			},success : function(data){
				   var html = '';
				
				   if(data.length==0){
				   
					alert('검색결과가 없습니다');
					 this.reset();
					return false;
					   
				   }
				    
				  
	                for(var i=0; i<data.length;i++){
	                	
	                    html += '<div>\n';
	                    
	                    html += '유기번호 : <a id="onSearch" onclick="apiSearch('+data[i].a_desertionNo+')">' + data[i].a_desertionNo  +'</a>\n';
	                    html += '아이디 : '  + data[i].m_id  +'\n';
	         	   	    html += '신청날짜 : ' + changeDate(data[i].a_date)+'\n';
	                    html += '신청제목 : ' + data[i].a_title +'\n';
	                    html += '신청내용 : ' + data[i].a_text +'<br>\n';
	                    html += '<button class="itemBtn" onclick="edit('+ data[i].a_idx +')">수정하기</button>\n';
	                    html += '<button class="itemBtn" onclick="del('+ data[i].a_idx +')">삭제하기</button>\n';
	              	    html += '</div>\n';
	                }
	                
	                $('#applyList').html(html);
			}
			
		});
		 this.reset();
		 return false;
		
}); 
	

</script>
</html>