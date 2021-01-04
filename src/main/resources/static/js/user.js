let index = {
	//let _this = this; //function 쓸려면 치환 해줘야 한다고 함
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},
	
	save: function() {
		//alert('user의 save함수 호출 되따');
		let data = {
			username: $("#Username").val(),
			password: $("#password").val(),
			email: $("#email").val()
			 
		}
		console.log(data)
		//$.ajax().done().fail();
		$.ajax({
			type:"POST",
			url:"/blog/api/user",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
		}).done(function(resp){
			alert("화원가입이 완료 되었습니다.");
			console.log(resp);
			//location.href = "/blog";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();