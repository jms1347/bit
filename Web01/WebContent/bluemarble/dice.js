 var face0 = new Image();
face0.src = "../bluemarble/image/d1.gif"
var face1 = new Image();
face1.src = "../bluemarble/image/d2.gif"
var face2 = new Image();
face2.src = "../bluemarble/image/d3.gif"
var face3 = new Image();
face3.src = "../bluemarble/image/d4.gif"
var face4 = new Image();
face4.src = "../bluemarble/image/d5.gif"
var face5 = new Image();
face5.src = "../bluemarble/image/d6.gif"
	
var randomdice1;
var randomdice2;


function narathrowdice() {
	randomdice1 = Math.round((Math.random() * 5));
	randomdice2 = Math.round((Math.random() * 5));
	document.images["dice1"].src = eval("face" + randomdice1 + ".src");
	document.images["dice2"].src = eval("face" + randomdice2 + ".src");
	
	//console.log(randomdice1+1);
	//console.log(randomdice2+1);
	
	naramove();
}

function hyojoothrowdice() {
	randomdice1 = Math.round((Math.random() * 5));
	randomdice2 = Math.round((Math.random() * 5));
	document.images["dice1"].src = eval("face" + randomdice1 + ".src");
	document.images["dice2"].src = eval("face" + randomdice2 + ".src");
	
	console.log(randomdice1+1);
	console.log(randomdice2+1);
	hyojoomove();
}

function minjungthrowdice() {
	randomdice1 = Math.round((Math.random() * 5));
	randomdice2 = Math.round((Math.random() * 5));
	document.images["dice1"].src = eval("face" + randomdice1 + ".src");
	document.images["dice2"].src = eval("face" + randomdice2 + ".src");
	
	console.log(randomdice1+1);
	console.log(randomdice2+1);
	minjungmove();
}

function bomithrowdice() {
	randomdice1 = Math.round((Math.random() * 5));
	randomdice2 = Math.round((Math.random() * 5));
	document.images["dice1"].src = eval("face" + randomdice1 + ".src");
	document.images["dice2"].src = eval("face" + randomdice2 + ".src");
	
	console.log(randomdice1+1);
	console.log(randomdice2+1);
	bomimove();
}
