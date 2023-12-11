import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TypeManager implements WalletElement {
    public static List<Type> types = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
    public void displayTypes() {
        if (types.isEmpty()) {
            System.out.println("Pas encore de type");
        } else {
            for (int i = 0; i < types.size(); i++) {
                System.out.println("   " + (i + 1) + "-" + types.get(i).getName());
            }
        }
    }

    @Override
    public void throwBack() {
        throw new Error("Not implemented");
    }
    @Override
    public void add() {
        System.out.print("Saisissez le nom de votre type: ");
        String name = scanner.nextLine();
        System.out.print("Voulez-vous que ce type de document ne puisse supporter qu'un seul exemplaire? (O/N) : ");
        boolean isUnique = scanner.nextLine().equalsIgnoreCase("O");

        types.add(new Type(name, isUnique));
        System.out.println("Type créé avec succès.");
    }
}
