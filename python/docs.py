from uuid import uuid4

types = []
docs = []

def add_type():
    name = input('Saisissez le nom de votre type: ')
    is_unique = input("Voulez-vous que ce type de document ne peut supporter qu'un seul exemplaire? (O/N) : ")
    is_unique = True if is_unique == 'O' else False

    types.append({
        'id': uuid4(),
        'name': name,
        'isUnique': is_unique
    })
    print('Type créé avec succès.')

def display_types():
    if not types:
        print('Pas encore de type')
    else:
        for index, type_item in enumerate(types, start=1):
            print(f'   {index}-{type_item["name"]}')

def display_docs():
    if not docs:
        print("Pas encore de document")
    else:
        for index, doc in enumerate(docs, start=1):
            print(f'{index}-{doc["label"]}')

def add_doc():
    if not types:
        print("Créez d'abord un type.")
    else:
        label = input("Une étiquette pour votre document : ")
        description = input("Une petite description pour votre document : ")
        display_types()
        type_index = int(input("Quel sera le type de votre document? (réponse un nombre) : ")) - 1

        if 0 <= type_index < len(types):
            docs.append({
                'id': uuid4(),
                'label': label,
                'description': description,
                'typeId': types[type_index]['id']
            })

def remove_doc():
    display_docs()
    doc_index = int(input("Quel document souhaitez-vous supprimer? (réponse un nombre) : ")) - 1
    if 0 <= doc_index < len(docs):
        docs.pop(doc_index)
        print('Document supprimé avec succès.')
    else:
        print("Le document n'existe pas.")

def display_doc_details():
    display_docs()
    doc_index = int(input("Sur quel document souhaitez-vous connaitre plus de détail? (réponse un nombre) : ")) - 1

    if 0 <= doc_index < len(docs):
        doc = docs[doc_index]
        type_item = next((t for t in types if t['id'] == doc['typeId']), None)
        if type_item:
            print(f"Voici les détails sur ce document :\n"
                  f"- étiquette : {doc['label']}\n"
                  f"- description: {doc['description']}\n"
                  f"- type: {type_item['name']}")
        else:
            print("Type de document non trouvé.")
    else:
        print("Le document n'existe pas.")

def modify_doc():
    display_docs()
    doc_index = int(input("Quel document souhaitez-vous modifier? (réponse un nombre) : ")) - 1

    if 0 <= doc_index < len(docs):
        doc = docs[doc_index]
        print(f"Que souhaitez-vous modifier pour le document \"{doc['label']}\"?")
        print("1. Type\n2. Description\n3. Label")
        attribute_to_modify = int(input("Entrez le numéro correspondant : "))

        if attribute_to_modify == 1:
            display_types()
            type_index = int(input("Quel sera le nouveau type pour ce document? (réponse un nombre) : ")) - 1
            if 0 <= type_index < len(types):
                doc['typeId'] = types[type_index]['id']
                print('Type de document modifié avec succès.')
            else:
                print('Type de document invalide.')
        elif attribute_to_modify == 2:
            new_description = input("Entrez la nouvelle description pour ce document : ")
            doc['description'] = new_description
            print('Description du document modifiée avec succès.')
        elif attribute_to_modify == 3:
            new_label = input("Entrez le nouveau label pour ce document : ")
            doc['label'] = new_label
            print('Label du document modifié avec succès.')
        else:
            print('Choix invalide.')
    else:
        print("Le document n'existe pas.")