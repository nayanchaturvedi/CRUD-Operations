package com.example.erp.controller;

import com.example.erp.bean.LoginDetails;
import com.example.erp.service.loginService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("accounts")
public class LoginController {
    loginService loginservice = new loginService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response loginEmployee(LoginDetails logindetails) throws URISyntaxException {
        System.out.println(logindetails.getEmail());
        System.out.println(logindetails.getPassword());
        boolean result = loginservice.verifyCredentials(logindetails);
        System.out.println("In LoginController");
        if (!result) {
//            System.out.println("No data received by Login controller(not verified)");
//            return Response.noContent().build();
            return Response.status(203).build();
        }
        return Response.ok().entity(result).build();
//        return Response.ok().build();

    }
}
