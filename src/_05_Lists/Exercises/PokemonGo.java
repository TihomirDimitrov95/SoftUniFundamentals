package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int removedElementsSum = 0;

        while (pokemonList.size()>0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index<0) {
                removedElementsSum += pokemonList.get(0);
                pokemonList.set(0, pokemonList.get(pokemonList.size()-1));

                executeChange(pokemonList.get(0), pokemonList);

            } else if (index>=pokemonList.size()) {
                removedElementsSum += pokemonList.get(pokemonList.size()-1);

                pokemonList.set(pokemonList.size()-1, pokemonList.get(0));
                executeChange(pokemonList.get(pokemonList.size()-1), pokemonList);

            } else {
                int caughtPokemon = pokemonList.get(index);
                removedElementsSum += caughtPokemon;

                executeChange(caughtPokemon, pokemonList);
                pokemonList.remove(index);
            }
        }

        System.out.println(removedElementsSum);

    }

    private static void executeChange(Integer valueOfRemovedPokemon, List<Integer> pokemonList) {
        for (int i = 0; i < pokemonList.size(); i++) {
            if (pokemonList.get(i)>valueOfRemovedPokemon) {
                int updatedValue = pokemonList.get(i) - valueOfRemovedPokemon;
                pokemonList.set(i, updatedValue);
            } else {
                int updatedValue = pokemonList.get(i) + valueOfRemovedPokemon;
                pokemonList.set(i, updatedValue);
            }
        }
    }

}
