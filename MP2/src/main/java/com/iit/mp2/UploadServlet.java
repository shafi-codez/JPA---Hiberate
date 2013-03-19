/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.mp2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shafi
 */
public class UploadServlet extends HttpServlet {

    public List regions = new ArrayList();
    public List state = new ArrayList();
    public static List<String> rowObj = new ArrayList<String>();

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

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

        String contentType = request.getContentType();
        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {

            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();
            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;
            while (totalBytesRead < formDataLength) {
                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                totalBytesRead += byteRead;
            }

            String file = new String(dataBytes);
            System.out.println("file ::  " + file);
            String loadFile = file.substring(file.indexOf("filename=\"") + 10);
            loadFile = loadFile.substring(0, loadFile.indexOf("\n"));
            loadFile = loadFile.substring(loadFile.lastIndexOf("\\") + 1, loadFile.indexOf("\""));
            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1, contentType.length());
            int pos;
            pos = file.indexOf("filename=\"");
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            int boundaryLocation = file.indexOf(boundary, pos) - 4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            File ff = new File(loadFile);
            FileOutputStream fileOut = new FileOutputStream(ff);
            fileOut.write(dataBytes, startPos, (endPos - startPos));
            fileOut.flush();
            fileOut.close();
            System.out.println("You have successfully upload the file:" + loadFile);
            if (dataPersist(loadFile)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("regions", regions);
                session.setAttribute("states", state);
                session.setAttribute("rowObj", rowObj);
                response.sendRedirect("analytics.jsp");
            } else {
                response.sendRedirect("invalid.jsp");
            }
        }
    }

    public boolean dataPersist(String loadFile) {
        Statement pst = null;
        String line = null;

        int header = 1;
        System.out.println("dataPersist :: " + loadFile);
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MP2");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            StringBuilder contents = new StringBuilder();

            BufferedReader input = new BufferedReader(new FileReader(loadFile));
            System.out.println("dataPersist :: going to looop nw ");
            while ((line = input.readLine()) != null) {
                System.out.println("dataPersist :: Inside while");
                contents.append(line);
                rowObj.add(line);
                if (header != 1) {
                    
                    System.out.println("line is:" + line);
                    String[] values = line.split(",");
                    
                    USCensusPopulationData Info = new USCensusPopulationData(values);
                    System.out.println("Line values are" + values.toString());
                    System.out.println("Beans values are" + Info.toString());

                    if (em.getTransaction().isActive()) {
                        em.persist(Info);
                        //entityManager.flush();
                        System.out.println("Am active:");
                    } else {
                        System.out.println("Am INNNactive:");
                    }
                }
                header++;
            }

            em.getTransaction().commit();



            String regionQuery = "select name from uscensuspopulationdata where state=0";

            Query query = em.createNativeQuery(regionQuery);
            System.out.println("I git it:");

            List<String> ex = query.getResultList();
            System.out.println("Going to iterate ->" + ex.size());
            Iterator i = ex.iterator();
            System.out.println("Going to iterate");

            while (i.hasNext()) {
                String region = i.next().toString();
                System.out.println("out is :" + region);
                regions.add(region);
            }

            String stateQuery = " select name from uscensuspopulationdata where state!=0";

            Query query1 = em.createNativeQuery(stateQuery);
            System.out.println("I git it:");

            List<String> ex1 = query1.getResultList();
            System.out.println("Going to iterate ->" + ex1.size());
            Iterator i1 = ex1.iterator();
            System.out.println("Going to iterate");

            while (i1.hasNext()) {
                String state_itr = i1.next().toString();
                System.out.println("out is :" + state_itr);
                state.add(state_itr);
            }

            System.out.println("states >>" + state.toString());
            System.out.println("regions >>" + regions.toString());



        } catch (Exception e) {
            System.out.println("dataPersist exception !!!!:: ");
            System.out.println(e.getMessage());
            return false;
        }


        System.out.println("All Saved...");

        return true;
    }
}