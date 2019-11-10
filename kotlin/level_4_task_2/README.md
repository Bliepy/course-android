# Android APP Development - Level 4 Questions

## A singleton pattern is used in the class that defines the database. What is the purpose of this pattern?

The singleton is used to have a single database connection class,
that is only instantiated once.

## Why should you load the data in a background thread?

If you don't  use a separate threat the UI will frees and the application will crash .

## What are the three major components of ROOM and what are their responsibilities?

### Database
It represents the DB, it is an object that holds a connection to the SQLite DB and all the operations are executed through it. It is annotated with @Database.

### Entity
Represents a table within the Room Database. It should be annotated with @Entity.

### DAO
An interface that contains the methods to access the Database. It is annotated with @Dao.

### info
- https://medium.com/mindorks/room-kotlin-android-architecture-components-71cad5a1bb35

## How can you extract the current database so that you can see the table, columns, and data?

### On virtual android device

- View > Tool Windows > Device File Explorer
- data/data/<app_package_name>/database.db
- Open whit SQLite viewer

### info
- https://developer.android.com/studio/debug/device-file-explorer
