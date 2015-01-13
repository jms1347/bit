var currPageNo;
var maxPageNo;


//$(document).ready(function(){});
$(function() {
	$('.form').load('form.html');
	
	loadGoodsList(1);

	$(document).on('click', '.data-row a', function() {
		loadGoods($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteGoods($(this).attr('data-no'))
		loadGoods(0);
	});
});

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

function loadGoodsList(pageNo) {
	if (pageNo <= 0)
		pageNo = currPageNo;
	$.getJSON('../json/goods/list.do?pageNo=' + pageNo, 
	function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var goodss = data.goodss;
		
		require([ 'text!templates/goods-table.html' ], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		});
	});
}
