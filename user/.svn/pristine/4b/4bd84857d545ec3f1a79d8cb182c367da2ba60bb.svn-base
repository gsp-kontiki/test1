// 判断字符串是否为空或空字符或长度是否为0
function reg_NULL(str){
	if(str==undefined||str==""||str.length==0){
		return true;
	}
	return false;
}

function isUrl(str) {
	var strRegex="([a-zA-z]+://[^\s]*)";
	var re = new RegExp(strRegex);
	return re.test(str);
}

//alert后select和focus
function alertSelectFocus(id, alertMessage) {
	alert(alertMessage);
	selectFocus(id);
}

// select和focus
function selectFocus(id) {
	if (id != "") {
		$("#" + id).select();
		$("#" + id).focus();
	}
}
