<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>호텔 예약 사이트</title>
<!-- 
Journey Template 
http://www.templatemo.com/tm-511-journey
-->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css">                <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datepicker.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/slick/slick-theme.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo-style.css">                                   <!-- Templatemo style -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
      </head>

      <body>
        <div class="tm-main-content" id="top">
            <div class="tm-top-bar-bg"></div>    
            <div class="tm-top-bar" id="tm-top-bar">
                <div class="container">
                    <div class="row">
                        <nav class="navbar navbar-expand-lg narbar-light">
                            <a class="navbar-brand mr-auto" href="#">
                                <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Site logo">
                                D-Trip
                            </a>
                            <button type="button" id="nav-toggle" class="navbar-toggler collapsed" data-toggle="collapse" data-target="#mainNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div id="mainNav" class="collapse navbar-collapse tm-bg-white">
                                <ul class="navbar-nav ml-auto">
                                  <li class="nav-item">
                                    <a class="nav-link active" href="#top">메인<span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#tm-section-2">추천호텔</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#tm-section-3">지역별 호텔</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#tm-section-4">문의하기</a>
                                </li>
                            </ul>
                        </div>                            
                    </nav>
                </div> <!-- row -->
            </div> <!-- container -->
        </div> <!-- .tm-top-bar -->

        <div class="tm-page-wrap mx-auto">
            <section class="tm-banner">
                <div class="tm-container-outer tm-banner-bg">
                    <div class="container">

                        <div class="row tm-banner-row tm-banner-row-header">
                            <div class="col-xs-12">
                                <div class="tm-banner-header">
                                    <h1 class="text-uppercase tm-banner-title">호텔 검색은 D-Trip</h1>
                                    <img src="${pageContext.request.contextPath}/resources/img/dots-3.png" alt="Dots">
                                    <p class="tm-banner-subtitle">저희 D-Trip은 여러분을 위하겠습니다.</p>
                                    <a href="javascript:void(0)" class="tm-down-arrow-link"><i class="fa fa-2x fa-angle-down tm-down-arrow"></i></a>       
                                </div>    
                            </div>  <!-- col-xs-12 -->                      
                        </div> <!-- row -->
                        <div class="row tm-banner-row" id="tm-section-search">

                            <form action="index.html" method="get" class="tm-search-form tm-section-pad-2">
                                <div class="form-row tm-search-form-row">                                
                                    <div class="form-group tm-form-group tm-form-group-pad tm-form-group-1">
                                        <label for="inputCity">지역</label>
                                        <input name="address" type="text" class="form-control" id="inputCity" placeholder="찾고싶은 지역을 검색하세요.">
                                    </div>
                                    <div class="form-group tm-form-group tm-form-group-1">                                    
                                        <div class="form-group tm-form-group tm-form-group-pad tm-form-group-2">
                                            <label for="inputRoom">객실</label>
                                            <select name="room" class="form-control tm-select" id="inputRoom">
                                                <option value="1" selected>1개</option>
                                                <option value="2">2개</option>
                                                <option value="3">3개</option>
                                                <option value="4">4개</option>
                                                <option value="5">5개</option>
                                                <option value="6">6개</option>
                                                <option value="7">7개</option>
                                                <option value="8">8개</option>
                                                <option value="9">9개</option>
                                                <option value="10">10개</option>
                                            </select>                                      
                                        </div>
                                        <div class="form-group tm-form-group tm-form-group-pad tm-form-group-3">                                       
                                            <label for="inputAdult">성인</label>     
                                            <select name="adult" class="form-control tm-select" id="inputAdult">
                                                <option value="1" selected>1명</option>
                                                <option value="2">2명</option>
                                                <option value="3">3명</option>
                                                <option value="4">4명</option>
                                                <option value="5">5명</option>
                                                <option value="6">6명</option>
                                                <option value="7">7명</option>
                                                <option value="8">8명</option>
                                                <option value="9">9명</option>
                                                <option value="10">10명</option>
                                            </select>                                       
                                        </div>
                                        <div class="form-group tm-form-group tm-form-group-pad tm-form-group-3">

                                            <label for="inputChildren">아동</label>                                            
                                            <select name="children" class="form-control tm-select" id="inputChildren">
                                            	<option value="0" selected>0명</option>
                                                <option value="1">1명</option>
                                                <option value="2">2명</option>
                                                <option value="3">3명</option>
                                                <option value="4">4명</option>
                                                <option value="5">5명</option>
                                                <option value="6">6명</option>
                                                <option value="7">7명</option>
                                                <option value="8">8명</option>
                                                <option value="9">9명</option>
                                            </select>                               
                                        </div>
                                    </div>
                                </div> <!-- form-row -->
                                <div class="form-row tm-search-form-row">

                                    <div class="form-group tm-form-group tm-form-group-pad tm-form-group-3">
                                        <label for="inputCheckIn">체크 인</label>
                                        <input name="start_resv_date" type="text" class="form-control" id="start_resv_date" placeholder="Check In">
                                    </div>
                                    <div class="form-group tm-form-group tm-form-group-pad tm-form-group-3">
                                        <label for="inputCheckOut">체크 아웃</label>
                                        <input name="end_resv_date" type="text" class="form-control" id="end_resv_date" placeholder="Check Out">
                                    </div>
                                    <div class="form-group tm-form-group tm-form-group-pad tm-form-group-1">
                                        <label for="btnSubmit">&nbsp;</label>
                                        <button type="submit" class="btn btn-primary tm-btn tm-btn-search text-uppercase" id="btnSubmit">검색</button>
                                    </div>
                                </div>                              
                            </form>                             

                        </div> <!-- row -->
                        <div class="tm-banner-overlay"></div>
                    </div>  <!-- .container -->                   
                </div>     <!-- .tm-container-outer -->                 
            </section>

            <section class="p-5 tm-container-outer tm-bg-gray">            
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 mx-auto tm-about-text-wrap text-center">                        
                            <h2 class="text-uppercase mb-4">Your <strong>Journey</strong> is our priority</h2>
                            <p class="mb-4">약상자에는 없는 치료제가 여행이다 여행은 모든 세대를 통틀어 가장 잘 알려진 예방약이자 치료제이며 동시에 회복이다<br><br><h7 aligin="center">-대니얼 트레이크-</h7></p>
                            <a href="#" class="text-uppercase btn-primary tm-btn">Continue explore</a>                              
                        </div>
                    </div>
                </div>            
            </section>
            
            <div class="tm-container-outer" id="tm-section-2">
                <section class="tm-slideshow-section">
                    <div class="tm-slideshow">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-01.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-02.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-03.jpg" alt="Image">    
                    </div>
                    <div class="tm-slideshow-description tm-bg-primary">
                        <h2 class="">Europe's most visited places</h2>
                        <p>Aenean in lacus nec dolor fermentum congue. Maecenas ut velit pharetra, pharetra tortor sit amet, vulputate sem. Vestibulum mi nibh, faucibus ac eros id, sagittis tincidunt velit. Proin interdum ullamcorper faucibus. Ut mi nunc, sollicitudin non pulvinar id, sagittis eget diam.</p>
                        <a href="#" class="text-uppercase tm-btn tm-btn-white tm-btn-white-primary">Continue Reading</a>
                    </div>
                </section>
                <section class="clearfix tm-slideshow-section tm-slideshow-section-reverse">

                    <div class="tm-right tm-slideshow tm-slideshow-highlight">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-02.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-03.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-01.jpg" alt="Image">
                    </div> 

                    <div class="tm-slideshow-description tm-slideshow-description-left tm-bg-highlight">
                        <h2 class="">Asia's most popular places</h2>
                        <p>Vivamus in massa ullamcorper nunc auctor accumsan ac at arcu. Donec sagittis mattis pharetra. Proin commodo, ante et volutpat pulvinar, arcu arcu ullamcorper diam, id maximus sem tellus id sem. Suspendisse eget rhoncus diam. Fusce urna elit, porta nec ullamcorper id.</p>
                        <a href="#" class="text-uppercase tm-btn tm-btn-white tm-btn-white-highlight">Continue Reading</a>
                    </div>                        

                </section>
                <section class="tm-slideshow-section">
                    <div class="tm-slideshow">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-03.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-02.jpg" alt="Image">
                        <img src="${pageContext.request.contextPath}/resources/img/tm-img-01.jpg" alt="Image">
                    </div>
                    <div class="tm-slideshow-description tm-bg-primary">
                        <h2 class="">America's most famous places</h2>
                        <p>Donec nec laoreet diam, at vehicula ante. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse nec dapibus nunc, quis viverra metus. Morbi eget diam gravida, euismod magna vel, tempor urna.</p>
                        <a href="#" class="text-uppercase tm-btn tm-btn-white tm-btn-white-primary">Continue Reading</a>
                    </div>
                </section>
            </div>        
            <div class="tm-container-outer" id="tm-section-3">
                <ul class="nav nav-pills tm-tabs-links">
                    <li class="tm-tab-link-li">
                        <a href="#1a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/north-america.png" alt="Image" class="img-fluid">
                            North America
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#2a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/south-america.png" alt="Image" class="img-fluid">
                            South America
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#3a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/europe.png" alt="Image" class="img-fluid">
                            Europe
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#4a" data-toggle="tab" class="tm-tab-link active"><!-- Current Active Tab -->
                            <img src="${pageContext.request.contextPath}/resources/img/asia.png" alt="Image" class="img-fluid">
                            Asia
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#5a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/africa.png" alt="Image" class="img-fluid">
                            Africa
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#6a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/australia.png" alt="Image" class="img-fluid">
                            Australia
                        </a>
                    </li>
                    <li class="tm-tab-link-li">
                        <a href="#7a" data-toggle="tab" class="tm-tab-link">
                            <img src="${pageContext.request.contextPath}/resources/img/antartica.png" alt="Image" class="img-fluid">
                            Antartica
                        </a>
                    </li>
                </ul>
                <div class="tab-content clearfix">
                	
                    <!-- Tab 1 -->
                    <div class="tab-pane fade" id="1a">
                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">North Garden Resort</h3>
                                    <p class="tm-text-highlight">One North</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$110</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Felis nec dignissim</h3>
                                    <p class="tm-text-highlight">Two North</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <div id="preload-hover-img"></div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$120</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Sed fermentum justo</h3>
                                    <p class="tm-text-highlight">Three North</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$130</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Maecenas ultricies neque</h3>
                                    <p class="tm-text-highlight">Four North</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$140</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->
                    
                    <!-- Tab 2 -->
                    <div class="tab-pane fade" id="2a">

                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">South Resort Hotel</h3>
                                    <p class="tm-text-highlight">South One</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$220</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Aenean ac ante nec diam</h3>
                                    <p class="tm-text-highlight">South Second</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$230</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Suspendisse nec dapibus</h3>
                                    <p class="tm-text-highlight">South Third</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$240</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Aliquam viverra mi at nisl</h3>
                                    <p class="tm-text-highlight">South Fourth</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$250</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->          
                    
                    <!-- Tab 3 -->     
                    <div class="tab-pane fade" id="3a">

                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Europe Hotel</h3>
                                    <p class="tm-text-highlight">Venecia, Italy</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$330</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">In viverra enim turpis</h3>
                                    <p class="tm-text-highlight">Paris, France</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$340</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Volutpat pellentesque</h3>
                                    <p class="tm-text-highlight">Barcelona, Spain</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$350</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Grand Resort Pasha</h3>
                                    <p class="tm-text-highlight">Istanbul, Turkey</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$360</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->
                    
                    <!-- Tab 4 -->
                    <div class="tab-pane fade show active" id="4a">
                    <!-- Current Active Tab WITH "show active" classes in DIV tag -->
                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Asia Resort Hotel</h3>
                                    <p class="tm-text-highlight">Singapore</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$440</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Nullam eget est a nisl</h3>
                                    <p class="tm-text-highlight">Yangon, Myanmar</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <div id="preload-hover-img"></div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$450</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Proin interdum ullamcorper</h3>
                                    <p class="tm-text-highlight">Bangkok, Thailand</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$460</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Lorem ipsum dolor sit</h3>
                                    <p class="tm-text-highlight">Vientiane, Laos</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$470</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->
                    
                    <!-- Tab 5 -->
                    <div class="tab-pane fade" id="5a">

                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Africa Resort Hotel</h3>
                                    <p class="tm-text-highlight">First City</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$550</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Aenean ac magna diam</h3>
                                    <p class="tm-text-highlight">Second City</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$560</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Beach Barbecue Sunset</h3>
                                    <p class="tm-text-highlight">Third City</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$570</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Grand Resort Pasha</h3>
                                    <p class="tm-text-highlight">Fourth City</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$580</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->   
                    
                    <!-- Tab 6 -->            
                    <div class="tab-pane fade" id="6a">

                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Hotel Australia</h3>
                                    <p class="tm-text-highlight">City One</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$660</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Proin interdum ullamcorper</h3>
                                    <p class="tm-text-highlight">City Two</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$650</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Beach Barbecue Sunset</h3>
                                    <p class="tm-text-highlight">City Three</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$640</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Grand Resort Pasha</h3>
                                    <p class="tm-text-highlight">City Four</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$630</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->
                    
                    <!-- Tab 7 -->
                    <div class="tab-pane fade" id="7a">

                        <div class="tm-recommended-place-wrap">
                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-04.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Antartica Resort</h3>
                                    <p class="tm-text-highlight">Ant City One</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$770</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>                        
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-05.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Pulvinar Semper</h3>
                                    <p class="tm-text-highlight">Ant City Two</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$230</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-06.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Cras vel sapien</h3>
                                    <p class="tm-text-highlight">Ant City Three</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$140</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>

                            <div class="tm-recommended-place">
                                <img src="${pageContext.request.contextPath}/resources/img/tm-img-07.jpg" alt="Image" class="img-fluid tm-recommended-img">
                                <div class="tm-recommended-description-box">
                                    <h3 class="tm-recommended-title">Nullam eget est</h3>
                                    <p class="tm-text-highlight">Ant City Four</p>
                                    <p class="tm-text-gray">Sed egestas, odio nec bibendum mattis, quam odio hendrerit risus, eu varius eros lacus sit amet lectus. Donec blandit luctus dictum...</p>   
                                </div>
                                <a href="#" class="tm-recommended-price-box">
                                    <p class="tm-recommended-price">$190</p>
                                    <p class="tm-recommended-price-link">Continue Reading</p>
                                </a>
                            </div>    
                        </div>                        

                        <a href="#" class="text-uppercase btn-primary tm-btn mx-auto tm-d-table">Show More Places</a>
                    </div> <!-- tab-pane -->
                </div>
            </div>

            <div class="tm-container-outer tm-position-relative" id="tm-section-4">
                <div id="google-map"></div>
                <form action="index.html" method="post" class="tm-contact-form">
                    <div class="form-group tm-name-container">
                        <input type="text" id="contact_name" name="contact_name" class="form-control" placeholder="Name"  required/>
                    </div>
                    <div class="form-group tm-email-container">
                        <input type="email" id="contact_email" name="contact_email" class="form-control" placeholder="Email"  required/>
                    </div>
                    <div class="form-group">
                        <input type="text" id="contact_subject" name="contact_subject" class="form-control" placeholder="Subject"  required/>
                    </div>
                    <div class="form-group">
                        <textarea id="contact_message" name="contact_message" class="form-control" rows="9" placeholder="Message" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary tm-btn-primary tm-btn-send text-uppercase">Send Message Now</button>
                </form>
            </div> <!-- .tm-container-outer -->

            <footer class="tm-container-outer">
                <p class="mb-0">Copyright © <span class="tm-current-year">2018</span> Your Company 
                    
                . Designed by <a rel="nofollow" href="http://www.google.com/+templatemo" target="_parent">Template Mo</a></p>
            </footer>
        </div>
    </div> <!-- .main-content -->

    <!-- load JS files -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>                    <!-- https://popper.js.org/ -->       
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>                 <!-- https://getbootstrap.com/ -->
    <script src="${pageContext.request.contextPath}/resources/js/datepicker.min.js"></script>                <!-- https://github.com/qodesmith/datepicker -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.singlePageNav.min.js"></script>      <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->
    <script src="${pageContext.request.contextPath}/resources/slick/slick.min.js"></script>                  <!-- http://kenwheeler.github.io/slick/ -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>           <!-- https://github.com/flesler/jquery.scrollTo -->
    <script> 
        /* Google Maps
        ------------------------------------------------*/
        var map = '';
        var center;

        function initialize() {
            var mapOptions = {
                zoom: 16,
                center: new google.maps.LatLng(37.5642135, 127.0016985),
                scrollwheel: false
            };

            map = new google.maps.Map(document.getElementById('google-map'),  mapOptions);

            google.maps.event.addDomListener(map, 'idle', function() {
              calculateCenter();
          });

            google.maps.event.addDomListener(window, 'resize', function() {
              map.setCenter(center);
          });
        }

        function calculateCenter() {
            center = map.getCenter();
        }

        function loadGoogleMap(){
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.src = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDVWt4rJfibfsEDvcuaChUaZRS5NXey1Cs&v=3.exp&sensor=false&' + 'callback=initialize';
            document.body.appendChild(script);
        } 

        /* DOM is ready
        ------------------------------------------------*/
        $(function(){

            // Change top navbar on scroll
            $(window).on("scroll", function() {
                if($(window).scrollTop() > 100) {
                    $(".tm-top-bar").addClass("active");
                } else {                    
                 $(".tm-top-bar").removeClass("active");
                }
            });

            // Smooth scroll to search form
            $('.tm-down-arrow-link').click(function(){
                $.scrollTo('#tm-section-search', 300, {easing:'linear'});
            });

            // Date Picker in Search form
            var pickerCheckIn = datepicker('#start_resv_date');
            var pickerCheckOut = datepicker('#end_resv_date');
 
            // Update nav links on scroll
            $('#tm-top-bar').singlePageNav({
                currentClass:'active',
                offset: 60
            });

            // Close navbar after clicked
            $('.nav-link').click(function(){
                $('#mainNav').removeClass('show');
            });

            // Slick Carousel
            $('.tm-slideshow').slick({
                infinite: true,
                arrows: true,
                slidesToShow: 1,
                slidesToScroll: 1
            });

            loadGoogleMap();                                       // Google Map                
            $('.tm-current-year').text(new Date().getFullYear());  // Update year in copyright           
        });
        
        $.datepicker.setDefaults({
            dateFormat: 'yy년 mm월 dd일',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            yearSuffix: '년'
          })

          $(function() {
            $("#start_resv_date, #end_resv_date").datepicker()
          })



    </script>             

</body>
</html>