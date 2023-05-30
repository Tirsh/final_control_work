package Services;

import Model.*;

public class PetCreator extends Creator {

    @Override
    protected Pet createNewPet(PetType type) {

        switch (type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
            case Donkey:
                return new Donkey();
            case Horse:
                return new Horse();
        }
        return null;
    }
}
