<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="mb-3">Report Application</h1>


		<form:form action="search" modelAttribute="search" method="POST">

			<table>
				<tr>
					<td>Plan name:</td>
					<td><form:select path="planName">
							<form:option value="">-Select</form:option>
							<form:options items="${planName}" />
						</form:select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select</form:option>
							<form:options items="${planStatus}" />
						</form:select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date"></form:input></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>End Date:</td>
					<td><form:input type="date" path="endDate"></form:input></td>
				</tr>
				<tr>
					<td><input type="submit" value="Reset" class="btn btn-danger" />
						<input type="submit" value="Search" class="btn btn-primary" /></td>
				</tr>

			</table>
		</form:form>

		<hr />
		<table class="table  table-striped table-hover">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Citizen Name</th>
					<th>Citizen Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
					<th>Denial Reason</th>
					<th>Terminated Date</th>
					<th>Termination Reason</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.citizenGeneder}</td>
						<td>${plan.citizenPlanName}</td>
						<td>${plan.citizenPlanStatus}</td>
						<td>${plan.citizenPlanStartDate}</td>
						<td>${plan.citizenPlanEndDate}</td>
						<td>${plan.citizenBenefitAmount}</td>
						<td>${plan.citizenDenialReason}</td>
						<td>${plan.citizenTerminatedDate}</td>
						<td>${plan.citizenTerminationReson}</td>


					</tr>

				</c:forEach>

			</tbody>
		</table>
		<hr />

		Export: <a href="">EXCEL</a>
		<td></td>
		<td></td>
		<td></td>
		<td></td> <a href="">PDF</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>