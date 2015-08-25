# book-library-saga

This is an exercise of Domain Driven Design and Spring Boot techniques. 

The program manages books and readers of a library. Each reader can borrow up to three books, and one book can only be borrowed by one reader a time. When a book has been borrowed five times, it is marked as a 'hot' book. The admin can register new books and new readers. The admin can check who is holding a book and what books a reader has currently borrowed.

This application uses:

- Domain Driven Design
- CQRS
- Event Sourcing
- Spring Boot
- Axon Framework
- RESTful service

# Build

$ mvn package

# Start service

net start MongoDB

java -jar target/library-0.1.0.jar

# Tests

## Register Library
curl -X POST -d '{"name":"Bantian District Library"}' -H "Content-Type:application/json" http://localhost:8080/api/libraries

## Register readers
curl -X POST -d '{"name":"John Smith"}' -H "Content-Type:application/json" http://localhost:8080/api/libraries/{libraryId}/readers


## Register books
curl -X POST -d '{"title":"Lord of the Rings", "author": "J. R. R. Tolkien"}' -H "Content-Type:application/json" http://localhost:8080/api/libraries/{libraryId}/books

## List libraries
curl http://localhost:8080/api/libraries


## List readers
curl http://localhost:8080/api/libraries/{libraryId}/readers

## List books
curl http://localhost:8080/api/libraries/{libraryId}/books


## Borrow a book
curl -X POST -d '{"bookId":"3f7bf042-489a-4d5a-b0cb-ba62bf71ae32"}' -H "Content-Type:application/json" http://localhost:8080/api/libraries/{libraryId}/readers/{readerId}/borrow

## Return a book
curl http://localhost:8080/api/libraries/{libraryId}/readers/{readerId}/return


# Check MongoDB


&gt; mongo

&gt; show dbs
&gt; use axonframework
switched to db axonframework

&gt; show collections

domainevents
system.indexes

&gt; db.domainevents.find()


# TODO

This version is just a rough sketch. Still lots to do.
