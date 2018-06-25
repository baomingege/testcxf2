package com.cc.testcxf2.service;

import com.cc.testcxf2.entity.Persons;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/per")
public interface PersonsService {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add/{id}/{name}")
    public Persons add(@PathParam("id") Integer id, @PathParam("name") String name );
}
