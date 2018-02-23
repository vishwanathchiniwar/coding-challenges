<center>
  <h1>
    <span style="font-size: 4rem;">👨🏼‍💻</span>
    <br/>
    <span>Mobile-App Coding Challenge</span>
  </h1>
</center>

## Aufgabe

Erstelle eine Mobile-Application. Die App soll einem Benutzer alle Häuser aus Game of Thrones in einer Liste anzeigen.

Es soll möglich sein eines dieser Häuser aus der Tabelle auszuwählen. Durch Klick auf einen Button soll das ausgewählte Haus als Inhalt eines Tweets getwittert werden.

### Tooling, APIs und Docs
*Hierzu stehen dir folgende Hilfsmittel zur verfügung:*
* [Game Of Thrones API](https://anapioficeandfire.com)
* IFTTT Endpoint: https://maker.ifttt.com/trigger/mhp_challenge/with/key/mgLArA5BWrsgm39Yn8FWoVnrezDadQQcCsMixn34AS7
*Dieser kann mit drei Übergabeparametern getriggert werden:*
```json
{
  "value1": "",
  "value2": "",
  "value3": ""
}
```

Der Inhalt dieser Paramter wird von [@1ChallengeBot](https://twitter.com/1ChallengeBot) getwittert.


## Anforderungen

- Erstelle eine native App
  - Android
    - Code in Kotlin
    - Min. API Level 21
    - Verwendung von RecyclerView
    - Nutzung externer Libraries vermeiden
  - iOS
   -
   - 
- Benutze eine Versionsverwaltung (GitHub, Bitbucket) über die du uns das Projekt zur Verfügung stellst.
