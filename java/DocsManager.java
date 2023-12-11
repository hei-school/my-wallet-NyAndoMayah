import java.util.ArrayList;
import java.util.Scanner;

public class DocsManager implements WalletElement{
    static TypeManager typeManager = new TypeManager();
    static ArrayList<Doc> docs = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void displayDocs() {
        if (docs.isEmpty()) {
            System.out.println("Pas encore de document");
        } else {
            for (int i = 0; i < docs.size(); i++) {
                System.out.println((i + 1) + "-" + docs.get(i).getLabel());
            }
        }
    }

    public void displayDocDetails() {
        displayDocs();
        System.out.print("Sur quel document souhaitez-vous connaitre plus de détail? (réponse un nombre) : ");
        int docsIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (docsIndex >= 0 && docsIndex < docs.size()) {
            Doc doc = docs.get(docsIndex);
            Type type = typeManager.getTypes().stream().filter(t -> t.getId().equals(doc.getTypeId())).findFirst().orElse(null);
            if (type != null) {
                System.out.println("Voici les détails sur ce document :\n" +
                        "- étiquette : " + doc.getLabel() + "\n" +
                        "- description: " + doc.getDescription() + "\n" +
                        "- type: " + type.getName());
            }
        } else {
            System.out.println("Le document n'existe pas.");
        }
    }
    @Override
    public void throwBack() {
        displayDocs();
        System.out.print("Quel document souhaitez-vous supprimer? (réponse un nombre) : ");
        int docsIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (docsIndex >= 0 && docsIndex < docs.size()) {
            docs.remove(docsIndex);
            System.out.println("Document supprimé avec succès.");
        } else {
            System.out.println("Le document n'existe pas.");
        }
    }

    @Override
    public void add() {
        if (typeManager.getTypes().isEmpty()) {
            System.out.println("Créez d'abord un type.");
        } else {
            System.out.print("Une étiquette pour votre document : ");
            String label = scanner.nextLine();
            System.out.print("Une petite description pour votre document : ");
            String description = scanner.nextLine();
            typeManager.displayTypes();
            System.out.print("Quel sera le type de votre document? (réponse un nombre) : ");
            int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (typeIndex >= 0 && typeIndex < typeManager.getTypes().size()) {
                docs.add(new Doc(label, description, typeManager.getTypes().get(typeIndex).getId()));
            }
        }
    }
    public void modify() {
        displayDocs();
        System.out.print("Quel document souhaitez-vous modifier? (réponse un nombre) : ");
        int docIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (docIndex >= 0 && docIndex < docs.size()) {
            Doc doc = docs.get(docIndex);
            System.out.print("Que souhaitez-vous modifier pour le document \"" + doc.getLabel() + "\"?\n" +
                    "1. Type\n" +
                    "2. Description\n" +
                    "3. Label\n" +
                    "Entrez le numéro correspondant : ");
            int attributeToModify = Integer.parseInt(scanner.nextLine());

            switch (attributeToModify) {
                case 1:
                    typeManager.displayTypes();
                    System.out.print("Quel sera le nouveau type pour ce document? (réponse un nombre) : ");
                    int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (typeIndex >= 0 && typeIndex < typeManager.getTypes().size()) {
                        doc.setTypeId(typeManager.getTypes().get(typeIndex).getId());
                        System.out.println("Type de document modifié avec succès.");
                    } else {
                        System.out.println("Type de document invalide.");
                    }
                    break;
                case 2:
                    System.out.print("Entrez la nouvelle description pour ce document : ");
                    String newDescription = scanner.nextLine();
                    doc.setDescription(newDescription);
                    System.out.println("Description du document modifiée avec succès.");
                    break;
                case 3:
                    System.out.print("Entrez le nouveau label pour ce document : ");
                    String newLabel = scanner.nextLine();
                    doc.setLabel(newLabel);
                    System.out.println("Etiquette du document modifiée avec succès.");
                default:
                    System.out.println("Saisissez un numéro existant: ");
            }
        }
    }
}
