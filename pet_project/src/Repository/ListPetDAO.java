package Repository;

import Model.Pet;
import Model.PetType;
import Services.Creator;
import Services.PetCreator;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ListPetDAO implements PetDAO {
    private final Creator petCreator = new PetCreator();
    private final List<Pet> petDb;
    private Map<Integer, List<String>> commands;

    {
        petDb = new ArrayList<>();
        commands = new HashMap<>();
        petDb.add(petCreator.createPet(1, PetType.Cat, "Мурка", LocalDate.of(2012, 12, 31)));
        petDb.add(petCreator.createPet(2, PetType.Dog, "Барбос", LocalDate.of(2014, 12, 1)));
        commands.put(1, Arrays.asList("Мурчать"));
    }

    @Override
    public List<Pet> getAll() {
        return petDb;
    }

    @Override
    public Pet getById(int petId) {
        return petDb.stream().filter(x -> x.getPetId() == petId).findFirst().orElse(null);
    }

    @Override
    public int create(Pet pet) {
        petDb.add(pet);
        return pet.getPetId();
    }

    public void train(int id, String command) {
        commands.computeIfPresent(id, (k, v) -> Stream.concat(v.stream(), Stream.of(command)).collect(Collectors.toList()));
        commands.computeIfAbsent(id, k -> new ArrayList<>(Collections.singletonList(command)));
    }

    public List<String> getCommandsById(int petId) {
        return commands.get(petId);
    }

    @Override
    public int update(Pet pet) {
        int petId = pet.getPetId();
        petDb.remove(getById(petId));
        petDb.add(pet);
        return petId;
    }

    @Override
    public void delete(int id) {
        petDb.removeIf(x -> x.getPetId() == id);
    }
}
