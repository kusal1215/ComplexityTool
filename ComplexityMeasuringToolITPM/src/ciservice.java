
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ciservice
 */
@WebServlet("/ciservice")
public class ciservice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ciservice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String value = request.getParameter("submit");
		System.out.println(value);

		String[] values = value.split("\\r?\\n");
		ArrayList list = new ArrayList();

		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//list1 = UI.inheritanceCi(list);
		list1 = Inheritance.inheritanceCi(list);

		//System.out.println("IN SERVLET. " + list1.size());
		request.setAttribute("List", list1);
		//request.setAttribute("List2", list);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Inheritance.jsp");
		dispatcher.forward(request, response);

	}

}
