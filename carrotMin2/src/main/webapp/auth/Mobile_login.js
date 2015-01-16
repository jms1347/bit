

$(function() {
	$('#mjoin').click(function(event){
		  location.href = '/carrot/auth/Mobile_join.html';
		});

	$('#mlogin').click(function() {
		if ($('#mph').val().length == 0) {
			alert('아이디 입력은 필수 입력 항목입니다.');
			return false;
		} else if ($('#mpwd').val().length == 0) {
			alert('비밀번호 입력은 필수 입력 항목입니다.');
			return false;
		}
	});
	
	var emailValid = 'null';

	$('#mlogin').click(function(event) {
		
		$.post('../json/auth2/login.do', {
			clientTel : $('#mph').val(),
			clientPassword : $('#mpwd').val(),
			save : $('#login-save').is(':checked')
		}, function(data) {
			if (data.status == 'success') {
				location.href = '../auth/mobile_main.html';
			} else {
				alert('로그인 아이디 또는 암호가 맞지 않습니다.');
				$('#mpwd').val('');
			}
		}, 'json');

	});
})

