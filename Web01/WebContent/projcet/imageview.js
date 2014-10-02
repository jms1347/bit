/*-------------------------------------------------------------------버튼*/

window.onload = initPage;
var welcomePaneShowing = true;

function initPage() {

	var buttons = document.getElementById("menu2").getElementsByTagName("a");
	for ( var i = 0; i < buttons.length; i++) {
		var currentBtn = buttons[i];
		/*currentBtn.onmouseover = showHint;
		currentBtn.onmouseout = hideHint;*/
		currentBtn.onclick = showTab;
		currentBtn.onmouseover = buttonOver;
		currentBtn.onmouseout = buttonOut;
	}
}
var buttons2 = document.getElementById("btnset").getElementsByTagName("span");
for ( var i = 0; i < buttons2.length; i++) {
	var currentBtn2 = buttons2[i];

	currentBtn2.onclick = showTab2;

}

/*function showHint() {
	if (!welcomePaneShowing) {
		return;
	}
	switch (this.title) {
	case "pencil":
		break;
	case "eraser":
		break;
	case "shapes":
		break;
	default:

	}
}

function hideHint() {

}
*/
function showTab() {

	var selectedTab = this.title;

	if (selectedTab == "pencil") {

		console.log("연필");

		$('#option').css('display', '');

		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#000000",
			radius : 3
		});
		var contorlBoard = new jQuery.BrushControl({
			controlID : document.getElementById("lineWidthChooser"),
			radius : 3
		});
		var picker = new jQuery.ColorPicker({
			targetID : document.getElementById("pickerView"),
			color : "#000000"
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "eraser") {
		console.log("지우개");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#ffffff",
			radius : 3
		});
		var contorlBoard = new jQuery.BrushControl({
			controlID : document.getElementById("lineWidthChooser"),
			radius : 3
		});

		var picker = new jQuery.ColorPicker({
			targetID : document.getElementById("pickerView"),
			color : "#000000"
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "shapes") {
		console.log("색깔");
		$('#btnset').css('display', '');
		$('option').css('display','none');
	}

}

function showTab2() {
	$('#btnset').css('display', '');
	var selectedTab = this.title;

	if (selectedTab == "black") {
		console.log("검정");

		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#000000",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "white") {
		console.log("하얀");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#ffffff",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "green") {
		console.log("초록");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#00ff00",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "blue") {
		console.log("파랑");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#0000ff",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "red") {
		console.log("빨강");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#ff0000",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "orange") {
		console.log("주황");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#ff4500",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "yellow") {
		console.log("노랑");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#ffff00",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	} else if (selectedTab == "gray") {
		console.log("회색");
		var mainBoard = new jQuery.BaseCanvas({
			canvasID : document.getElementById("view"),
			color : "#808080",
			radius : 3
		});

		jQuery(picker).bind("change", function(event) {
			mainBoard.setLineColor(picker.color);
		});

		jQuery(contorlBoard, picker).bind("change", function(event) {
			mainBoard.setLineWidth(contorlBoard.radius);
		});

	}

}

function buttonOver() {
	this.className = "active";
}
function buttonOut() {
	this.className = "";
}


/*----------------------------------------------------------------------*/
