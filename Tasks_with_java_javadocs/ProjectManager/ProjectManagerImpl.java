import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import lt.itakademija.exam.Issue;
import lt.itakademija.exam.Project;
import lt.itakademija.exam.ProjectManager;

public class ProjectManagerImpl implements ProjectManager {

	List<Issue> issues = new LinkedList<>();
	List<Project> projets = new LinkedList<>();

	@Override
	public Issue createIssue(Project project, String summary) {
		if (project == null || summary == null)
			throw new NullPointerException();
		if (summary.isEmpty())
			throw new IllegalArgumentException();

		Issue newIssue = new Issue(project, summary);
		issues.add(newIssue);
		return newIssue;
	}

	@Override
	public Issue createIssue(String projectId, String summary) {
		if (projectId == null || summary == null)
			throw new NullPointerException();
		if (projectId.isEmpty() || summary.isEmpty())
			throw new IllegalArgumentException();

		Project newProject = new Project(projectId, summary);
		Issue newIssue = new Issue(newProject, summary);
		newProject.addIssue(newIssue);
		issues.add(newIssue);
		return newIssue;
	}

	@Override
	public Project createProject(String id, String summary) {
		if (id.isEmpty() || summary.isEmpty())
			throw new IllegalArgumentException();

		Project newProject = new Project(id, summary);
		projets.add(newProject);
		return newProject;
	}

	@Override
	public Collection<Issue> getIssues(Project project) {
		List<Issue> newIssues = new LinkedList<>();

		for (Issue issue : issues) {
			if (issue.getProject() == project) {
				newIssues.add(issue);
			}
		}
		return newIssues;
	}

	@Override
	public Collection<Issue> getIssues(String projectId) {
		List<Issue> newIssues = new LinkedList<>();

		for (Issue issue : issues) {
			if (issue.getProject().getId().equals(projectId)) {
				newIssues.add(issue);
			}
		}
		return newIssues;
	}

	@Override
	public Project getProjectById(String id) {
		return projets.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
	}

	@Override
	public Collection<Project> getProjects() {
		return projets;
	}

	public static void main(String[] args) {
		String projectId = "PROJ-1";
		String projectSummary = "Test project";
		List<Issue> issues = new LinkedList();
		ProjectManager sut = new ProjectManagerImpl();
		Project project = sut.createProject(projectId, projectSummary);

		for (int i = 0; i < random(100); ++i) {
			String issueSummary = "Test project: " + i;
			issues.add(new Issue(project, issueSummary));
			sut.createIssue(project, issueSummary);
		}

		Collection<Issue> createdIssues = sut.getIssues(projectId);
		System.out.println();
//		Assert.assertThat(createdIssues, Matchers.hasItems(issues.toArray(new Issue[0])));
	}

	private static int random(int maxValue) {
		return 1 + (int) (Math.random() * (double) maxValue);
	}
}
