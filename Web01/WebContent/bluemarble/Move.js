		function move(player){
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			var i = player.attr('posit') + dicesum;
			

			player.prependTo('#div' + (i) + '')
					  .css('margin', '10px');

			palyer.attr('posit',i); //현재위치 저장

			if ((player.attr('posit')) > 40) {
				dicesum = -(40 - i);
				
				palyer.attr('posit',dicesum); 
				
				i = 0;
				$('#nara').prependTo('#div' + (dicesum) + '')
						  .css('margin','10px');
				
				console.log("나라 위치", cities[player.attr('posit')]);
				console.log("나라 돈", player.attr('posit'));
			
				console.log("플레이어1", player.attr('owner'));
				
				

			} else {
				console.log("나라 위치", cities[player.attr('posit')]);
				console.log("나라 돈", player.attr('money'));
				
				console.log("플레이어1", player.attr('owner'));
			}

		}
		

		function naramove() {
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			var i = naraposit + dicesum;
			var naramoney = 5000000;

			$('#nara').prependTo('#div' + (i) + '')
					  .css('margin', '10px');

			naraposit = i; //현재위치 저장

			if ((naraposit) > 40) {
				dicesum = -(40 - i);
				naraposit = dicesum;
				i = 0;
				$('#nara').prependTo('#div' + (dicesum) + '')
						  .css('margin','10px');
				
				console.log("나라 위치", cities[naraposit]);
				console.log("나라 돈", naramoney);
				console.log("나라의 돈1", $('#nara').attr('money'));
				console.log("플레이어1", $('#nara').attr('owner'));
				
				

			} else {
				console.log("나라 위치", cities[naraposit]);
				console.log("나라 돈", naramoney);
				console.log("나라의 돈1", $('#nara').attr('money'));
				console.log("플레이어1", $('#nara').attr('owner'));
			}

		}

	
		function hyojoomove() {
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			var i = hyojooposit + dicesum;
			var hyojoomoney = 5000000;

			$('#hyojoo').prependTo('#div' + (i) + '')
						.css('margin', '25px');

			hyojooposit = i; //현재 위치 저장

			if ((hyojooposit) > 40) {
				dicesum = -(40 - i);
				hyojooposit = dicesum;
				i = 0;
				$('#hyojoo').prependTo('#div' + (dicesum) + '')
							.css('margin','25px');

				console.log("효주 위치", cities[hyojooposit]);
				console.log("효주 돈", hyojoomoney);
				
			} else {
				console.log("효주 위치", cities[hyojooposit]);
				console.log("효주 돈", hyojoomoney);
			}
		}

		/* 		if (randomdice1 == randomdice2) {

		 $('#nara').prependTo('#div' + (i) + '').css('margin', '15px');
		 naraposit = i; //������ġ ����

		 if ((naraposit) > 40) {
		 dicesum = -(40 - i);
		 naraposit = dicesum;
		 i = 0;

		 $('#nara').prependTo('#div' + (dicesum) + '').css('margin',
		 '15px');
		 console.log("���̸�", cities[naraposit]);
		 console.log("����", naramoney);
		 } else {

		 console.log('�ѹ���');
		 console.log("���̸�", cities[i]);
		 console.log("����", naramoney);
		 }
		 } else { �� �ȿ� ���ߵ� ���� �ҽ� �����Ȱ�}
		 */