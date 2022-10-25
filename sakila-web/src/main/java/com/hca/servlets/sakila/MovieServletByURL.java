package com.hca.servlets.sakila;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServletByURL
 */
@WebServlet(description = "Find movies by parsing URL", urlPatterns = { "/MoviesByURL/*" })
public class MovieServletByURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieServletByURL() {
		super();
// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// get the URI
		String url = request.getRequestURI();
		System.out.println(url); // debugging only
		// split the URI into parts
		String[] parts = url.split("/");
		System.out.println(Arrays.asList(parts)); // debugging only
		// find the term genre in part
		if (parts.length > 3 && !parts[3].equals("genre")) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			out.println("<h1> Unable to read your message!</h1>");
		} else {
			String genre = parts[4]; // guaranteed that parts[4] exists
			// because of if statement up top.
			out.println("<h1>You are interested in " + genre + " movies</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
