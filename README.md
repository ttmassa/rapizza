# Rapizza

Welcome to Rapizza!

Rapizza is a Java Swing application designed as a comprehensive management solution for a pizza delivery company. From inventory management to recruitment, pizza and ingredient selection, and customer ordering, Rapizza aims to streamline operations for efficiency and customer satisfaction.

This application automates various aspects of the pizza business, including stock management, staffing, and pricing calculations. It also provides a user-friendly interface for customers to place orders and receive detailed order receipts.

Although Rapizza operates in a fictional monetary system, it handles transactions seamlessly, automating client account top-ups and calculating prices based on production costs, profit margins, and pizza sizes.

We invite you to explore Rapizza and discover how it can enhance the management and customer experience of your pizza delivery business.

## Table of Contents

1. [Overview](#description)
2. [Features](#features)
3. [Getting Started](#usage)
4. [License](#license)
5. [Documentation](#documentation)

## University project

Rapizza was developed as a project for object-oriented programming at my university. It serves as a practical application of the concepts learned during the course, highlighting Java programming skills, GUI development using Swing and software design principles.

## Features

- **Inventory Management:** Easily track and manage pizza ingredients and stock levels.
- **Recruitment System:** Streamline hiring processes for staff members.
- **Pizza Customization:** elect from a variety of pizzas and ingredients to create custom recipes.
- **Automated Pricing:** Automatically calculate prices based on production costs, margins, and pizza size.
- **Customer Ordering:** Provide a user-friendly interface for customers to place pizza orders.
- **Monetary System:** Manage client accounts and handle transactions within a fictional monetary system.

## Getting started

The easiest way to get started is to create a jar file with Maven commands. Make sure you have a usable version of maven installed locally on your computer.

1. **Compile all files:**

- Navigate to the root directory. Execute this command to compile all the .java file into the target folder.

    ```bash
    mvn compile

2. **Create jar file:**

- Make sure all the files are compiled and execute this command to create a jar file.

   ```bash
   mvn package

This should create 2 .jar files in the target folder.

3. **Execute the jar file:**

- Navigate to the target directory and run this command to execute the newly created jar file and launch the app.

    ```bash
    java -jar .\rapizza-1.0-SNAPSHOT-jar-with-dependencies.jar
Make sure to execute the jar file with dependencies. 

If you're encountouring any issues, you might want to check out the maven documentation or check the setup of java and maven on your computer.

## License

This project is licensed under the Apache-2.0 license - see the [LICENSE.md](LICENSE.md) file for details.

Concretly you can: 
- Use the project wherever and however you want as long as you credit me.

## Documentation

Explore the following resources for detailed documentation about related technologies:

1. **Repository:**
- Find the latest updates, releases, and source code on the GitHub repository: [https://github.com/ttmassa/file-encryption](https://github.com/ttmassa/rapizza).

2. **Java Programming Language Documentation:**
- Brush up on your Java programming skills with the official Java documentation: [Java Programming Documentation](https://docs.oracle.com/en/java/).

3. **Swing Documentation:**
- Find a summary of all swing library here: [Swing Documentation](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/package-summary.html).

5. **Maven:**
- Make sure to check out the maven documentation to learn more about its use in this project: [Maven Documentation](https://maven.apache.org/guides/index.html).

Have fun reading all that! (nobody does it anyway)
