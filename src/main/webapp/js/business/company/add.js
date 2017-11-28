//单独验证某一个input  class="checkpass"
jQuery.validator.addMethod("checkacc", function(value, element) {
	return this.optional(element)
			|| ((value.length <= 30) && (value.length >= 3));
}, "账号由3至30位字符组合构成");
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			"companyFormMap.organization_code" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : 'isExistOrganization_code.shtml',
					data : {
						organization_code : function() {
							return $("#organization_code").val();
						}
					}
				}
			},
			"companyFormMap.company_name" : {
				required : true,
			},
			"companyFormMap.inspection_code" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : 'isExistInspection_code.shtml',
					data : {
						inspection_code : function() {
							return $("#inspection_code").val();
						}
					}
				}
			}
		},
		messages : {
			"companyFormMap.organization_code" : {
				required : "请输入企业组织机构代码",
				remote : "该组织机构代码已经存在"
			},
			"companyFormMap.company_name" : {
				required : "请输入企业名称",
			},
			"companyFormMap.inspection_code" : {
				required : "请输入企业检验检疫代码",
				remote : "该检验检疫代码已经存在"
			},
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
