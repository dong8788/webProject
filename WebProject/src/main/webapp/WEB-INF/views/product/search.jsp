<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/jquery-ui-1.12.1.custom/jquery-ui.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/categories_styles.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/categories_responsive.css'/>">
</head>


<body>

	<div class="container product_section_container">
		<div class="row">
			<div class="col product_section clearfix">

				<!-- Breadcrumbs -->

				<div class="breadcrumbs d-flex flex-row align-items-center">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li class="active"><a href="index.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
					</ul>
				</div>

				<!-- Sidebar -->

				<div class="sidebar">
					<div class="sidebar_section">
						<div class="sidebar_title">
							<h5>Product Category</h5>
						</div>
						<ul class="sidebar_categories">
							<li <c:if test="${param.condition == '전체' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">전체</a></li>
							<li <c:if test="${param.condition == '패션' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">패션</a></li>
							<li <c:if test="${param.condition == '잡화' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">잡화</a></li>
							<li <c:if test="${param.condition == '뷰티' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">뷰티</a></li>
							<li <c:if test="${param.condition == '주방' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">주방</a></li>
							<li <c:if test="${param.condition == '가전디지털' }">class="active"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span</c:if>><a href="#">가전디지털</a></li>
						</ul>
					</div>

					<!-- Price Range Filtering -->
					<div class="sidebar_section">
						<div class="sidebar_title">
							<h5>Filter by Price</h5>
						</div>
						<p>
							<input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
						</p>
						<div id="slider-range"></div>
						<div class="filter_button"><span>filter</span></div>
					</div>

					<!-- Sizes -->
					<div class="sidebar_section">
						<div class="sidebar_title">
							<h5>Sizes</h5>
						</div>
						<ul class="checkboxes">
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>S</span></li>
							<li class="active"><i class="fa fa-square" aria-hidden="true"></i><span>M</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>L</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>XL</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>XXL</span></li>
						</ul>
					</div>

					<!-- Color -->
					<div class="sidebar_section">
						<div class="sidebar_title">
							<h5>Color</h5>
						</div>
						<ul class="checkboxes">
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Black</span></li>
							<li class="active"><i class="fa fa-square" aria-hidden="true"></i><span>Pink</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
							<li><i class="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
						</ul>
						<div class="show_more">
							<span><span>+</span>Show More</span>
						</div>
					</div>

				</div>

				<!-- Main Content -->

				<div class="main_content">

					<!-- Products -->

					<div class="products_iso">
						<div class="row">
							<div class="col">

								<!-- Product Sorting -->

								<div class="product_sorting_container product_sorting_container_top">
									<ul class="product_sorting">
										<li>
											<span class="type_sorting_text">Default Sorting</span>
											<i class="fa fa-angle-down"></i>
											<!-- 카테고리 별 상품 필터링 categorys_custom.js -->
											<ul class="sorting_type">
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span></li>
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'><span>Product Name</span></li>
											</ul>
										</li>
										<li>
											<span>Show</span>
											<span class="num_sorting_text">10</span>
											<i class="fa fa-angle-down"></i>
											<ul class="sorting_num">
												<li class="num_sorting_btn"><span>10</span></li>
												<li class="num_sorting_btn"><span>20</span></li>
												<li class="num_sorting_btn"><span>30</span></li>
											</ul>
										</li>
									</ul>

								</div>

								<!-- Product Grid -->

								<div class="product-grid">

									<!-- Product 1 -->
									<c:forEach var="product" items="${prodList}" varStatus="loop">
										<div class="product-item men">
											<div class="product discount product_filter">
												<div class="product_image">
													<img src="${pageContext.request.contextPath}/${ product.photoUrl }" alt="" style="height: 230px">
												</div>
												<div class="favorite favorite_left"></div>
												<div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-${ product.discount}</span></div>
												<div class="product_info">
													<h6 class="product_name"><a href="<c:url value='/product/content/${ product.prodSeq }'/>">${ product.prodName}</a></h6>
													<div class="product_price">${ product.price - product.discount}<span>${ product.discount}</span></div>
												</div>
											</div>
											<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
										</div>
									</c:forEach>
								</div>
								<!-- Product Sorting -->
								<hr width="100%">
								<div align="center">
									
								    <c:if test="${pageMaker.prev}">
								    	<a href="<c:url value='/product/search/${pageMaker.makeSearch(pageMaker.startPage - 1)}'/>">이전</a>&nbsp;
								    </c:if> 
								    
									<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
									    <a href="<c:url value='/product/search/${pageMaker.makeSearch(idx)}'/>">${idx}</a>&nbsp;
								    </c:forEach>
								
									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									    <a href="<c:url value='/product/search/${pageMaker.makeSearch(pageMaker.endPage + 1)}'/>">다음</a>
								   	</c:if> 

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/styles/bootstrap4/popper.js'/>"></script>
<script src="<c:url value='/styles/bootstrap4/bootstrap.min.js'/>"></script>
<script src="<c:url value='/plugins/Isotope/isotope.pkgd.min.js'/>"></script>
<script src="<c:url value='/plugins/OwlCarousel2-2.2.1/owl.carousel.js'/>"></script>
<script src="<c:url value='/plugins/easing/easing.js'/>"></script>
<script src="<c:url value='/plugins/jquery-ui-1.12.1.custom/jquery-ui.js'/>"></script>
<script src="<c:url value='/js/categories_custom.js'/>"></script>

</body>
</html>
<jsp:include page="../include/footer.jsp" />