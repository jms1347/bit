		function minjungmove() {
			
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			/*var dicesum = $('#minjung').attr('posit');*/
			var i = minjungposit + dicesum;

			$('#minjung').prependTo('#div' + (i) + '')
					  .css('margin', '10px');

			minjungposit = i; //현재위치 저장

			if ((minjungposit) > 40) {
				dicesum = -(40 - i);
				minjungposit = dicesum;
				i = 0;
				$('#minjung').prependTo('#div' + (dicesum) + '')
						  .css('margin','10px');
				
				$('#minjung').attr('posit',minjungposit);
				
				console.log("민정 위치", cities[minjungposit]);
				console.log("민정의 돈1", $('#minjung').attr('money'));
				console.log("플레이어1", $('#minjung').attr('owner'));

			} else {
				$('#minjung').attr('posit',i);
				console.log("민정 위치", cities[minjungposit]);
				console.log("민정의 돈1", $('#minjung').attr('money'));
				console.log("플레이어1", $('#minjung').attr('owner'));
			}
		}
	
		function MinjungCityBuy() { //성을 산다고 했을경우

			var money = $('#minjung').attr('money');
			var owner = $('#minjung').attr('owner');
			var posit = $('#minjung').attr('posit');
			var price = cities[posit].price;

			if (cities[posit].awner == "") {
				//money = (money - price);
				$('#minjung').attr('money', (money - price));
				console.log("성 가격", price);
				cities[posit].awner = owner;
				$('#flag'+posit+'')
				.css("background-color", "green");
				console.log(owner + "님이" ,cities[posit].name + "을(를) 구매 하였습니다."  )
				if($('#minjung').attr('money') <= 0){
					alert("파산되었습니다.")
					init();
				}

				console.log("money1", $('#minjung').attr('money'));
				console.log("owner1", $('#minjung').attr('owner'));
				console.log("posit1", $('#minjung').attr('posit'));

			} else if (cities[posit].awner == $('#minjung').attr('owner')) {

				if (cities[posit].level < 3) {
					cities[posit].level = (cities[posit].level + 1);
					cities[posit].toll = (cities[posit].toll * 2);

					console.log("posit2", $('#minjung').attr('posit'));
					console.log(owner , "님이 성 레벨업을 하였습니다.", "현재레벨" + cities[posit].level);
					
				} else {
					console.log("더이상 level up을 할수 없습니다.");
					console.log("posit3", $('#minjung').attr('posit'));

				}
			}  
				console.log("money2", $('#minjung').attr('money'));
				console.log("owner2", $('#minjung').attr('owner'));
				console.log("posit4", $('#minjung').attr('posit'));
				
				$('#minjungMoney').attr('value', $('#minjung').attr('money'));
				$('#minjungPosit').attr('value', posit);
			}
		
		