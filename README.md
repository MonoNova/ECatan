# ECatan
Het bordspel van Catan gedaan in Java doormiddel van Swing. Door de boys van Groep E.

## Getting Started

Deze instructies laten coding conventions en andere regels zien. Houdt jezelf aan deze regels zodat iedereen elkaars code kan blijven lezen.

### Code style
Klasnamen altijd met hoofdletter.
```Java
public class DezeMooiClass{

}
```

Variabelen en functies altijd met camelcase.
```Java
private int whatCounter = 0;

public void sayWhaaaat(){
    whatCounter += 1;
}
```

Constanten altijd in allcaps en underscores.
```Java
private final int MAX_POTATOES = 500;
```

Enums zijn ook altijd in allcaps, alleen geen underscores. De naam van de enum is met hoofdletter.
```Java
private enum Status{
    GOOD,
    BAD,
    GOODGOODNOTBAD
}
```

Getters en Setters moeten altijd beginnen met "get" en "set", respectievelijk.
```Java
public int getPosX(){
    return posX;
}

public void setPosX(int posX){
    this.posX = posX;
}
```
