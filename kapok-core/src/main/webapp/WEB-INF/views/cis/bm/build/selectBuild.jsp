<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${system_name}-${company_name}</title>
<link rel="stylesheet" href="${ctx}/resources/libs/${fontAwesome}/css/font-awesome.min.css" type="text/css">
<!--[if IE 7]> 
	<link rel="stylesheet" href="${ctx}/resources/libs/${fontAwesome}/css/font-awesome.min.css"> 
<![endif]-->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/libs/${jqueryEasyui}/themes/metro-blue/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/resources/libs/${jqueryEasyui}/themes/icon.css">
<link rel="stylesheet" href="${ctx}/resources/css/gxwlui.css">
<link rel="stylesheet" href="${ctx}/resources/css/page.css">
<style type="text/css">
	.aaaa{
		padding: 0 10px;
		margin: 0;
	}
</style>
</head>

<body>
<div id="mainTab" class="easyui-panel" style="width:100%;height:100%; margin: 0; padding: 0;">
     <div title="列表" style="position:relative;">
     	 <div id="query">
		    <form id="queryForm" class="formCls" method="post">
		    	 <table style="padding: 5px 0 6px 0;">
					<tr>
						<!-- <td class="aaaa">
							<label>小区名称</label> 
							<input id="q_cisBmCommunityMsg.communityName_LIKE" name="q_cisBmCommunityMsg.communityName_LIKE" type="text" />
						</td> -->
						<td class="aaaa">
							<label>楼栋号</label> 
							<input id="q_ldCode_LIKE" name="q_ldCode_LIKE" type="text" />
						</td>
						<td>
							<a href="javascript:void(0);" onclick="query();"
								class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">查询</a> 
								
							<a href="javascript:void(0);" onclick="clearQueryForm('#queryForm');"
								class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-undo'">重置</a>
						</td>
					</tr>
				</table>
		    </form>
		</div>
			<table id="listGrid" style="height: 323px;"></table>
     </div>
    <div id="toolbar" class="dialog-button" style="border: 0;">
		<a id="confirm" href="javascript:void(0);" class="easyui-linkbutton g-button" onclick="window.actions.confirm($('#listGrid').datagrid('getSelected'));" >确定</a> 
		<a id="cancel" href="javascript:void(0);" class="easyui-linkbutton g-button" onclick="window.actions.cancel();">取消</a>
	</div>
</div>

	<script type="text/javascript" src="${ctx}/resources/libs/${jqueryEasyui}/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/resources/libs/${jqueryEasyui}/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/resources/libs/${jqueryEasyui}/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/gxwl.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/public.js"></script>
	<script type="text/javascript">
	
		var data = {};
	
		$(function() {
			
			
			var o = window.params.queryParams();
			
			if(o && o.comId){
				data['q_cisBmCommunityMsg.comId_EQ'] = o.comId ;
			}
			
			$("#listGrid").datagrid({
				rownumbers : true,
				singleSelect:true,
				autoRowHeight : false,
				border : false,
				pagination : true,
				queryParams: $.extend(true, getFormData("#queryForm") ,data ),
				url : "${ctx}/buildingmsg/search",
				columns : [ [ {
					field : "buildId",
					hidden:true,
				}, {
					field : "org",
					title : "所属机构",
					width : 150,
					align:'left',
					formatter :  function (value,row,index){
						
						return  publicAttr.getOrgName(value);
					}
				},{
					field:"communityName",
					title:"小区名称",
					width:150,
					align:'left'
				},{
					field:"ldCode",
					title:"楼栋号",
					width:100,
					align:'left'
				}]]
			});

			$("#listGrid").datagrid("getPager").pagination({
				layout : defaultPageLayout
			}); 
		});

		function query() {
			$("#listGrid").datagrid("load", $.extend(true, getFormData("#queryForm") ,data ));
		}
	</script>

</body>
</html>