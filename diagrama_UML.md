# Diagrama UML - Classe Automobil
# LlogaAuto S.L. - Mòdul 5 A5.1

```mermaid
classDiagram
    class Automobil {
        +String marca
        +String model
        +String matricula
        +Automobil(marca String, model String, matricula String)
        +mostrarDades() String
        +validarMatricula(matricula String)$ boolean
    }

    note for Automobil "Les funcions subratllades ($) són static"
```

---

## Diagrama d'objectes (3 instàncies)

```mermaid
classDiagram
    class auto1 {
        <<Automobil>>
        marca = "Toyota"
        model = "Corolla"
        matricula = "1234LMN"
    }

    class auto2 {
        <<Automobil>>
        marca = "Ford"
        model = "Focus"
        matricula = "5678BCD"
    }

    class auto3 {
        <<Automobil>>
        marca = "Seat"
        model = "Ibiza"
        matricula = "9012FGH"
    }
```

---

## Explicació del format de matrícula espanyola

| Posició | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
|---------|-----|-----|-----|-----|-----|-----|-----|
| Tipus   | Nº  | Nº  | Nº  | Nº  | Ll. | Ll. | Ll. |
| Exemple | 1   | 2   | 3   | 4   | L   | M   | N   |

- **4 primers**: dígits numèrics (0-9)
- **3 últims**: consonants (sense A, E, I, O, U, Ñ, Q)
