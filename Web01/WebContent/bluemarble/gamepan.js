		//게임판 생성
		$(function() {
			var bg = [];
			for (var i = 0; i < 11; i++) {
				bg[i] = $('<div class="northline" id = "div'+i+'"></div>')
						.appendTo('#north');
				$('<img src ="../bluemarble/image/bg'+i+'.png" id="bg'+i+'">' ).appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">&nbsp</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'">&nbsp</div>').appendTo(
						'#div' + i + '');
			}

			for (var i = 11; i < 21; i++) {
				bg[i] = $('<div class="eastline" id = "div'+i+'"></div>')
						.appendTo('#east');
				$('<img src ="../bluemarble/image/bg'+i+'.png" id="bg'+i+'">').appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">&nbsp</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'">&nbsp</div>').appendTo(
						'#div' + i + '');
			}

			for (var i = 30; i > 20; i--) {
				bg[i] = $('<div class="southline" id = "div'+i+'"></div>')
						.appendTo('#south');
				$('<img src ="../bluemarble/image/bg'+i+'.png" id="bg'+i+'">').appendTo(
						'#div' + i + '');
				$('<div id = "flag'+i+'">&nbsp</div>').appendTo('#div' + i + '')
						.css("background-color", "lightgray");
				$('<div id = "infor'+i+'">&nbsp</div>').appendTo(
						'#div' + i + '');
			}
			for (var i = 39; i > 30; i--) {
				bg[i] = $('<div class="westline" id = "div'+i+'"></div>')
						.appendTo('#west');
				$('<img src ="../bluemarble/image/bg'+i+'.png" id="bg'+i+'">').appendTo('#div' + i + '');
				$('<div id = "flag'+i+'">&nbsp</div>').appendTo('#div' + i + '')
													.css("background-color", "lightgray");
				$('<div id = "infor'+i+'">&nbsp</div>').appendTo('#div' + i + '');
			}
			
			$('#flag3').css("background-color","white");
			$('#flag7').css("background-color","white");
			$('#flag10').css("background-color","white");
			$('#flag15').css("background-color","white");
			$('#flag23').css("background-color","white");
			$('#flag27').css("background-color","white");
			$('#flag35').css("background-color","white");
			$('#flag0').css("background-color","white");
			$('#flag20').css("background-color","white");
			$('#flag30').css("background-color","white");

			
		});
