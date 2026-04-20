<!DOCTYPE html>
<html>
<head>
    <title>Hospital Dashboard</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f4f6f8;
            text-align: center;
        }
        h1 {
            color: #2c3e50;
        }
        .card {
            margin: 50px auto;
            padding: 30px;
            width: 300px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        a {
            display: block;
            margin: 15px;
            padding: 10px;
            text-decoration: none;
            background: #3498db;
            color: white;
            border-radius: 5px;
        }
        a:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>

<h1>🏥 Hospital Patient Record System</h1>

<div class="card">
    <a href="addPatient.jsp"> Add Patient</a>
    <a href="viewPatients.jsp"> View Patients</a>
</div>

<div class="card">
    <a href="addPatient.jsp"> Add Patient</a>
    <a href="viewPatients.jsp"> View Patients</a>
    <a href="searchPatient.jsp"> Search Patient</a>
    <a href="deletePatient.jsp"> Delete Patient</a>
</div>

</body>
</html>