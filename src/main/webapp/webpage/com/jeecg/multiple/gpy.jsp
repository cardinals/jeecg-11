<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%--<link href="plug-in/gpy/css/style.css" rel="stylesheet" type="text/css" />--%>
	<script language=JavaScript>

        function deloptionRes()
        {
            var obj=document.getElementById("selRes").options;
            while (obj.length > 0)
            {
                obj.options.remove(obj.length - 1);
            }
        }
        function addoptionRes(s)
        {
            var obj=document.getElementById("selRes").options;
            var opt = new Option(s, obj.length );
            obj.options.add(opt);
        }
        function deloptionScanSize()
        {
            var obj=document.getElementById("selScanSize").options;
            while (obj.length > 0)
            {
                obj.options.remove(obj.length - 1);
            }
        }
        function addoptionScanSize(s)
        {
            var obj=document.getElementById("selScanSize").options;
            var opt = new Option(s, obj.length );
            obj.options.add(opt);
        }
        function deloptionColor()
        {
            var obj=document.getElementById("selColor").options;
            while (obj.length > 0)
            {
                obj.options.remove(obj.length - 1);
            }
        }
        function addoptionColor(s)
        {
            var obj=document.getElementById("selColor").options;
            var opt = new Option(s, obj.length );
            obj.options.add(opt);
        }
        function deloptionDev()
        {
            var obj=document.getElementById("selDev").options;
            while (obj.length > 0)
            {
                obj.options.remove(obj.length - 1);
            }
        }
        function addoptionDev(s)
        {
            var obj=document.getElementById("selDev").options;
            var opt = new Option(s, obj.length );
            obj.options.add(opt);
        }
        function deloptionRotate()
        {
            var obj=document.getElementById("selRotate").options;
            while (obj.length > 0)
            {
                obj.options.remove(obj.length - 1);
            }
        }
        function addoptionRotate(s)
        {
            var obj=document.getElementById("selRotate").options;
            var opt = new Option(s, obj.length );
            obj.options.add(opt);
        }
        function contentLoad()
        {
            //ScanCtrl.EnableDateRecord(true);
            fun();
            ScanCtrl.SlectDevice(0);
        }
        function fun()
        {
            deloptionDev();
            var iDevIndex = ScanCtrl.GetCurDevIndex();
            if(iDevIndex != -1)
            {
                var count = ScanCtrl.GetDeviceCount();
                for(i = 0; i < count; i++)
                {
                    var s = ScanCtrl.GetDevName(i);
                    addoptionDev(s);
                }
                document.getElementById("selDev").value=iDevIndex;
            }

            deloptionRes();
            var iResIndex = ScanCtrl.GetCurResolutionIndex();
            if(iResIndex != -1)
            {
                var count = ScanCtrl.GetResolutionCount();
                for(i = 0;i < count; i++)
                {
                    var w=ScanCtrl.GetResolutionWidth(i);
                    var h=ScanCtrl.GetResolutionHeight(i);
                    var str=w.toString()+"x"+h.toString();
                    addoptionRes(str);
                }
                document.getElementById("selRes").value=iResIndex;
            }

            deloptionScanSize();
            var iScanSizeIndex = ScanCtrl.GetCurScanSizeIndex();
            if(iScanSizeIndex != -1)
            {
                var count = ScanCtrl.GetScanSizeCount();
                for(i = 0; i < count; i++)
                {
                    var str = ScanCtrl.GetScanSizeName(i);
                    addoptionScanSize(str);
                }
                addoptionScanSize("自定义");

                var bCustom = ScanCtrl.IsCustom();
                if(bCustom)
                {
                    document.getElementById("selScanSize").value=count;
                }
                else
                {
                    document.getElementById("selScanSize").value=iScanSizeIndex;
                }

            }

            deloptionRotate();
            var iRotateIndex = ScanCtrl.GetCurRotateAngle();
            if(iRotateIndex != -1)
            {
                addoptionRotate("0");
                addoptionRotate("90");
                addoptionRotate("180");
                addoptionRotate("270");
                document.getElementById("selRotate").value=iRotateIndex;
            }

            deloptionColor();
            var iColorIndex = ScanCtrl.GetCurColor();
            if(iColorIndex != -1)
            {
                addoptionColor("彩色");
                addoptionColor("灰度");
                addoptionColor("黑白");
                document.getElementById("selColor").value=iColorIndex;
            }

            var bRotateCrop = ScanCtrl.IsRotateCrop();
            document.getElementById("rotatecrop").checked=bRotateCrop;
            var bDelBkColor = ScanCtrl.IsDelBackColor();
            document.getElementById("delbkcolor").checked=bDelBkColor;
        }
        function start_preview(url)
        {
            // ScanCtrl.SetCurDev(1);
            //ScanCtrl.StartPreviewEx();
            ScanCtrl.StartPreview();
            fun();
        }
        function loadstart()
        {
            ScanCtrl.StartPreview();
            fun();
        }
        function stop_preview(url)
        {
            ScanCtrl.StopPreview();
            fun();
        }
        function get_name()
        {
            var date=new Date();
            var yy=date.getFullYear().toString();
            var mm=(date.getMonth()+1).toString();
            var dd=date.getDate().toString();
            var hh=date.getHours().toString();
            var nn=date.getMinutes().toString();
            var ss=date.getSeconds().toString();
            var mi=date.getMilliseconds().toString();
            var picName=yy+mm+dd+hh+nn+ss+mi;
            return picName;
        }
        function TakePic(url)
        {
            var path="D:\\"+get_name()+".jpg";
            //ScanCtrl.EnableDateRecord(1);
            var flag=ScanCtrl.Scan(path);
            if(flag)
            {
//                EThumbnails.AddToDisplay(path);
                addImgToDisplay(path);
            }
        }
        function Property(url)
        {
            ScanCtrl.Property();
        }
        function ZoomIn()
        {
            ScanCtrl.SetZoomIn();
        }
        function ZoomOut()
        {
            ScanCtrl.SetZoomOut();

        }
        function deletefolder()
        {
            ScanCtrl.DeleteFolder("D:\\imageqq");
        }
        function changeresolution()
        {
            var num= ScanCtrl.GetResolutionCount();
            var obj=document.getElementById("selRes").options;
            var x = obj.selectedIndex;

            ScanCtrl.SetResolution(x);
            fun();
        }
        function changedev()
        {
            var num= ScanCtrl.GetDeviceCount();
            var obj=document.getElementById("selDev").options;
            var x = obj.selectedIndex;

            ScanCtrl.SlectDevice(x);
            ScanCtrl.SetCurDev(x);
            fun();
        }
        function changescansize()
        {
            var   num=ScanCtrl.GetScanSizeCount();
            var   obj=document.getElementById("selScanSize").options;
            var   x = obj.selectedIndex;

            ScanCtrl.SetScanSize(x);
            fun();
        }
        function changerotate()
        {
            var   obj=document.getElementById("selRotate").options;
            var   x = obj.selectedIndex;

            ScanCtrl.SetVideoRotate(x);
            fun();
        }
        function changecolor()
        {
            var obj = document.getElementById("selColor").options;
            var x = obj.selectedIndex;

            ScanCtrl.SetVideoColor(x);
            fun();
        }
        function RotateCrop(obj)
        {
            ScanCtrl.SetRotateCrop(obj.checked);
            fun();
        }
        function RemoveBackColor(obj)
        {
            ScanCtrl.DelBackColor(obj.checked);
            fun();
        }
        function barcode() {

            alert(ScanCtrl.ScanBarcode("D:\\barcode.jpg"));
            alert(ScanCtrl.Barcode("D:\\barcode.jpg"));
        }
        function Pdf_Create()
        {
            var tp=new Array();
            tp=thumbnailPath();
            if(tp.length<=0){
                alert("请选择要上传的图片！");
                return;
            }
            var imgStr,pdfName="D:/x"+get_name()+".pdf";
            for(var i=0;i<tp.length;i++){
                // alert(tp[i]);
                imgStr=tp[i];
                if(imgStr=='' || imgStr==null || imgStr==undefined){
                    continue;
                }
                ScanCtrl.PDF_AddFile(imgStr);
            }
            var isOk=ScanCtrl.PDF_Create(pdfName);
            if(isOk){
                alert("PDF创建成功！");
            }
        }
        function TIF_Create()
        {
            var tp = new Array();
            tp = thumbnailPath();
            if (tp.length <= 0) {
                alert("请选择要上传的图片！");
                return;
            }
            var imgStr, pdfName = "D:/x" + get_name() + ".tif";
            for (var i = 0; i < tp.length; i++) {
                // alert(tp[i]);
                imgStr = tp[i];
                if (imgStr == '' || imgStr == null || imgStr == undefined) {
                    continue;
                }
                ScanCtrl.TIF_AddFile(imgStr);
            }
            var isOk = ScanCtrl.TIF_Create(pdfName);
            if (isOk) {
                alert("TIF创建成功！");
            }
        }
        function TIF_ALLCreate()
        {
            var tp = new Array();
            tp = thumbnailAllPath();
            if (tp.length <= 0) {
                alert("请选择要上传的图片！");
                return;
            }
            var imgStr, pdfName = "D:/x" + get_name() + ".tif";
            for (var i = 0; i < tp.length; i++) {
                // alert(tp[i]);
                imgStr = tp[i];
                if (imgStr == '' || imgStr == null || imgStr == undefined) {
                    continue;
                }
                ScanCtrl.TIF_AddFile(imgStr);
            }
            var isOk = ScanCtrl.TIF_Create(pdfName);
            if (isOk) {
                alert("TIF创建成功！");
            }
        }
        function thumbnailPath()
        {
            var isOk,num,gfp=new Array();
            num=EThumbnails.GetDisplayCount();
            for(var i=0;i<num;i++){
                isOk=EThumbnails.IsChecked(i);
                if(isOk==1){
                    gfp[i]=EThumbnails.GetFilePath(i);
                }
            }
            return gfp;
        }
        function thumbnailAllPath()
        {
            var isOk, num, gfp = new Array();
            num = EThumbnails.GetDisplayCount();
            for (var i = 0; i < num; i++) {

                gfp[i] = EThumbnails.GetFilePath(i);

            }
            return gfp;
        }
        function SetJpgQuality()
        {
            ScanCtrl.SetJpegQuality(50);
            //alert("????");
        }
        function slectdev()
        {
            //  ScanCtrl.SetCurDev(1);
        }
        function getName() {
            var date = new Date();
            var yy = date.getFullYear().toString();
            var mm = (date.getMonth() + 1).toString();
            var dd = date.getDate().toString();
            var hh = date.getHours().toString();
            var nn = date.getMinutes().toString();
            var ss = date.getSeconds().toString();
            var mi = date.getMilliseconds().toString();
            var getName = yy + mm + dd + hh + nn + ss + mi;
            return getName;
        }
        function getAnPath()
        {
            var anpath = location.href;
            anpath = anpath.substring(anpath.lastIndexOf(':/') - 1, anpath.lastIndexOf('/') + 1);
            //alert(anpath);
            //replace /\//g
            //anpath=anpath.replace(/\//g,'\\\\');
            return anpath;
        }
        function ocr_by_mode()
        {
            var anpath = getAnPath();

            var resName = anpath + getName() + ".xml";

            var model = anpath + "template/" + "imageMode.xml";

            //var isOk = ScanCtrl.ScanDiscern(model, resName);
            // var isOk = ScanCtrl.ScanRecogResults(model);
            alert("kaishi");
            var ok = ScanCtrl.InitOcr(model);
            if (ok) {
                alert(ScanCtrl.GetResultByMode("name", model));
                alert(ScanCtrl.GetResultByMode("company", model));
                alert(ScanCtrl.GetResultByMode("telephone", model));
                alert(ScanCtrl.GetResultByMode("adreass", model));
            }
        }
        function IsColect()
        {
            alert(ScanCtrl.IsConnect());
            alert(ScanCtrl.GetFileBase64("D://1.jpg"));
        }
        function SetWidthCom()
        {
            ScanCtrl.SetPicWidth(1.5);
        }
        function SetHigthCom()
        {
            ScanCtrl.SetPicHigth(1.5);
        }
        function DiscernIdcard()
        {
            var temp = ScanCtrl.IDCardRecognize();
            if(temp)
            {
                var msg = "姓名：" + ScanCtrl.GetIDCardName() + "\n"
                    + "民族：" + ScanCtrl.GetIDCardNation() + "\n"
                    + "性别：" + ScanCtrl.GetIDCardSex() + "\n"
                    + "出生日期：" + ScanCtrl.GetIDCardBorn() + "\n"
                    + "住址：" + ScanCtrl.GetIDCardAddr() + "\n"
                    + "号码：" + ScanCtrl.GetIDCardNo() + "\n"
                    + "发证机关：" + ScanCtrl.GetIDCardPolice() + "\n"
                    + "有效期：" + ScanCtrl.GetIDCardActive() + "\n"

                alert(msg);
            }
            else
            {
                alert("识别失败！");
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
            debugger;
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
            var url="${webRoot}/aMaterialsUploadController.do?uploadFile&business_id=${bProjectBusiness.id}&items_id=${itemsId}&id=${materialId }&type=${flag}";
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
	</script>

	<script language="Javascript" event="DeviceChange(code)" for="ScanCtrl">
        fun();
	</script>

	<style type="text/css">
		.one
		{
			border-color: #ffa8a8;
			background-color: #fff3f3;
			color: #000;
		}
	</style>
</head>
<body onload="contentLoad();">
<div class="main">
	<div class="global-width">
		<div class="action">
			<div class="t">开始预览</div>
			<div class="pages" style="float:left;width:45%;">
				<div>
					<object classid="clsid:090457CB-DF21-41EB-84BB-39AAFC9E271A"
							id="ScanCtrl" codebase="*.cab#version=1,0,0,1" width="660"
							height="400"></object>
				</div>

				<form>
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						   class="addform-item">
						<tbody>
						<tr>
							<td>
								<input class="submit_01" type="button" value="开始预览"onclick="start_preview()" />
								<input class="submit_01" type="button" value="停止预览" onclick="stop_preview()" />
								<input class="submit_01" type="button" value="拍照" onclick="TakePic()" />
								<%--<input class="submit_01" type="button" value="属性" onclick="Property()" />--%>
								<input class="submit_01" type="button" value="放大" onclick="ZoomIn()" />
								<input class="submit_01" type="button" value="缩小" onclick="ZoomOut()" />
								<%--<input class="submit_01" type="button" value="设置宽度" onclick="SetWidthCom()" />
								<input class="submit_01" type="button" value="设置高度" onclick="SetHigthCom()" />--%>
								<input class="submit_01" type="button" value="全选" onclick="selectAll()" />
								<input class="submit_01" type="button" value="反选" onclick="unSelectAll()" />
								<input class="submit_01" type="button" value="上传" onclick="uploadImg()" />
								<input class="submit_01" type="button" value="返回" onclick="javascript:history.go(-1)" />

							</td>
						</tr>
						<%--<tr>
							<td>
								分辨率：<select id="selRes" style="width: 90px" name="selRes"onchange="changeresolution()"></select>
								扫描尺寸：<select id="selScanSize" style="width: 90px" name="selScanSize" onchange="changescansize()"></select>
								旋转角度：&nbsp;&nbsp;<select id="selRotate" style="width: 90px" name="selRotate" onchange="changerotate()"></select>
								<input id="rotatecrop" type="checkbox" value="" onclick="RotateCrop(this)" />纠偏裁边
							</td>
						</tr>--%>
						<tr>
							<td>
								颜&nbsp;&nbsp;色：<select id="selColor" style="width: 90px" name="selColor" onchange="changecolor()"></select>
								设备列表：<select id="selDev" style="width: 90px" name="selDev" onchange="changedev()"></select>
								<input id="delbkcolor" type="checkbox" value="" onclick="RemoveBackColor(this)" />去底色
								<%--<input class="submit_01" type="button" value="扫描条形码" onclick="barcode()" />
								<input class="submit_01" type="button" value="图片质量设定" onclick="SetJpgQuality()" />
								<input class="submit_01" type="button" value="是否连接了设备" onclick="IsColect()" />
								<input class="submit_01" type="button" value="一键PDF" onclick="Pdf_Create()" />
								<input class="submit_01" type="button" value="一键TIF" onclick="TIF_Create()" />
								<input class="submit_01" type="button" value="一键全选TIF" onclick="TIF_ALLCreate()" />
								<input class="submit_01" type="button" value="二代证读取" onclick="DiscernIdcard()" />--%>
							</td>
						</tr>
						</tbody>
					</table>
				</form>

				<%--<div>
					<OBJECT ID="EThumbnails"  CLASSID="CLSID:E8B3DD46-A440-4C3C-AB0A-DC689EEBDA84" width="660" height="150"></OBJECT>
				</div>--%>
			</div>
			<div style="float:left;width:45%;height:450px;overflow:auto;border:1px solid #CCC;padding-top: 20px;" id="imgDiv"></div>
		</div>
	</div>
</div>
<%--<div style="text-align: center;">
	<a href='javascript:void(0)' onclick="javascript:history.go(-1)" class="ace_button" target='_blank'>返回</a>
</div>--%>
</body>
</html>