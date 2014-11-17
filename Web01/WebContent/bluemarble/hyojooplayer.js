		function hyojoomove() {
			
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			/*var dicesum = $('#hyojoo').attr('posit');*/
			var i = hyojooposit + dicesum;

			$('#hyojoo').prependTo('#div' + (i) + '')
					  .css('margin', '10px');

			hyojooposit = i; //현재위치 저장

			if ((hyojooposit) > 40) {
				dicesum = -(40 - i);
				hyojooposit = dicesum;
				i = 0;
				$('#hyojoo').prependTo('#div' + (dicesum) + '')
						  .css('margin','10px');
				
				$('#hyojoo').attr('posit',hyojooposit);
				
				console.log("효주 위치", cities[hyojooposit]);
				console.log("효주의 돈1", $('#hyojoo').attr('money'));
				console.log("플레이어1", $('#hyojoo').attr('owner'));

			} else {
				$('#hyojoo').attr('posit',i);
				console.log("효주 위치", cities[hyojooposit]);
				console.log("효주의 돈1", $('#hyojoo').attr('money'));
				console.log("플레이어1", $('#hyojoo').attr('owner'));
			}
		}
	
		function HyojooCityBuy() { //성을 산다고 했을경우

			var money = $('#hyojoo').attr('money');
			var owner = $('#hyojoo').attr('owner');
			var posit = $('#hyojoo').attr('posit');
			var price = cities[posit].price;

			if (cities[posit].awner == "") {
				//money = (money - price);
				$('#hyojoo').attr('money', (money - price));
				console.log("성 가격", price);
				cities[posit].awner = owner;
				$('#flag'+posit+'')
				.css("background-color", "red");
				console.log(owner + "님이" ,cities[posit].name + "을(를) 구매 하였습니다."  )
				if($('#hyojoo').attr('money') <= 0){
					alert("파산되었습니다.")
					init();
				}

				console.log("money1", $('#hyojoo').attr('money'));
				console.log("owner1", $('#hyojoo').attr('owner'));
				console.log("posit1", $('#hyojoo').attr('posit'));

			} else if (cities[posit].awner == $('#hyojoo').attr('owner')) {

				if (cities[posit].level < 3) {
					cities[posit].level = (cities[posit].level + 1);
					cities[posit].toll = (cities[posit].toll * 2);

					console.log("posit2", $('#hyojoo').attr('posit'));
					console.log(owner , "님이 성 레벨업을 하였습니다.", "현재레벨" + cities[posit].level);
					
				} else {
					console.log("더이상 level up을 할수 없습니다.");
					console.log("posit3", $('#hyojoo').attr('posit'));

				}
			}  
				console.log("money2", $('#hyojoo').attr('money'));
				console.log("owner2", $('#hyojoo').attr('owner'));
				console.log("posit4", $('#hyojoo').attr('posit'));
				
				$('#hyojooMoney').attr('value', $('#hyojoo').attr('money'));
				$('#hyojooPosit').attr('value', posit);
			}
		
		