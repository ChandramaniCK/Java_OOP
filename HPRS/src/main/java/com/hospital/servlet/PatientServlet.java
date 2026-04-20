package com.hospital.servlet;

import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class PatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        String action = req.getParameter("action");
        HospitalService service = new HospitalService();

        try {

            // ➕ ADD PATIENT
            if ("add".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int age = Integer.parseInt(req.getParameter("age"));
                String disease = req.getParameter("disease");

                Patient p = new Patient(id, name, age, disease);
                service.addPatient(p);

                res.sendRedirect("viewPatients.jsp");
            }

            // 🔍 SEARCH PATIENT
            else if ("search".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                String result = service.searchPatient(id);

                req.setAttribute("result", result);
                req.getRequestDispatcher("searchResult.jsp").forward(req, res);
            }

            // 🗑️ DELETE PATIENT
            else if ("delete".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                service.deletePatient(id);

                res.sendRedirect("viewPatients.jsp");
            }

        } catch (Exception e) {
            res.getWriter().println("<h3 style='color:red'>" + e.getMessage() + "</h3>");
        }
    }
}