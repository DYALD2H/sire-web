/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sire.ws.service;

import com.sire.entities.InvGrupo3;
import com.sire.entities.InvGrupo3PK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Administrator
 */
@Stateless
@Path("com.sire.entities.invgrupo3")
public class InvGrupo3FacadeREST extends AbstractFacade<InvGrupo3> {
    @PersistenceContext(unitName = "com.sire_SIRE-WS_war_1.0.0PU")
    private EntityManager em;

    private InvGrupo3PK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codEmpresa=codEmpresaValue;codGrupo1=codGrupo1Value;codGrupo2=codGrupo2Value;codGrupo3=codGrupo3Value'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.sire.entities.InvGrupo3PK key = new com.sire.entities.InvGrupo3PK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codEmpresa = map.get("codEmpresa");
        if (codEmpresa != null && !codEmpresa.isEmpty()) {
            key.setCodEmpresa(codEmpresa.get(0));
        }
        java.util.List<String> codGrupo1 = map.get("codGrupo1");
        if (codGrupo1 != null && !codGrupo1.isEmpty()) {
            key.setCodGrupo1(codGrupo1.get(0));
        }
        java.util.List<String> codGrupo2 = map.get("codGrupo2");
        if (codGrupo2 != null && !codGrupo2.isEmpty()) {
            key.setCodGrupo2(codGrupo2.get(0));
        }
        java.util.List<String> codGrupo3 = map.get("codGrupo3");
        if (codGrupo3 != null && !codGrupo3.isEmpty()) {
            key.setCodGrupo3(codGrupo3.get(0));
        }
        return key;
    }

    public InvGrupo3FacadeREST() {
        super(InvGrupo3.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(InvGrupo3 entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, InvGrupo3 entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.sire.entities.InvGrupo3PK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public InvGrupo3 find(@PathParam("id") PathSegment id) {
        com.sire.entities.InvGrupo3PK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<InvGrupo3> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<InvGrupo3> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
