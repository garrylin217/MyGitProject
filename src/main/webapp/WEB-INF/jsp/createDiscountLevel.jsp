<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Discount Level</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Create Discount Level</h1>
    <form action="${pageContext.request.contextPath}/discountLevels" method="post">
        <div class="form-group">
            <label for="discount">Discount:</label>
            <input type="text" class="form-control" name="discount" required/>
        </div>
        <div class="form-group">
            <label for="levelName">Level Name:</label>
            <input type="text" class="form-control" name="levelName" required/>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/discountLevels">Back to Discount Levels</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
