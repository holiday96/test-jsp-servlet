<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<!DOCTYPE html>
<html>

<head>
<title>Chỉnh sửa bài viết</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Thể
			loại</label>
		<div class="col-sm-9">
			<select class="form-select" id="categoryCode" name="categoryCode">
				<c:if test="${empty model.categoryCode}">
					<option value="" disabled>Chọn thể loại bài viết</option>
					<c:forEach var="item" items="${categories}">
						<option value="${item.code}">${item.name}</option>
					</c:forEach>
				</c:if>
				<c:if test="${not empty model.categoryCode}">
					<option value="" disabled>Chọn thể loại bài viết</option>
					<c:forEach var="item" items="${categories}">
						<option value="${item.code}" <c:if test="${item.code == model.categoryCode}">selected</c:if>>
							${item.name}
						</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="title" name="title"
				value="${model.title}" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Hình
			đại diện</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="thumbnail"
				name="thumbnail" value="" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Mô tả
			ngắn</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="shortDescription"
				name="shortDescription" value="${model.shortDescription}" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Nội
			dung</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="content" name="content"
				value="${model.content}" />
		</div>
	</div>
</body>

</html>