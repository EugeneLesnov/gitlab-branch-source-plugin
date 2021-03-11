package io.jenkins.plugins.gitlabbranchsource.Cause;

import java.util.HashMap;
import java.util.Map;
import org.gitlab4j.api.webhook.NoteEvent;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import static io.jenkins.plugins.gitlabbranchsource.Cause.GitLabCauseUtils.defaultIntString;
import static io.jenkins.plugins.gitlabbranchsource.Cause.GitLabCauseUtils.defaultVisibilityString;
import static org.apache.commons.lang.StringUtils.defaultString;

@ExportedBean
public class GitLabMergeRequestNoteData {

    private final Map<String, String> variables = new HashMap<>();

    public GitLabMergeRequestNoteData(NoteEvent noteEvent) {
        this.variables.put("GITLAB_OBJECT_KIND",  defaultString(NoteEvent.OBJECT_KIND));
        this.variables.put("GITLAB_COMMENT_TRIGGER",  defaultString(noteEvent.getObjectAttributes().getNote()));
        this.variables.put("GITLAB_USER_ID", defaultIntString(noteEvent.getUser().getId()));
        this.variables.put("GITLAB_PROJECT_ID", defaultIntString(noteEvent.getProjectId()));
        this.variables.put("GITLAB_PROJECT_ID_2", defaultIntString(noteEvent.getProject().getId()));
        this.variables.put("GITLAB_PROJECT_NAME", defaultString(noteEvent.getProject().getName()));
        this.variables.put("GITLAB_PROJECT_DESCRIPTION", defaultString(noteEvent.getProject().getDescription()));
        this.variables.put("GITLAB_PROJECT_WEB_URL", defaultString(noteEvent.getProject().getWebUrl()));
        this.variables.put("GITLAB_PROJECT_AVATAR_URL", defaultString(noteEvent.getProject().getAvatarUrl()));
        this.variables.put("GITLAB_PROJECT_GIT_SSH_URL", defaultString(noteEvent.getProject().getGitSshUrl()));
        this.variables.put("GITLAB_PROJECT_GIT_HTTP_URL", defaultString(noteEvent.getProject().getGitHttpUrl()));
        this.variables.put("GITLAB_PROJECT_NAMESPACE", defaultString(noteEvent.getProject().getNamespace()));
        this.variables.put("GITLAB_PROJECT_VISIBILITY_LEVEL", defaultVisibilityString(noteEvent.getProject().getVisibilityLevel()));
        this.variables.put("GITLAB_PROJECT_PATH_NAMESPACE", defaultString(noteEvent.getProject().getPathWithNamespace()));
        this.variables.put("GITLAB_PROJECT_CI_CONFIG_PATH", defaultString(noteEvent.getProject().getCiConfigPath()));
        this.variables.put("GITLAB_PROJECT_DEFAULT_BRANCH", defaultString(noteEvent.getProject().getDefaultBranch()));
        this.variables.put("GITLAB_PROJECT_HOMEPAGE", defaultString(noteEvent.getProject().getHomepage()));
        this.variables.put("GITLAB_PROJECT_URL", defaultString(noteEvent.getProject().getUrl()));
        this.variables.put("GITLAB_PROJECT_SSH_URL", defaultString(noteEvent.getProject().getSshUrl()));
        this.variables.put("GITLAB_PROJECT_HTTP_URL", defaultString(noteEvent.getProject().getHttpUrl()));
        this.variables.put("GITLAB_REPO_NAME", defaultString(noteEvent.getRepository().getName()));
        this.variables.put("GITLAB_REPO_URL", defaultString(noteEvent.getRepository().getUrl()));
        this.variables.put("GITLAB_REPO_DESCRIPTION", defaultString(noteEvent.getRepository().getDescription()));
        this.variables.put("GITLAB_REPO_HOMEPAGE", defaultString(noteEvent.getRepository().getHomepage()));
        this.variables.put("GITLAB_REPO_GIT_SSH_URL", defaultString(noteEvent.getRepository().getGit_ssh_url()));
        this.variables.put("GITLAB_REPO_GIT_HTTP_URL", defaultString(noteEvent.getRepository().getGit_http_url()));
        this.variables.put("GITLAB_REPO_VISIBILITY_LEVEL", defaultVisibilityString(noteEvent.getRepository().getVisibility_level()));
        this.variables.put("GITLAB_REQUEST_URL", defaultString(noteEvent.getRequestUrl()));
        this.variables.put("GITLAB_REQUEST_STRING", defaultString(noteEvent.getRequestQueryString()));
        this.variables.put("GITLAB_REQUEST_TOKEN", defaultString(noteEvent.getRequestSecretToken()));
    }

    @Exported
    public Map<String, String> getBuildVariables() {
        return variables;
    }
}
