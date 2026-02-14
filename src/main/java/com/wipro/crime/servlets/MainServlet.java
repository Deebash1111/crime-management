package com.wipro.crime.servlets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.wipro.crime.bean.CrimeBean;
import com.wipro.crime.service.Administrator;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    Administrator admin = new Administrator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        try {
            if ("newRecord".equals(operation)) {
                CrimeBean bean = new CrimeBean();
                bean.setCaseTitle(request.getParameter("caseTitle"));
                bean.setSuspectName(request.getParameter("suspectName"));
                bean.setCrimeType(request.getParameter("crimeType"));
                bean.setLocation(request.getParameter("location"));
                bean.setRemarks(request.getParameter("remarks"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                bean.setCrimeDate(sdf.parse(request.getParameter("crimeDate")));
                String result = admin.addRecord(bean);
                if ("SUCCESS".equals(result))
                    response.sendRedirect("success.html");
                else
                    response.sendRedirect("error.html");
            }
            else if ("viewRecord".equals(operation)) {
                String title = request.getParameter("caseTitle");
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                CrimeBean bean = admin.viewCrime(title,sdf.parse(request.getParameter("crimeDate")));
                request.setAttribute("crime", bean);
                RequestDispatcher rd =request.getRequestDispatcher("displayCrime.jsp");
                rd.forward(request, response);
            }
            else if ("viewAllRecords".equals(operation)) {
                List<CrimeBean> list = admin.viewAllCrimes();
                request.setAttribute("crimeList", list);
                RequestDispatcher rd =request.getRequestDispatcher("displayAllCrimes.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}