		function bomimove() {
			
			var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
			/*var dicesum = $('#bomi').attr('posit');*/
			var i = bomiposit + dicesum;

			$('#bomi').prependTo('#div' + (i) + '')
					  .css('margin', '10px');

			bomiposit = i; //현재위치 저장

			if ((bomiposit) > 40) {
				dicesum = -(40 - i);
				bomiposit = dicesum;
				i = 0;
				$('#bomi').prependTo('#div' + (dicesum) + '')
						  .css('margin','10px');
				
				$('#bomi').attr('posit',bomiposit);
				
				console.log("보미 위치", cities[bomiposit]);
				console.log("보미의 돈1", $('#bomi').attr('money'));
				console.log("플레이어1", $('#bomi').attr('owner'));

			} else {
				$('#bomi').attr('posit',i);
				console.log("보미 위치", cities[bomiposit]);
				console.log("보미의 돈1", $('#bomi').attr('money'));
				console.log("플레이어1", $('#bomi').attr('owner'));
			}
		}
	
		function BomiCityBuy() { //성을 산다고 했을경우

			var money = $('#bomi').attr('money');
			var owner = $('#bomi').attr('owner');
			var posit = $('#bomi').attr('posit');
			var price = cities[posit].price;

			if (cities[posit].awner == "") {
				//money = (money - price);
				$('#bomi').attr('money', (money - price));
				console.log("성 가격", price);
				cities[posit].awner = owner;
				$('#flag'+posit+'')
				.css("background-color", "orange");
				console.log(owner + "님이" ,cities[posit].name + "을(를) 구매 하였습니다."  )
				if($('#bomi').attr('money') <= 0){
					alert("파산되었습니다.")
					init();
				}

				console.log("money1", $('#bomi').attr('money'));
				console.log("owner1", $('#bomi').attr('owner'));
				console.log("posit1", $('#bomi').attr('posit'));

			} else if (cities[posit].awner == $('#bomi').attr('owner')) {

				if (cities[posit].level < 3) {
					cities[posit].level = (cities[posit].level + 1);
					cities[posit].toll = (cities[posit].toll * 2);

					console.log("posit2", $('#bomi').attr('posit'));
					console.log(owner , "님이 성 레벨업을 하였습니다.", "현재레벨" + cities[posit].level);
					
				} else {
					console.log("더이상 level up을 할수 없습니다.");
					console.log("posit3", $('#bomi').attr('posit'));

				}
			}  
				console.log("money2", $('#bomi').attr('money'));
				console.log("owner2", $('#bomi').attr('owner'));
				console.log("posit4", $('#bomi').attr('posit'));
				
				$('#bomiMoney').attr('value', $('#bomi').attr('money'));
				$('#bomiPosit').attr('value', posit);
			}
		
		