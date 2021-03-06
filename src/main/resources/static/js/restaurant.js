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
		$("#btn-image").on("click", () => {
			this.image();
		});
	},



	write: function() {
		var data = {
			title: $("#title").val(),
			content: $("#content").val(),
			cuisine: $("#cuisine").val(),
			region: $("#region").val(),
			address: $("#address").val()
		};
		var formData = new FormData($('#form')[0]);
		formData.append('file', $('#file'));
		formData.append('key', new Blob([JSON.stringify(data)], { type: "application/json" }));
		if (data.region = null) {
			alert("region을 설정하세요");
		} else {
			$.ajax({
				type: "POST",
				url: "/restaurant/writeProc",
				data: formData,
				contentType: false,
				processData: false,
				dataType: "json"
			}).done(function(resp) {
				alert("글작성 완료");
				location.href = "/restaurant";
			}).fail(function(error) {
				alert(JSON.stringify(error));
			})
		}
	},

	update: function() {
		let id = $("#id").val();
		var data = {
			title: $("#title").val(),
			content: $("#content").val(),
			cuisine: $("#cuisine").val(),
			region: $("#region").val(),
			address: $("#address").val(),
			
		};
		var formData = new FormData($('#form')[0]);
		formData.append('file', $('#file'));
		formData.append('key', new Blob([JSON.stringify(data)], { type: "application/json" }));
		
			$.ajax({
				type: "PUT",
				url: "/restaurant/updateProc/" + id,
				data: formData,
				contentType: false,
				processData: false,
				dataType: "json"
			}).done(function(resp) {
				alert("글작성 완료");
				location.href = "/restaurant" + id;
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