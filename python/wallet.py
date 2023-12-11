from categories import display_categories, check_balance, add_money, throw_back_money, throw_back_money, add_category, throw_back_category, modify_category
from docs import add_type, display_types, display_docs, add_doc, remove_doc, display_doc_details, modify_doc

def wallet():
    quit_option = 15
    while True:
        print('''
        ===================================WALLET=====================================
                            SUIVI DE SOLDE
                                1. consulter votre solde
                            GESTION DE DEPENSE
                                2. Ajouter de l'argent
                                3. Retirer de l'argent
                            PLANIFICATION BUDGETAIRE
                                4. Voir toutes les catégories
                                5. Ajouter une nouvelle catégorie
                                6. Supprimer une catégorie
                                7. Modifier une catégorie
                            GESTION DE DOCUMENTS
                                8. Voir tous les types
                                9. Voir tous les documents
                                10. Ajouter un type de document
                                11. Voir les détails sur un document
                                12. Ajouter un document
                                13. Retirer un document
                                14. Modifier un document
                                15. QUITTER
        ===============================================================================''')

        choice = int(input(f"Que souhaitez-vous faire? (réponse : un nombre de 1 à {quit_option}) : "))

        if choice == 1:
            check_balance()
        elif choice == 2:
            add_money()
        elif choice == 3:
            throw_back_money()
        elif choice == 4:
            display_categories()
        elif choice == 5:
            add_category()
        elif choice == 6:
            remove_category()
        elif choice == 7:
            modify_category()
        elif choice == 8:
            display_types()
        elif choice == 9:
            display_docs()
        elif choice == 10:
            add_type()
        elif choice == 11:
            display_doc_details()
        elif choice == 12:
            add_document()
        elif choice == 13:
            remove_doc()
        elif choice == 14:
            modify_doc()
        elif choice == quit_option:
            return
        else:
            print(f"Veuillez choisir un nombre entre 1 et {quit_option}.")

if __name__ == "__main__":
    wallet()