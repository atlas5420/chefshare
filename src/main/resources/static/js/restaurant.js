let restaurantindex = {
	init: function() {
		$("#btn-restaurant-write").on("click", () => {
			this.image();
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
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			cuisine: $("#cuisine").val(),
			region: $("#region").val(),
			address: $("#address").val(),
		}

		$.ajax({
			type: "POST",
			enctype: "multipart/form-data",
			url: "/restaurant/writeProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(data);
			alert("글작성 완료");
			location.href = "/restaurant";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})

	},

	image: function() {
		var formData = new FormData($('#image')[0]);
		

		$.ajax({
			type: "POST",
			url: "/restaurant/imageProc",
			processData: false,
			contentType: false,
			data: formData,
			dataType: 'json',
			success: function(){
			console.log(formData);
			alert("등록성공");
			}
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
			image: $("#image").val()
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