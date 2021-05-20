package com.example.erp.controller;

import com.example.erp.bean.Bill;
import com.example.erp.service.DomainService;
import com.example.erp.service.operationService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

public class DomainController {

    DomainService domainService = new DomainService();

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createBill(@FormDataParam("description") String description,
                               @FormDataParam("amount") Integer amount,
                               @FormDataParam("date") String date,
                               @FormDataParam("status") String status) throws URISyntaxException {
        Bill bill = new Bill(description, amount, date, status);
        System.out.println(bill.getDescription());
        System.out.println(bill.getAmount());
        operationService operationServ = new operationService();
        if (operationServ.createBill(bill)) {
            System.out.println("No data received by create bill controller");
            return Response.status(203).build();
        }
        return Response.ok().build();
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBill(@FormDataParam("student_id") String description,
                               @FormDataParam("amount") Integer amount,
                               @FormDataParam("status") String status) throws URISyntaxException {
        System.out.println("INSIDE OPERATION CONTROLLER");
        Bill bill = new Bill(description, amount, null, status);
        if (domainService.updateBill(bill)) {
            System.out.println("No data received by update bill controller");
            return Response.status(203).build();
        }
        return Response.ok().build();

    }

    @POST
    @Path("/read")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response readBill(@FormDataParam("bill_id") Integer bill_id) throws URISyntaxException {
        Bill bill0 = new Bill(bill_id);

        System.out.println("In Controller");
        Bill bill = domainService.readBill(bill0);
        System.out.println(bill_id);
        System.out.println(bill.getDescription());
        System.out.println(bill.getAmount());
        System.out.println(bill.getDate());
        System.out.println(bill.getStatus());

        //String str=
        if (bill == null) {
            System.out.println("No data received by controller(not verified)");
            return Response.status(203).build();
        }
        return Response.ok().entity(bill).build();
    }
}

