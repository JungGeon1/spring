<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	var chk = ${rCnt};
	if(chk>0){
		alert('가입되었습니다. 감사합니다.');
		
		location.href='/mm/main';
	} else {
		alert('회원가입이 되지 않았다. 관리자에 연락해라.');
		location.href='../main';
	}
</script>