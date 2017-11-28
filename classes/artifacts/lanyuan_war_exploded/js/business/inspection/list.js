var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			hide:true
		}, {
			colkey : "organization_code",
			name : "组织机构代码",
			//isSort:true,
			width : '120px',
		}, {
			colkey : "company_name",
			name : "企业名称",
			width : '150px',
		}, {
			colkey : "batch",
			name : "生产批次",
		},{
			colkey : "product_quantity",
			name : "生产数量",
		},  {
			colkey : "package_type",
			name : "包装种类",
		}, {
			colkey : "package_material",
			name : "包装材料",
			}, {
			colkey : "inspection_weight",
			name : "重量",
		},{
			colkey : "inspection_time",
			name : "检验时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		} ],
		jsonUrl : rootPath + '/inspection/findByPage.shtml',
		checkbox : true,
		serNumber : false
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
});
