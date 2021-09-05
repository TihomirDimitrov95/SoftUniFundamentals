package _11_FinalExam._02_SecondPracticeExam;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfHeroes; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String heroName = input[0];
            int heroHP = Integer.parseInt(input[1]);
            if (heroHP > 100) {
                heroHP = 100;
            }
            int heroMP = Integer.parseInt(input[2]);
            if (heroMP > 200) {
                heroHP = 200;
            }

            heroesMap.put(heroName, new ArrayList<>());
            heroesMap.get(heroName).add(heroHP); //Hero Health will always be first in the list
            heroesMap.get(heroName).add(heroMP); // Hero Mana will always be second in the list
        }

        String[] command = scanner.nextLine().split(" - ");
        while(!command[0].equals("End")) {
            String heroName = command[1];

            switch (command[0]) {
                case "CastSpell":
                    castSpellCommand(heroesMap, heroName, Integer.parseInt(command[2]), command[3]);
                    break;
                case "TakeDamage":
                    takeDamageCommand(heroesMap, heroName, Integer.parseInt(command[2]), command[3]);
                    break;
                case "Recharge":
                    rechargeCommand(heroesMap, heroName, Integer.parseInt(command[2]));
                    break;
                case "Heal":
                    healCommand(heroesMap, heroName, Integer.parseInt(command[2]));
                    break;
            }

            command = scanner.nextLine().split(" - ");
        }

        heroesMap.entrySet().stream()
                .sorted((left, right) -> {
                    int result = right.getValue().get(0).compareTo(left.getValue().get(0));

                    if (result == 0) {
                        result = left.getKey().compareTo(right.getKey());
                    }

                    return result;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.printf("  HP: %d%n", e.getValue().get(0));
                    System.out.printf("  MP: %d%n", e.getValue().get(1));
                });


    }

    private static void healCommand(Map<String, List<Integer>> heroesMap, String heroName, int amount) {
        int updatedHealth = amount + heroesMap.get(heroName).get(0);

        if (updatedHealth>100) {
            updatedHealth = 100;
            amount = 100 - heroesMap.get(heroName).get(0);
        }

        heroesMap.get(heroName).set(0, updatedHealth);
        System.out.printf("%s healed for %d HP!%n", heroName, amount);
    }

    private static void rechargeCommand(Map<String, List<Integer>> heroesMap, String heroName, int amount) {
        int updatedManaPoints = amount + heroesMap.get(heroName).get(1);

        if (updatedManaPoints>200) {
            updatedManaPoints=200;
            amount = 200 - heroesMap.get(heroName).get(1);
        }

        heroesMap.get(heroName).set(1, updatedManaPoints);
        System.out.printf("%s recharged for %d MP!%n", heroName, amount);
    }

    private static void takeDamageCommand(Map<String, List<Integer>> heroesMap, String heroName, int damage, String attacker) {
        int availableHealth = heroesMap.get(heroName).get(0);

        if (availableHealth-damage>0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, availableHealth-damage);
            heroesMap.get(heroName).set(0, availableHealth-damage);
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
            heroesMap.remove(heroName);
        }


    }

    private static void castSpellCommand(Map<String, List<Integer>> heroesMap, String heroName, int manaNeeded, String spellName) {
        int manaAvailable = heroesMap.get(heroName).get(1);

        if (manaAvailable>=manaNeeded) {
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaAvailable-manaNeeded);
            heroesMap.get(heroName).set(1, manaAvailable-manaNeeded);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }


    }
}
