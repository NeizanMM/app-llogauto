# Diagrama UML - A5.3 Herència
# LlogaAuto S.L.

## Diagrama complet (Mermaid)

```mermaid
classDiagram
    class Automobil {
        <<abstract>>
        -String marca
        -String model
        -String matricula
        -TipusCombustible combustible
        -int comptador$
        +Automobil(marca, model, matricula, combustible)
        +Automobil()
        +getMarca() String
        +setMarca(marca String) void
        +getModel() String
        +setModel(model String) void
        +getMatricula() String
        +setMatricula(matricula String) void
        +getCombustible() TipusCombustible
        +setCombustible(c TipusCombustible) void
        +mostrarDades() String
        +getComptador()$ int
        +validarMatricula(matricula String)$ boolean
    }

    class Cotxe {
        -int numPortes
        +Cotxe(marca, model, matricula, combustible, numPortes)
        +Cotxe()
        +getNumPortes() int
        +setNumPortes(numPortes int) void
        +mostrarDades() String
    }

    class Camio {
        -Float tara
        -Float pesMaxim
        +Camio(marca, model, matricula, combustible, tara, pesMaxim)
        +Camio()
        +getTara() float
        +setTara(tara Float) void
        +getPesMaxim() float
        +setPesMaxim(pesMaxim Float) void
        +mostrarDades() String
    }

    class TipusCombustible {
        <<enumeration>>
        BENZINA_95
        BENZINA_98
        DIESEL
        ELECTRIC
        HIBRID
        -double preuPerUnitat
        +getPreu() double
    }

    class GestorAutomobils {
        -Automobil[] llistaCotxes
        -int numAutos
        +GestorAutomobils(capacitat int)
        +afegirAutomobil(posicio int, auto Automobil) void
        +llistarAutomobils() void
        +getNumAutos() int
    }

    Automobil <|-- Cotxe : herència
    Automobil <|-- Camio : herència
    Automobil --> TipusCombustible : associació
    GestorAutomobils "1" o-- "0..*" Automobil : conté
```

---

## Comandes Git - A5.3

```bash
# Partir de la branca activitat_5_2
git switch activitat_5_2

# Crear i canviar a la nova branca
git branch activitat_5_3
git switch activitat_5_3

# Fer els canvis (nous fitxers: TipusCombustible, Cotxe, Camio)
# Modificar: Automobil (abstract), GestorAutomobils, Main

git add .
git commit -m "feat: A5.3 - herencia Cotxe i Camio, abstract Automobil, enum TipusCombustible"
git push origin activitat_5_3

# Merge a main
git switch main
git merge activitat_5_3
git push origin main
```
