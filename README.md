# Java Car Rental System

A desktop car rental management app built with Java Swing. Lets an admin manage a vehicle inventory (add, edit, delete, view) and handles customer rentals and payments, backed by a MySQL database.

## Tech Stack

- Java (Swing for GUI)
- MySQL (via JDBC)

## Project Structure

```
src/com/example/carrental/
├── Main.java              # entry point
├── MainGUI.java           # main window
├── AddVehicleGUI.java
├── EditVehicleGUI.java
├── DeleteVehicleGUI.java
├── ViewVehiclesGUI.java
├── DatabaseConnector.java # JDBC connection + queries
├── Vehicle.java / Car.java
├── Customer.java
├── Rental.java / RentalActions.java
```

Supporting files:
- `UML.drawio`, `Class Diagram (Unconfirmed.drawio` — design diagrams
- `PROJECT PLAN.txt` — original feature/DB plan
- `Mini project deliverable - Template.docx` — assignment template
- `src.zip` — zipped copy of the source

## Running It

1. Set up a MySQL database named `car_rental_db`.
2. Update the credentials in `DatabaseConnector.java` (currently hardcoded to `root` / `password` on `localhost:3306` — change before running anywhere else).
3. Compile and run `Main.java` (e.g. via an IDE, or `javac`/`java` from the `src` folder).

## Notes

- Compiled `.class` files are checked into `src/`. Consider adding a `.gitignore` for `*.class` if this goes back into version control.
- DB credentials are hardcoded — fine for a class project, not for anything beyond that.
