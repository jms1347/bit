function NaraCityBuy() { //성을 산다고 했을경우

			var money = $('#nara').attr('money');
			var owner = $('#nara').attr('owner');
			var posit = $('#nara').attr('posit');
			var price = cities[posit].price;

			if (cities[posit].awner == "") {
				$('#nara').attr('money', (money - price));
				$('#flag'+posit).css('background-color','blue');
				
				console.log("성 가격", price);
				cities[posit].awner = owner;
				if($('#nara').attr('money') <= 0){
					alert("파산되었습니다.")
					init();
				}
				
				console.log(owner + " 님이 " + cities[posit].name +" 를(을) 구매하였습니다.");
				console.log(cities[posit]);

			} else if (cities[posit].awner == $('#nara').attr('owner')) {

				if (cities[posit].level < 3) {
					cities[posit].level = (cities[posit].level + 1);
					cities[posit].toll = (cities[posit].toll * 2);
					
					console.log(cities[posit].name + " 를(을) level up 하였습니다.");
					console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);
				} else {
					console.log("더이상 level up을 할수 없습니다.");
					alert("더이상 레벨업을 할 수 없습니다.")
					console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);

				}
			}  
				
				$('#naraMoney').attr('value', $('#nara').attr('money'));
				$('#naraPosit').attr('value', posit);
			}

function HyojooCityBuy() { //성을 산다고 했을경우

	var money = $('#hyojoo').attr('money');
	var owner = $('#hyojoo').attr('owner');
	var posit = $('#hyojoo').attr('posit');
	var price = cities[posit].price;

	if (cities[posit].awner == "") {
		$('#hyojoo').attr('money', (money - price));
		$('#flag'+posit).css('background-color','red');
		
		console.log("성 가격", price);
		cities[posit].awner = owner;
		if($('#hyojoo').attr('money') <= 0){
			alert("파산되었습니다.")
			init();
		}
		
		console.log(owner + " 님이 " + cities[posit].name +" 를(을) 구매하였습니다.");
		console.log(cities[posit]);

	} else if (cities[posit].awner == $('#hyojoo').attr('owner')) {

		if (cities[posit].level < 3) {
			cities[posit].level = (cities[posit].level + 1);
			cities[posit].toll = (cities[posit].toll * 2);
			
			console.log(cities[posit].name + " 를(을) level up 하였습니다.");
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);
		} else {
			console.log("더이상 level up을 할수 없습니다.");
			alert("더이상 레벨업을 할 수 없습니다.")
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);

		}
	}  
		
		$('#hyojooMoney').attr('value', $('#hyojoo').attr('money'));
		$('#hyojooPosit').attr('value', posit);
	}


function MinjungCityBuy() { //성을 산다고 했을경우

	var money = $('#minjung').attr('money');
	var owner = $('#minjung').attr('owner');
	var posit = $('#minjung').attr('posit');
	var price = cities[posit].price;

	if (cities[posit].awner == "") {
		$('#minjung').attr('money', (money - price));
		$('#flag'+posit).css('background-color','green');
		
		console.log("성 가격", price);
		cities[posit].awner = owner;
		if($('#minjung').attr('money') <= 0){
			alert("파산되었습니다.")
			init();
		}
		
		console.log(owner + " 님이 " + cities[posit].name +" 를(을) 구매하였습니다.");
		console.log(cities[posit]);

	} else if (cities[posit].awner == $('#minjung').attr('owner')) {

		if (cities[posit].level < 3) {
			cities[posit].level = (cities[posit].level + 1);
			cities[posit].toll = (cities[posit].toll * 2);
			
			console.log(cities[posit].name + " 를(을) level up 하였습니다.");
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);
		} else {
			console.log("더이상 level up을 할수 없습니다.");
			alert("더이상 레벨업을 할 수 없습니다.")
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);

		}
	}  
		
		$('#minjungMoney').attr('value', $('#minjung').attr('money'));
		$('#minjungPosit').attr('value', posit);
	}


function BomiCityBuy() { //성을 산다고 했을경우

	var money = $('#bomi').attr('money');
	var owner = $('#bomi').attr('owner');
	var posit = $('#bomi').attr('posit');
	var price = cities[posit].price;

	if (cities[posit].awner == "") {
		$('#bomi').attr('money', (money - price));
		$('#flag'+posit).css('background-color','orange');
		
		console.log("성 가격", price);
		cities[posit].awner = owner;
		if($('#bomi').attr('money') <= 0){
			alert("파산되었습니다.")
			init();
		}
		
		console.log(owner + " 님이 " + cities[posit].name +" 를(을) 구매하였습니다.");
		console.log(cities[posit]);

	} else if (cities[posit].awner == $('#bomi').attr('owner')) {

		if (cities[posit].level < 3) {
			cities[posit].level = (cities[posit].level + 1);
			cities[posit].toll = (cities[posit].toll * 2);
			
			console.log(cities[posit].name + " 를(을) level up 하였습니다.");
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);
		} else {
			console.log("더이상 level up을 할수 없습니다.");
			alert("더이상 레벨업을 할 수 없습니다.")
			console.log("성이름: " + cities[posit].name+ " , " + "level: " + cities[posit].level);

		}
	}  
		
		$('#bomiMoney').attr('value', $('#bomi').attr('money'));
		$('#bomiPosit').attr('value', posit);
	}

	