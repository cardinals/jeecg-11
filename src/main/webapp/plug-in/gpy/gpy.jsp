<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery"></t:base>
<link rel="stylesheet" href="plug-in/bootstrap/css/bootstrap.css" type="text/css"></link>
	<div style="width:45%;float:left;background-color: white;">
				<div>
					<div>
						<object classid="clsid:090457CB-DF21-41EB-84BB-39AAFC9E271A"
							id="ScanCtrl" codebase="*.cab#version=1,0,0,1" width="600"
							height="550"></object>
					</div>
                      
					<form>
						<table width="90%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td align="center">
										<button type="button" class="btn btn-default" onclick="start_preview()">开始预览</button>
										<button type="button" class="btn btn-default" onclick="stop_preview()">停止预览</button>
										<button type="button" class="btn btn-default" onclick="TakePic()">拍照</button>
										<button type="button" class="btn btn-default" onclick="selectAll()">全选</button>
										<button type="button" class="btn btn-default" onclick="unSelectAll()">反选</button>
										<button type="button" class="btn btn-default" onclick="uploadImg()">上传</button>
									</td>
								</tr>
								<tr>
									<td align="center"><br/>
									             设备列表：<select id="selDev" style="width: 90px" class="form-control" name="selDev" onchange="changedev()"></select>
										 旋转角度：&nbsp;&nbsp;<select id="selRotate" style="width: 90px" name="selRotate" onchange="changerotate()"></select>
									</td>
								</tr>
								<tr style="display: none;">
								  <td>
									  分辨率：<select id="selRes" style="width: 90px" name="selRes" onchange="changeresolution()"></select> 
									扫描尺寸：<select id="selScanSize" style="width: 90px" name="selScanSize" onchange="changescansize()"></select>
                                  </td>
								</tr>
							</tbody>							
						</table>
					</form>
				</div>
	</div>
	<div style="float:left;width:50%;height:525px;overflow:auto;border:1px solid #CCC;padding-top: 20px;" id="imgDiv"></div> 
 <script language=JavaScript>
$(function(){
	contentLoad();
	 var devName = ScanCtrl.GetDevName(1);
	 if(devName=="GF810"){
		ScanCtrl.SetCurDev(1);
		document.getElementById("selDev").value=1;
	}else{
		ScanCtrl.SetCurDev(0);
		document.getElementById("selDev").value=0;
	} 
});

function contentLoad(){
    ScanCtrl.EnableDateRecord(true);
  	fun();
}
//初始化
function fun(){
	deloptionDev();
	var iDevIndex = ScanCtrl.GetCurDevIndex();
	if(iDevIndex != -1){
	    	var count = ScanCtrl.GetDeviceCount();
	    	for(i = 0; i < count; i++)
	    	{
	        	var s = ScanCtrl.GetDevName(i);
			addoptionDev(s);
	    	}
		document.getElementById("selDev").value=iDevIndex;
	}
	
	deloptionRotate();
	var iRotateIndex = ScanCtrl.GetCurRotateAngle();
	if(iRotateIndex != -1){
		addoptionRotate("0");
		addoptionRotate("90");
		addoptionRotate("180");
		addoptionRotate("270");
		document.getElementById("selRotate").value=iRotateIndex;
	}
}
//开始预览
function start_preview(url){   
	ScanCtrl.StartPreviewEx();
	fun();
 }
//切换设备
function changedev(){
    var num= ScanCtrl.GetDeviceCount();
    var obj=document.getElementById("selDev").options; 
    var x = obj.selectedIndex;    
	ScanCtrl.SetCurDev(x); 
	fun();
}
//停止预览
function stop_preview(url){   
	ScanCtrl.StopPreviewEx();
	fun();
}
//生成图片名称
function get_name(){
	var date=new Date();
	var yy=date.getFullYear().toString();
	var mm=(date.getMonth()+1).toString();
	var dd=date.getDate().toString();
	var hh=date.getHours().toString();
	var nn=date.getMinutes().toString();
	var ss=date.getSeconds().toString();
	var mi=date.getMilliseconds().toString();
	var picName=yy+mm+dd+hh+nn+ss+mi;
	//var taskName = "${taskName}";
	//var caseCode = "${caseCode}";
	//picName = caseCode+"_"+taskName
	return picName;
}
//拍照   
function TakePic(url){
	var path="E:\\temp\\"+get_name()+".jpg";
	ScanCtrl.EnableDateRecord(0);
    var flag=ScanCtrl.Scan(path);
	if(flag){
		addImgToDisplay(path);
	}
 }
//显示图片
function addImgToDisplay(url){
		 var htmlString="<div style='float:left;width:120px;height:120px;margin-left:20px;'><input type='checkbox' name='imgcheck'  id='test' value='"+url+"' />";
		 //htmlString+="<img src='courtCaseController.do?imgPath&imgpath="+url+"' style='width:100px;height:100px;' /></div>";
		 htmlString+="<img src='data:image/jpg;base64,"+ScanCtrl.ScanBase64(url)+"' style='width:100px;height:100px;' /></div>";
		 var htmlStringOld=document.getElementById("imgDiv").innerHTML;
		 document.getElementById("imgDiv").innerHTML=htmlStringOld+htmlString;
}
//全选
function selectAll(){
	var objCheck=document.getElementsByName('imgcheck');
	  for(var i=0; i<objCheck.length; i++){
	   if(objCheck[i].checked==false){
	    objCheck[i].checked=true;
	   }
	  }
}
//反选
function unSelectAll(){
	var objCheck=document.getElementsByName('imgcheck');
	  for(var i=0; i<objCheck.length; i++){
	   if(objCheck[i].checked==true){
	    objCheck[i].checked=false;
	   }
	  }
}
//上传
function uploadImg(){
	  var objCheck=document.getElementsByName('imgcheck');
	  var flag = false;
	  for(var i=0;i<objCheck.length;i++){
		  if(objCheck[i].checked){
			  flag = true;
		  }
	  }
	  if(!flag){
		  alert("请选择要上传的图片！");
		  return;
	  }
	  var url="";
	  if("${seq}"!=null&&"${seq}"!=""){//是文书不是附件
		  url="${webRoot}/paperController.do?uploadPaper&taskId=${taskId}&courtCaseId=${courtCaseId}&seq=${seq}";
	  }else{//是附件
		  url="${webRoot}/courtCaseController.do?gpyUploadFile&taskId=${taskId}&courtCaseId=${courtCaseId}";
	  }
	  var isSuccess=true;
	  for(var i=0;i<objCheck.length;i++){
		  if(objCheck[i].checked){
			var a =ScanCtrl.UploadFileOfHTTP(url,objCheck[i].value ,"");
			if(!a){
				isSuccess=false;
			}  
		  }
	  }
	  if(isSuccess){
		  alert("上传成功");
	  }else{
		  alert("上传失败");
	  }
}
//旋转角度
function changerotate(){
    var   obj=document.getElementById("selRotate").options; 
    var   x = obj.selectedIndex;    
    ScanCtrl.SetVideoRotate(x);
    fun();
}
//分辨率
function changeresolution(){
    var num= ScanCtrl.GetResolutionCount();
    var obj=document.getElementById("selRes").options; 
    var x = obj.selectedIndex;    
	ScanCtrl.SetResolution(x);  
	fun();

}
//扫描尺寸
function changescansize(){
    var  num=ScanCtrl.GetScanSizeCount();
    var  obj=document.getElementById("selScanSize").options; 
    var  x = obj.selectedIndex;    
    ScanCtrl.SetScanSize(x);
    fun();
 }  
function deloptionRes(){   
    var obj=document.getElementById("selRes").options; 
    while (obj.length > 0){
        obj.options.remove(obj.length - 1);   
    }
}
function addoptionRes(s){
    var obj=document.getElementById("selRes").options; 
    var opt = new Option(s, obj.length ); 
    obj.options.add(opt);
}

function deloptionScanSize(){   
	var obj=document.getElementById("selScanSize").options; 
	while (obj.length > 0){
	  obj.options.remove(obj.length - 1);
	}
}

function addoptionScanSize(s){
    var obj=document.getElementById("selScanSize").options; 
    var opt = new Option(s, obj.length ); 
    obj.options.add(opt);
}

function deloptionColor(){   
   var obj=document.getElementById("selColor").options; 
   while (obj.length > 0){
    obj.options.remove(obj.length - 1);   
   }
}

function addoptionColor(s){
   var obj=document.getElementById("selColor").options; 
   var opt = new Option(s, obj.length ); 
   obj.options.add(opt);
}


function deloptionDev(){   
   var obj=document.getElementById("selDev").options; 
   while (obj.length > 0){
    obj.options.remove(obj.length - 1);   
   }
}


function addoptionDev(s){
   var obj=document.getElementById("selDev").options; 
   var opt = new Option(s, obj.length ); 
   obj.options.add(opt);
}


function deloptionRotate(){   
   var obj=document.getElementById("selRotate").options; 
   while (obj.length > 0)
   {
    obj.options.remove(obj.length - 1);   
   }
}

function addoptionRotate(s){
   var obj=document.getElementById("selRotate").options; 
   var opt = new Option(s, obj.length ); 
   obj.options.add(opt);
}
</script>
