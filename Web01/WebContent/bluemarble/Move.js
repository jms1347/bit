function naramove() {

	var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
	var i = naraposit + dicesum;
	
	$('#nara').prependTo('#div' + (i) + '')
	.css('margin', '10px');

	naraposit = i; //현재위치 저장

	if ((naraposit) > 40) {
		dicesum = -(40 - i);
		naraposit = dicesum;
		i = 0;
		$('#nara').prependTo('#div' + (dicesum) + '')
		.css('margin','10px');

		$('#nara').attr('posit',naraposit);
		
		$('#naraMoney').attr('value', $('#nara').attr('money'));
		$('#naraPosit').attr('value', $('#nara').attr('posit'));

		console.log("나라 위치", cities[naraposit]);

	} else {
		$('#nara').attr('posit',i);
		
		$('#naraMoney').attr('value', $('#nara').attr('money'));
		$('#naraPosit').attr('value', $('#nara').attr('posit'));
		
		
		console.log("나라 위치", cities[naraposit]);
	}
}

function hyojoomove() {

	var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
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
		
		$('#hyojooMoney').attr('value', $('#hyojoo').attr('money'));
		$('#hyojooPosit').attr('value', $('#hyojoo').attr('posit'));

		console.log("효주 위치", cities[hyojooposit]);

	} else {
		$('#hyojoo').attr('posit',i);
		
		$('#hyojooMoney').attr('value', $('#hyojoo').attr('money'));
		$('#hyojooPosit').attr('value', $('#hyojoo').attr('posit'));
		
		
		console.log("효주 위치", cities[hyojooposit]);
	}
}

function minjungmove() {

	var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
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
		
		$('#minjungMoney').attr('value', $('#minjung').attr('money'));
		$('#minjungPosit').attr('value', $('#minjung').attr('posit'));

		console.log("민정 위치", cities[minjungposit]);

	} else {
		$('#minjung').attr('posit',i);
		
		$('#minjungMoney').attr('value', $('#minjung').attr('money'));
		$('#minjungPosit').attr('value', $('#minjung').attr('posit'));
		
		
		console.log("민정 위치", cities[minjungposit]);
	}
}

function bomimove() {

	var dicesum = (randomdice1 + 1) + (randomdice2 + 1);
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
		
		$('#bomiMoney').attr('value', $('#bomi').attr('money'));
		$('#bomiPosit').attr('value', $('#bomi').attr('posit'));

		console.log("보미 위치", cities[bomiposit]);

	} else {
		$('#bomi').attr('posit',i);
		
		$('#bomiMoney').attr('value', $('#bomi').attr('money'));
		$('#bomiPosit').attr('value', $('#bomi').attr('posit'));
		
		
		console.log("보미 위치", cities[bomiposit]);
	}
}