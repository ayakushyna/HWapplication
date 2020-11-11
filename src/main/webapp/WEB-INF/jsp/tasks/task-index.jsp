<%@ include file="../header.jspf"%>
<div class="container p-5">
    <div class="card p-2">
        <div class="card-title">
                <h2>Task List</h2>
                <br/>
                <a type="button" class="btn btn-outline-success"
                   href="${pageContext.request.contextPath}/tasks/create">Create Task</a>
        </div>

        <table class="card-body table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col">Done</th>
                <th scope="col">Created At</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  items="${tasks}" var ="task">
                <tr>
                    <td>${task.title}</td>
                    <td>${task.done}</td>
                    <td>
                        <fmt:formatDate value="${task.createdAt}"
                                        pattern="dd/MM/yyyy" />
                    </td>
                    <td>
                        <a type="button" class="btn btn-outline-dark"
                           href="${pageContext.request.contextPath}/tasks/${task.taskId}">Show</a>
                        <a type="button" class="btn btn-outline-info"
                           href="${pageContext.request.contextPath}/tasks/edit/${task.taskId}">Edit</a>
                        <a type="button" class="btn btn-outline-danger"
                           href="${pageContext.request.contextPath}/tasks/delete/${task.taskId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../footer.jspf"%>