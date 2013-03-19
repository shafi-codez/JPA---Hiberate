/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.mp2hib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class ProcessServlet extends HttpServlet {

    List display = new ArrayList();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            System.out.println("PROCESS SERVLET :");
            HttpSession session = request.getSession(true);
            if (request.getParameter("DisplayALL") != null) {
                if (request.getParameter("DisplayALL").equals("DisplayALL")) {
                    System.out.println("PROCESS SERVLET : INSDIE");
                    ArrayList<String> rowValArr = (ArrayList<String>) session.getAttribute("rowObj");
                    System.out.println("row Length is :" + rowValArr.size());
                    System.out.println("rowis Value :" + rowValArr.get(0).toString());
                    response.sendRedirect("displayAll.jsp");
                }
            } else {
                display.clear();
                if (session.getAttribute("result") != null) {
                    session.removeAttribute("result");
                }
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTANCE_UNIT);
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                String question = (String) request.getParameter("questioniare");
                String region = (String) request.getParameter("regions");
                String state = (String) request.getParameter("states");
                System.out.println("==>" + question);
                System.out.println("==>" + region);
                System.out.println("==>" + state);

                if (question.equals(Constants.OPTION1)) {

                    String add = "";

                     if (state != null && !region.equals("ALL")) {
                        add = "'" + region + "'";
                    } else {
                        add = "'United States'";
                    }

                    Query query1 = em.createNativeQuery(Constants.QUERY1 + add);
                    System.out.println(Constants.QUERY1 + add);
                    analytics(query1.getResultList());

                    Query query2 = em.createNativeQuery(Constants.QUERY2 + add);
                    analytics(query2.getResultList());
                    System.out.print(Constants.QUERY1 + add);


                } else if (question.equals(Constants.OPTION2)) {
                    String add = "";

                    if (state != null && !state.equals("ALL")) {
                        add = "'" + state + "'";
                    } else {
                        add = "'%'";
                    }

                    Query query2010 = em.createNativeQuery(Constants.QUERY3 + add);
                    analytics(query2010.getResultList());

                    Query query2011 = em.createNativeQuery(Constants.QUERY4 + add);
                    analytics(query2011.getResultList());

                } else if (question.equals(Constants.OPTION3)) {
                    String add = "";

                    if (state != null && !state.equals("ALL")) {
                        add = "'" + state + "'";
                    } else {
                        add = "'%'";
                    }

                    Query query2010 = em.createNativeQuery(Constants.QUERY5 + add);
                    analytics(query2010.getResultList());

                    Query query2011 = em.createNativeQuery(Constants.QUERY6 + add);
                    analytics(query2011.getResultList());

                } else if (question.equals(Constants.OPTION4)) {
                    String add = "";

                    if (state != null && !state.equals("ALL")) {
                        add = "'" + state + "'";
                    } else {
                        add = "'%'";
                    }

                    Query qPopInc = em.createNativeQuery(Constants.QUERY7 + add);
                    analytics(qPopInc.getResultList());

                } else if (question.equals(Constants.OPTION5)) {
                    String add = "";
                    if (state != null && !state.equals("ALL")) {
                        add = "'" + state + "'";
                    } else {
                        add = "'%'";
                    }
                    Query qPopdec = em.createNativeQuery(Constants.QUERY8 + add);
                    analytics(qPopdec.getResultList());

                } else if (question.equals(Constants.OPTION6)) {
                    Query qMost_2010 = em.createNativeQuery(Constants.QUERY9);
                    analytics(qMost_2010.getResultList());

                    Query qMost_2011 = em.createNativeQuery(Constants.QUERY10);
                    analytics(qMost_2011.getResultList());

                } else if (question.equals(Constants.OPTION7)) {
                    Query qLeast_2010 = em.createNativeQuery(Constants.QUERY11);
                    analytics(qLeast_2010.getResultList());

                    Query qLeast_2011 = em.createNativeQuery(Constants.QUERY12);
                    analytics(qLeast_2011.getResultList());
                }
                System.out.println("==> display array" + display.toString());
                session.setAttribute("result", display);
                response.sendRedirect("analytics.jsp");
            }
        } catch (Exception e) {
            System.err.println("EXCEPTION");
            System.out.println(e.fillInStackTrace().toString());
        }

    }

    public void analytics(List<Object> out) {
        Iterator i = out.iterator();
        System.out.println("analytics : Going to iterate");

        while (i.hasNext()) {
            Object obj = i.next();
            System.out.println("analytics1 : OBJ is" + obj.toString());
            display.add(obj);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
