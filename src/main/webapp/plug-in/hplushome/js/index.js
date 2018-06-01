// JavaScript Document
function selectTag(showContent,selfObj){
	var tabs = selfObj.parentNode.parentNode.getElementsByTagName("li");	
	for(var i=0;i<tabs.length;i++)
	{
		tabs[i].className = "";
		if(i== showContent)
		tabs[i].className = "selectTag";
	}
	var options = selfObj.parentNode.parentNode.parentNode.parentNode.children[1];
	
	for(var i=0;i<options.children.length;i++)
	{  
		options.children[i].className = "tagContent";
		if(i== showContent)
		{
			options.children[i].className = "tagContent selectTag";
		}
	}
}

  var winH, contentH;
    var contentHeight= function () {
        winH = $(window).height()
        contentH = $(window).height() - $(".t2-footer").height() - $(".t2-header").height();
        $(".t2-sidebar").height(contentH)
        $(".t2-main-con").outerHeight(contentH -$(".t2-breadcrumb").height())
    }
        contentHeight();
    $(window).resize(function(event) {
        contentHeight();
    });
	
 $(function () {  
            $("#tabs1 a").mousemove(function (e) {  
                $(this).tab('show');  
            });  
            $("#tabs2 a").mousemove(function (e) {  
                $(this).tab('show');  
            });  
            $("#tabs3 a").mousemove(function (e) {  
                $(this).tab('show');  
            });  
            $("#tabs4 a").mousemove(function (e) {  
                $(this).tab('show');  
            }); 
            $("#tabs5 a").mousemove(function (e) {  
                $(this).tab('show');  
            }); 
            $("#tabs6 a").mousemove(function (e) {  
                $(this).tab('show');  
            }); 
        });  
		
		
		
		

$(document).ready(function() {
  $("#menu").hover(function(){
			$("#menu > .t2_btn").removeClass("close").addClass("open");
			$("#menu").css({"width":500,"left":0});
},function(){
			$("#menu > .t2_btn").removeClass("open").addClass("close");
			$("#menu").css({"width":270,"left":230});
});  
});

