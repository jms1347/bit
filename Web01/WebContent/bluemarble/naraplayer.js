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

	


function NaraCityBuy() { //성을 산다고 했을경우

	var money = $('#nara').attr('money');
	var owner = $('#nara').attr('owner');
	var posit = $('#nara').attr('posit');
	var price = cities[posit].price;

	if (cities[posit].awner == "") {
		//money = (money - price);
		$('#nara').attr('money', (money - price));
		console.log("성 가격", price);
		cities[posit].awner = owner;
		$('#flag'+posit+'')
		.css("background-color", "blue");
		console.log(owner + "님이" ,cities[posit].name + "을(를) 구매 하였습니다."  )
		if($('#nara').attr('money') <= 0){
			alert("파산되었습니다.")
			init();
		}

		console.log("money1", $('#nara').attr('money'));
		console.log("owner1", $('#nara').attr('owner'));
		console.log("posit1", $('#nara').attr('posit'));

	} else if (cities[posit].awner == $('#nara').attr('owner')) {

		if (cities[posit].level < 3) {
			cities[posit].level = (cities[posit].level + 1);
			cities[posit].toll = (cities[posit].toll * 2);

			console.log("posit2", $('#nara').attr('posit'));
			console.log(owner , "님이 성 레벨업을 하였습니다.", "현재레벨" + cities[posit].level);
			
		} else {
			console.log("더이상 level up을 할수 없습니다.");
			console.log("posit3", $('#nara').attr('posit'));

		}
	}  
		console.log("money2", $('#nara').attr('money'));
		console.log("owner2", $('#nara').attr('owner'));
		console.log("posit4", $('#nara').attr('posit'));
		
		$('#naraMoney').attr('value', $('#nara').attr('money'));
		$('#naraPosit').attr('value', posit);
	}