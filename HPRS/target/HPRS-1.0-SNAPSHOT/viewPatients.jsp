<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Patients</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            text-align: center;
        }
        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 70%;
            background: white;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background: #3498db;
            color: white;
        }
        .critical {
            background-color: #ffcccc;
        }
        a {
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h2>Patient Records</h2>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Disease</th>
</tr>

<%
BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
String line;

while((line = br.readLine()) != null){
    String[] data = line.split(",");

    int age = Integer.parseInt(data[2]);
    String disease = data[3];

    String cssClass = "";

    if (age > 60 && disease.equalsIgnoreCase("Heart Problem")) {
        cssClass = "critical";
    }
%>

<tr class="<%=cssClass%>">
    <td><%=data[0]%></td>
    <td><%=data[1]%></td>
    <td><%=data[2]%></td>
    <td><%=data[3]%></td>
</tr>

<%
}
br.close();
%>

</table>

<a href="index.jsp">🏠 Back to Home</a>

</body>
</html>