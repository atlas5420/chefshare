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

		var userCheck = /^[a-zA-Z0-9]{6,12}$/;
		var emailCheck = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var pwdCheck = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;

		if (!userCheck.test(data.username) || !emailCheck.test(data.email) || !pwdCheck.test(data.password)) {
			if (!userCheck.test(data.username)) {
				$("#id_check").text("가입할 수 없는 아이디입니다.");
				$("#id_check").css("color", "red");
				$("#id_check").attr("disabled", true);
				$("#username").focus();
			} else {
				$("#id_check").text("");
				$("#id_check").attr("disabled", false);
			}
			if (!emailCheck.test(data.email)) {
				$("#email_check").text("이메일 형식이 올바르지 않습니다.");
				$("#email_check").css("color", "red");
				$("#email_check").attr("disabled", true);
			} else {
				$("#email_check").text("");
				$("#email_check").attr("disabled", false);
			}
			if (!pwdCheck.test(data.password)) {
				$("#pwd_check").text("비밀번호는 8~16자 영문, 숫자, 특수문자를 사용해주세요.");
				$("#pwd_check").css("color", "red");
				$("#pwd_check").attr("disabled", true);
			} else {
				$("#pwd_check").text("");
				$("#pwd_check").attr("disabled", false);
			}
		} else {
			$.ajax({
				type: "POST",
				url: "/register/access",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp) {
				if (resp.status === 500) {
					alert("이미 가입된 아이디입니다");
				} else {
					alert("회원가입 완료");
					location.href = "/";
				}

			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		}
	},

	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#usename").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		var emailCheck = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var pwdCheck = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;

		if (!emailCheck.test(data.email) || !pwdCheck.test(data.password)) {
			if (!emailCheck.test(data.email)) {
				$("#email_check").text("이메일 형식이 올바르지 않습니다.");
				$("#email_check").css("color", "red");
				$("#email_check").attr("disabled", true);
			} else {
				$("#email_check").text("");
				$("#email_check").attr("disabled", false);
			}
			if (!pwdCheck.test(data.password)) {
				$("#pwd_check").text("비밀번호는 8~16자 영문, 숫자, 특수문자를 사용해주세요.");
				$("#pwd_check").css("color", "red");
				$("#pwd_check").attr("disabled", true);
			} else {
				$("#pwd_check").text("");
				$("#pwd_check").attr("disabled", false);
			}
		} else {
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