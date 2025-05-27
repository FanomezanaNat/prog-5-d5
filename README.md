# Machine à Café

## Description

Ce projet simule le fonctionnement d'une machine à café automatique.  
L'utilisateur peut insérer des jetons, choisir un café avec des options personnalisées (sucre, lait, topping) et recevoir son café si toutes les conditions sont remplies.  
Le système gère également les erreurs courantes comme les pannes de courant, l'absence d'eau ou un café non disponible.

---

## Cas d'utilisation

### 1. Payer

- L'utilisateur insère des jetons dans la machine.
- La machine vérifie que le nombre de jetons est suffisant avant toute opération.

### 2. Choisir un café

- L'utilisateur sélectionne un café parmi une liste disponible.
- Il peut ajouter les options suivantes :
    - Avec ou sans sucre
    - Avec ou sans lait
    - Un topping (exemple : crème ou mousse)
- La machine valide la sélection et les conditions suivantes :
    - Le café est disponible
    - Il y a de l'eau
    - Il n'y a pas de coupure de courant

### 3. Recevoir le café

- Si toutes les conditions sont remplies, la machine prépare le café et le délivre.

---

## Règles métier

- Un café standard coûte un nombre fixe de jetons (exemple : 3 jetons).
- Chaque topping ajouté augmente le coût (exemple : +1 jeton par topping).
- L'utilisateur doit insérer suffisamment de jetons avant de pouvoir commander.
- La machine ne peut pas fonctionner dans les cas suivants :
    - Jetons insuffisants
    - Café non disponible
    - Panne d'eau
    - Coupure de courant

---

## Erreurs possibles

| Code d'erreur        | Description                                      |
|----------------------|--------------------------------------------------|
| `TokenExcepton `     | L'utilisateur n'a pas inséré assez de jetons     |
| `CoffeeNotFound `    | Le café sélectionné n'est pas disponible         |
| `NoWaterException `  | Il n'y a pas suffisamment d'eau dans la machine  |
| `BlackoutException ` | La machine est hors tension (coupure de courant) |

---
# PROG5 Coffee Machine

Ce projet modélise une interaction utilisateur avec une machine à café automatique en Java.

---

## Use Case

Le système est destiné à des environnements semi-publics comme bureaux ou universités.  
L’utilisateur insère des jetons prépayés pour commander des cafés avec options (sucre, lait, topping).  
La machine vérifie l’état (eau, alimentation) et gère les erreurs courantes (panne, jetons insuffisants).

---

## Modèles

### CoffeeMachine

**Propriétés :**

- `jetons` : nombre de jetons insérés (int)
- `hasWater` : indique la présence d’eau (booléen)
- `isPowered` : indique si la machine est alimentée (booléen)

**Méthodes :**

- `insertJetons(int amount)`  
  Ajoute un nombre donné de jetons.

- `isReady() : boolean`  
  Vérifie que la machine est alimentée et qu’elle contient de l’eau.

- `makeCoffee(String typeName, boolean milk, boolean sugar, String topping) : Coffee`  
  Prépare un café selon le type et options, vérifie la disponibilité et les jetons, lance une exception si problème.

- `powerOff()`  
  Coupe l’alimentation.

- `emptyWater()`  
  Vide le réservoir d’eau.

- `reset()`  
  Remet la machine en état normal.

---

### Coffee

**Propriétés :**

- `type` : type de café (enum `CoffeeType`)
- `milk` : ajout de lait (booléen)
- `sugar` : ajout de sucre (booléen)
- `topping` : topping ajouté (String, optionnel)

**Méthodes :**

- `getPrice() : int`  
  Calcule le prix du café (tarif de base + topping).

- `getName() : String`  
  Retourne le nom du café avec options.

---

### CoffeeType (enum)

- `ESPRESSO`
- `LATTE`
- `CAPPUCCINO`
- *(autres types selon besoin)*

---

### Exceptions personnalisées

- `MachineNotReadyException` : lancée si la machine n’est pas prête (panne, pas d’eau, coupure).
- `TokenException` : jetons insuffisants.
- `CoffeeNotFoundException` : café non disponible.

---

## Exemple de scénario d’utilisation

1. L’utilisateur insère des jetons via `insertJetons(5)`.

2. La machine vérifie avec `isReady()` si elle peut préparer un café.

3. L’utilisateur choisit un café et options, puis appelle `makeCoffee("latte", true, false, "mousse")`.

4. La machine vérifie les erreurs, déduit les jetons et retourne l’objet `Coffee`.

5. L’utilisateur reçoit son café.

---

