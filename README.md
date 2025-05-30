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

