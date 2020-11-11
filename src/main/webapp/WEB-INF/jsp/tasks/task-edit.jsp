<%@ include file="../header.jspf"%>

<div class="container p-5">
    <div class="card p-2">
        <div class="card-title">
            <h2> Edit Task </h2>
        </div>
        <div class="card-body">
            <form:form action="${pageContext.request.contextPath}/tasks/update" method="post" modelAttribute="task">
                <form:hidden path="taskId" />
                <fieldset class="form-group col-md-8">
                    <form:label path="title">Title</form:label>
                    <form:input path="title" type="text" maxlength="70" class="form-control"
                                required="required" />
                </fieldset>

                <fieldset class="form-group col-md-8">
                    <form:label path="description">Description</form:label>
                    <form:textarea path="description" maxlength="280" class="form-control" />
                </fieldset>

                <fieldset class="form-group col-md-8">
                    Done <form:checkbox path="done" value="Done"/>
                </fieldset>

                <div class="row justify-content-begin m-2">
                        <a type="button" href="${pageContext.request.contextPath}/tasks/" class="btn btn-outline-secondary mr-2">Back</a>
                        <button type="submit" class="btn btn-success">Save</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="../footer.jspf"%>