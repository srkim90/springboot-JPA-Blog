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
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#emali").val()
			 
		}
		console.log(data)
		$.ajax().done.fail();
	}
}

index.init();