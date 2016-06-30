Date.prototype.format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

var datatable_local_language = {
		"emptyTable":     "暂无数据",
	    "info":           "当前第 _START_ 至 _END_ 条数据，共 _TOTAL_ 条数据",
	    "infoEmpty":      "共 0 条数据",
	    "infoFiltered":   "(filtered from _MAX_ total entries)",
	    "infoPostFix":    "",
	    "thousands":      ",",
	    "lengthMenu":     "每页显示 _MENU_ ",
	    "loadingRecords": "<img src='../assets/images/loaders/loader6.gif' alt=''> 加载中，请稍后...",
	    "processing":     "<img src='../assets/images/loaders/loader6.gif' alt=''> 正在执行，请稍后...",
	    "search":         "搜索:",
	    "zeroRecords":    "没有找到匹配的数据",
	    "paginate": {
	        "first":      "首页",
	        "last":       "尾页",
	        "next":       "下一页",
	        "previous":   "上一页"
	    }
};