<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
</head>
<body class="page page_index  page_no-touch">

<div class="page-wrapper">
    <div class="page_container _topline">
        <header class="header">
            <div class="banner _Billboard"></div>
            <section class="topline">
                <div class="topline-top"></div>
                <div class="topline-bottom">
                    <nav>
                            <span class="topline-bottom-link">
                                <a href="/msk/cinema/">КИНО</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/msk/concerts/">КОНЦЕРТЫ</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/msk/theatre/">ТЕАТР</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/msk/exhibitions/">ВЫСТАВКИ</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/msk/kids/">ДЕТИ</a>
                            </span>
                        <span class="topline-bottom-link _active">
                                <a href="/msk/restaurants/">РЕСТОРАНЫ</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/msk/quests/">КВЕСТЫ</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/selection/">ПОДБОРКИ</a>
                            </span>
                        <span class="topline-bottom-link">
                                <a href="/">ВСЕ</a>
                            </span>
                    </nav>
                    <span class="topline-bottom-link _choice">
                            <a href="/msk/restaurants/restaurant_list/thebest/" class="topline-bottom-choice"
                               data-text="Лучшее в Москве">
                                <i class="label _normal _white"></i>
                            </a>
                        </span>
                </div>
            </section>
        </header>
    </div>

    <div class="page_container _search">
        <div class="rootblock" id="suggest-root">
            <div class="c8e9d27b__form-fonts">
                <form:form action="findBarByName" cssClass="_5b3132fe__form-form" method="post" modelAttribute="search">
                    <form:input path="query" cssClass="_642e2d74__input-input"/>
                    <div class="c6c8b68d__button-button">
                        <form:button>найти</form:button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>

    <div id="content">
        <div class="page_container">
            <div class="page_container_left _container-search">
                <div class="search_header">
                    <div class="search_header_text">
                        <h1>Кафе и рестораны Москвы</h1>
                    </div>
                </div>
                <section class="search j-list-container">
                    <div class="page_container">
                        <div class="results">
                            <div class="results_text">
                                <h2>Найдено ${count} заведений</h2>
                            </div>
                        </div>
                    </div>
                    <section class="search_results">
                        <ul class="list s-search-rests j-list-wrapper _cards " data-minwidth="630">
                            <c:forEach var="bar" items="${allBars}">
                                <li class="list_item j-first-item">
                                    <!-- шаблон для отображения карточками -->
                                    <span class="places_cards">
                                        <div class="places_info">
                                            <h2 class="places_title">
                                                <a href="/api/restaurant/${bar.id}" class="places_link">
                                                    <span class="places_name">${bar.name}</span>
                                                </a>
                                                <ul class="places-tag_items">
                                                    <li class="places_cuisine places-tag_item">
                                                        <a href="/api/restaurants/${bar.type}">${bar.type}</a>
                                                    </li>
                                                </ul>
                                            </h2>
                                            <span class="places_contact">Москва</span>
                                            <a href="/api/restaurant/${bar.id}" class="places_link">
                                                <span class="places_contact">
                                                    <span class="places_address">${bar.address}</span>
                                                    <span class="places_metro">${bar.district}</span>
                                                    <span class="places_phone">${bar.publicPhone}</span><br>
                                                    <span class="places_sit_count">Посадочных мест ${bar.sitCount}</span>
                                                </span>
                                            </a>
                                        </div>
                                    </span>
                                </li>
                            </c:forEach>
                        </ul>
                    </section>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>
