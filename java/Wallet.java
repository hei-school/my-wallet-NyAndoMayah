import java.util.Scanner;

public class Wallet {
    static CategoriesManager categoriesManager = new CategoriesManager();
    static CostManager costManager = new CostManager();
    static TypeManager typeManager = new TypeManager();
    static DocsManager docsManager = new DocsManager();
    public static void prompt(){
        final int quitOption = 15;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===================================WALLET=====================================\n" +
                    "                        SUIVI DE SOLDE\n" +
                    "                                1. consulter votre solde\n" +
                    "                        GESTION DE DEPENSE\n" +
                    "                                2. Ajouter de l'argent\n" +
                    "                                3. Retirer de l'argent\n" +
                    "                        PLANIFICATION BUDGETAIRE\n" +
                    "                                4. Voir toutes les catégories\n" +
                    "                                5. Ajouter une nouvelle catégorie\n" +
                    "                                6. Supprimer une catégorie\n" +
                    "                                7. Modifier une catégorie\n" +
                    "                        GESTION DE DOCUMENTS\n" +
                    "                                8. Voir tous les types\n" +
                    "                                9. Voir tous les documents\n" +
                    "                                10. Ajouter un type de document\n" +
                    "                                11. Voir les détails sur un document\n" +
                    "                                12. Ajouter un document\n" +
                    "                                13. Retirer un document\n" +
                    "                                14. Modifier un document\n" +
                    "                               "+ quitOption + ". QUITTER\n" +
                    "================================================================================");

            System.out.print("Que souhaitez-vous faire? (réponse : un nombre de 1 à " + quitOption + ") : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    categoriesManager.checkBalance();
                    break;
                case 2:
                    costManager.add();
                    break;
                case 3:
                    costManager.throwBack();
                    break;
                case 4:
                    categoriesManager.displayCategories();
                    break;
                case 5:
                    categoriesManager.add();
                    break;
                case 6:
                    categoriesManager.throwBack();
                    break;
                case 7:
                    categoriesManager.modifyCategory();
                    break;
                case 8:
                    typeManager.displayTypes();
                    break;
                case 9:
                    docsManager.displayDocs();
                    break;
                case 10:
                    typeManager.add();
                    break;
                case 11:
                    docsManager.displayDocDetails();
                    break;
                case 12:
                    docsManager.add();
                    break;
                case 13:
                    docsManager.throwBack();
                    break;
                case 14:
                    docsManager.modify();
                    break;
                case quitOption:
                    return;
                default:
                    System.out.println("Veuillez choisir un nombre entre 1 et 7.");
                    break;
            }
        }
    }
}
