<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>StudentMVC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
	
	<div class="container mt-5">
		  <div class="alert alert-primary" role="alert">
		  Welcome to student CRUD 
		  </div>
	</div>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-4">
				<div class="card" style="width: 18rem;">
  					<div class="card-body">
    				<h5 class="card-title">Register student</h5>
    				<p class="card-text">Click below to register</p>
    				<a href="register.jsp" class="btn btn-success">Register</a>
					</div>
				</div>	
  			</div>
  			
  			<div class="col-lg-4">
				<div class="card" style="width: 18rem;">
  					<div class="card-body">
    				<h5 class="card-title">Fetch student</h5>
    				<p class="card-text">Click below to view all student</p>
    				<a href="student-list.jsp" class="btn btn-success">View Students</a>
					</div>
				</div>	
  			</div>
  		</div>
  	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>