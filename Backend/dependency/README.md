# Backend Coding Challenge: Module Dependency Challenge

### Projektaufbau:
Dieses Spring-Boot-Projekt besteht aus einem Hauptmodul und zwei Submodulen ("inquiry" und "notification"). 
Das "notifications"-Modul ist vom "inquiry"-Modul abhängig.

Der `InquiryTest` ruft `InquiryService#create(Inquiry)` auf und prüft, ob die Methoden `EmailHandler#sendEmail(Inquiry)`
und `PushNotificationHandler#sendNotification` mit dem gleichen Parameter aufgerufen wurden.

### Akzeptanzkritieren: 
 - Der `InquiryTest` muss erfolgreich sein
 
### Rahmenbedingungen:
 - Die Klassen `Inquiry`, `InquiryTest` und `Application` dürfen nicht modifiziert werden.
 - Die bestehenden Klassen dürfen nicht zwischen den Modulen verschoben werden
 - Die Abhängigkeiten zwischen den Modulen dürfen nicht angepasst werden.
 - Ansonsten können beliebige gradle dependencies hinzugefügt werden. 
 
