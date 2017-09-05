<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="user">Login</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode == 'HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome And Login!</h1>
				</div>
			</div>
		</c:when>
	

		<c:when test="${mode == 'NEW' }">
			<div class="container text-center">
				<h3>Login</h3>
				<hr>
				
		<form method="POST" action="save-user">
		  <div class="form-group">
		    <label for="email1">Email address/ Username</label>
		    <input type="email" class="form-control" id="email1" placeholder="Enter email" name="username" value="${username}"/>
		  </div>
		  <div class="form-group">
		    <label for="password1">Password</label>
		    <input type="password" class="form-control" id="password1" placeholder="Password" name="password" value="${password}"/>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Login</button>
		  </form>

		</div>
		</c:when>
	</c:choose>
</body>
</html> 