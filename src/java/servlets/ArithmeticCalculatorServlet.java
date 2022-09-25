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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String firstNum = request.getParameter("first");
            String secondNum = request.getParameter("second");
            String operation = request.getParameter("operation");

            int num1 = Integer.parseInt(firstNum);
            int num2 = Integer.parseInt(secondNum);
            int result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }

            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);

            if (firstNum.equals("") && secondNum.equals("")) {
                request.setAttribute("result", "---");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                        .forward(request, response);
                return;
            }

            if (firstNum == null || firstNum.equals("") || secondNum == null
                    || secondNum.equals("")) {
                request.setAttribute("result", "invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                        .forward(request, response);
                return;
            }

        } catch (NumberFormatException e) {
            request.setAttribute("result", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
        }
    }
}