var user;
var signUpCheckEmail = false;
var signUpCheckName = false;
var regExp4 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{1,20}$/;
var regExp5 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 이메일
var regExp6 = /^[0-9a-zA-Z가-힣]([-_\.]?[0-9a-zA-Z가-힣])*$/i; // 닉네임
var regExp7 = /^[0-9]+$/; // 숫자검사

$(function() {
	$('#mcancel').click(function() {
		history.back();
	});

	$('#mjoin').click(function() {
		if ($('#mph').val().length == 0) {
			alert('핸드폰 번호는 필수 입력 항목입니다.');
			return false;
		} else if ($('#mpwd').val().length == 0) {
			alert('비밀번호는 필수 입력 항목입니다.');
			return false;
		} else if ($('#mpwd_check').val().length == 0) {
			alert('비밀번호 체크는필수 입력 항목입니다.');
			return false;
		} else if ($('#mname').val().length == 0) {
			alert('상호명은 필수 입력 항목입니다.');
			return false;
		} else if (checkph() == false) {

			alert('핸드폰 번호를 다시 입력해주세요');
			return false;
		} else if (checkPwd() == false) {
			alert('비밀번호를 다시 확인해주세요');
			return false;
		}

		$.post('../json/auth2/signup.do', {
			// 서버에 보낼 데이터를 객체에 담아 넘긴다
			clientTel : $('#mph').val(),
			clientPassword : $('#mpwd').val(),
			clientCorName : $('#mname').val(),
			scname : $('#mcode').val(),
			clientMemo : $('mmemo').val(),
			

		}, function(resultMap) {

			if (resultMap.status == "success") {
				alert("회원가입이 완료 되었습니다.");
				location.href = '../auth/Mobile_login.html';
			} else {

			}
		}, 'json')
		// 서버가 보낸 데이터를 JSON 형식으로 처리
		// 서버 요청이 실패했을 때 호출될 함수 등록
		.fail(function(jqXHR, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		});
	});
})

$(function() {
	$("#mcode").keyup(function() {
		if ($('#mcode').val() != '') {
			$.get("http://192.168.0.109:3000/searchid", {
				searchitem : $('#mcode').val()
			}, function(data) {
				$('button').remove();
				for (var i = 0; i < data.length; i++) {
					
					$('<button>').appendTo('#result')
					.attr("id","test"+i).attr("class","test")
					.attr("type","button").attr("dataname",data[i].SCNAME)
					.html(data[i].SCNAME);	
		
				}
				
				$('.test').click(function(){
					$('#test'+$('.test').index(this)).click(function(){
						console.log($('#test'+$('.test').index(this)).attr('dataname'));
						$('#mcode').val($('#test'+$('.test').index(this)).attr('dataname'));
						$('.test').css('display','none');
						
					});
				});
				
				

			}).fail(function() {
				$('button').remove();
				console.log('error');
			})
		} else {
			$('button').remove();
					
		}
	});
})

$(function() {
	$("#mph").keyup(function() { // 아이디 유효성검사
		if (checkph()) {
			$.get("http://192.168.0.109:3000/phcheck", {
				ph : $('#mph').val()
			}, function(data) {
				$('#checkMsg').html(data.result);
				if (data.result == "사용 가능합니다.") {
					$('#checkMsg').css("color", "blue");
				} else if (data.result == "가입되어 있는 핸드폰 번호입니다.") {
					$('#checkMsg').css("color", "red");
				}
			});
		}
	});
})

function checkph() { // 닉네임 유효성검사
	var swanph = document.getElementById('mph').value;
	if (swanph == null || swanph.length == 0) {
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "핸드폰 번호를 입력해주세요.";
		return false;
	} else if (!regExp6.test($('#mph').val())) {
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "특수문자나 공백을 사용 할 수 없습니다.";
		return false;
	} else if (!regExp7.test($('#mph').val())) {
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "숫자만 입력해주세요.";
		// swanph.value="";
		return false;
	}
	return true;
}

function checkPwd() { // 비밀번호 유효성검사

	var pwd = document.getElementById("mpwd").value;

	var rePwd = document.getElementById("mpwd_check").value;

	if (pwd == null || pwd.length == 0) {

		document.getElementById('checkPwd').style.color = "red";

		document.getElementById('checkPwd').innerHTML = "비밀번호를 입력해주세요.";

		return false;

	} else if (!regExp4.test($("#mpwd").val())) {

		document.getElementById('checkPwd').style.color = "red";

		document.getElementById('checkPwd').innerHTML = "비밀번호는 문자, 숫자, 특수문자의 조합으로 입력해주세요.";

		return false;

	} else if (pwd.length < 6 || pwd.length > 16) {

		document.getElementById('checkPwd').style.color = "red";

		document.getElementById('checkPwd').innerHTML = "비밀번호는 6 ~ 16 자리로 입력해주세요.";

		return false;

	} else if (pwd != rePwd) {

		document.getElementById('checkPwd').style.color = "red";

		document.getElementById('checkPwd').innerHTML = "비밀번호가 일치하지 않습니다.";

		return false;

	} else if (pwd == rePwd) {

		document.getElementById('checkPwd').style.color = "blue";

		document.getElementById('checkPwd').innerHTML = "비밀번호가 확인되었습니다.";

		return true;
		;

	}

}
