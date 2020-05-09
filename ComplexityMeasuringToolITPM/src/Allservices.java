

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Allservices
 */
@WebServlet("/Allservices")
public class Allservices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allservices() {
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
		String value = request.getParameter("submit");
		System.out.println(value);
		System.out.println("xxxxxxxxxxxxxxxxxxx1111");
		
		int NoClass = 0;
		int OneClass = 1;
		int TwoClass = 2;
		int ThreeClass = 3;
		int MoreClass = 4;
		
		int Keyword = 1;
		int Identifer = 1;
		int Operator = 1;
		int Number = 1;
		int Stringliteral = 1;
		
		int Globalvariable = 2;
		int Localvariable = 1;
		int Primitivedatatypevariable = 1;
		int Compositedatatypevariable = 2;
		
		int primitivereturntype = 1;
		int compositereturntype = 2;
		int voidreturntype = 0;
		int Primitiveparameter = 1;
		int Compositeparameter = 2;
		
		String[] values = value.split("\\r?\\n");
		ArrayList list = new ArrayList();

		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		
		list1 = Inheritance.inheritanceCi(list,NoClass,OneClass,TwoClass,ThreeClass,MoreClass);
		list2 = Size.calcSize(list, Keyword, Identifer, Operator, Number, Stringliteral);
		list3 = Cv.variable(list, Globalvariable, Localvariable, Primitivedatatypevariable, Compositedatatypevariable);
		list4 = Cm.MethodsCm(list, primitivereturntype, compositereturntype, voidreturntype, Primitiveparameter, Compositeparameter);
		
		request.setAttribute("List", list1);
		request.setAttribute("List2", list2);
		request.setAttribute("List3", list3);
		request.setAttribute("List4", list4);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllComplexity.jsp");
		dispatcher.forward(request, response);
	}

}
