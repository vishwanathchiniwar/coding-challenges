# Backend Coding Challenge: Mapping Challenge

Akzeptanzkritieren: 
 - `Article` wird korrekt zu `ArticleDTO` gemapped (Siehe `ArticleController#list`)
 - `ArticleDTO` wird korrekt zu `Article` gemapped (Siehe `ArticleController#create`)
 - Die Collection von `ArticleBlockDto` in `ArticleDTO` ist nach dem `sortIndex` in `ArticleBlockDTO` sortiert
 - Falls ein `Article` per ID nicht gefunden werden kann, soll eine 404 Repsonse ausgeliefert werden
 - Optional: Falls eine neue Implementierung/Ableitung von `ArticleBlock` implementiert wird und noch kein Mapping implementiert sein,
   soll mann darauf hingewiesen werden. Wie ist frei überlassen.
 
Rahmenbedingungen:
 - DB Models und DTO Models können mit Informantionen/Properties erweitert werden.
 - Bestehende Felder von Models und DTOs können nicht modifiziert werden. 
 - Die Packagestruktur darf nicht modifiziert werden. 
 
