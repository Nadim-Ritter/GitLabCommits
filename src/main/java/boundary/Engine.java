package boundary;

import control.CallMicroService;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by admin on 07.12.2018.
 */

@Stateless
public class Engine {

    @Inject
    CallMicroService callMicroService;

    public List<Commit> getCommitsData(int projectID) throws IOException, GitLabApiException, ParseException {
        return callMicroService.getCommitsData(projectID);

    }




}
