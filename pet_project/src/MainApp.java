import Controller.PetController;
import Repository.ListPetDAO;
import Repository.PetDAO;
import UI.ConsoleMenu;

public class MainApp {
    public static void main(String[] args) throws Exception {

        PetDAO myZoo = new ListPetDAO();
        PetController controller = new PetController(myZoo);
        new ConsoleMenu (controller).start();
    }
}    