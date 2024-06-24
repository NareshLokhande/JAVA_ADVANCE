<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="alert alert-primary text-center" role="alert">Create
			new Publication</div>
		<div class="row-justify-content-center">
			<div class="col md-6">
				<div class="card">
					<div class="card-body">
						<form action="save-publication" method="post">
							<div class="mb-3">
								<label for="title" class="form-label">Publication Title</label>
								<input type="text" class="form-control" id="title" name="title"
									placeholder="Publication Title" required>
							</div>

							<div class="mb-3">
								<label for="name" class="form-label">Publication Type</label> <input
									type="text" class="form-control" id="type" name="type"
									placeholder="Publication type" required>

							</div>

							<div class="mb-3">
								<label for="name" class="form-label">Publication Content</label>
								<textarea type="content" class="form-control" id="content"
									name="content" placeholder="Content" required></textarea>
							</div>
							<button type="submit" class="btn btn-dark w-100">Save</button>
						</form>

						<div class="mt-3 text-center">
							<a href="publication-list" class="btn btn-dark">view
								Publications</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
