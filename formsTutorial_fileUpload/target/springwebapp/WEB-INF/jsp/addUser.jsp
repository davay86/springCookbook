<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser" enctype="multipart/form-data">

    <input type="file" name="file" />

    <input type="submit" value="Submit" />
</form:form>
