package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String strAge = request.getParameter("age");

       request.setAttribute("age", strAge);

       if (strAge == null || strAge.equals("")) {
           request.setAttribute("error", "You must give your current age.");

           getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                   .forward(request, response);
           return;
       }
       else {
           try {
               Integer.parseInt(strAge);
           } catch (NumberFormatException e) {
               request.setAttribute("error", "You must enter a number.");
               getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                       .forward(request, response);
               return;
           }
       }

       int nextAge = Integer.parseInt(strAge) + 1;

       request.setAttribute("valid", "Your age next birthday will be " + nextAge
               + ".");
       getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
               .forward(request, response);
    }
}
