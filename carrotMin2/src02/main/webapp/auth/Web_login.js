/*function checkId() {
	var swanid = document.getElementById("inputId").value;
	if (swanid == null || swanid.length == 0) {
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "아이디를 입력해주세요.";
	} else {
		document.getElementById('checkMsg').innerHTML = "&nbsp";
	}
}

function checkPwd() { //비밀번호 유효성검사
	var swanpwd1 = document.getElementById("inputPassword3").value;

	if (swanpwd1 == null || swanpwd1.length == 0) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "비밀번호를 입력해주세요.";
	} else {
		document.getElementById('checkPwd').innerHTML = "&nbsp";
	}
}*/

$(function() {
	$('#joinbtnSelect').click(function(event){
		  location.href = '/carrot/auth/Web_join.html';
		});

	$('#btnSelect').click(function() {
		if ($('#inputId').val().length == 0) {
			alert('아이디 입력은 필수 입력 항목입니다.');
			return false;
		} else if ($('#inputPassword3').val().length == 0) {
			alert('비밀번호 입력은 필수 입력 항목입니다.');
			return false;
		}
	});
	
	var emailValid = 'null';

	$('#btnSelect').click(function(event) {
		
		$.post('../json/auth/login.do', {
			sid : $('#inputId').val(),
			spwd : $('#inputPassword3').val(),
			save : $('#login-save').is(':checked')
		}, function(data) {
			if (data.status == 'success') {
				location.href = '../auth/main.html';
			} else {
				alert('로그인 아이디 또는 암호가 맞지 않습니다.');
				$('#inputPassword3').val('');
			}
		}, 'json');

	});
})

