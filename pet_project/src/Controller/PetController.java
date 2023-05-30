package Controller;

import Model.Pet;
import Model.PetType;
import Repository.ListPetDAO;
import Repository.PetDAO;
import Services.Creator;
import Services.PetCreator;
import UI.ConsoleView;
import UI.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetController {
    private final PetDAO petRepository;
    private final Creator petCreator;
    private final View view;
    private final Validator validator;

    public PetController(PetDAO petRepository) {
        this.petRepository = petRepository;
        this.petCreator = new PetCreator();
        this.view = new ConsoleView();
        this.validator = new Validator();
    }

    public void createPet(PetType type, int id) {

        String[] data = new String[]{view.getName(), view.getBirthday()};
        validator.validate(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        try {
            int newId = petRepository.create(petCreator.createPet(id, type, data[0], birthday));
            view.showMessage(String.format("Добавлена запись № %d", newId));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void updatePet(int id) {

        Pet pet = getById(id);
        String[] data = new String[]{view.getName(), view.getBirthday()};

        validator.validate(data);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        pet.setName(data[0]);
        pet.setBirthday(birthday);
        try {
            int res = petRepository.update(pet);
            view.showMessage(String.format("%d запись изменена \n", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void getAllPet() {
        try {
            view.printAll(petRepository.getAll(), Pet.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean trainPet(int id, String command) {
        try {
            if (petRepository.getCommandsById(id) != null && petRepository.getCommandsById(id).contains(command))
                view.showMessage("Такая команда есть");
            else {
                ((ListPetDAO) petRepository).train(id, command);
                view.showMessage("Новая команда изучена\n");
                return true;

            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Pet getById(int id) {
        try {
            return petRepository.getById(id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            petRepository.delete(id);
            view.showMessage("запись удалена");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void getCommands(int id) {
        try {
            view.printAll(((ListPetDAO) petRepository).getCommandsById(id), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }
}
