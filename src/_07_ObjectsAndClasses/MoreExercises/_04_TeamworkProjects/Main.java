package _07_ObjectsAndClasses.MoreExercises._04_TeamworkProjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTeams = Integer.parseInt(scanner.nextLine());

        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            String[] tokens = scanner.nextLine().split("-");
            String teamCreator = tokens[0];
            String teamName = tokens[1];
            List<String> teamMemberNames = new ArrayList<>();
            teamMemberNames.add(teamCreator);

            boolean flag = false;
            for (Team team:teamList) {
                if (teamName.equals(team.getTeamName())) {
                    System.out.printf("Team %s was already created!%n", teamName);
                    flag = true;
                    break;
                }
            }
            for (Team team: teamList) {
                if (teamCreator.equals(team.getCreator())) {
                    System.out.printf("%s cannot create another team!%n", teamCreator);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            Team currentTeam = new Team(teamCreator, teamName, teamMemberNames, 1);
            teamList.add(currentTeam);

            System.out.printf("Team %s has been created by %s!%n", teamName, teamCreator);
        }

        String[] command = scanner.nextLine().split("->");
        while (!command[0].equals("end of assignment")) {
            String currentTeamName = command[1];
            String person = command[0];

            boolean doesTeamExist = false;
            for (Team team : teamList) {
                if (currentTeamName.equals(team.getTeamName())) {
                    doesTeamExist = true;
                }
            }
            if (!doesTeamExist) {
                System.out.printf("Team %s does not exist!%n", currentTeamName);
                command = scanner.nextLine().split("->");
                continue;
            }

            boolean memberOfTeam = false;
            for (Team team : teamList) {
                if (team.getTeamMemberNames().contains(person)) {
                    memberOfTeam = true;
                    System.out.printf("Member %s cannot join team %s!%n", person, currentTeamName);
                    command = scanner.nextLine().split("->");
                    break;
                }
            }
            if (memberOfTeam) {
                continue;
            }

            for (Team team : teamList) {
                if (currentTeamName.equals(team.getTeamName())) {
                    List<String> newTeamMembership = team.getTeamMemberNames();
                    newTeamMembership.add(person);
                    team.setTeamMemberNames(newTeamMembership);

                    int newCountOfMembers = team.getNumberOfMembers() +1;
                    team.setNumberOfMembers(newCountOfMembers);
                }
            }

            command = scanner.nextLine().split("->");
        }

        List<Team> activeTeamsList = teamList.stream().filter(team -> team.getNumberOfMembers()>1).collect(Collectors.toList());
        for (Team active : activeTeamsList) {
            System.out.println(active.getTeamName());
            Collections.sort(active.getTeamMemberNames());
            for (int i = 0; i < active.getNumberOfMembers(); i++) {
                if (i==0) {
                    System.out.printf("- %s%n", active.getCreator());
                } else {
                    System.out.printf("-- %s%n", active.getTeamMemberNames().get(i));
                }
            }
        }


        List<Team> disbandedTeamsList = teamList.stream().filter(team -> team.getNumberOfMembers()==1).collect(Collectors.toList());
        List<String> disbandedTeamsSorted = new ArrayList<>();

        if (disbandedTeamsList.size()>0) {
            System.out.println("Teams to be disband:");

            for (Team disbanded : disbandedTeamsList) {
                disbandedTeamsSorted.add(disbanded.getTeamName());
            }

            Collections.sort(disbandedTeamsSorted);
            for (String team : disbandedTeamsSorted) {
                System.out.println(team);
            }
        }

    }
}
