categories = [
    {"balance": 0, "name": "Principale"}
]

def display_categories():
    for index, category in enumerate(categories, start=1):
        print(f"       {index}. {category['name']}")

def check_balance():
    display_categories()
    category_index = int(input("Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : "))
    print(f"La solde de la catégorie {categories[category_index - 1]['name']} est {categories[category_index - 1]['balance']} Ariary")

def add_money():
    display_categories()
    category_index = int(input("A quelle catégorie allez-vous ajouter de l'argent? (réponse: un nombre) : "))
    if 0 < category_index <= len(categories):
        value = float(input("Saisissez la valeur à ajouter : "))
        categories[category_index - 1]['balance'] += value
        print('Argent ajoutée avec succès.')
    else:
        print("La catégorie n'existe pas")

def throw_back_money():
    display_categories()
    category_index = int(input("A quelle catégorie allez-vous retirer de l'argent? (réponse: un nombre) : "))
    if 0 < category_index <= len(categories):
        value = float(input("Saisissez la valeur à retirer : "))
        categories[category_index - 1]['balance'] -= value
        print('Argent retirée avec succès.')
    else:
        print("La catégorie n'existe pas")

def add_category():
    new_category_name = input('Veuillez saisir le nom de la catégorie : ')
    categories.append({"balance": 0, "name": new_category_name})
    print('Catégorie ajoutée avec succès.')

def throw_back_category():
    display_categories()
    category_index = int(input('Quelle catégorie allez-vous supprimmer? (réponse : un nombre) : '))
    if 0 < category_index <= len(categories):
        categories.pop(category_index - 1)
        print('Catégorie retirée avec succès.')
    else:
        print("La catégorie n'existe pas")

def modify_category():
    display_categories()
    category_index = int(input('Quelle catégorie souhaitez-vous modifier ? (Entrez un numéro) : '))

    if 0 < category_index <= len(categories):
        attribute_choice = input('Souhaitez-vous modifier le nom (tapez "nom") ou le montant (tapez "montant") de cette catégorie ? : ')

        if attribute_choice.lower() == 'nom':
            new_name = input('Entrez le nouveau nom pour cette catégorie : ')
            categories[category_index - 1]['name'] = new_name
            print('Nom de catégorie modifié avec succès.')
        elif attribute_choice.lower() == 'montant':
            new_amount = float(input('Entrez le nouvel montant pour cette catégorie : '))

            if not new_amount.is_nan():
                categories[category_index - 1]['balance'] = new_amount
                print('Montant de catégorie modifié avec succès.')
            else:
                print('Montant invalide.')
        else:
            print('Choix invalide.')
    else:
        print('La catégorie n\'existe pas')
