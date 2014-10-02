
(function($) {
 
	$.ColorPicker = function(options) {
		this.initialize(options);
	};
 
	$.ColorPicker.prototype = {
 
		container : null,
		position : null,
		handlerFunc : null,
		hsl : [],
		rgb : [],
		width : 0,
		radius : 0,
		color : 0,
		square : 0,
 
		initialize : function(options) {

			this.container = options.targetID;

			this.picker = $(".picker", this.container).get(0);
						 
			this.square = 100;
			this.width = 194;
			this.radius = this.width / 2 - 12;

			this.position = $(this.container).offset();
 
			$("*", this.container).mousedown(
			$.proxy(this.onMouseDown_Picker, this));

		}
		
 
	}
 
	})(jQuery);