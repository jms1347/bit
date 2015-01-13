//var client;
//
//$(document).on('click','#btnAdd',function(){
//	if (!validateForm()) return;
//
//	/*$.post(URL, 성공함수)
//   .fail(실패함수)
//   .done(성공함수2)
//   .always(마무리함수);
//	 */
//	$.post('../json/client/add.do' /* URL */
//			, { /* 서버에 보낼 데이터를 객체에 담아 넘긴다 */
//				clientTel : $('#clientTel').val(),
//				clientPassword : $('#clientPassword').val(),
//				clientCorName : $('#clientCorName').val(),
//				clientMail : $('#clientMail').val(),
//				clientName : $('#clientName').val(),
//				clientPostNo : $('#clientPostNo').val(),
//				clientAddress : $('#clientAddress').val(),
//				clientAddressDet : $('#clientAddressDet').val(),
//				clientMemo : $('#clientMemo').val()
//			} 
//			, function(result){ /* 서버로부터 응답을 받았을 때 호출될 메서드*/
//				if (result.status == "success") {
//					loadClientList(1);
//					$('#btnCancel').click(); // click 이벤트 발생시킴.
//				} else {
//					alert("등록 실패!");
//				}
//			} 
//			, 'json' /* 서버가 보낸 데이터를 JSON 형식으로 처리*/)
//			/* 서버 요청이 실패했을 때 호출될 함수 등록*/   
//			.fail(function(jqXHR, textStatus, errorThrown){ 
//				alert(textStatus + ":" + errorThrown);
//			});
//});
//
//
//$('#btnCancel').click(function(){
//	$('.my-update-form').css('display', 'none');
//	$('.my-new-form').css('display', '');
//	client = null;
//});
//
//$('#btnDelete').click(function(){
//	deleteClient($('#no').val());
//});
//
//$('#btnUpdate').click(function(){
//	if (client.clientTel == $('#clientTel').val() &&
//			client.clientPassword == $('#clientPassword').val() &&
//			client.clientCorName == $('#clientCorName').val() &&
//			client.clientMail == $('#clientMail').val() &&
//			client.clientName == $('#clientName').val() &&
//			client.clientPostNo == $('#clientPostNo').val() &&
//			client.clientAddress == $('#clientAddress').val() &&
//			client.clientAddressDet == $('#clientAddressDet').val() &&
//			client.clientMemo == $('#clientMemo').val() {
//		alert('변경한 것이 없습니다!');
//		return;
//	}
//
//	if (!validateForm()) return;
//
//	updateClient($('#no').val());
//});
//
//	$('#btnAdd').click(function(){
//		if (!validateForm()) return;
//
//		/*$.post(URL, 성공함수)
//       .fail(실패함수)
//       .done(성공함수2)
//       .always(마무리함수);
//		 */
//		$.post('../json/client/add.do' /* URL */
//				, { /* 서버에 보낼 데이터를 객체에 담아 넘긴다 */
//					clientTel : $('#clientTel').val(),
//					clientPassword : $('#clientPassword').val(),
//					clientCorName : $('#clientCorName').val(),
//					clientMail : $('#clientMail').val(),
//					clientName : $('#clientName').val(),
//					clientPostNo : $('#clientPostNo').val(),
//					clientAddress : $('#clientAddress').val(),
//					clientAddressDet : $('#clientAddressDet').val(),
//					clientMemo : $('#clientMemo').val()
//				} 
//				, function(result){ /* 서버로부터 응답을 받았을 때 호출될 메서드*/
//					if (result.status == "success") {
//						loadClientList(1);
//						$('#btnCancel').click(); // click 이벤트 발생시킴.
//					} else {
//						alert("등록 실패!");
//					}
//				} 
//				, 'json' /* 서버가 보낸 데이터를 JSON 형식으로 처리*/)
//				/* 서버 요청이 실패했을 때 호출될 함수 등록*/   
//				.fail(function(jqXHR, textStatus, errorThrown){ 
//					alert(textStatus + ":" + errorThrown);
//				});
//
//	});
//
//	function loadClient(clientNo) {
//		$.getJSON('../json/client/view.do?no=' + clientNo, 
//				function(data){
//			$('#btnCancel').click();
//
//			$('#clientTel').val(data.client.clientTel);
//			$('#clientPassword').val(data.client.clientPassword);
//			$('#clientCorName').val(data.client.clientCorName);
//			$('#clientMail').val(data.client.clientMail);
//			$('#clientName').val(data.client.clientName);
//			$('#clientPostNo').val(data.client.clientPostNo);
//			$('#clientAddress').val(data.client.clientAddress);
//			$('#clientAddressDet').val(data.client.clientAddressDet);
//			$('#clientMemo').val(data.client.clientMemo);
//
//			client = data.client;
//
//			$('.my-update-form').css('display', '');
//			$('.my-new-form').css('display', 'none');
//		});
//	}
//
//	function deleteClient(clientNo) {
//		$.getJSON('../json/client/delete.do?no=' + clientNo, 
//				function(data){
//			if (data.status == 'success') {
//				loadClientList(0);
//
//				$('#btnCancel').click();
//			}
//		});
//	}
//
//	function validateForm() {
//		if ( $('#clientCorName').val().length == 0) {
//			alert('제품명은 필수 입력 항목입니다.');
//			return false;
//		}
//
//		if ( $('#clientName').val().length == 0) {
//			alert('수량은 필수 입력 항목입니다.');
//			return false;
//		}
//
//		if ( $('#clientPassword').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientTel').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientMail').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientPostNo').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientAddress').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientAddressDet').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		if ( $('#clientMemo').val() == '0') {
//			alert('제조사를 선택하세요');
//			return false;
//		}
//
//		return true;
//	}
//
//	function updateClient() {
//		$.post('../json/client/update.do'
//				, {
//					no : $('#no').val(),
//					name : $('#name').val(),
//					quantity : $('#quantity').val(),
//					makerNo : $('#makerNo').val(),
//					madeDate : $('#madeDate').val(),
//					photofile2 : $('#photofile').val()
//				} 
//				, function(result){
//					if (result.status == "success") {
//						loadClientList(0);
//						$('#btnCancel').click(); 
//					} else {
//						alert("변경 실패!");
//					}
//				} 
//				, 'json')
//				.fail(function(jqXHR, textStatus, errorThrown){ 
//					alert(textStatus + ":" + errorThrown);
//				});
//	}