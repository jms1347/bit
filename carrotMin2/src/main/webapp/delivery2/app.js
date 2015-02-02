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
		var ccname = data.ccname;
		var oddate = data.oddate;
		var mlevel = data.mlevel;
		
		/*if(mlevel == '1'){
			$.post('../json/delivery2/title.do'),{
				mlevel : mlevel,
			}, function(resultMap){
				
			}
		}*/

		require(['text!templates/delivery-table.html'], function(html) {
			var template = Handlebars.compile(html);
			console.log("dname : " + ccname);
			console.log("ddate : " + oddate);
			console.log("mlevel : " + mlevel);
			$('#listDiv').html(template(data));
			$('#titleDiv').html(ccname);
			$('#titleDiv2').html(oddate);
			$('#sumDiv').html(mlevel).css('display', 'none');
			
			
	/*		.css('display', 'none')*/
		});
	});
}

