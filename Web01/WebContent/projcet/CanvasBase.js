( function( $ ) {
	
	$.BaseCanvas	= function( options ){
		
		this.initCanvas( options );
		
	};
	
	$.BaseCanvas.prototype	={
		canvas	:null,
		context :null,
		canvasPosition:null,
		cavnasW :0,
		canvasH :0,
		isPress	:false,
		clickPoint:null,
		currentPoint:null,
		actionType:0,
		lineWidth:0, 
		
		initCanvas	:function(options){
			this.canvas = options.canvasID;
			this.lineWidth = options.radius;
			this.lineColor = options.color;
			this.context = this.canvas.getContext("2d");
			this.canvasPosition	= $( this.canvas ).offset();
			this.canvasW	=$( this.canvas ).width();
			this.canvasH 	=$( this.canvas ).height();
			this.registEvent();
		},
		
		registEvent:function(){
			console.info( 'initialzie' , this );
			$( this.canvas ).mousedown( $.proxy( this.onMouseDown_Canvas, this ) );
			
		},
		
		onMouseDown_Canvas:function( event ){
			
			this.clickPoint = this.getPosition( event );
			this.currentPoint	= this.clickPoint;
			this.setContextStyle();
			$(document)
				.bind( "mousemove", $.proxy( this.onMouseMove_Canvas, this ) )
				.bind( "mouseup", $.proxy( this.onMouseUp_Canvas, this ) );
			this.isPress = true;
		},
		
		onMouseMove_Canvas : function( event ){
			if( this.isPress ){
				this.currentPoint = this.getPosition( event );
				switch( this.actionType ) {
					case 1:
						this.drawPencil();
					break;
					
					default:
						this.drawLine();
					break;
				}
				
				$.extend( true, this.clickPoint, this.currentPoint );
			}
		},
		
		onMouseUp_Canvas	:function( event ){
			
			$(document)
				.unbind( "mousemove", $.proxy( this.onMouseMove_Canvas, this ) )
				.unbind( "mouseup", $.proxy( this.onMouseUp_Canvas, this ) );
			this.isPress	=false;
		},
		
		getPosition			:function( event ){
			var x = parseInt( event.pageX - this.canvasPosition.left );
			var y = parseInt( event.pageY - this.canvasPosition.top );
			return {x:x, y:y };
		},
		

		
		setContextStyle :function(){
			this.context.strokeStyle=this.lineColor;
			this.context.lineWidth	=this.lineWidth;
		},
		
		drawPencil	:function(){
			this.context.save();
			this.context.beginPath();
			this.context.lineCap = "round";
			this.context.moveTo( this.clickPoint.x, 	this.clickPoint.y );
			this.context.lineTo( this.currentPoint.x, this.currentPoint.y );
			this.context.stroke();
			this.context.closePath();
			this.context.restore();
		},
		
		drawLine	:function(){
			this.context.beginPath();
			this.context.moveTo( this.clickPoint.x, 	this.clickPoint.y );
			this.context.lineTo( this.currentPoint.x, this.currentPoint.y );
			this.context.stroke();
			this.context.closePath();
		},
		
		setActionType	:function( nType ){
			console.info( 'nType', nType );
			if( this.actionType != nType ){
				this.actionType = nType;
			}
		},
		
		setLineWidth	:function( nSize ){
			if( this.lineWidth != nSize ){
				this.lineWidth = nSize;
				this.setContextStyle();
			}
		},
		
		setLineColor	:function( nColor ){
			this.lineColor = nColor;
			console.info( this.lineColor );
			this.setContextStyle();
		}
		
	};

	$.fn.BaseCanvas	= $.BaseCanvas;
	
})(jQuery);


( function( $ ){
		$.BrushControl=function( options ){
		this.initControl( options );
	};
	
	$.BrushControl.prototype = {
		canvas	:null,
		context :null,
		canvasPosition:null,
		cavnasW :0,
		canvasH :0,
		isPress	:false,
		clickPoint:null,
		currentPoint:null,
		min : 1,
		max : 0,
		radius:0,
		
		initControl	:function( options ){
		
			this.canvas		= options.controlID;
			this.radius = options.radius;
			this.context = this.canvas.getContext("2d");
			this.canvasW = $( this.canvas ).width();
			this.canvasH = $( this.canvas ).height();
			this.max = this.canvasH/2;
			this.canvasPosition	= $( this.canvas ).offset();
			this.registEvent();
			this.drawControl();
		},
		
		drawControl : function(){
			
			// context  
			this.context.clearRect( 0, 0, this.canvasW, this.canvasH );
			this.context.fillStyle="rgba( 100, 100, 100, 0.2)";
			
			this.context.lineWidth =3;
			this.context.strokeStyle="rgb(255, 0, 0)";
			
			// control 漳  
			this.context.fillRect( 0, 0, this.canvasW, this.canvasH );
			
			// slider  
			this.context.fillStyle="rgb( 255, 0, 0 )";
			this.context.moveTo( 1, this.canvasH/2 );
			this.context.beginPath();
			this.context.rect( 1, this.canvasH/2 , this.canvasW-1, 2 );
			this.context.fill();
			this.context.closePath();
			
			this.context.beginPath();
			this.context.fillStyle	="rgb(0,0,0)";
			var r = ( this.radius == this.min ) ? 0 : this.radius;
			this.context.arc( r/this.max *(this.canvasW-this.max), this.canvasH/2, this.radius, 0, Math.PI*2 );
			this.context.fill();
			this.context.closePath();
			console.info( (this.radius/this.max) );
		},
		
		registEvent	:function(){
			$( this.canvas ).mousedown( $.proxy( this.onMouseDown_Canvas, this ) );
				
		},
		
		onMouseDown_Canvas	:function( event ){
			
			this.clickPoint	 	=this.getPosition( event );
			this.currentPoint	=this.clickPoint;
			
			$(document)
				.bind( "mousemove", $.proxy( this.onMouseMove_Canvas, this ) )
				.bind( "mouseup", $.proxy( this.onMouseUp_Canvas, this ) );
			
			this.isPress		=true;
			this.onMouseMove_Canvas( event );
		},
		
		onMouseMove_Canvas	:function( event ){
			if( this.isPress ){
				this.currentPoint = this.getPosition( event );
				
				this.radius = this.min+(this.currentPoint.x/this.canvasW )*this.max;
				
				if( this.currentPoint.x <= this.min ){
					this.radius =this.min;
				} 
				
				if( this.currentPoint.x >= this.canvasW-this.max ) {
					this.radius = this.max;
				}
				this.drawControl();
				$.extend( true, this.clickPoint, this.currentPoint );
				$( this ).trigger( "change" );
			}
		},
		
		onMouseUp_Canvas	:function( event ){
		
			$(document)
				.unbind( "mousemove", $.proxy( this.onMouseMove_Canvas, this ) )
				.unbind( "mouseup", $.proxy( this.onMouseUp_Canvas, this ) );
			this.isPress	=false;				
		},
		
		getPosition			:function( event ){
			var x = parseInt( event.pageX - this.canvasPosition.left );
			var y = parseInt( event.pageY - this.canvasPosition.top );
			return {x:x, y:y };
		}
		
	};
	
	$.fn.BrushControl	= $.BrushControl;
		
})( jQuery );