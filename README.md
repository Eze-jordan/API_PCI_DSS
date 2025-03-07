# Standard PCI DSS - API de gestion des transactions monétiques

## Description
Ce projet est une API REST de gestion des transactions monétiques conforme au standard **PCI DSS**. L'objectif est de stocker les informations sensibles (PAN, date d'expiration, CVX) de manière chiffrée et de les afficher en clair sur l'interface utilisateur.

## Technologies utilisées
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** (Hibernate, MySQL)
- **Spring Security** (JWT, Authentification)
- **Springdoc OpenAPI** (Swagger UI)
- **Jasypt** (Chiffrement des données sensibles)
- **Docker** (optionnel pour le déploiement)

## Installation et exécution

### 1. Cloner le projet
```sh
git clone https://github.com/ton-repo/standard-pci-dss.git
cd standard-pci-dss
```

### 2. Configurer la base de données
Assurez-vous d'avoir une base **MySQL** en place et configurez **`application.properties`** :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pci_dss_db
spring.datasource.username=root
spring.datasource.password=mot_de_passe
spring.jpa.hibernate.ddl-auto=update
```

### 3. Générer une clé de chiffrement AES-256
Exécutez la classe `KeyGeneratorUtil` pour obtenir une clé que vous placerez dans `application.properties` :
```properties
app.encryption.secret-key=VOTRE_CLE_AES_256
```

### 4. Lancer l'application
```sh
mvn spring-boot:run
```
L'API sera accessible sur **`http://localhost:8080`**.

## Documentation API (Swagger UI)
Une documentation interactive est disponible à l'adresse suivante :
👉 **[Swagger UI](http://localhost:8080/swagger-ui.html)**

## Routes Principales
| Méthode | URL | Description |
|----------|------------------|---------------------------|
| **POST** | `/transactions` | Créer une nouvelle transaction |
| **GET**  | `/transactions` | Récupérer toutes les transactions |

Exemple de requête **POST** en JSON :
```json
{
  "dateTransaction": "2025-02-01",
  "heureTransaction": "10:00:45",
  "origine": "GA",
  "moyenPaiement": "CB",
  "numPan": "497993XXXXXX1232",
  "dateFinValidite": "27/05",
  "cvx": "010",
  "montant": 1500.00,
  "devise": "EUR",
  "identifiantBanqueAcquereur": "BANK001",
  "identifiantBanqueEmetteur": "BANK002",
  "scheme": "VISA",
  "typeProduit": "Carte Bleue"
}
```

## Sécurité & Conformité PCI DSS
- **Chiffrement des données sensibles** avant stockage (AES-256)
- **Masquage des numéros de carte bancaire** à l'affichage (ex: `4979 93XX XXXX 1232`)
- **Authentification et autorisation** via JWT (optionnel)

## Auteur
👤 **Jordan**

---

🚀 **N'hésite pas à contribuer et à proposer des améliorations !**
