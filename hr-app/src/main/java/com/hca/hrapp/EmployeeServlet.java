package com.hca.hrapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet({"/employee", "/employees"})
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String url = request.getRequestURI();
		String[] parts = url.split("/");
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		if(parts.length > 1 && parts[2].equals("employees")) {
			out.println("<h1>List of employees</h1>");
			for(Employee employee : employees) {
				printEmployee(out, employee);
			}
		} else if(parameterMap.containsKey("id")) {
			String inputId = parameterMap.get("id")[0];
			for(Employee employee : employees) {
				if(employee.getId().equals(inputId)) {
					printEmployee(out, employee);
				}
			}
		} else if(parameterMap.containsKey("name")) {
			String inputName = parameterMap.get("name")[0];
			for(Employee employee : employees) {
				if(employee.getName().equals(inputName)) {
					printEmployee(out, employee);
				}
			}
		}
	}
	
	private void printEmployee(PrintWriter out, Employee employee) {
		out.println("Employee id:" + employee.getId());
		out.println("Employee name:" + employee.getName());
		out.println("Employee age:" + employee.getAge());
		
		out.println("<a href='employee?id=" + employee.getId() +"'>See details</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeName = request.getParameter("name");
		String employeeId = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Employee e = new Employee(employeeName, employeeId, age);
		employees.add(e);
		
		//this might not work due to the different options for urls
		doGet(request, response);
	}

}
