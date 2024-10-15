Dynamic PDF Generation using Spring Boot
Table of Contents
Introduction
Features
Technologies Used
Installation
API Endpoints
Request Schema
PDF Storage
How to Use
Example API Call
Error Handling
Contributing
License
Introduction
This project demonstrates a Spring Boot application with a REST API that generates a PDF document dynamically using data received from the user. The application supports downloading PDFs and storing them locally to avoid redundant generation.

Features
REST API to accept seller, buyer, and item details.
Generate a PDF using Thymeleaf or iText.
Store generated PDFs in local storage.
If the same data is submitted, return the stored PDF instead of regenerating it.
Ability to download PDFs via API.
Technologies Used
Java 17 or above
Spring Boot
Thymeleaf / iText (for PDF generation)
Postman (for testing API)
Maven (for dependency management)


example:
{
  "id": 1,
  "seller": "John's Electronics",
  "sellerGstIn": "29ABCDE1234F2Z5",
  "sellerAddress": "123 Market Street, Bangalore, Karnataka",
  "buyer": "ABC Pvt Ltd",
  "buyerGstIn": "07XYZDE6789A1Z2",
  "buyerAddress": "45 Tech Park, Delhi",
  "itemsEntity": {
    "id": "ITEM123",
    "name": "Laptop",
    "quantity": 2,
    "rate": 50000.0,
    "amount": 100000.0
  }
}
