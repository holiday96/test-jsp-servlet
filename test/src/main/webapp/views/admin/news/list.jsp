<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ include file="/commons/taglib.jsp"%>
        <!DOCTYPE html>
        <html>

        <body>
            <form action="<c:url value='/admin-news'/>" id="formSubmit" method="get">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Tên bài viết</th>
                            <th>Mô tả ngắn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${model.listResult}">
                            <tr>
                                <td>${item.title}</td>
                                <td>${item.shortDescription}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <ul class="pagination" id="pagination"></ul>

                <input type="hidden" value="" id="page" name="page" />
                <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
                <input type="hidden" value="" id="sortName" name="sortName" />
                <input type="hidden" value="" id="sortBy" name="sortBy" />
            </form>

            <script type="text/javascript">
                var totalPages = ${model.totalPage};
                var currentPage = ${model.page};
                var limit = 2;
                $(function() {
                    window.pagObj = $('#pagination').twbsPagination({
                        totalPages: totalPages,
                        visiblePages: 10,
                        startPage: currentPage,
                        onPageClick: function(event, page) {
                            if (currentPage != page) {
                                $('#maxPageItem').val(limit);
                                $('#page').val(page);
                                $('#sortName').val('title');
                                $('#sortBy').val('desc');
                                $('#formSubmit').submit();
                            }
                        }
                    });
                });
            </script>
        </body>

        </html>