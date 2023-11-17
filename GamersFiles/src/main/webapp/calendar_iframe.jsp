<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./calendar_js/index.global.js'></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script>
<%

request.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String start = request.getParameter("start");
String end = request.getParameter("end");
String body = request.getParameter("body");

LocalDate now = LocalDate.now();
%>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
			left : 'prev,next today',
			center : 'title',
			right : 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		},
		locale: "ko",
		initialDate : '<%=now%>',
		navLinks : true, // can click day/week names to navigate views
		businessHours : true, // display business hours
		editable : true,
		selectable : true,
		events : [ 
				{
			title : '<%=title%>',
				start : '<%=start%>',
				end : '<%=end%>',
				constraint : '<%=body%>'
			},

			{
				title : 'Business Lunch',
				start : '2023-11-03T13:00',
				constraint : 'businessHours'
			}, {
				title : 'Meeting',
				start : '2023-11-13T11:00',
				constraint : 'availableForMeeting', // defined below
				color : '#257e4a'
			}, {
				title : 'Conference',
				start : '2023-11-18',
				end : '2023-11-20'
			}, {
				title : 'Party',
				start : '2023-11-29T20:00:00'
			},

			// areas where "Meeting" must be dropped
			{
				groupId : 'availableForMeeting',
				start : '2023-01-11T10:00:00',
				end : '2023-01-11T16:00:00',
				display : 'background'
			}, {
				groupId : 'availableForMeeting',
				start : '2023-01-13T10:00:00',
				end : '2023-01-13T16:00:00',
				display : 'background'
			},

			// red areas where no events can be dropped
			{
				start : '2023-01-24',
				end : '2023-01-28',
				overlap : false,
				display : 'background',
				color : '#ff9f89'
			}, {
				start : '2023-01-06',
				end : '2023-01-08',
				overlap : false,
				display : 'background',
				color : '#ff9f89'
			} ]
		});

		calendar.render();
	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 800px;
	margin: 0 auto;
}

</style>
</head>
<body>
	
	<div id='calendar'></div>
</body>
</html>
