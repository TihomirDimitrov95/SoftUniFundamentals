package _07_ObjectsAndClasses.MoreExercises._04_TeamworkProjects;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Team {
    private String creator;
    private String teamName;
    private List<String> teamMemberNames;
    private int numberOfMembers;

    public Team(String creator, String teamName, List<String> teamMemberNames, int numberOfMembers) {
        this.creator = creator;
        this.teamName = teamName;
        this.teamMemberNames = teamMemberNames;
        this.numberOfMembers = numberOfMembers;
    }


    public String getCreator() {
        return creator;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<String> getTeamMemberNames() {
        return teamMemberNames;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamMemberNames(List<String> teamMemberNames) {
        this.teamMemberNames = teamMemberNames;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }
}
