<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹 이벤트</title>
<style>
</style>
</head>

<body>


	<style>
section {
	color: rgb(72, 72, 72);
}

.container {
	width: 1300px;
	margin: 0px auto;
	margin-top: 35px;	
}

.menuTitle {
	font-size: 30px;
	text-align: center;
}

.eventSelect {
	width: 500px;
	height: 54px;
	overflow: hidden;
	margin: 0px auto;
	margin-top: 25px;
}

.eventSelectType {
	float: left;
	display: flex;
	align-items: center;
	justify-content: center;
	border: 1px solid #ccc;
	border-bottom: 1px solid white;
	width: 248px;
	height: 48px;
	position: relative;
}

.nowWatchType {
	border: 2px solid #ff7f00;
	position: absolute;
	width: 246px;
	top: -1px;
}

a {
	text-decoration: none;
	color: rgb(72, 72, 72);
}

.container{
	padding:10px;
}
#eventHeader{}
</style>

		<div id="eventHeader">
			<div class="container">
				<div class="menuTitle">이벤트</div>
				<div class="eventSelect">
					<div class="eventSelectType">
						<div class="nowWatchType" id="ingEventLine" hidden></div>
						<a href="javascript:;" @click="fnSelect('N')">진행중인 이벤트</a>
					</div>

					<div class="eventSelectType"
						style="border-bottom: 1px solid #ccc; margin-left: -1px;">
						<div class="nowWatchType" id="endEventLine" hidden></div>
						<a href="javascript:;" @click="fnSelect('Y')">종료된 이벤트</a>
					</div>
				</div>
			</div>
		</div>

</body>

</html>
<script type="text/javascript">
	var eventHeader = new Vue({
		el : '#eventHeader',
		data : {
			endYn : "${endYn}"
		},
		methods : {
			fnLoad:function(){
				var self=this;
				if(self.endYn=="N"){
					$("#ingEventLine").prop("hidden",false);
					$("#endEventLine").prop("hidden",true);					
				} else{
					$("#ingEventLine").prop("hidden",true);
					$("#endEventLine").prop("hidden",false);	
				}				
			}, 
			
			fnSelect : function(endYn){
				var self = this;
				$.pageChange("/event-web-list.do", {					
					endYn : endYn
				});
			}
		},
		created : function() {
			var self = this;
			self.fnLoad();
		}
	});
</script>