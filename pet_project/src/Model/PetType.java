package Model;

public enum PetType {

    Cat("кошка"), Dog("собака"), Hamster("Хомяк"), Donkey("Ослик"), Horse("Лошадь");

    private String petType;

    PetType(String petType) {
        this.petType = petType;

    }
}
