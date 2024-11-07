package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.RealEstateService;
import model.RealEstate;

import java.io.*;
import java.util.*;

@WebServlet("/realestate")
public class RealEstateController extends HttpServlet {
    private RealEstateService realEstateService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Ініціалізація Spring контексту (якщо необхідно)
        // Примітка: перевірте, чи використовуєте Spring, чи просто сервлети
        // якщо використовуєте Spring, цей код буде ініціалізувати контекст
        // Наприклад: realEstateService = springContext.getBean(RealEstateService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RealEstate> realEstates = realEstateService.getAllRealEstates();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(writer, realEstates);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        RealEstate realEstate = objectMapper.readValue(sb.toString(), RealEstate.class);
        realEstateService.saveOrUpdateRealEstate(realEstate);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        RealEstate realEstate = objectMapper.readValue(sb.toString(), RealEstate.class);
        realEstateService.saveOrUpdateRealEstate(realEstate);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            realEstateService.deleteRealEstate(Integer.parseInt(id));
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}