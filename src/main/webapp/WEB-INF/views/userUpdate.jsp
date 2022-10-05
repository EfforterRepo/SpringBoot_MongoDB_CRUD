<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 정보 업데이트</h3>
<script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.memberId.value){
                alert("유저 데이터 번호를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.userPw.value){
                alert("변경할 비밀번호가 입력되지 않았습니다.");
                return false;
            }
            
            if(!document.userInfo.userId.value){
                alert("변경할 아이디가 입력되지 않았습니다.");
                return false;
            }
            
            if(!document.userInfo.userName.value){
                alert("변경할 이름이 입력되지 않았습니다.");
                return false;
            }
        }
    </script>

<form method="post" name="userInfo" action="update_exe" onsubmit="return checkValue();">
	<fieldset id="regbox">
		<legend>유저 정보 변경</legend>
		<input type="text" placeholder="아이디" name="id"/><br/>
		<input type="text" placeholder="변경할 비밀번호" name="name"/><br/>
		<input type="text" placeholder="변경할 이름" name="address"/><br/>
		<input type="submit" value="회원 정보 수정">
	</fieldset>
</form>



</body>
</html>