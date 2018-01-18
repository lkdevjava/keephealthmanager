$.fn.extend({

	obj : function() {
		return this;
	},

	create : function() {
		var $msg = this;
		$msg.show();
		$msg.append('<div class="msgpostion"></div>');
		$msg.css({
			'position' : 'absolute',
			'width' : document.documentElement.clientWidth,
			'height' : document.documentElement.clientHeight,
			'background-color' : 'rgba(115, 112, 124, 0.7)'
		});
		$('.msgpostion').css({
			'position' : 'absolute',
			'width' : '300px',
			'height' : '200px',
			'top' : '50%',
			'left' : '50%',
		});
		$('.msgpostion').append('<div class="msgbox"></div>');
		$('.msgbox').css({
			'position' : 'relative',
			'width' : '300px',
			'height' : '200px',
			'bottom' : '50%',
			'right' : '50%',
			'background-color' : 'rgb(255, 255, 255)',
			'border-top-left-radius' : '15px',
			'border-top-right-radius' : '15px',
			'border-bottom-left-radius' : '5px',
			'border-bottom-right-radius' : '5px',
			'-webkit-border-top-left-radius' : '15px',
			'-webkit-border-top-right-radius' : '15px',
			'-webkit-border-bottom-left-radius' : '5px',
			'-webkit-border-bottom-right-radius' : '5px',
			'-moz--borderr-top-left-radius' : '15px',
			'-moz--borderr-top-right-radius' : '15px',
			'-moz--borderr-bottom-left-radius' : '5px',
			'-moz--borderr-bottom-right-radius' : '5px'
		});
		$('.msgbox').append('<div class="msgtitle"><div>');
		$('.msgtitle').css({
			'position' : 'relative',
			'width' : '100%',
			'height' : '50px',
			'top' : '0',
			'background-color' : 'rgb(115, 112, 124)',
			'border-top-left-radius' : '15px',
			'border-top-right-radius' : '15px',
			'-webkit-border-top-right-radius' : '15px',
			'-webkit-border-top-left-radius' : '15px',
			'-moz--border-top-left-radius' : '15px',
			'-moz--border-top-right-radius' : '15px'
		});
		$('.msgtitle').append('<div class="close">X</div>');
		$('.close').css({
			'color' : '#ffffff',
			'font-size' : '14px',
			'width' : '12px',
			'height' : '12px',
			'float' : 'right',
			'margin-top' : '19px',
			'margin-right' : '19px'
		});
		$('.close').click(function() {
			$msg.hide();
		});
		$('.msgbox').append('<div class="msgcontent"><div>');
		$('.msgcontent').css({
			'position' : 'relative',
			'width' : '300px',
			'height' : '150px',
			'top' : '0',
			'left' : '0',
			'display' : 'table-cell',
			'vertical-align' : 'middle',
			'background-color' : 'rgb(255, 255, 255)',
			'text-align' : 'center',
			'border-bottom-left-radius' : '5px',
			'border-bottom-right-radius' : '5px',
			'-webkit-border-bottom-left-radius' : '5px',
			'-webkit-border-bottom-right-radius' : '5px',
			'-moz--borderr-bottom-left-radius' : '5px',
			'-moz--borderr-bottom-right-radius' : '5px',
			'font-size' : '15px',
		});
	},

	showSuccessMessage : function(msg) {
		this.create();
		$('.msgcontent').text(msg);
	},

	close : function() {
		this.hide();
	}

});