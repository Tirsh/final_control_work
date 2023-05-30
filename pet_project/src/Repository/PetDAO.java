package Repository;

import Model.Pet;

import java.util.List;

public interface PetDAO {

    List<Pet> getAll();

    Pet getById(int id);

    int create(Pet item);

    int update(Pet item);

    void delete(int item);

    List<String> getCommandsById(int id);
}
