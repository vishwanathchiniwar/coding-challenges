# Backend Coding Challenge: Authentication

## Description:

This Spring Boot project consists of one microservice, which is responsible for the access system of the company you now work for. The original developer never implemented any security features. The access to the network and therefore also the access system was handled elsewhere, so there was no need for a security implementation. In the course of a recent network structure change this requirement changed

In the current version of the service, as long as one has access to the network, they access all doors in the building and even unlock them if they wanted to. The service can be accessed through its REST API and then read from and written to. This poses a security threat and cannot be ignored

Your first project as new developer in the company will be to implement a security system for both existing endpoints in the service.

## Acceptance Criteria:

### (Junior) Consultant:

1. Both endpoints need to be secured with OAuth2
2. OAuth2 can be implemented with either Spring or Keycloak
3. OAuth2 should be implemented with a local authorization server

### Senior Consultant and above:

1. Both endpoints need to be secured with MTLS
2. MTLS can be implemented with either Spring, nginx or apache
3. Used certificates can either be self signed or valid ones for example from Let's encrypt
4. The backend/rest controller should validate the sent certificates

## General Conditions:
- The structure of the microservice at hand follows the Hexagonal-Architecture (aka. Clean Architecture - [https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)). Incorporate your implementation into the existing application architecture
- Additional dependencies can be added if needed, as well as external software like docker
- The included tests will only be successful when both endpoints return an HTTP 403
- You should complete this coding challenge within `3` days. Please keep this guidance in mind and submit your (partial) result upon expiration of this time frame
- If you draw up any notes or sketches during your implementation, please hand them in together with your solution

## Bonus Tasks (everyone):

- Write additional integration tests for your security implementation
- Secure both API endpoints with different credentials/roles/certificates

---

## Beschreibung:

Der ursprüngliche Entwickler hatte damals nie Sicherheitsmechanismen eingebaut. Der Zugang zum Netzwerk und damit auch zum Zugangssystem der Türen würde an anderer Stelle geregelt, was eine Sicherheitsimplementierung bisher überflüssig machte. Im Zuge einer kürzlichen Umstrukturierung des Netzwerk, hat sich diese Anforderung jedoch geändert

Zugriff auf die aktuelle Version des Services hat jeder, der Zugang zum Netzwerk hat. Dieser Zugang lässt einen sämtliche Türen abrufen und diese sogar entriegeln. Der Service ist nach außen durch eine REST API erreichbar und kann über diese ausgelesen und verändert werden. Dies stellt ein Sicherheitsrisiko dar und darf nicht ignoriert werden

Dein erstes Projekt als neuer Entwickler im Unternehmen wird es sein, beide Endpunkte des Services zu sichern

## Akzeptanzkriterien:

### (Junior) Consultant:

1. Beide API Endpunkte sollen durch OAuth2 gesichert weren
2. OAuth2 kann entweder mit Spring oder Keycloak realisiert werden
3. OAuth2 soll mit einem lokalen Autorisierungsserver realisiert werden

### Senior Consultant und höher:

1. Beide API Endpunkte sollen durch MTLS gesichert weren
2. MTLs kann mit Spring, nginx oder apache realisiert werden
3. Die verwendeten Zertifikate können selbst signiert oder valide sein (z.B. von let's encrypt)
4. Das Backend/Rest Controller soll die gesendeten Zertifikate auf Validität prüfen

## Rahmenbedingungen:
- Die Struktur des vorliegenden Microservices folgt der Hexagonalen-Architektur (aka. Clean Architecture - [https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)). Halte dich bei deiner Implementierung an die bestehende Anwendungsarchitektur
- Zusätzlich Abhängigkeiten dürfen hinzugefügt werden, dies gilt auch für externe Software wie docker
- Die mitgelieferten Tests sind nur dann erfolgreich, wenn beide Endpunkte einen HTTP 403 zurückgeben. 
- Für diese Coding Challenge haben wir `3` Tage eingeplant. Bitte richte dich bei deiner Umsetzung nach diesem Richtwert und reiche dein (Teil-)Ergebnis nach Ablauf dieser Arbeitszeit ein
- Solltest du während der Bearbeitung Zeichnungen oder Notizen anfertigen, reiche diese zusammen mit deiner Lösungen ein

## Bonusaufgaben (alle):

- Schreibe zusätzlich Integration Tests für deine Sicherheitsimplementierung
- Sichere beide API Endpunkte durch unterschiedliche Zugangsdaten/Rollen/Zertifikate
