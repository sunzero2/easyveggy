<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Easy Veggy's Healthy Choice</title>
<link rel="icon" type="image/x-icon" href="../resources/image/after/faviconv.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<link href="../resources/css/index/index.css" rel="stylesheet"/>

</head>
<body id="page-top">
	<%-- <%@ include file="../top/top.jsp" %> --%>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Start Your Happy</div>
                <div class="masthead-heading text-uppercase">EASY VEGGY</div>
                <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">LET's START</a>
            </div>
        </header>
        <!-- 카드선택하기 디브!!! -->
        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">at Your choice!</h2>
                    <h3 class="section-subheading text-muted">PICK ANY "THREE" CARDS YOU LIKE</h3>
                </div>
                <!-- 카드넣는 디브 -->
                <div class="row text-center">
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="veg" name="ing" id="checkk0">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-pageline fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk0">
	                        <h4 class="my-3">GRAIN/곡식</h4>
	                        <p class="text-muted">쌀,보리,밀,옥수수,귀리,기장,오트밀,검은콩,통밀,메밀,호밀,참깨,대두,녹두,렌틸,기장,수수,조,율무...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="meat" name="ing" id="checkk1">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-drumstick-bite fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk1">
	                        <h4 class="my-3">MEAT/육류</h4>
	                        <p class="text-muted">소, 돼지,양,염소,토끼...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="veg" name="ing" id="checkk2">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-carrot fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk2">
	                        <h4 class="my-3">VEGETABLE/채소</h4>
	                        <p class="text-muted">토마토,양배추,케일,샐러리,아스파라거스,가지,고추,오이,시금치,호박,고구마,감자,당근,바질,비트...</p>
                        </label>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="fish" name="ing" id="checkk3">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-fish fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk3">
	                        <h4 class="my-3">FISH/어류</h4>
	                        <p class="text-muted">갈치,고등어,광어,연어,참치,도미,민어,멸치,장어,송어...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="mushroom" name="ing" id="checkk4">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-certificate fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk4">
	                        <h4 class="my-3">Fungus/균류</h4>
	                        <p class="text-muted">느타리,팽이,새송이,양송이,표고,목이,석이,송로,트러플,상황,말굽...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="bird" name="ing" id="checkk5">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-kiwi-bird fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk5">
	                        <h4 class="my-3">Poultry/가금류</h4>
	                        <p class="text-muted">닭,오리,칠면조,etc...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="7" name="ing" id="checkk6">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-bacon fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk6">
	                        <h4 class="my-3">Seaweed/해조류</h4>
	                        <p class="text-muted">다시마,톳,모자반,미역,청각,파래,매생이,김,우뭇가사리...</p>
                        </label>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="fruit" name="ing" id="checkk7">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-lemon fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk7">
	                        <h4 class="my-3">Fruits/열매류</h4>
	                        <p class="text-muted">바나나,사과,복숭아,포도,딸기,자두,망고,무화과,귤,대추,레몬,라임,멜론,블루베리,아보카도,앵두,올리브,유자,자몽,파인애플...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="fish" name="ing" id="checkk8">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-anchor fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk8">
	                        <h4 class="my-3">Crustacean/갑각류</h4>
	                        <p class="text-muted">꽃게,새우,바다가재,가재,게,왕게,대게...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="eggs" name="ing" id="checkk9">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-egg fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk9">
	                        <h4 class="my-3">EGGS/난류</h4>
	                        <p class="text-muted">계란,성게알,청어알,연어알,숭어알,민어알,날치알,캐비어,명란...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="milk" name="ing" id="checkk10">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-tint fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk10">
	                        <h4 class="my-3">Oil/유지류</h4>
	                        <p class="text-muted">마요네즈,땅콩버터,마가린,버터,식물성유,동물성유,올리브유...</p>
                        </label>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="fish" name="ing" id="checkk11">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-cloud-meatball fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk11">
	                        <h4 class="my-3">Muscles/조개류</h4>
	                        <p class="text-muted">가리비,굴,모시조개,소라,전복,홍합,대합,바지락,소라,우렁,전복...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="milk" name="ing" id="checkk12">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-cheese fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk12">
	                        <h4 class="my-3">Dairy/유제품</h4>
	                        <p class="text-muted">휘핑,크림,치즈,우유,요구르트,플레인,연유,아이스크림...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        <input type="checkbox" class="menuRadio" value="fish" name="ing" id="checkk13">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-stumbleupon fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                       	<label for="checkk13">
	                        <h4 class="my-3">Mollusks/연체류</h4>
	                        <p class="text-muted">낙지,문어,오징어,주꾸미,꼴뚜기,해삼,해파리...</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="veg" name="ing" id="checkk14">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-cookie-bite fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk14">
	                        <h4 class="my-3">Bakery/베이커리</h4>
	                        <p class="text-muted">비건을 위한 베이커리</p>
                        </label>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x">
                        	<input type="checkbox" class="menuRadio" value="fruit" name="ing" id="checkk15">
							<em></em>
                     		<i class="fas fa-circle fa-stack-2x text-primary"></i>
                     		<i class="fas fa-mug-hot fa-stack-1x fa-inverse"></i>
                     	</span>
                        <br>
                        <label for="checkk15">
	                        <h4 class="my-3">Beverage/음료 </h4>
	                        <p class="text-muted">커피,차,건강주스,착즙주스,소다...</p>
                        </label>
                    </div>
                </div>
                <br><br><br>
                <div class="leval" style="margin-left: 40%;">
					<button type="button" class="btn btn-fill btn-outline-warning" onclick="clearAll();">선택초기화</button>
					<button type="button" class="btn btn-fill btn-outline-danger" onclick="choose();">선택 완료</button>
				</div>
			     
            </div>
            
        </section>
        <!-- MENU CARD/메뉴카드 나타나 Grid-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div id="myLevel" class="text-center">
                </div>
				<div class="row" id="row">
           	 	</div>
        	</div>
        </section>
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright © Easy Veggy 2020</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!">
                        	<i class="fab fa-twitter"></i>
                        </a>
                        <a class="btn btn-dark btn-social mx-2" href="#!">
                        	<i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="btn btn-dark btn-social mx-2" href="#!">
                        	<i class="fab fa-linkedin-in"></i>
                        </a>
                    </div>
                    <div class="col-lg-4 text-lg-right">
                    	<a class="mr-3" href="#!">Privacy Policy</a>
                    	<a href="#!">Terms of Use</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Portfolio Modals--><!-- Modal 1-->
        <div class="portfolio-modal modal fade" id="menuInfo" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal">
                    	<img src="../resources/image/after/close-icon.svg" />
                    </div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 id="infoMenuName" class="text-uppercase"></h2>
                                    <p id="infoMenuPrice" class="item-intro text-muted"></p>
                                    <ul class="list-inline">
                                        <li id="infoRestName"></li>
                                        <li id="infoRestLoc"></li>
                                        <li id="infoRestCell"></li>
                                        <li id="infoRestHour"></li>
                                    </ul>
                                    <div class="reviewWrapper">
										<hr class="reviewHr">
										<div class="reviewTitle">REVIEW</div>
											<ul class="media-list">
											</ul>  
										<div class="moreReview">
											<div class="back" onclick="index--; getReview();"><img src="../resources/image/after/portfolio/back.png" style="width: 18px;"></div>
											<div class="next" onclick="index++; getReview();"><img src="../resources/image/after/portfolio/next.png" style="width: 18px;"></div>
										</div>
										<div class="writeReview">
											<div class="myName">댓글을 작성해보세요!
											</div>
											<div class="starWrapper">
												<div class="starDiv"><img class="star" id="01" src="../resources/image/after/portfolio/starN.png"></div>
												<div class="starDiv"><img class="star" id="02" src="../resources/image/after/portfolio/starN.png"></div>
												<div class="starDiv"><img class="star" id="03" src="../resources/image/after/portfolio/starN.png"></div>
												<div class="starDiv"><img class="star" id="04" src="../resources/image/after/portfolio/starN.png"></div>
												<div class="starDiv"><img class="star" id="05" src="../resources/image/after/portfolio/starN.png"></div>
											</div>
											<c:if test="${loginInfo == null}">
												<textarea class="area" readonly>리뷰는 로그인 후 작성 가능합니다.</textarea><br>
											</c:if>
											<c:if test="${loginInfo != null}">
												<textarea class="area" placeholder="리뷰를 작성해보세요!"></textarea><br>
											</c:if>
											<c:if test="${loginInfo != null}">
												<button class="saveReview" onclick="addReview();">저장</button>
											</c:if>
											<c:if test="${loginInfo == null}">
												<button class="saveReview" onclick="alert('로그인 후 작성 가능');">저장</button>
											</c:if>
										</div>
									</div>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="../resources/js/jqBootstrapValidation.js"></script>
        <script src="../resources/js/contact_me.js"></script>
        <!-- Core theme JS-->
        <!-- <script src="../resources/js/scripts.js"></script> -->
        <!-- topBanner JS -->
        <!-- <script src="../resources/js/top.js"></script> -->
        <script src="../resources/js/index/index.js"></script>
        </body>
</html>