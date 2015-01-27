var currPageNo;
var maxPageNo;

$(function() {
  $('.header').load('../common/header.html');
	$('.form').load('form.html');

	loadDeliveryList(1);

	$(document).on('click', '.data-row a', function() {
		loadDeliveryList($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		delete($(this).attr('data-no'));
		loadDeliveryList(0);
	});
});

$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadDeliveryList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadDeliveryList(currPageNo + 1);
	}
});

function setPageNo(currPageNo, maxPageNo) {
	window.currPageNo = currPageNo;
	window.maxPageNo = maxPageNo;

	$('#pageNo').html(currPageNo);

	if (currPageNo <= 1)
		$('#prevBtn').css('display', 'none');
	else
		$('#prevBtn').css('display', '');

	if (currPageNo >= maxPageNo)
		$('#nextBtn').css('display', 'none');
	else
		$('#nextBtn').css('display', '');
}

function loadDeliveryList(pageNo) {
	if (pageNo <= 0)
		pageNo = currPageNo;

	$.getJSON('../json/delivery2/list.do?pageNo=' + pageNo,
		function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var deliverys = data.deliverys;

		require(['text!templates/delivery-table.html'], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		});
	});
}

function loadDelivery(goodsNo) {
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