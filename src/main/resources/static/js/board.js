let index = {
	init: function() {
		$("#btn-board-write").on("click", () => {
			this.write();
		});
		$("#btn-board-update").on("click", () => {
			this.update();
		});
		$("#btn-board-delete").on("click", () => {
			this.deleteContent();
		});
	},



	write: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
			type: "POST",
			url: "/board/writeProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
				alert("글작성 완료");
				location.href = "/board";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	},

	update: function() {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
			type: "PUT",
			url: "/board/updateProc/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글수정 완료");
			location.href = "/board/" + id;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	},

	deleteContent: function() {
		let id = $("#id").text();
		$.ajax({
			type: "DELETE",
			url: "/board/deleteProc/" + id,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("삭제 완료");
			location.href = "/board";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

}
index.init();