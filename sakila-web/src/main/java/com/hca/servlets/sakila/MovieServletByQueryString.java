package com.hca.servlets.sakila;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServletByQueryString
 */
@WebServlet("/MovieByQ/search")
public class MovieServletByQueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServletByQueryString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		Map<String, String[]> paramMap = request.getParameterMap();

		if(paramMap.containsKey("genre")) {
			String[] params = paramMap.get("genre");
			StringBuilder sb = new StringBuilder();
			for(String param : params) {
				sb.append(param + ", ");
			}
			writer.println("You like " + sb.toString());
			
		} else {
			writer.println("Do you like comedy movies too?");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
