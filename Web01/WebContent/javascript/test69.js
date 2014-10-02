"use strict"; 

//목표 : 라이브러리화 5
//val() 함수에 읽기 기능 추가
//삭제, 변경 버튼의 리스너 추가
//bit()함수를 변경 => querySelectorAll()을 사용하여 처리.



changeState('create');

var toYYYYMMDD = new Date();

function changeState(state) {
	var stateMap = {
			create: 'none',
			detail: 'none'
	};

	stateMap[state] = '';


		$('.detail').css('display', stateMap.detail);
		$('.create').css('display', stateMap.create);
}

//게시글을 저장하는 객체 생성자 함수
function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	$('#btnCancel').click();
}

var boardList = [];

$('#btnCancel').click(function(event) {
	changeState('create');
});

$('#btnAdd').click(function(event) {
	var board = new Board(
			$('#title').val(),
			$('#content').val(),
			$('#writer').val(),
			$('#password').val());

	boardList.push(board);

	resetForm();

	refreshBoardList();
});



$('#btnDelete').click(function(event){
	var no = $('#no').value; //html input박스에 번호를 가져오기위해
	boardList.splice(no, 1); //배열에서 게시물 삭제
	refreshBoardList(); //지운후 리프레쉬
	resetForm(); //폼 리셋.
});

$('#btnChange').click(function(event){
	var no = $('#no').value; //no 라는 input박스의 값을 달라고 요청
	var board = boardList[no]; //boarList에 no방에 들어있는 객체를 baord로 가져옴
	board.title = $('#title').val(); //제목 변경
	board.content = $('#content').val(); //값 변경
	refreshBoardList();
});



function refreshBoardList() {
	var boardTable = $('#boardTable');
	//var tbody = boardTable.children[0]; // <tbody>
	$('.dataRow').remove();

	for (var i in boardList) {
		$('<tr>')
			.appendTo(boardTable)
			.attr('class','dataRow')
			.append($('<td>').html(i))
			.append($('<td>')
					.append($('<a>')
							.attr('bno', new String(i))
							.attr('href', '#')
							.click(loadBoardDetail)
							.html(boardList[i].title)))
			.append($('<td>').html(boardList[i].writer))
			.append($('<td>').html($.toYYYYMMDD(boardList[i].date)))
			.append($('<td>').html(boardList[i].count));
			
	}
}

function loadBoardDetail(event) {
	event.preventDefault();

	changeState('detail');

	var board = boardList[this.getAttribute('bno')];
	$('#no').val($(this).attr('bno'));
	$('#title').val(board.title);
	$('#content').val(board.content);
	$('#writer').val(board.writer);
	$('#date').val($.toYYYYMMDD(board.date));
}















