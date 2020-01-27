# Backend Coding Challenge: E-Mail Retry

## Beschreibung:

Dieses Spring-Boot-Projekt beinhaltet den relevanten Teil eines Microservices (Notification Service), der für den Versand von Benachrichtigungen über verschiedene Kommunikationskanäle (E-Mail, SMS, Push Notification) zuständig ist. Der `EmailController` stellt eine HTTP Schnittstelle zur Verfügung, über die sich ein neuer Auftrag per E-Mail versenden lässt.

In der aktuellen Ausbaustufe wird der E-Mail Versand bereits asynchron ausgeführt. Als Antwort auf den HTTP Request erhält der Benutzer der Schnittstelle somit unmittelbar einen Status `200 OK` und die E-Mail wird dem Empfänger daraufhin zugestellt. Tritt während der Zustellung ein Fehler auf (z. B. der SMTP Server hat eine Störung und antwortet nicht) wird der Benutzer **nicht** informiert und der Auftrag wird **nicht** übermittelt. 

Über die letzten Wochen sind vermehrt Beschwerden über nicht zugestellt E-Mails beim Support Team eingegangen. Die Ursache ließ sich auf Ausfälle des SMTP Servers zurückführen. 

Deine erste Aufgabe als neuer Entwickler im Notifications Team ist deshalb die Implementierung eines Retry-Mechanismus für den E-Mail Versand. So sollen die Nachrichten zukünftig auch im Falle einer kurzzeitigen Störung der externen Systeme erfolgreich an den Empfänger übermittelt werden.

## Akzeptanzkriterien

1. Pro E-Mail muss es genau 5 Retrys geben. Der erste Retry muss nach 5 Sekunden erfolgen und darauffolgende Versuche müssen in exponentiellem Abstand voneinander ausgeführt werden.
2. Bei einem Neustart des Notification Services während ein oder mehrere Retrys ausgeführt werden, muss der Retry nach dem Neustart der Anwendung an der Stelle fortgesetzt werden an der er unterbrochen wurde (z. B.: 2 Retrys erfolgreich ausgeführt → Crash Notification Service → Neustart Notification Service → Ausführung der verbleibenden 3 Retrys).
3. Der implementierte Retry-Mechanismus muss für ein hochverfügbares Setup des Notification Service (d. h. mit mehreren parallel ausgeführten Instanzen) entwickelt werden. (Beachte diesen Umstand bei deinen Architekturentscheidungen)

## Rahmenbedingungen:

- Im Hauptverzeichnis des Projekts liegt eine `docker-compose.yml`. Mit dem Befehl `docker-compose up` lässt sich die benötigte Infrastruktur für die Challenge in Docker starten. 
Dabei werden folgende Dienste bereitgestellt:
    - MongoDB (NoSQL Datenbank): `[http://localhost:27017](http://localhost:27017)`
    - Mailhog (Mail Server Mock): `[http://localhost:1025](http://localhost:1025)` (SMTP Server), `[http://localhost:8025](http://localhost:8025)` (Web UI - Inbox)

    Zur erfolgreichen Fertigstellung der Challenge dürfen ausschließlich die aufgelisteten Dienste verwendet werden. Die Verwendung dieser Dienste ist nicht verpflichtend aber es dürfen keine zusätzlichen Anwendungen eingesetzt werden.

- Standardmäßig ist der Mail Server Mock (Mailhog) so konfiguriert, dass nur 50% der E-Mails erfolgreich verarbeitet werden. Dieses Verhalten lässt sich über die `docker-compose.yml` anpassen oder komplett deaktivieren.
- Für diese Coding Challenge haben wir `X` Tage eingeplant. Bitte richte dich bei deiner Umsetzung nach diesem Richtwert und reiche dein (Teil-)Ergebnis nach Ablauf dieser Arbeitszeit ein.
- Solltest du während der Bearbeitung Zeichnungen oder Notizen anfertigen, reiche diese zusammen mit deiner Lösungen ein.

## Bonus Aufgaben:

1. Schreibe Unit- und Integrationstests für deinen implementierten Retry-Mechanismus
