var currPageNo;
var maxPageNo;
var saveList="";
var aaa;
var stelClick = 0;
var snameClick = 0;
var scnameClick = 0;



//$(document).ready(function(){});
$(function() {

	$('.header2').load('../common/header2.html');

//	$('.form').load('form.html');

	loadCompanyList(1);

	$(document).on('click', '.data-row a', function() {
		loadCompany($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteCompany($(this).attr('data-no'))
		loadCompany(0);
	});

	$(document).on('click','#order-stel-head',function(){
		$('#order-stel-head').css('color','red');
		setstelList();
	});
	
	$(document).on('click','#order-sname-head', function(){
		setsnameList();
	});

	$(document).on('click','#order-scname-head', function(){
		setscnameList();
	});
});


function setPageNo(currPageNo, maxPageNo) {
	window.currPageNo = currPageNo;
	window.maxPageNo = maxPageNo;

	if (currPageNo <= 1)
		$('#prevBtn').css('display', 'none');
	else
		$('#prevBtn').css('display', '');

	if (currPageNo >= maxPageNo)
		$('#nextBtn').css('display', 'none');
	else
		$('#nextBtn').css('display', '');

	$('#page-selection').bootpag({
		total: maxPageNo,
		page: currPageNo,
		maxVisible: 10 
	}).on('page', function(event, num){
		loadCompanyList(num, saveList);		
	});
}

function setstelList(){
	stelClick++;
	console.log(stelClick);
	$('#order-stel-head').css('color','red');

	if((stelClick % 2) == 0){
		saveList = 'stel';
		loadCompanyList(1,'stel');
	} else if((stelClick % 2) == 1){
		saveList = 'stelDesc';
		loadCompanyList(1,'stelDesc');
	} 
}

function setsnameList(){
	snameClick++;
	console.log(setsnameList);

	if((setsnameList % 2) == 0){
		saveList = 'sname';
		loadCompanyList(1,'sname');
	} else if((setsnameList % 2) == 1){
		saveList = 'snameDesc';
		loadCompanyList(1,'snameDesc');
	} 
}

function setscnameList(){
	scnameClick++;
	console.log(scnameClick);

	if((scnameClick % 2) == 0){
		saveList = 'scname';
		loadCompanyList(1,'scname');
	} else if((scnameClick % 2) == 1){
		saveList = 'scnameDesc';
		loadCompanyList(1,'scnameDesc');
	} 
}

function loadCompanyList(pageNo, orderBy, stel, sname, scname, stelDesc, snameDesc, scnameDesc) {
	saveList = orderBy;

	if (pageNo <= 0)	pageNo = currPageNo;

	if (orderBy == null)	orderBy ="";
	if (stel == null)	stel ="";
	if (sname == null)	sname ="";
	if (scname == null)	scname ="";
	if (stelDesc == null)	stelDesc ="";
	if (snameDesc == null)	snameDesc ="";
	if (scnameDesc == null)	scnameDesc ="";

	$.getJSON('../json/company/list.do?pageNo=' + pageNo + '&orderBy=' + orderBy
			+ '&stel=' + stel + '&sname=' + sname + '&scname=' + scname
			+ '&stelDesc=' + stelDesc + '&snameDesc=' + snameDesc + '&scnameDesc=' + scnameDesc,

			function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var companys = data.companys;
		require([ 'text!templates/company-table.html' ], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		});
	});
}

$(document).on('click', '#btnCancel', function() {
//	$('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
	$('input').val('');
	company = null;
});

$(document).on('click', '#btnDelete', function() {
//	$('#btnDelete').click(function(){		
	deleteCompany($('#no').val());
});

/*$(document).on('click', '#btnUpdate', function() {
//	$('#btnUpdate').click(function(){
	if (goods.supplierNo == $('#supplierNo').val() &&
			goods.code == $('#code').val() &&
			goods.name == $('#name').val() &&
			goods.url == $('#url').val() &&
			goods.unit == $('#unit').val() &&
			goods.category == $('#category').val() &&
			goods.note == $('#note').val() &&
			goods.priceA == $('#priceA').val() &&
			goods.priceB == $('#priceB').val() &&
			goods.priceC == $('#priceC').val()) {
		alert('변경한것이 없습니다');
		return;
	}
//	if (!validateForm()) return;
	updateGoods($('#no').val());
});*/

/*$(document).on('click', '#btnAdd', function() {
//	$('#btnAdd').click(function(){
	$.post('../json/goods/add.do' URL  , 
			{
		no : $('#no').val(),
		supplierNo : $('#supplierNo').val(),
		code : $('#code').val(),
		name : $('#name').val(),
		url : $('#url').val(),
		unit : $('#unit').val(),
		category : $('#category').val(),
		note : $('#note').val(),
		priceA : $('#priceA').val(),
		priceB : $('#priceB').val(),
		priceC : $('#priceC').val()
			}, function(result) {
				if (result.status == "success") {
					loadGoodsList(maxPageNo);
					$('#btnCancel').click();
					$('#closeModal').click();

				} else {
					alert("등록 실패!");
				}
			} 서버로부터 응답을 받았을 때 호출될 메서드 
			, 'json' 서버가 보낸 데이터를 JSON형식으로 처리 )
			 서버 요청이 실패했을때 호출될 함수 등록 
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
});*/


function loadCompany(companyNo) {
	$.getJSON('../json/company/view.do?no=' + companyNo, 
			function(data){
		$('#btnCancel').click();
		$('#sno').val(data.company.sno),
		$('#sid').val(data.company.sid),
		$('#stel').val(data.company.stel),
		$('#sname').val(data.company.sname),
		$('#scname').val(data.company.scname),
		$('#sbno').val(data.company.sbno),
		$('#spostno').val(data.company.spostno),
		$('#saddr').val(data.company.saddr),
		$('#saddr_det').val(data.company.saddr_det),
		$('#smemo').val(data.company.smemo),
//		$('#url').val(data.goods.url)

		company = data.company;
		aaa = data.company.no;


		$('#myModalLabel2').css('display', '');
		$('#myModalLabel').css('display', 'none');
	});
}

function deleteCompany(companyNo) {
	$.getJSON('../json/company/delete.do?no=' + companyNo, 
			function(data){
		if (data.status == 'success') {
			loadCompanyList(0);

			$('#btnCancel').click();
		}
	});
}



/*function updateGoods(goodsNo) {
	$.post('../json/goods/update.do'
			, {
				no : aaa,
				supplierNo : $('#supplierNo').val(),
				code : $('#code').val(),
				name : $('#name').val(),
				unit : $('#unit').val(),
				category : $('#category').val(),
				note : $('#note').val(),
				priceA : $('#priceA').val(),
				priceB : $('#priceB').val(),
				priceC : $('#priceC').val(),
				url : $('#url').val()
			}, function(result) {
				console.log(result);
				if (result.status == "success") {
					loadGoodsList(0);
					$('#btnCancel').click();
					$('#closeModal').click();
				} else {
					alert("변경 실패!");
				}
			}
			, 'json')
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
}
*/


/* 수정전 

$('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
	//goods = null;
});

$('#btnDelete').click(function(){		
	deleteGoods($('#no').val());
});

$('#btnUpdate').click(function(){
	if (goods.supplierNo == $('#supplierNo').val() &&
			goods.code == $('#code').val() &&
			goods.name == $('#name').val() &&
			goods.url == $('#url').val() &&
			goods.unit == $('#unit').val() &&
			goods.category : $('#category').val() &&
			goods.note == $('#note').val() &&
			goods.priceA == $('#priceA').val() &&
			goods.priceB == $('#priceB').val() &&
			goods.priceC == $('#priceC').val()) {
		alert('변경한것이 없습니다');
		return;
	}
	if (!validateForm()) return;

	updateGoods($('#no').val());
});


$('#btnAdd').click(function(){
	$.post('../json/goods/add.do' URL 
			no : $('#no').val(),
			supplierNo : $('#supplierNo').val(),
			code : $('#code').val(),
			name : $('#name').val(),
			url : $('#url').val(),
			unit : $('#unit').val(),
			category : $('#category').val(),
			note : $('#note').val(),
			priceA : $('#priceA').val(),
			priceB : $('#priceB').val(),
			priceC : $('#priceC').val()
			}, function(result) {
				if (result.status == "success") {
					loadGoodsList(-1);
					$('#btnCancel').click();

				} else {
					alert("등록 실패!");
				}
			} 서버로부터 응답을 받았을 때 호출될 메서드 
			, 'json' 서버가 보낸 데이터를 JSON형식으로 처리 )
			 서버 요청이 실패했을때 호출될 함수 등록 
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
});


function loadGoods(goodsNo) {
	$.getJSON('../json/goods/view.do?no=' + goodsNo, 
			function(data){
		$('#btnCancel').click();
		no : $('#no').val(data.goods.no),
		supplierNo : $('#supplierNo').val(data.goods.supplierNo),
		code : $('#code').val(data.goods.code),
		name : $('#name').val(data.goods.name),
		url : $('#url').val(data.goods.url),
		unit : $('#unit').val(data.goods.unit),
		category : $('#category').val(data.goods.category),
		note : $('#note').val(data.goods.note),
		priceA : $('#priceA').val(data.goods.priceA),
		priceB : $('#priceB').val(data.goods.priceB),
		priceC : $('#priceC').val(data.goods.priceC)

		goods = data.goods;

		$('.my-update-form').css('display', '');
		$('.my-new-form').css('display', 'none');
	});
}

function deleteGoods(goodsNo) {
	$.getJSON('../json/goods/delete.do?no=' + goodsNo, 
			function(data){
		if (data.status == 'success') {
			loadGoodsList(0);

			$('#btnCancel').click();
		}
	});
}



function updateGoods(goodsNo) {
	$.post('../json/goods/update.do'
			, {
				no : $('#no').val(),
				supplierNo : $('#supplierNo').val(),
				code : $('#code').val(),
				name : $('#name').val(),
				url : $('#url').val(),
				unit : $('#unit').val(),
				category : $('#category').val(),
				note : $('#note').val(),
				priceA : $('#priceA').val(),
				priceB : $('#priceB').val(),
				priceC : $('#priceC').val()
			}, function(result) {
				if (result.status == "success") {
					loadGoodsList(0);
				} else {
					alert("변경 실패!");
				}
			}
			, 'json')
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
}*/