let index = {
	//let _this = this; //function 쓸려면 치환 해줘야 한다고 함 
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-login").on("click", () => {
			this.login();
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
			url:"/api/user",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
		}).done(function(resp){
			alert("회원가입이 완료 되었습니다.");
			console.log(resp);
			location.href = "";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	login: function() {
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
			url:"/api/user/login",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
		}).done(function(resp){
			if (resp.data == "1"){ 
				alert("로그인이 완료 되었습니다.");
				location.href = "/";
			}
			else {
				alert("로그인 실패");
			}
			console.log(resp);
			
			
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();