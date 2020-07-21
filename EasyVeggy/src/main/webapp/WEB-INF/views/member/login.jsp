<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="../resources/css/member/login.css"/>
<title>Easy Veggy's Healthy Choice</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
   <!-- Modal HTML -->
      <div class="modal-dialog modal-login">   
         <div class="modal-content">
            <div class="modal-header">
               <img class="modal-header-logo"
                  src="/easyveggy/resources/image/after/vganlogo-1w.png">
               <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">x</button>
               <h4 class="modal-title">Sign in</h4>
            </div>
            <div class="modal-body">
               <form action="/easyveggy/member/login.do" method="post">
                  <div class="form-group">
                     <input name="userEmail" type="text" class="form-control" placeholder="e-mail"
                        required="required">
                  </div>
                  <div class="form-group">
                     <input name="pw" type="password" class="form-control"
                        placeholder="Password" required="required">
                  </div>
                  <div class="form-group">
                     <input type="submit" class="btn btn-primary btn-block btn-lg"
                        value="Sign in">
                  </div>
               </form>
               <p class="hint-text small">
                  <a href="/easyveggy/member/searchmem.do">Forgot Your Password?</a><a href="/easyveggy/member/searchmem.do"> / Forgot
                     Your ID?</a>
               </p>
            </div>
            <div class="or-seperator">
               <b>or</b>
            </div>

            <div class="modal-body" id="modal-body-accnt">
            <div class="modal-header">
                  <h4 class="modal-title">New Account</h4>
                  <br><br>
                  </div>
               <form action="/easyveggy/member/join.do" method="post">
                  <br>
                  <div class="form-group">
                     <input type="text" class="form-control" name="nickname"
                        placeholder="Username" required="required">
                  </div>
                  <div class="form-group">
                     <input type="email" class="form-control" name="userEmail"
                       id="userEmail" placeholder="e-mail" required="required" style="width: 75%; display:inline-block;">
                  	<button type="button" onclick="emailCheck();" class="emailCheckBtn btn btn-primary">Check</button>
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control" name="pw"
                       id="userPwd" placeholder="Password" required="required">
                     <span id="pwdSpan"></span>
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control"
                        id="pwdCheck"  placeholder="Confirm Password"
                        required="required">
                     <span id="checkSpan"></span>
                  </div>
                  <div class="form-group">
                     <button type="submit"
                        class="btn btn-success btn-lg btn-block signup-btn">Sign
                        Up</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../resources/js/member/login.js"></script>
</body>
</html>