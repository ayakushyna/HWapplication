<%@ include file="../header.jspf"%>

<div class="container p-5">
    <div class="card p-2">
        <div class="card-title">
            <h2> Task View </h2>
        </div>

        <div class="card-body">
            <div>
                <b>Title:</b> ${task.title}
            </div>
            <div>
                <b>Description:</b> ${task.description}
            </div>
            <div>
                <b>Done:</b> ${task.done}
            </div>
            <div>
                <b>Created At:</b> <fmt:formatDate value="${task.createdAt}" pattern="dd/MM/yyyy"/>
            </div>

            <div class="row justify-content-begin m-2">
                <a type="button" href="${pageContext.request.contextPath}/tasks/" class="btn btn-outline-secondary mr-2">Back</a>
                <a type="button" class="btn btn-outline-info"
                   href="${pageContext.request.contextPath}/tasks/edit/${task.taskId}">Edit</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jspf"%>