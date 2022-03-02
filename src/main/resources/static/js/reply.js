let index = {
	init: function() {
		$("#btn-reply-write").on("click", () => {
			this.write();
		});
	},

	write: function() {
		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		};

		$.ajax({
			type: "POST",
			url: `/board/${data.boardId}/reply`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글등록 완료");
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replyDelete: function(boardId, replyId) {

		$.ajax({
			type: "DELETE",
			url: `/board/${boardId}/reply/${replyId}`,
			dataType: "json"
		}).done(function(resp) {
			alert("댓글삭제 완료");
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	}
}
index.init();