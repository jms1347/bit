var currPageNo;
var maxPageNo;
var saveList="";
var aaa;


//$(document).ready(function(){});
$(function() {
  $('.header').load('../common/header.html');

//	$('.form').load('form.html');
	
	loadGoodsList(1);

	$(document).on('click', '.data-row a', function() {
		loadGoods($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteGoods($(this).attr('data-no'))
		loadGoods(0);
	});
	
	$(document).on('click','#order-category', function(){
		saveList = 'category';
		loadGoodsList(1,'category');
	});
	
	$(document).on('click','#order-code', function(){
		saveList = 'code';
		loadGoodsList(1,'code');
	});
	
	$(document).on('click','#order-name', function(){
		saveList = 'name';
		loadGoodsList(1,'name');
	});
});





/*
$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadGoodsList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadGoodsList(currPageNo + 1);
	}
});
*/

//paging
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
		loadGoodsList(num, saveList);		
	});
}

	
function loadGoodsList(pageNo, orderBy, category, code, name) {
	saveList = orderBy;
	
	if (pageNo <= 0)	pageNo = currPageNo;
	
	if (orderBy == null)	orderBy ="";
	if (category == null)	category ="";
	if (code == null)	code ="";
	if (name == null)	name ="";

	
		
	$.getJSON('../json/supplier/list.do?pageNo=' + pageNo + '&orderBy=' + orderBy
			+ '&category=' + category + '&code=' + code + '&name=' + name, 
	function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var goodss = data.goodss;
		require([ 'text!templates/goods-table.html' ], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		}); 	
	});
}





$(document).on('click', '#closeModal', function() {
  $('input').val('');
});


$(document).on('click', '#btnCancel', function() {
//$('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
	$('input').val('');
	goods = null;
});

$(document).on('click', '#btnDelete', function() {
//$('#btnDelete').click(function(){		
	deleteGoods($('#no').val());
});

$(document).on('click', '#btnUpdate', function() {
//$('#btnUpdate').click(function(){
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
});

$(document).on('click', '#btnAdd', function() {
	$('#btnCancel').click();
//$('#btnAdd').click(function(){
	$.post('../json/goods/add.do'/* URL */ , 
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
			}/* 서버로부터 응답을 받았을 때 호출될 메서드 */
			, 'json'/* 서버가 보낸 데이터를 JSON형식으로 처리 */)
			/* 서버 요청이 실패했을때 호출될 함수 등록 */
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
});


function loadGoods(goodsNo) {
	$.getJSON('../json/goods/view.do?no=' + goodsNo, 
			function(data){
		$('#btnCancel').click();
		$('#supplierNo').val(data.goods.supplierNo),
		$('#code').val(data.goods.code),
		$('#name').val(data.goods.name),
		$('#unit').val(data.goods.unit),
		$('#category').val(data.goods.category),
		$('#note').val(data.goods.note),
		$('#priceA').val(data.goods.priceA),
		$('#priceB').val(data.goods.priceB),
		$('#priceC').val(data.goods.priceC),
//		$('#url').val(data.goods.url)

		goods = data.goods;
		aaa = data.goods.no;
		
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