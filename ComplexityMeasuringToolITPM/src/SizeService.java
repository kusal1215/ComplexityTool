

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SizeService
 */
@WebServlet("/SizeService")
public class SizeService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SizeService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");


		String value = request.getParameter("userId");
		System.out.println(value);
		System.out.println("xxxxxxxxxxxxxxxxxxx");
		
		int Keyword = Integer.parseInt(request.getParameter("Keyword"));
		int Identifer = Integer.parseInt(request.getParameter("Identifer"));
		int Operator = Integer.parseInt(request.getParameter("Operator"));
		int Number = Integer.parseInt(request.getParameter("Number"));
		int Stringliteral = Integer.parseInt(request.getParameter("Stringliteral"));
		
		System.out.println(Keyword);
		System.out.println(Identifer);
		System.out.println(Operator);
		System.out.println(Number);
		System.out.println(Stringliteral);
		
		String[] values = value.split("\\r?\\n");
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}
		
		
		
		  ArrayList<Integer> list1 = new ArrayList<Integer>(); 
		  list1 =  Size.calcSize(list,Keyword,Identifer,Operator,Number,Stringliteral);
		 
		request.setAttribute("List", list1);

		System.out.println(list1);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Size.jsp");
		dispatcher.forward(request, response);
	}

}
