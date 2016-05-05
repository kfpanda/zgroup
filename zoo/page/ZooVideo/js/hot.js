(function() {
	
	var host='http://192.168.34.114:8080/zoo';
	
	
	var data = {
		zbname: '',
		vname: '',
		type: ''
	}
	var url = host+'/video/list/';

	$.ajax({
		type: "GET",
		url: url,
		data:data,
		success: function(datas) {
			var blocks='';
			var datas=eval("("+ datas+")");
			if(1==datas.r){
               var vs=eval("("+ datas.msg+")");
              
               for(var i=0;i<20;i++){
               	    blocks += '<div class="v_block"><div class="img"><a href='+ vs[i].url+'><img src='+ vs[i].img+' /></a></div>' 
	+ '<div class="msg"><div class="left"><div class="top">' 
	+ '<span class="hoster">'+vs[i].zbname+'</span></div>' 
	+ '<div class="bottom"><a href="javascript:void(0);" class="title">'+vs[i].vname+'</a></div></div>' 
	+ '<div class="right"><div class="top"><span class="audience"> '+vs[i].viewnum+'</span></div>' 
	+ '<div class="bottom"><a href="javascript:void(0);" class="like"> 收藏</a></div></div></div></div>';
               }
               $(".row").html(blocks);
              }
			
		},
		complete: function() {},
		error: function() {}
	});


	var block = '';




	















})();