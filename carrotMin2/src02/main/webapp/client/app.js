var currPageNo;
var maxPageNo;

//$(document).ready(function(){});
$(function() {
  $('.header').load('../common/header.html');
	$('.form').load('form.html');

	loadClientList(1);

	$(document).on('click', '.data-row a', function() {
		loadClientList($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteClient($(this).attr('data-no'));
		loadClientList(0);
	});
});

$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadClientList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadClientList(currPageNo + 1);
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

function loadClientList(pageNo) {
	if (pageNo <= 0)
		pageNo = currPageNo;

	$.getJSON('../json/client/list.do?pageNo=' + pageNo,
		function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var clients = data.clients;

		require(['text!templates/client-table.html'], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		});
	});
}

