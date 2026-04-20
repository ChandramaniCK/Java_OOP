<%
String result = (String) request.getAttribute("result");

if (result != null) {
    String[] data = result.split(",");
%>

<h2>Patient Found</h2>
ID: <%=data[0]%><br>
Name: <%=data[1]%><br>
Age: <%=data[2]%><br>
Disease: <%=data[3]%><br>

<%
} else {
%>
<h3>No Result</h3>
<%
}
%>

<a href="index.jsp">Back</a>