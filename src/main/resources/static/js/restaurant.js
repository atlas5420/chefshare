let restaurantindex = {
	init: function() {
		$("#btn-restaurant-write").on("click", () => {
			this.write();
		});
		$("#btn-restaurant-update").on("click", () => {
			this.update();
		});
		$("#btn-restaurant-delete").on("click", () => {
			this.deleteContent();
		});
	},



	write: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			cuisine: $("#cuisine").val(),
			region: $("#region").val(),
			address: $("#address").val(),
			image:$("#image").val()
		}

		$.ajax({
			type: "POST",
			url: "/restaurant/writeProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
				alert("글작성 완료");
				location.href = "/restaurant";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
		
	},

	update: function() {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			cuisine: $("#cuisine").val(),
			region: $("#region").val(),
			address: $("#address").val(),
			image:$("#image").val()
		}

		$.ajax({
			type: "PUT",
			url: "/restaurant/updateProc/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글수정 완료");
			location.href = "/restaurant/" + id;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	},

	deleteContent: function() {
		let id = $("#id").val();
		
		$.ajax({
			type: "DELETE",
			url: "/restaurant/deleteProc/" + id,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
		console.log(id);
			alert("삭제 완료");
			location.href = "/restaurant";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

}
restaurantindex.init();