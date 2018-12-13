package control;

import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.*;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.User;
import org.gitlab4j.api.utils.ISO8601;

/**
 * Created by admin on 07.12.2018.
 */
public class CallMicroService {

    private final String USER_AGENT =  "Chrome/70.0.3538.110";

    // DB_USER is same as PROJECT_NAME
    private final String PROJECT_NAME = System.getenv("DB_USER");
    final String REST_URI = "https://" + PROJECT_NAME + ".komeo.net";

    GitLabApi gitLabApi = new GitLabApi("https://k289gitlab1.citrin.ch", "a9GVH8k_WVxibEFzG8M9");




    public List<Commit> getCommitsData(int projectID) throws IOException, ParseException, GitLabApiException {

        //Client client = Client.create();
        //WebResource resource = client.resource(REST_URI);
        //WebResource resource = client.resource(REST_URI);



        // Get a list of commits assoc  iated with the specified branch that fall within the specified time window
        // This uses the ISO8601 date utilities the in org.gitlab4j.api.utils.ISO8601 class
        Date since = ISO8601.toDate("2017-01-01T00:00:00Z");
        Date until = new Date(); // now
        List<Commit> commits = gitLabApi.getCommitsApi().getCommits(projectID);

        System.out.println("----------------------------" + commits.get(0));


        return commits;
    }
}
