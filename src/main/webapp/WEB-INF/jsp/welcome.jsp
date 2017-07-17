<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form class="form-signin" role="form" method="POST">
	<h2 class="form-signin-heading">Please create User</h2>
	<input type="text" name="name" class="form-control" placeholder="Name" required autofocus>
	<input type="email" name="email" class="form-control" placeholder="Email" required autofocus>  
	<input type="password" name="password" class="form-control" placeholder="Password" required> 
	<button class="btn btn-lg btn-primary btn-block" type="submit" name="send">Create User</button>
</form>

  <section>
    <div class="jumbotron">
      <div class="container">
        <p> ${history0} </p>
        <p> ${history1} </p>
        <p> ${history2} </p>
        <p> ${history3} </p>
        <p> ${history4} </p>
        <p> ${history5} </p>
        <p> ${history6} </p>
        <p> ${history7} </p>
        <p> ${history8} </p>
        <p> ${history9} </p>
        
        <form class="form-signin" role="form" method="POST">
        	<button class="btn btn-lg btn-primary btn-block" onclick="location.href='/register.htm'">Update History</button>
        </form>
      </div>
    </div>
  </section>