import java.util.ArrayList;
import java.util.Scanner;

public class CostManager implements WalletElement {
    private static CategoriesManager categoriesManager = new CategoriesManager();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void throwBack() {
        categoriesManager.getCategories();

        System.out.print("À quelle catégorie allez-vous retirer de l'argent? (réponse: un nombre) : ");
        int categoryIndex = scanner.nextInt();
        ArrayList<Category> categories = CategoriesManager.getCategories();

        if (categoryIndex >= 1 && categoryIndex <= categories.size()) {
            System.out.print("Saisissez la valeur à retirer : ");
            int value = scanner.nextInt();
            Category category = categories.get(categoryIndex - 1);
            category.setBalance(category.getBalance() - value);
            System.out.println("Argent retiré avec succès.");
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }

    @Override
    public void add() {
        categoriesManager.getCategories();
        System.out.print("À quelle catégorie allez-vous ajouter de l'argent? (réponse: un nombre) : ");
        int categoryIndex = scanner.nextInt();
        ArrayList<Category> categories = CategoriesManager.getCategories();

        if (categoryIndex >= 1 && categoryIndex <= categories.size()) {
            System.out.print("Saisissez la valeur à ajouter : ");
            int value = scanner.nextInt();
            Category category = categories.get(categoryIndex - 1);
            category.setBalance(category.getBalance() + value);
            System.out.println("Argent ajouté avec succès.");
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }
}
