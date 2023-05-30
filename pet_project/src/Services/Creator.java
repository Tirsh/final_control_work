package Services;

import Model.Pet;
import Model.PetType;

import java.time.LocalDate;

public abstract class Creator {

    protected abstract Pet createNewPet(PetType type);

    public Pet createPet(int id, PetType type, String name, LocalDate date) {
        Pet pet = createNewPet(type);
        pet.setPetId(id);
        pet.setName(name);
        pet.setBirthday(date);
        return pet;
    }
}
