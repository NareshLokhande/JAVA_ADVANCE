<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
	
	<div class="container mt-5">
		  <div class="alert alert-primary" role="alert">
		  Registration form for student 
		  </div>
	</div>
	
	<div class="container mt-5">
		<form action="StudentController" method="post">
			<div class="row">
				<div class="col-lg-4">
					<div class="mb-3">
						<label for="id" class="form-label">ID</label>
    					<input type="text" class="form-control" id="id" name="id">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label for="name" class="form-label">Name</label>
    					<input type="text" class="form-control" id="name" name="name">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-4" >
					<div class="mb-3">
						<label for="marks" class="form-label">Marks</label>
    					<input type="text" class="form-control" id="marks" name="marks">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label for="phone" class="form-label">Phone</label>
    					<input type="text" class="form-control" id="phone" name="phone">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-4">
					<div class="form-check">
  						<input class="form-check-input" type="radio" name="flexRadioDefault" id="gender-m" checked>
  						<label class="form-check-label" for="gender-m">
    					Male
  						</label>
					</div>
					<div class="form-check">
  						<input class="form-check-input" type="radio" name="flexRadioDefault" id="gender-f">
  						<label class="form-check-label" for="gender-f">
    					Female
  						</label>
					</div>		
  				</div>
  				
  				<div class="col-lg-4">
  					<select class="form-select" aria-label="Default select example">
  						<option selected>City</option>
  						<option value="1">Mumbai</option>
  						<option value="2">Pune</option>
 						<option value="3">Nashik</option>
					</select>
  				</div>
			</div>
			
			<div class="row mt-5">
				<a href="register.jsp" class="btn btn-success">Register</a>
			</div>
		</form>	
  	</div>
  
	

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>