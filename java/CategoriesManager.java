import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.isNaN;

public class CategoriesManager implements WalletElement {

    private static ArrayList<Category> categories = new ArrayList<Category>();

    static {
        categories.add(new Category(0, "Principale"));
    }

    public static void setCategories(ArrayList<Category> categories) {
        CategoriesManager.categories = categories;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public void displayCategories() {
        for (int i = 0; i < categories.size(); i++) {
            int index = i+1;
            System.out.println(index + "-" + getCategories().get(i).getName());
        }
    }

    @Override
    public void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir le nom de la catégorie : ");
        String newCategoryName = scanner.nextLine();
        ArrayList<Category> categories = getCategories();
        categories.add(new Category(0, newCategoryName));
        setCategories(categories);
        System.out.println("Catégorie ajoutée avec succès.");
    }
    @Override
    public void throwBack() {
        Scanner scanner = new Scanner(System.in);
        displayCategories();
        System.out.print("Quelle catégorie allez-vous supprimer? (réponse : un nombre) : ");
        int categoryIndex = scanner.nextInt();
        if (categoryIndex >= 1 && categoryIndex <= getCategories().size()) {
            ArrayList<Category> categories = getCategories();
            categories.remove(categoryIndex - 1);
            setCategories(categories);
            System.out.println("Catégorie retirée avec succès.");
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }
    public void checkBalance() {
        displayCategories();
        System.out.print("Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : ");
        Scanner scanner = new Scanner(System.in);
        int categoryIndex = scanner.nextInt();

        if (categoryIndex >= 1 && categoryIndex <= getCategories().size()) {
            System.out.printf("Le solde de la catégorie %s est %d Ariary%n",
                    getCategories().get(categoryIndex - 1).getName(), getCategories().get(categoryIndex - 1).getBalance());
        } else {
            System.out.println("Catégorie invalide.");
        }
    }
    public void modifyCategory() {
        Scanner scanner = new Scanner(System.in);
        displayCategories();
        System.out.print("Quelle catégorie souhaitez-vous modifier ? (Entrez un numéro) : ");
        int categoryIndex = Integer.parseInt(scanner.nextLine());

        if (categoryIndex > 0 && categoryIndex <= categories.size()) {
            System.out.print("Souhaitez-vous modifier le nom (tapez 'nom') ou le montant (tapez 'montant') de cette catégorie ? : ");
            String attributeChoice = scanner.nextLine().toLowerCase();

            if (attributeChoice.equals("nom")) {
                System.out.print("Entrez le nouveau nom pour cette catégorie : ");
                String newName = scanner.nextLine();
                categories.get(categoryIndex - 1).setName(newName);
                System.out.println("Nom de catégorie modifié avec succès.");
            } else if (attributeChoice.equals("montant")) {
                System.out.print("Entrez le nouvel montant pour cette catégorie : ");
                int newAmount = Integer.parseInt(scanner.nextLine());

                if (!isNaN(newAmount)) {
                    categories.get(categoryIndex - 1).setBalance(newAmount);
                    System.out.println("Montant de catégorie modifié avec succès.");
                } else {
                    System.out.println("Montant invalide.");
                }
            } else {
                System.out.println("Choix invalide.");
            }
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }

}