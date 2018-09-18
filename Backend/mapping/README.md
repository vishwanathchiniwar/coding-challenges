# Backend Coding Challenge: Mapping Challenge

Akzeptanzkritieren: 
 - `Article` wird korrekt zu `ArticleDTO` gemapped (Siehe `ArticleController#list` und `ArticleController#details`) und als JSON von den Controllern ausgegeben. 
 - Die Collection von `ArticleBlockDto` in `ArticleDTO` ist nach dem `sortIndex` in `ArticleBlockDTO` sortiert
 - Falls ein `Article` per ID nicht gefunden werden kann, soll eine 404 Repsonse ausgeliefert werden (Siehe `ArticleController#details`)
 - Optional: Falls eine neue Implementierung/Ableitung von `ArticleBlock` implementiert wird und noch kein Mapping implementiert ist,
   soll mann darauf hingewiesen werden. Wie ist frei überlassen.
 
Rahmenbedingungen:
 - DB Models und DTO Models können mit Interfaces/Properties erweitert werden.
 - Bestehende Felder von Models und DTOs können nicht modifiziert werden. 
 - Die Packagestruktur darf nicht modifiziert werden. 
 - Es können beliebig gradle dependencies hinzugefügt werden. 
