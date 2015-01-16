var currPageNo;
var maxPageNo;

//$(document).ready(function(){});
$(function(){
  $('.header').load('../common/header.html');
  
  loadCompanyList(1);
  
  $(document).on('click', '.data-row a', function(){
    loadCompany($(this).attr('data-no'));
  });
  
  $(document).on('click', '.my-delete-btn', function(){
    deleteCompany($(this).attr('data-no'))
    loadCompany(0);
  });
});

$('#prevBtn').click(function(event){
	if (currPageNo > 1) {
		loadCompanyList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event){
	if (currPageNo < maxPageNo) {
	  loadCompanyList(currPageNo + 1);
	}
});

function setPageNo(currPageNo, maxPageNo) {
  window.currPageNo = currPageNo;
  window.maxPageNo = maxPageNo;
  
  $('#pageNo').html(currPageNo);
  
  if (currPageNo <= 1) $('#prevBtn').css('display', 'none');
  else $('#prevBtn').css('display', '');
  
  if (currPageNo >= maxPageNo) $('#nextBtn').css('display', 'none');
  else $('#nextBtn').css('display', '');
}
	
function loadCompanyList(pageNo) {
  if (pageNo <= 0) pageNo = currPageNo;
  
	$.getJSON('../json/company/list.do?pageNo=' + pageNo, 
    function(data){
      setPageNo(data.currPageNo, data.maxPageNo);
      var companys = data.companys;
      
      require(['text!templates/company-table.html'], function(html){
        var template = Handlebars.compile(html);
        $('#listDiv').html( template(data) );
      });
    });
}
	
                                                                                       





$(document).on('click', '#closeModal', function() {
  $('input').val('');
});


$(document).on('click', '#btnCancel', function() {
// $('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
	$('input').val('');
	companys = null;
});

$(document).on('click', '#btnDelete', function() {
// $('#btnDelete').click(function(){
	deleteCompanys($('#no').val());
});

$(document).on('click', '#btnUpdate', function() {
// $('#btnUpdate').click(function(){
	if (supplier.sid == $('#sid').val() &&
			supplier.sphonenum == $('#sphonenum').val() &&
			supplier.scname == $('#scname').val() &&
			supplier.sname == $('#sname').val() &&
			supplier.snum == $('#snum').val() &&
			supplier.spostnum == $('#spostnum').val() &&
			supplier.saddr == $('#saddr').val() &&
			supplier.saddr_dep == $('#saddr_dep').val() &&
			supplier.snote == $('#snote').val()) {
		alert('변경한것이 없습니다');
		return;
	}
// if (!validateForm()) return;
	updateCompanys($('#no').val());
});

$(document).on('click', '#btnAdd', function() {
	$('#btnCancel').click();
// $('#btnAdd').click(function(){
	$.post('../json/company/add.do'/* URL */ , 
			{
			sid : $('#sid').val(),
			stel : $('#sphonenum').val(),
			scname : $('#scname').val(),
			sname : $('#sname').val(),
			snum : $('#snum').val(),
			spostno : $('#spostnum').val(),
			saddr : $('#saddr').val(),
			saddr_dep : $('#saddr_dep').val(),
			snote : $('#snote').val()
			}, function(result) {
				if (result.status == "success") {
					loadCompanysList(maxPageNo);
					$('#btnCancel').click();
					$('#closeModal').click();
						
				} else {
					alert("등록 실패!");
				}
			}/* 서버로부터 응답을 받았을 때 호출될 메서드 */
			, 'json'/* 서버가 보낸 데이터를 JSON형식으로 처리 */)
			/* 서버 요청이 실패했을때 호출될 함수 등록 */
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});

});







































