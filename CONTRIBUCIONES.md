# Guia de Contribuciones
Hay que tratar de seguir estas guias para el desarrollo del proyecto
### Formato
Formatear el codigo en netbeans con `Alt + Shift + F`
### Comentarios
Al principio del proyecto no es tan importante ya que todo va sufrir muchos cambios. Cuando hayan partes del codigo que no cambien hay que documentarlos siguiendo este ejemplo
```java
/**
     * @param field - field to get the display version for
     * @return A version of the field name more suitable for display
     */
    public static String getDisplayName(String field) {
        String lowercaseField = field.toLowerCase(Locale.ROOT);

        if (DISPLAY_NAMES.containsKey(lowercaseField)) {
            return DISPLAY_NAMES.get(lowercaseField);
        }
        return StringUtil.capitalizeFirst(field);
}
```
Los comentarios no deben ser redundantes como 
```java
//incrementar contador
contador++;
```
### Testing
**Todas** las clases deben tener su propio *Unit Test*. Para crearlo hay que colocar el cursor encima del nombre de la clase y presionar `Alt + Enter` y elegir *Junit*
### Commits
Hacer commits cuando se tenga un avance considerable que tenga sentido registrar en el historial. Recomiendo tratar de seguir esta [guia](https://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html)
### Fetch
Recuerden hacer fetch para ver los cambios que los demas han hecho
### Libro de Git
Pueden descargar el libro oficial de git [aqui](https://git-scm.com/book/en/v2). Para familiarizarse rapidamente con git es recomendado leer
* Getting started
    * A partir de *Git Basics*
* Git basics
    * Desde *Getting a git repository* hasta *Working with remotes*
* Git branching
    * Todo el capitulo
* Distributed git
    * Distributed workflows
