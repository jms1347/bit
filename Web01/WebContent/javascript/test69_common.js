
"use strict"; 

//window.bit = function(value) {
function bit(value) {
	var elements = null;
	
	if (value instanceof Element) {
		elements = [value];
	} else if (value.charAt(0) == '<') { // 태그일 경우,
		elements = [document.createElement(value.replace(/<|>/g, ''))];	
	} else {
		elements = document.querySelectorAll(value);
	}

	elements.text = function(value) {
		for (var i = 0; i < this.length; i++) {
			this[i].textContent = value;
		}
		return this;
	};

	elements.html = function(value) {
		for (var i = 0; i < this.length; i++) {
			this[i].innerHTML = value;
		}
		return this;createClass[i]
	};

	elements.append = function(child) {
		for (var i = 0; i < this.length; i++) {
			if (child instanceof Element) {
				this[i].appendChild(child);
			} else {
				for (var x = 0; x < child.length; x++) {
					this[i].appendChild(child[x]);
				}
			}
		}
		return this;
	};

	elements.appendTo = function(parent) {
		for (var i = 0; i < this.length; i++) {
			if (parent instanceof Element) {
				parent.appendChild(this[i]);
			} else {
				parent[0].appendChild(this[i]);
			}
		}
		return this;
	};

	elements.attr = function(name, value) {
		if (arguments.length == 2) {
			for (var i = 0; i < this.length; i++) {
				this[i].setAttribute(name, value);
			}
			return this;
		} else {
			return this[0].getAttribute(name);
		}
	};

	elements.click = function(listener) {
		for (var i = 0; i < this.length; i++) {
			if (listener) {
				this[i].onclick = listener;
			} else {
				var event = new MouseEvent('click', {
					'view': window,
					'bubbles': true,
					'cancelable': true
				});
				this[i].dispatchEvent(event);
			}
		}
		return this;
	}

	elements.val = function(value) {
		if (arguments.length == 1) {
			for (var i = 0; i < this.length; i++) {
				this[i].value = value;
			}
			return this;
		} else {
			return this[0].value;
		}
	};

	elements.css = function(name, value) {
		if (arguments.length == 2) {
			for (var i = 0; i < this.length; i++) {
				this[i].style[name] = value;
			}
			return this;
		} else {
			return this[0].style[name];
		}
	};
	
	elements.remove = function() {
		for (var i = 0; i < this.length; i++) {
			this[i].parentElement.removeChild(this[i]);
		}
		return this;
	};
	

	return elements;
}

var $ = bit;

//함수도 객체다! 저장소로 사용될 수 있다.
bit.toYYYYMMDD = function(date) {
	return date.getFullYear() + '-' +
	(date.getMonth() + 1) + '-' +
	date.getDate();
};















