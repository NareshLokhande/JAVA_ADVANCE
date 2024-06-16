<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>	
	    <div class="container mt-5">
        <div class="alert alert-primary text-center" role="alert">
            Spring Product MVC
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form action="save-product" method="post">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
                            </div>
                            <div class="mb-3">
                                <label for="price" class="form-label">Price (RS)</label>
                                <input type="text" class="form-control" id="price" name="price" placeholder="Price" required>
                            </div>
                            <div class="mb-3">
                                <label for="qty" class="form-label">Quantity</label>
                                <input type="text" class="form-control" id="qty" name="qty" placeholder="Quantity" required>
                            </div>
                            <button type="submit" class="btn btn-dark w-100">Add Product</button>
                        </form>
                        <div class="mt-3 text-center">
                            <a href="products-list" class="btn btn-success">View Product List</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
