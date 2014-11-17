		//게임판 생성
		$(function() {
			var bg = [];
			for (var i = 0; i < 11; i++) {
				bg[i] = $('<div class="northline" id = "div'+i+'"></div>')
						.appendTo('#north');
				$('<img src ="../bluemarble/image/bg'+i+'.png">').appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">깃발</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'"> </div>').appendTo(
						'#div' + i + '');
			}

			for (var i = 11; i < 21; i++) {
				bg[i] = $('<div class="eastline" id = "div'+i+'"></div>')
						.appendTo('#east');
				$('<img src ="../bluemarble/image/bg'+i+'.png">').appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">깃발</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'"> </div>').appendTo(
						'#div' + i + '');
			}

			for (var i = 30; i > 20; i--) {
				bg[i] = $('<div class="southline" id = "div'+i+'"></div>')
						.appendTo('#south');
				$('<img src ="../bluemarble/image/bg'+i+'.png">').appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">깃발</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'"> </div>').appendTo(
						'#div' + i + '');
			}
			for (var i = 39; i > 30; i--) {
				bg[i] = $('<div class="westline" id = "div'+i+'"></div>')
						.appendTo('#west');
				$('<img src ="../bluemarble/image/bg'+i+'.png">').appendTo('#div' + i + '');
				$('<div id = "flag'+i+'">깃발</div>').appendTo('#div' + i + '')
													.css("background-color", "lightgray");
				$('<div id = "infor'+i+'"> </div>').appendTo('#div' + i + '');
			}

		});
