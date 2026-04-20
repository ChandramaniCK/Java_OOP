<!DOCTYPE html>
<html>
<head>
    <title>Add Patient</title>
    <style>
        body {
            font-family: Arial;
            background: #ecf0f1;
            text-align: center;
        }
        .form-box {
            background: white;
            padding: 20px;
            margin: 50px auto;
            width: 300px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        input {
            width: 90%;
            padding: 8px;
            margin: 8px;
        }
        button {
            padding: 10px;
            background: #27ae60;
            color: white;
            border: none;
            cursor: pointer;
        }
        a {
            display: block;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<h2>Add Patient</h2>

<div class="form-box">
<form action="addPatient" method="post">

    <!-- ✅ ADD THIS LINE -->
    <input type="hidden" name="action" value="add">

    ID: <input type="text" name="id"><br><br>
    Name: <input type="text" name="name"><br><br>
    Age: <input type="text" name="age"><br><br>
    Disease: <input type="text" name="disease"><br><br>

    <input type="submit" value="Add Patient">
</form>

<a href="index.jsp">🏠 Back to Home</a>
</div>

</body>
</html>