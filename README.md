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
