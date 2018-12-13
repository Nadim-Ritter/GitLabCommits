package service;

import boundary.Engine;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by admin on 07.12.2018.
 */

@Path("/")
public class Resource {

    @EJB
    Engine engine;

    /*
    @GET
    @Path("getCommitsData")
    public List<Commit> getCommitsData(@PathParam("string") String userName) throws IOException, GitLabApiException, ParseException {
        return engine.getCommitsData(userName);
    }
    */

    @GET
    @Path("getCommitsData/{int}")
    public List<Commit> getCommitsData(@PathParam("int") int projectID) throws IOException, GitLabApiException, ParseException {
        return engine.getCommitsData(projectID);
    }
}
