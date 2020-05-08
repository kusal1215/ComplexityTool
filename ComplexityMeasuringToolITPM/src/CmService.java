

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MethodsComplexity;

/**
 * Servlet implementation class CmService
 */
@WebServlet("/CmService")
public class CmService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CmService() {
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
		String value = request.getParameter("userId");
		System.out.println(value);
		System.out.println("xxxxxxxxxxxxxxxxxxx");
		
		int primitivereturntype = Integer.parseInt(request.getParameter("primitivereturntype"));
		int compositereturntype = Integer.parseInt(request.getParameter("compositereturntype"));
		int voidreturntype = Integer.parseInt(request.getParameter("voidreturntype"));
		int Primitiveparameter = Integer.parseInt(request.getParameter("Primitiveparameter"));
		int Compositeparameter = Integer.parseInt(request.getParameter("Compositeparameter"));
		
		System.out.println(primitivereturntype);
		System.out.println(compositereturntype);
		System.out.println(voidreturntype);
		System.out.println(Primitiveparameter);
		System.out.println(Compositeparameter);
		
		String[] values = value.split("\\r?\\n");
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}
		
			
		ArrayList<MethodsComplexity> list1 = new ArrayList<>(); 
		list1 =  Cm.MethodsCm(list,primitivereturntype,compositereturntype,voidreturntype,Primitiveparameter,Compositeparameter);
		 
		request.setAttribute("List", list1);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/methods.jsp");
		dispatcher.forward(request, response);
	}

}
