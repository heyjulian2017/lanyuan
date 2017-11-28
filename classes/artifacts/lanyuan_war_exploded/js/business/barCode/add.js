//单独验证某一个input  class="checkpass"
jQuery.validator.addMethod("checkacc", function(value, element) {
	return this.optional(element)
			|| ((value.length <= 30) && (value.length >= 3));
}, "账号由3至30位字符组合构成");

<!--自定义校验规则 -->
$.validator.addMethod("batchCheck",function(value,element,params) {
	if (value==""||value==null) return false;
	var re = /^\d{4}\d{2}\d{2}\d{3}$/g //匹配IP地址的正则表达式
	if (re.test(value)) {
		if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
	}
	else {
		return false;
	}
},"生产批次格式不正确");



$(function() {
	$("form").validate({
		rules : {
			"organization_code" : {
				required : true,
			},
			"batch" : {
				required : true,
				batchCheck:true
			},
			"quantity" : {
				required : true,
				digits:true,
				min:1,
			},
			"package_code" : {
				required : true,
				maxlength: 4,
			},
		},
		messages : {
			"organization_code" : {
				required : "请输入企业组织机构代码",
			},
			"batch" : {
				required : "请输入生产批次号",
				batchCheck:"生产批次格式不正确"
			},
			"package_code" : {
				required : "包装码不可为空",
				maxlength: "包装码不合法"
			},
			"quantity" : {
				required : "请输入生产数量",
				digits:"请输入正整数",
				min:"输入值必须大于零"
			}
		},
		errorPlacement : function(error, element) {
			// 自定义提示错误位置
			$(".l_err").css('display', 'block');
			// element.css('border','3px solid #FFCCCC');
			$(".l_err").html(error.html());
		},
		success : function(label) {// 验证通过后
			$(".l_err").css('display', 'none');
		}
	});
});
