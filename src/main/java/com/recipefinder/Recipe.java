package com.recipefinder;

public record Recipe(String title, String ingredients, String servings, String instructions) {

    @Override
    public String toString() {
        return String.format("%s\n\n%s\n\n%s\n\n%s\n", title, ingredients, servings, instructions);
    }

}
