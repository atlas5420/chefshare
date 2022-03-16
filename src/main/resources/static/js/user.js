let userindex = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
		/*	
			$("#btn-login").on("click", () => {
					this.login();
				});
		*/
	},

	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		$.ajax({
			type: "POST",
			url: "/register/access",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			if(resp.status === 500){
			alert("가입할 수 없는 아이디입니다");
			}else{
			alert("회원가입 완료");
			location.href = "/";
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#usename").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		$.ajax({
			type: "PUT",
			url: "/update/access",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("회원수정 완료");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

userindex.init();


	/*	
			login: function() {
			let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			}
	
		$.ajax({
				type: "POST",
				url: "/user/login",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp) {
				alert("로그인 성공");
				location.href = "/";
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
}
*/