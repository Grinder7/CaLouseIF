<p align="center"><img src="https://github.com/Grinder7/CaLouseIF/blob/main/src/resources/images/logo.png?raw=true" alt="drawing" width="400"/></p>

# CalouseIF

CaLouselF is a marketplace application specifically designed to facilitate the buying and selling of second-hand clothing easily and safely.

This project is for final Project of COMP6115001 Object Oriented Analysis & Design Laboratory.

## Authors

- [@Iyaiyak](https://github.com/Iyaiyak) 2602163336 - Davin Nayaka Pandya
- [@Grinder7](https://github.com/Grinder7) 2602085883 - Calvin Farrellino Kurniawan
- [@kudanilbau](https://github.com/kudanilbau) 2602076140 - Renata Elisse Agneslita
- [@dySrdh](https://github.com/dySrdh) 2602062236 - Doddy Suryadharma

## Library

- [JavaFX 17.0.7](https://gluonhq.com/products/javafx/)
- [MySQL Connector 8.0.24](https://dev.mysql.com/downloads/connector/j/)

## Run Locally

1. Clone the project
   ```
     git clone https://github.com/Grinder7/CaLouseIF
   ```
2. Import project into Eclipse Java IDE
   Open the project in eclipse and configure build path to make sure the JavaFX and MySQLConnector library is properly added. If not, add the libraries into Modulepath.

3. Prepare database
   Make a migration by importing Migration in src/resources/SQL into MySQL Database. If you want to include example data you can use the MigrationSeeder. Put the database credentials in src/repository/DatabaseConnector

4. Run project
   Open src/main/Main and press Ctrl+F11 or the Run button
