import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApiService {
    // Gets the list of workflow runs for a repository
    @GET("/repos/{owner}/{repo}/actions/runs")
    Call<WorkflowRunsResponse> getWorkflowRuns(@Path("owner") String owner, @Path("repo") String repo, @Query("per_page") int perPage);

    // Gets the details of a specific workflow run
    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}")
    Call<WorkflowRunDetailsResponse> getWorkflowRunDetails(@Path("owner") String owner, @Path("repo") String repo, @Path("run_id") long runId);

    // Gets the list of jobs for a workflow run
    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/jobs")
    Call<WorkflowJobsResponse> getWorkflowJobs(@Path("owner") String owner, @Path("repo") String repo, @Path("run_id") long runId);

    // Gets the artifacts for a workflow run
    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/artifacts")
    Call<ArtifactsResponse> getArtifacts(@Path("owner") String owner, @Path("repo") String repo, @Path("run_id") long runId);
}